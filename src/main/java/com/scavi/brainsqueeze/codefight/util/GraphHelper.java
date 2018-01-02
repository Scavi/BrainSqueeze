package com.scavi.brainsqueeze.codefight.util;

public class GraphHelper {
    public static boolean[][] fromCitiesAndRoads(final int cities, final int[][] roads) {
        boolean[][] matrix = new boolean[cities][cities];
        for (int[] road : roads) {
            matrix[road[1]][road[0]] = true;
            matrix[road[0]][road[1]] = true;
        }
        return matrix;
    }
}
