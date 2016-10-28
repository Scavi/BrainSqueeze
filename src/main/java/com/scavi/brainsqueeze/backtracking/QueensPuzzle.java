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

package com.scavi.brainsqueeze.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Michael Heymel
 * @since 28/10/16
 */
public class QueensPuzzle {
    /**
     * This method implicitly enumerates all N^N possible placements (instead
     * of N!), but the backtracking prunes off most of them, so it's not
     * necessarily worth the extra complication of enumerating only
     * permutations.
     * <p/>
     * The result is a field
     *
     * @param fieldSize the size of the chess field to place the queens
     * @return a list with all possible queens placements (1 dim array)
     */
    public List<int[]> placeQueens(final int fieldSize) {
        final int[] field = new int[fieldSize];
        List<int[]> retVal = new LinkedList<>();
        placeQueens(field, 0, retVal);
        return retVal;
    }


    /**
     * Places all queens for the given field
     *
     * @param field  the field
     * @param level  the current level (a helper variable)
     * @param retVal the generated result
     */
    private void placeQueens(final int[] field, final int level, final List<int[]> retVal) {
        if (level == field.length) {
            retVal.add(field);
        } else {
            for (int i = 0; i < field.length; i++) {
                field[level] = i;
                if (isConsistent(field, level)) {
                    placeQueens(field, level + 1, retVal);
                }
            }
        }
    }


    /**
     * This method verifies if the current field is valid (no queens are placed
     * on the same column or a major diagonal)
     *
     * @param field the current field
     * @param level the level defines how many entries are set in the field
     * @return <code>true</code> the current field is valid<br> <code>false</code> the current field
     * is not valid
     */
    private boolean isConsistent(final int[] field, final int level) {

        for (int i = 0; i < level; i++) {
            if (field[i] == field[level]) {
                return false; // same column
            }
            if ((field[i] - field[level]) == (level - i)) {
                return false; // same major diagonal
            }
            if ((field[level] - field[i]) == (level - i)) {
                return false; // same minor diagonal
            }
        }
        return true;
    }
}
