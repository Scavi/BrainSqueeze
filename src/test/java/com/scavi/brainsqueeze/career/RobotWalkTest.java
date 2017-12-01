package com.scavi.brainsqueeze.career;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.*;

public class RobotWalkTest {
    @Test
    public void test1() {
        int[][] matrix = new int[][]{
                new int[]{0, 5, 4},
                new int[]{3, 5, 3},
                new int[]{4, 6, 5},
        };

        int shortestPath = new RobotWalk().minCost(matrix);
        assertThat(shortestPath).isEqualTo(5);
    }


    @Test
    public void test2() {
        int[][] matrix = new int[][]{
                new int[]{2, 5, 4},
                new int[]{3, 5, 3},
                new int[]{4, 6, 5},
        };

        int shortestPath = new RobotWalk().minCost(matrix);
        assertThat(shortestPath).isEqualTo(3);
    }

    @Test
    public void test3() {
        int[][] matrix = new int[][]{
                new int[]{2, 5, 4},
                new int[]{3, 5, 3},
                new int[]{4, 6, 5},
        };

        List<int[]> expectedPath = new ArrayList<>();
        expectedPath.add(new int[]{2, 2});
        expectedPath.add(new int[]{2, 1});
        expectedPath.add(new int[]{2, 0});
        expectedPath.add(new int[]{1, 0});
        expectedPath.add(new int[]{0, 0});

        List<int[]> path = new RobotWalk().shortestPath(matrix);
        assertThat(expectedPath.size()).isEqualTo(path.size());
        for (int i = 0; i < expectedPath.size(); ++i) {
            assertThat(expectedPath.get(i)).isEqualTo(path.get(i));
        }

    }
}
