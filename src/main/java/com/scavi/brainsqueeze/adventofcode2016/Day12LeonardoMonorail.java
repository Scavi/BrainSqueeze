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

package com.scavi.brainsqueeze.adventofcode2016;

import com.google.common.base.Preconditions;

import java.util.Map;

/**
 * Solves both questions http://adventofcode.com/2016/day/12
 *
 * @author Michael Heymel
 * @since 12/12/16
 */
public class Day12LeonardoMonorail {
    private static final int ASCII_START_A = 97;


    public int determineRegisterValue(final String[] input,
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
                    i += Integer.parseInt(instructionParts[2]) - 1;
                }
            }
        }
        return registerValues.get(lookup);
    }
}