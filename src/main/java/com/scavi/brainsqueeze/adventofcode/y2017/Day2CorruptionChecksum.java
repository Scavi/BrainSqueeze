package com.scavi.brainsqueeze.adventofcode.y2017;

public class Day2CorruptionChecksum {
    public int solveA(int[][] matrix) {
        int sum = 0;
        for (int y = 0; y < matrix.length; ++y) {
            int min = Integer.MAX_VALUE;
            int max = 0;
            for (int x = 0; x < matrix[0].length; ++x) {
                min = Math.min(matrix[y][x], min);
                max = Math.max(matrix[y][x], max);
            }
            sum += max - min;
        }
        return sum;
    }


    public int solveB(int[][] matrix) {
        int sum = 0;
        for (int y = 0; y < matrix.length; ++y) {
            for (int x = 1; x < matrix[0].length; ++x) {
                for (int i = 0; i < x; ++i) {
                    int min = Math.min(matrix[y][i], matrix[y][x]);
                    int max = Math.max(matrix[y][i], matrix[y][x]);
                    if ((max % min) == 0) {
                        sum += max / min;
                        break;
                    }
                }
            }
        }
        return sum;
    }
}
