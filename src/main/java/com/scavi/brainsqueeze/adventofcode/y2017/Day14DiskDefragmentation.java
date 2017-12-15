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
                    markGroup(grid, x, y);
                }
            }
        }
        return groupCount;
    }

    private void markGroup(final char[][] grid, final int x, final int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE || grid[y][x] != MARKED) {
            return;
        }
        grid[y][x] = 'X'; // mark as visited
        markGroup(grid, x - 1, y);
        markGroup(grid, x + 1, y);
        markGroup(grid, x, y + 1);
        markGroup(grid, x, y - 1);
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