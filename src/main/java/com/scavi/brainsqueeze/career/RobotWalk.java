package com.scavi.brainsqueeze.career;

import java.util.ArrayList;
import java.util.List;

public class RobotWalk {

    /**
     * Robot walked from the upper left to the lower right, can only go down and to the right, the number of each grid is height,
     * If the next cell height is higher than the current, we must pay the difference cost, otherwise no cost,
     * Find the minimum cost to reach the lower right corner.
     *
     * @param matrix the matrix
     * @return the min cost or <code>-1</code> in case of an illegal matrix
     */
    public int minCost(final int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }

        for (int x = 1; x < matrix[0].length; ++x) {
            matrix[0][x] = Math.max(matrix[0][x], matrix[0][x - 1]);
        }
        for (int y = 1; y < matrix[0].length; ++y) {
            matrix[y][0] = Math.max(matrix[y][0], matrix[y - 1][0]);
        }
        for (int y = 1; y < matrix.length; ++y) {
            for (int x = 1; x < matrix[0].length; ++x) {
                matrix[y][x] = Math.max(matrix[y][x], Math.min(matrix[y][x - 1], matrix[y - 1][x]));
            }
        }
        return matrix[matrix.length - 1][matrix[0].length - 1] - matrix[0][0];
    }


    /**
     * Follow up 1, print the minimum cost path
     *
     * @param matrix the matrix
     * @return the shortest path
     */
    public List<int[]> shortestPath(final int[][] matrix) {
        int minPath = minCost(matrix);
        if (minPath == -1) {
            return null;
        }

        List<int[]> path = new ArrayList<>(matrix.length + matrix[0].length - 1);
        int x = matrix[0].length - 1;
        int y = matrix.length - 1;

        addPath(path, x, y);
        while (x != 0 || y != 0) {
            if (x > 0 && y > 0) {
                if (matrix[y - 1][x] > matrix[y][x - 1]) {
                    addPath(path, x - 1, y);
                    --x;
                } else {
                    addPath(path, x, y - 1);
                    --y;
                }
            } else if (x > 0) {
                addPath(path, x - 1, y);
                --x;
            } else {
                addPath(path, x, y - 1);
                --y;
            }
        }
        return path;
    }

    private void addPath(final List<int[]> path, final int x, final int y) {
        path.add(new int[]{x, y});
    }
}