package com.scavi.brainsqueeze.adventofcode.y2017;

import java.util.ArrayList;
import java.util.List;

public class Day21FractalArt {
    public int solveA(char[][] grid, final String[] ruleData, final int iterations) {
        List<PatternCache> rules = createPatternRules(ruleData);
        for (int i = 0; i < iterations; ++i) {
            if (grid.length % 3 == 0) {
                grid = processRule(grid, rules, 3);
            } else if (grid.length % 2 == 0) {
                grid = processRule(grid, rules, 2);
            } else {
                throw new IllegalArgumentException();
            }
        }
        return countPixels(grid);
    }

    private char[][] processRule(final char[][] input, final List<PatternCache> rules, final int size) {
        int newSize = input.length + (input.length / size);
        char[][] output = new char[newSize][newSize];
        int offsetY = 0;
        for (int y = 0; y < input.length; y += size) {
            int offsetX = 0;
            for (int x = 0; x < input.length; x += size) {
                char[][] lookupGrid = createLookupGrid(input, x, y, size);
                char[][] replaceGrid = findReplaceGrid(lookupGrid, rules, 0);
                if (replaceGrid == null) {
                    throw new IllegalArgumentException(); // ###/#.#/##.
                }
                merge(output, replaceGrid, x + offsetX, y + offsetY);
                offsetX++;
            }
            offsetY++;
        }
        return output;
    }


    private void merge(final char[][] output, final char[][] replaceGrid, final int fromX, final int fromY) {
        for (int y = 0; y < replaceGrid.length; ++y) {
            for (int x = 0; x < replaceGrid.length; ++x) {
                output[fromY + y][fromX + x] = replaceGrid[y][x];
            }
        }
    }


    // 1 = rotate
    // 2 = flip horizontal
    // 3 = flip vertical
    private char[][] findReplaceGrid(final char[][] lookupGrid, final List<PatternCache> rules, final int iteration) {
        if (iteration > 3) {
            return null;
        }

        char[][] result = null;
        if (iteration == 0) {
            result = compareWith(lookupGrid, rules);
            if (result == null) {
                result = findReplaceGrid(lookupGrid, rules, iteration + 1);
            }
        }
        // rotate
        else if (iteration == 1) {
            for (int i = 0; i < 4 && result == null; ++i) {
                rotate(lookupGrid);
                result = compareWith(lookupGrid, rules);
                if (result == null) {
                    result = findReplaceGrid(lookupGrid, rules, iteration + 1);
                }
            }
        } else if (iteration == 2) {
            for (int i = 0; i < lookupGrid.length; ++i) {
                flipHorizontal(lookupGrid);
                result = compareWith(lookupGrid, rules);
                if (result == null) {
                    result = findReplaceGrid(lookupGrid, rules, iteration + 1);
                }
                flipHorizontal(lookupGrid);
            }
        } else if (iteration == 3) {
            for (int i = 0; i < lookupGrid.length; ++i) {
                flipVertical(lookupGrid);
                result = compareWith(lookupGrid, rules);
                if (result == null) {
                    result = findReplaceGrid(lookupGrid, rules, iteration + 1);
                }
                flipVertical(lookupGrid);
            }
        }
        return result;
    }


    private void rotate(final char[][] lookupGrid) {
        for (int y = 0; y < lookupGrid.length; ++y) {
            for (int x = y; x < lookupGrid[0].length; ++x) {
                swap(lookupGrid, x, y, y, x);
            }
        }
        int xLen = lookupGrid[0].length - 1;
        for (int y = 0; y < lookupGrid.length; ++y) {
            for (int x = 0; x < lookupGrid[0].length / 2; x++) {
                swap(lookupGrid, x, y, xLen - x, y);
            }
        }
    }


    private void flipHorizontal(final char[][] lookupGrid) {
        for (int y = 0; y < lookupGrid.length; ++y) {
            swap(lookupGrid, 0, y, lookupGrid.length - 1, y);
        }
    }


    private void flipVertical(final char[][] lookupGrid) {
        for (int x = 0; x < lookupGrid.length; ++x) {
            swap(lookupGrid, x, 0, x, lookupGrid.length - 1);
        }
    }


    private void swap(final char[][] lookupGrid, final int x1, final int y1, final int x2, final int y2) {
        char tmp = lookupGrid[y1][x1];
        lookupGrid[y1][x1] = lookupGrid[y2][x2];
        lookupGrid[y2][x2] = tmp;
    }

    private char[][] compareWith(final char[][] lookupGrid, final List<PatternCache> rules) {
        for (PatternCache pattern : rules) {
            if (pattern.isEqualTo(lookupGrid)) {
                return pattern._to;
            }
        }
        return null;
    }


    private char[][] createLookupGrid(final char[][] input, final int fromX, final int fromY, final int size) {
        char[][] grid = new char[size][size];
        for (int y = 0; y < size; ++y) {
            for (int x = 0; x < size; ++x) {
                grid[y][x] = input[fromY + y][fromX + x];
            }
        }
        return grid;
    }


    private int countPixels(final char[][] input) {
        int lightedPixels = 0;
        for (int y = 0; y < input.length; ++y) {
            for (int x = 0; x < input[0].length; ++x) {
                if (input[y][x] == '#') {
                    lightedPixels++;
                }
            }
        }
        return lightedPixels;
    }

    private List<PatternCache> createPatternRules(final String[] ruleData) {
        List<PatternCache> pattern = new ArrayList<>(ruleData.length);
        for (String rule : ruleData) {
            pattern.add(new PatternCache(rule));
        }
        return pattern;
    }


    private class PatternCache {
        private final char[][] _from;
        private final char[][] _to;

        PatternCache(final String pattern) {
            String[] tmp = pattern.split(" => ");
            _from = convert(tmp[0]);
            _to = convert(tmp[1]);
        }

        private char[][] convert(final String pattern) {
            String[] tmp = pattern.split("/");
            char[][] lookupPattern = new char[tmp.length][tmp.length];

            for (int y = 0; y < tmp.length; ++y) {
                for (int x = 0; x < tmp[0].length(); ++x) {
                    lookupPattern[y][x] = tmp[y].charAt(x);
                }
            }
            return lookupPattern;
        }


        public boolean isEqualTo(final char[][] from) {
            if (_from.length != from.length) {
                return false;
            }

            for (int y = 0; y < from.length; ++y) {
                for (int x = 0; x < from.length; ++x) {
                    if (_from[y][x] != from[y][x]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
