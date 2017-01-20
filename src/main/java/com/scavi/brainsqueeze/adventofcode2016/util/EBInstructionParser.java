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
import com.scavi.brainsqueeze.adventofcode2016.ex.TransmitException;

import java.util.Map;

/**
 * @author Michael Heymel
 * @since 25/12/16
 */
public class EBInstructionParser {
    private static final int ASCII_START_A = 97;
    private SignalTransmit _signalTransmitter;


    /**
     * Constructor
     */
    public EBInstructionParser() {
        this(null);
    }


    /**
     * Constructor
     *
     * @param signalTransmitter a signal transmitter for the out-instruction
     */
    public EBInstructionParser(final SignalTransmit signalTransmitter) {
        _signalTransmitter = signalTransmitter;
    }


    /**
     * Parses the input instructiosn to determine the register value
     *
     * @param input          the input instructions
     * @param registerValues the register values (containing the initialization of teh register
     *                       values)
     * @param lookup         the lookup character
     * @return the register value (based on the lookup)
     */
    public int determineRegisterValue(final String[] input,
            final Map<Character, Integer> registerValues, final char lookup) {
        Preconditions.checkNotNull(input, "Illegal input: <null>");
        for (int i = 0; i < input.length; ++i) {
            String instruction = input[i];
            String[] instructionParts = instruction.split(" ");
            if (instruction.startsWith("inc")) {
                inc(instructionParts, registerValues);
            } else if (instruction.startsWith("dec")) {
                dec(instructionParts, registerValues);
            } else if (instruction.startsWith("cpy")) {
                cpy(instructionParts, registerValues);
            } else if (instruction.startsWith("jnz")) {
                i = jnz(instructionParts, registerValues, i);
            } else if (instruction.startsWith("tgl")) {
                tgl(input, instructionParts, registerValues, i);
            } else if (instruction.startsWith("out")) {
                out(instructionParts, registerValues);
                // found the valid signal
                if (_signalTransmitter.isTransmissionFinished()) {
                    return 0;
                }
            } else {
                throw new UnsupportedOperationException("Illegal instruction: " + instruction);
            }
        }
        // in case a signal transmitter is defined, this return should never happen! In case of a
        // signal transmit the return is defined by an "infinite" signal transmission
        if (_signalTransmitter != null && !_signalTransmitter.isTransmissionFinished()) {
            throw new TransmitException("Illegal transmission!");
        }
        return registerValues.get(lookup);
    }


    /**
     * Implements the tgl-operation
     *
     * @param instructionParts the parts of the given instruction
     * @param registerValues   the register with the values
     */
    private void out(final String[] instructionParts, final Map<Character, Integer> registerValues)
            throws TransmitException {
        char information = instructionParts[1].charAt(0);
        if (information >= ASCII_START_A) {
            _signalTransmitter.transmit(registerValues.get(information));
        } else {
            _signalTransmitter.transmit(Integer.parseInt(String.valueOf(information)));
        }
    }


    /**
     * Implements the tgl-operation
     *
     * @param input            the input instructions
     * @param instructionParts the parts of the given instruction
     * @param registerValues   the register with the values
     * @param pos              the current position within the instructions
     */
    private void tgl(final String[] input, final String[] instructionParts,
            final Map<Character, Integer> registerValues, int pos) {
        char registerAccess = instructionParts[1].charAt(0);
        int move = Integer.parseInt(String.valueOf(registerValues.get(registerAccess)));
        if (isLegalInstruction(input, instructionParts, pos, move)) {
            String targetInstruction = input[pos + move];
            String[] targetInstructionParts = targetInstruction.split(" ");
            // one argument instruction
            if (targetInstructionParts.length == 2) {
                if (targetInstruction.startsWith("inc")) {
                    input[pos + move] = targetInstruction.replace("inc", "dec");
                } else {
                    input[pos + move] = "inc" + targetInstruction.substring(3);
                }
            }
            // two argument instruction
            else if (targetInstructionParts.length == 3) {
                if (targetInstruction.startsWith("jnz")) {
                    input[pos + move] = verifyInstructionResult(targetInstruction,
                            targetInstruction.replace("jnz", "cpy"));
                } else {
                    input[pos + move] = "jnz" + targetInstruction.substring(3);
                }
            } else {
                throw new UnsupportedOperationException(
                        "Illegal tgl instruction reference: " + targetInstruction);
            }
        }
    }


    /**
     * Implements the inc-operation
     *
     * @param instructionParts the parts of the given instruction
     * @param registerValues   the register with teh values
     */
    private void inc(final String[] instructionParts,
            final Map<Character, Integer> registerValues) {
        char registerAccess = instructionParts[1].charAt(0);
        registerValues.put(registerAccess, registerValues.get(registerAccess) + 1);
    }


    /**
     * Implements the inc-operation
     *
     * @param instructionParts the parts of the given instruction
     * @param registerValues   the register with the values
     */
    private void dec(final String[] instructionParts,
            final Map<Character, Integer> registerValues) {
        char registerAccess = instructionParts[1].charAt(0);
        registerValues.put(registerAccess, registerValues.get(registerAccess) - 1);
    }


    /**
     * Implements the inc-operation
     *
     * @param instructionParts the parts of the given instruction
     * @param registerValues   the register with the values
     */
    private void cpy(final String[] instructionParts,
            final Map<Character, Integer> registerValues) {
        char registerAccess = instructionParts[2].charAt(0);
        char registerReferenceAccess = instructionParts[1].charAt(0);
        if (ASCII_START_A <= registerReferenceAccess) {
            registerValues.put(registerAccess, registerValues.get(registerReferenceAccess));
        } else {
            registerValues.put(registerAccess, Integer.parseInt(instructionParts[1]));
        }
    }


    /**
     * Implements the jnz-operation
     *
     * @param instructionParts the parts of the given instruction
     * @param registerValues   the register with the values
     * @param pos              the current position within the instructions
     */
    private int jnz(final String[] instructionParts, final Map<Character, Integer> registerValues,
            int pos) {
        char registerAccess = instructionParts[1].charAt(0);
        if ((registerValues.containsKey(registerAccess) &&
                registerValues.get(registerAccess) != 0) ||
                (ASCII_START_A > registerAccess && registerAccess >= 0)) {
            if (instructionParts[2].charAt(0) >= ASCII_START_A) {
                pos += registerValues.get(instructionParts[2].charAt(0)) - 1;
            } else {
                pos += Integer.parseInt(instructionParts[2]) - 1;
            }
        }
        return pos;
    }


    private boolean isLegalInstruction(final String[] input, final String[] instructionParts,
            final int currentPos, final int registerMove) {
        return input.length > currentPos + registerMove;
    }


    private String verifyInstructionResult(final String original, final String changed) {
        if (changed.startsWith("cpy")) {
            String[] changedParts = changed.split(" ");
            char toValidate = changedParts[2].trim().charAt(0);
            return toValidate < ASCII_START_A ? original : changed;
        }
        return changed;
    }
}
