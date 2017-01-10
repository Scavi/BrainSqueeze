/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.scavi.brainsqueeze.adventofcode2016.util;

import com.google.common.base.Preconditions;

import java.util.Map;

/**
 * @author Michael Heymel
 * @since 25/12/16
 */
public class EBInstructionParser {
    private static final int ASCII_START_A = 97;


    public static int determineRegisterValue(final String[] input,
            final Map<Character, Integer> registerValues, final char lookup) {
        Preconditions.checkNotNull(input, "Illegal input: <null>");
        for (int i = 0; i < input.length; ++i) {
            String instruction = input[i];
            String[] instructionParts = instruction.split(" ");
            if (instruction.startsWith("inc")) {
                char registerAccess = instructionParts[1].charAt(0);
                registerValues.put(registerAccess, registerValues.get(registerAccess) + 1);
            } else if (instruction.startsWith("dec")) {
                char registerAccess = instructionParts[1].charAt(0);
                registerValues.put(registerAccess, registerValues.get(registerAccess) - 1);
            } else if (instruction.startsWith("cpy")) {
                char registerAccess = instructionParts[2].charAt(0);
                char registerReferenceAccess = instructionParts[1].charAt(0);
                if (ASCII_START_A <= registerReferenceAccess) {
                    registerValues.put(registerAccess, registerValues.get(registerReferenceAccess));
                } else {
                    registerValues.put(registerAccess, Integer.parseInt(instructionParts[1]));
                }
            } else if (instruction.startsWith("jnz")) {
                char registerAccess = instructionParts[1].charAt(0);
                if ((registerValues.containsKey(registerAccess) &&
                        registerValues.get(registerAccess) != 0) ||
                        (ASCII_START_A > registerAccess && registerAccess >= 0)) {
                    if (instructionParts[2].charAt(0) >= ASCII_START_A) {
                        i += registerValues.get(instructionParts[2].charAt(0)) - 1;
                    } else {
                        i += Integer.parseInt(instructionParts[2]) - 1;
                    }
                }
            } else if (instruction.startsWith("tgl")) {
                char registerAccess = instructionParts[1].charAt(0);
                int move = Integer.parseInt(String.valueOf(registerValues.get(registerAccess)));
                if (isLegalInstruction(input, instructionParts, i, move)) {
                    String targetInstruction = input[i + move];
                    String[] targetInstructionParts = targetInstruction.split(" ");
                    // one argument instruction
                    if (targetInstructionParts.length == 2) {
                        if (targetInstruction.startsWith("inc")) {
                            input[i + move] = targetInstruction.replace("inc", "dec");
                        } else {
                            input[i + move] = "inc" + targetInstruction.substring(3);
                        }
                    }
                    // two argument instruction
                    else if (targetInstructionParts.length == 3) {
                        if (targetInstruction.startsWith("jnz")) {
                            input[i + move] = verifyInstructionResult(targetInstruction,
                                    targetInstruction.replace("jnz", "cpy"));
                        } else {
                            input[i + move] = "jnz" + targetInstruction.substring(3);
                        }
                    } else {
                        throw new UnsupportedOperationException(
                                "Illegal tgl instruction reference: " + targetInstruction);
                    }
                }
            } else {
                throw new UnsupportedOperationException("Illegal instruction: " + instruction);
            }
        }
        return registerValues.get(lookup);
    }


    private static boolean isLegalInstruction(final String[] input, final String[] instructionParts,
            final int currentPos, final int registerMove) {
        return input.length > currentPos + registerMove;
    }


    private static String verifyInstructionResult(final String original, final String changed) {
        if (changed.startsWith("cpy")) {
            String[] changedParts = changed.split(" ");
            char toValidate = changedParts[2].trim().charAt(0);
            return toValidate < ASCII_START_A ? original : changed;
        }
        return changed;
    }
}
