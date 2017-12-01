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

package com.scavi.brainsqueeze.adventofcode.y2016;

import com.google.common.base.Preconditions;

/**
 * Question: http://adventofcode.com/2016/day/18
 *
 * @author Michael Heymel
 * @since 18/12/16
 */
public class Day18LikeARogue {
    private static final char TRAP = '^';
    private static final char SAFE = '.';


    /**
     * Find the amount of save fields in the entire room
     *
     * @param startRow   the start row
     * @param roomLength the room length
     * @return the amount of save fields
     */
    public int findSaveFields(final char[] startRow, final int roomLength) {
        Preconditions.checkNotNull(startRow, "Illegal input: <null>");
        Preconditions.checkArgument(roomLength > 0, "Illegal room size! Room size must be > 0");

        int noOfSaveFields = 0;
        for (int i = 0; i < startRow.length; ++i) {
            noOfSaveFields = startRow[i] == TRAP ? noOfSaveFields : noOfSaveFields + 1;
        }

        char[][] room = new char[roomLength][startRow.length];
        room[0] = startRow;

        for (int col = 1; col < roomLength; ++col) {
            room[col] = new char[startRow.length];
            for (int row = 0; row < startRow.length; ++row) {
                boolean isFieldTrap = isTrap(room[col - 1], row);
                room[col][row] = isFieldTrap ? TRAP : SAFE;
                noOfSaveFields = isFieldTrap ? noOfSaveFields : noOfSaveFields + 1;
            }
        }
        return noOfSaveFields;
    }


    /**
     * Validates if it is a save field or a trap
     *
     * @param prevRow  the previous row
     * @param fieldPos the field position
     * @return <code>true</code>it's a trap! ;-) <p/> <code>false</code> no trap
     */
    private boolean isTrap(final char[] prevRow, final int fieldPos) {
        boolean isUpLeftTrap = fieldPos > 0 && prevRow[fieldPos - 1] == TRAP;
        boolean isUpTrap = prevRow[fieldPos] == TRAP;
        boolean isUpRightTrap = prevRow.length > fieldPos + 1 && prevRow[fieldPos + 1] == TRAP;
        return (isUpLeftTrap && !isUpTrap && !isUpRightTrap) ||
                (isUpLeftTrap && isUpTrap && !isUpRightTrap) ||
                (!isUpLeftTrap && !isUpTrap && isUpRightTrap) ||
                (!isUpLeftTrap && isUpTrap && isUpRightTrap);
    }
}
