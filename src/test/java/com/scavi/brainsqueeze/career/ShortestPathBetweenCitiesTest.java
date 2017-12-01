package com.scavi.brainsqueeze.career;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class ShortestPathBetweenCitiesTest {
    @Test
    public void test1() {
        int[][] matrix = new int[][]{
                {0, 200, 500, 500, 400},
                {0, 0, 800, 400, 500},
                {0, 0, 0, 500, 300},
                {0, 0, 0, 0, 200},
                {0, 0, 0, 0, 0},
        };
        int distance = new ShortestPathBetweenCities().findShortestPath(matrix, 1);
        assertThat(distance).isEqualTo(800);
    }
}
