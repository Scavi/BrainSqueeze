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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Solves the question http://adventofcode.com/2016/day/2
 *
 * @author Michael Heymel
 * @since 02/12/16
 */
public class Day2BathroomSecurity {
    private static final int GRID_START_POS = 5;
    private static final int GRID_INSTRUCTION_SET_SIZE = 3;
    private static final int GRID_MAX_SIZE = 9;
    private static final int CROSS_START_POS = 11;
    private static final int CROSS_INSTRUCTION_SET_SIZE = 5;
    private static final int CROSS_MAX_SIZE = 25;
    private final Set<Integer> _illegalCrossPositions = new HashSet<>();
    private final Map<Integer, String> _crossPositionKeyCorrelation = new HashMap<>();


    /**
     * Constructor
     */
    public Day2BathroomSecurity() {
        _illegalCrossPositions.addAll(Arrays.asList(1, 2, 4, 5, 6, 10, 16, 20, 21, 22, 24, 25));
        _crossPositionKeyCorrelation.put(3, "1");
        _crossPositionKeyCorrelation.put(7, "2");
        _crossPositionKeyCorrelation.put(8, "3");
        _crossPositionKeyCorrelation.put(9, "4");
        _crossPositionKeyCorrelation.put(11, "5");
        _crossPositionKeyCorrelation.put(12, "6");
        _crossPositionKeyCorrelation.put(13, "7");
        _crossPositionKeyCorrelation.put(14, "8");
        _crossPositionKeyCorrelation.put(15, "9");
        _crossPositionKeyCorrelation.put(17, "A");
        _crossPositionKeyCorrelation.put(18, "B");
        _crossPositionKeyCorrelation.put(19, "C");
        _crossPositionKeyCorrelation.put(23, "D");
    }


    /**
     * Determines the code of a 3 by 3 grid from 1 - 9 by following the given instruction.
     *
     * @param instructions the instructions to follow. The outer list contains the "set" of
     *                     instruction. Each set represents a code digit
     * @return the determined code
     */
    public String determineGridCode(final List<List<Instruction>> instructions) {
        Preconditions.checkNotNull(instructions, "Illegal instruction set: <null>");
        Preconditions.checkArgument(instructions.size() > 0, "Illegal instruction set: 0");
        int position = GRID_START_POS; // start pos

        StringBuilder code = new StringBuilder(instructions.size());
        for (List<Instruction> currentInstructionData : instructions) {
            for (Instruction instruction : currentInstructionData) {
                position = followInstruction(position,
                        instruction,
                        GRID_INSTRUCTION_SET_SIZE,
                        GRID_MAX_SIZE);
            }
            code.append(position);
        }
        return code.toString();
    }


    /**
     * This method follows the instruction from the given position. In case, the position is at an
     * edge and the instruction would be to move over the edge, the movement will be blocked and the
     * position won't be changed.
     * </p>
     * Important: Due to the first question, the position is 1 based, not 0!
     *
     * @param pos         the current position
     * @param instruction the instruction
     * @param setSize     the size of the instruction size. The instruction size represents the
     *                    width of the and height of the possible instructions
     * @param maxSize     the maximal size of the field
     * @return the new position
     */
    private int followInstruction(final int pos, final Instruction instruction, final int setSize,
            final int maxSize) {
        int newPosition = 0;
        switch (instruction) {
            case U:
                newPosition = pos - setSize > 0 ? pos - setSize : pos;
                break;
            case D:
                newPosition = pos + setSize <= maxSize ? pos + setSize : pos;
                break;
            case L:
                newPosition = (pos % setSize) != 1 ? pos - 1 : pos;
                break;
            case R:
                newPosition = (pos % setSize) != 0 ? pos + 1 : pos;
                break;
        }
        return newPosition;
    }


    /**
     * This method follows the cross grid instruction. To do this, the method follows the normal
     * grid instruction (for the grid) and validates, if the result position is illegal for the
     * cross field
     *
     * @param position    the current position
     * @param instruction the instruction
     * @return the new position
     */
    private int followCrossGridInstruction(final int position, final Instruction instruction) {
        int newPosition = followInstruction(position,
                instruction,
                CROSS_INSTRUCTION_SET_SIZE,
                CROSS_MAX_SIZE);
        if (_illegalCrossPositions.contains(newPosition)) {
            newPosition = position;
        }
        return newPosition;
    }


    /**
     * Determines the second question (determine the code withthe cross)
     *
     * @param instructions the instructions
     * @return the code
     */
    public String determineCrossCode(final List<List<Instruction>> instructions) {
        Preconditions.checkNotNull(instructions, "Illegal instruction set: <null>");
        Preconditions.checkArgument(instructions.size() > 0, "Illegal instruction set: 0");
        int position = CROSS_START_POS; // start pos

        StringBuilder code = new StringBuilder(instructions.size());
        for (List<Instruction> currentInstructionData : instructions) {
            for (Instruction instruction : currentInstructionData) {
                position = followCrossGridInstruction(position, instruction);
            }
            code.append(_crossPositionKeyCorrelation.get(position));
        }
        return code.toString();
    }


    /**
     * Enum for instructions
     */
    enum Instruction {
        U, D, L, R;


        /**
         * A helper method to create all instruction based on the given input string array. 
         *
         * @param inputInstructions the character within a string represents an instruction. The
         *                          string represents the instruction set and the array all
         *                          instructions
         * @return the list containing the list of a set of instructions
         */
        public static List<List<Instruction>> from(final String[] inputInstructions) {
            if (inputInstructions == null || inputInstructions.length == 0) {
                return null;
            }

            List<List<Instruction>> resultInstructions = new ArrayList<>(inputInstructions.length);

            for (String instructions : inputInstructions) {
                Preconditions.checkNotNull(instructions, "Illegal instruction: <null>");
                List<Instruction> instructionData = new ArrayList<>(instructions.length());

                for (char instruction : instructions.toCharArray()) {
                    instructionData.add(Instruction.valueOf(String.valueOf(instruction)));
                }
                resultInstructions.add(instructionData);
            }
            return resultInstructions;
        }
    }
}