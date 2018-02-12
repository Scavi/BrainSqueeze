package com.scavi.brainsqueeze.codefight.i.dp;

public class MaximalSquare {
    /**
     * You have a 2D binary matrix that's filled with 0s and 1s. In the matrix, find the largest square that contains
     * only 1s and return its area.
     *
     * @param matrix Guaranteed constraints:
     *               0 ≤ matrix.length ≤ 100,
     *               1 ≤ matrix[i].length ≤ 100,
     *               0 ≤ matrix[i][j] ≤ 1.
     * @return An integer that represents the area of the largest square in the given matrix that is composed only of
     * 1s.
     */
    int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] dpCache = new int[matrix.length + 1][matrix[0].length + 1];
        int size = 0;
        for (int y = 1; y <= matrix.length; ++y) {
            for (int x = 1; x <= matrix[0].length; ++x) {
                if (matrix[y - 1][x - 1] == '1') {
                    dpCache[y][x] = 1 + Math.min(dpCache[y - 1][x - 1], Math.min(dpCache[y - 1][x], dpCache[y][x - 1]));
                    size = Math.max(size, dpCache[y][x]);
                }
            }
        }
        return size * size;
    }
}
