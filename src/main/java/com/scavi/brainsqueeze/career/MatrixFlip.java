package com.scavi.brainsqueeze.career;

import javax.annotation.Nonnull;

public class MatrixFlip {

    // TODO
    public int requiredFlips(@Nonnull final int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }
        int retVal = -1;
        int[] xCache = new int[matrix[0].length];
        int[] yCache = new int[matrix.length];
        int sum = setupCaches(matrix, xCache, yCache);
        if (sum == 0) {
            retVal = 0;
        }


        return retVal;
    }


    private int setupCaches(final int[][] matrix, int[] xCache, int[] yCache) {
        int sum = 0;
        for (int y = 0; y < matrix.length; ++y) {
            for (int x = 0; x < matrix[0].length; ++x) {
                if (matrix[y][x] == 1) {
                    xCache[x]++;
                    yCache[y]++;
                    sum++;
                }
            }
        }
        return sum;
    }
}