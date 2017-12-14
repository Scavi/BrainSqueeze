package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.util.StringHelper;

import javax.annotation.Nonnull;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Day14DiskDefragmentation {
    private static final int SIZE = 128;
    private static final char MARKED = '#';

    public int solveA(@Nonnull final String input) {
        String[] gridBinaries = solve(input);
        return createGridFromBinaries(gridBinaries, new char[SIZE][SIZE]);
    }

    public int solveB(@Nonnull final String input) {
        String[] gridBinaries = solve(input);
        char[][] grid = new char[SIZE][SIZE];
        createGridFromBinaries(gridBinaries, grid);
        int groupCount = 0;
        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid.length; ++x) {
                // found a marked position in the grid.
                if (grid[y][x] == MARKED) {
                    groupCount++;
                    Queue<int[]> fields = new LinkedList<>();
                    fields.add(new int[]{x, y});
                    // do bfs and mark every field marked field as visited
                    while (!fields.isEmpty()) {
                        int[] current = fields.poll();
                        int currentX = current[0];
                        int currentY = current[1];
                        int left = currentX - 1;
                        int up = currentY - 1;
                        int right = currentX + 1;
                        int down = currentY + 1;

                        // left
                        if (left >= 0 && grid[currentY][left] == MARKED) {
                            fields.add(new int[]{left, currentY});
                        }
                        // right
                        if (right < SIZE && grid[currentY][right] == MARKED) {
                            fields.add(new int[]{right, currentY});
                        }
                        // up
                        if (up >= 0 && grid[up][currentX] == MARKED) {
                            fields.add(new int[]{currentX, up});
                        }
                        // down
                        if (down < SIZE && grid[down][currentX] == MARKED) {
                            fields.add(new int[]{currentX, down});
                        }
                        grid[currentY][currentX] = 'X'; // mark as visited
                    }
                }
            }
        }
        return groupCount;
    }

    private String[] solve(final String input) {
        String[] gridBinaries = new String[SIZE];
        String temp;
        for (int i = 0; i < SIZE; ++i) {
            int[] inputData = IntStream.range(0, 256).toArray();
            temp = new Day10KnotHash().solveB(inputData, String.format("%s-%s", input, i));
            gridBinaries[i] = StringHelper.fromHexToBinary(temp);
        }
        return gridBinaries;
    }


    private int createGridFromBinaries(final String[] gridBinaries, final char[][] grid) {
        int squareCount = 0;
        for (int y = 0; y < SIZE; ++y) {
            for (int x = 0; x < SIZE; ++x) {
                if (gridBinaries[y].charAt(x) == '1') {
                    squareCount++;
                    grid[y][x] = MARKED;
                } else {
                    grid[y][x] = '.';
                }
            }
        }
        return squareCount;
    }
}