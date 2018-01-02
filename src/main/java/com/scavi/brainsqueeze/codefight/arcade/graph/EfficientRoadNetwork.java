package com.scavi.brainsqueeze.codefight.arcade.graph;

import java.util.Arrays;

public class EfficientRoadNetwork {
    private final int UNREACHABLE = 100000;

    boolean efficientRoadNetwork(int cities, int[][] roads) {
        if (cities == 1) {
            return true;
        }
        int[][] graph = new int[cities][cities];
        for (int[] m : graph) {
            Arrays.fill(m, UNREACHABLE);
        }
        for (int[] road : roads) {
            graph[road[1]][road[0]] = 1;
            graph[road[0]][road[1]] = 1;
        }
        // floyd warshall
        for (int i = 0; i < cities; ++i) {
            for (int j = 0; j < cities; ++j) {
                for (int k = 0; k < cities; ++k) {
                    if (graph[j][i] + graph[i][k] < graph[j][k]) {
                        graph[j][k] = graph[j][i] + graph[i][k];
                    }
                }
            }
        }
        for (int y = 0; y < cities; ++y) {
            for (int x = 0; x < cities; ++x) {
                if (graph[y][x] > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
