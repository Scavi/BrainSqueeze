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

package com.scavi.brainsqueeze.codefight.i;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Scavenger on 7/4/2017.
 */
public class Sudoku2 {
    boolean sudoku2(char[][] grid) {
        try {
            new Grid(grid);
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }


    private static final int ROW_CNT = 9;
    private static final int COL_CNT = 9;
    private static final char BLANK = '.';
    private static final int GRID_SIZE = 3;

    private final class Grid {

        private final SubGrid[][] _subGrids;

        public Grid(char[][] grid) {
            _subGrids = new SubGrid[grid.length / GRID_SIZE][grid[0].length / GRID_SIZE];
            for (int y = 0; y < grid.length; ++y) {
                for (int x = 0; x < grid[0].length; ++x) {
                    SubGrid currentSubGrid;
                    if ((x % GRID_SIZE) == 0 && (y % GRID_SIZE) == 0) {
                        currentSubGrid = new SubGrid();
                        _subGrids[y / GRID_SIZE][x / GRID_SIZE] = currentSubGrid;
                    } else {
                        currentSubGrid = _subGrids[y / GRID_SIZE][x / GRID_SIZE];
                    }

                    int pos = (y * ROW_CNT) + x;
                    char value = grid[y][x];
                    if (isPlaceable(pos, x, y, value)) {
                        currentSubGrid.add(pos, value);
                    } else {
                        throw new IllegalArgumentException(
                                String.format("An error has occurred for the character '%s' at position '%s'.",
                                        value,
                                        pos));
                    }
                }
            }
        }

        private boolean isPlaceable(int pos, int x, int y, char value) {
            int subGridRow = y / GRID_SIZE;
            int subGridCol = x / GRID_SIZE;

            for (int i = 0; i < GRID_SIZE; ++i) {
                SubGrid rowGrid = _subGrids[subGridRow][i];
                SubGrid colGrid = _subGrids[i][subGridCol];
                if (rowGrid != null) {
                    if (rowGrid.hasInRow(pos, value)) {
                        return false;
                    }
                }
                if (colGrid != null) {
                    if (colGrid.hasInColumn(pos, value)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }


    private final class SubGrid {
        private Map<Integer, Set<Character>> _rowValues = new HashMap<>();
        private Map<Integer, Set<Character>> _colValues = new HashMap<>();
        private Set<Character> _values = new HashSet<>();

        public void add(int pos, char value) {
            if (value == BLANK) {
                return;
            }
            if (hasInGrid(value)) {
                throw new IllegalArgumentException(
                        String.format("An error has occurred for the character '%s' at position '%s'.",
                                value,
                                pos));
            }
            add(_rowValues, pos / ROW_CNT, value);
            add(_colValues, pos % COL_CNT, value);
            _values.add(value);
        }


        private void add(Map<Integer, Set<Character>> values, int pos, char newValue) {
            if (values.containsKey(pos)) {
                values.get(pos).add(newValue);
            } else {
                Set<Character> access = new HashSet<>();
                access.add(newValue);
                values.put(pos, access);
            }
        }

        boolean hasInRow(int pos, char value) {
            if (value == BLANK) {
                return false;
            }
            int rowPos = pos / ROW_CNT;
            return _rowValues.containsKey(rowPos) && _rowValues.get(rowPos).contains(value);
        }

        boolean hasInColumn(int pos, char value) {
            if (value == BLANK) {
                return false;
            }
            int colPos = pos % COL_CNT;
            return _colValues.containsKey(colPos) && _colValues.get(colPos).contains(value);
        }

        boolean hasInGrid(char value) {
            if (value == BLANK) {
                return true;
            }
            return _values.contains(value);
        }
    }
}
