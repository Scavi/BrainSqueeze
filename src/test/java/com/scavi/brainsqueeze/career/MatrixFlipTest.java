package com.scavi.brainsqueeze.career;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class MatrixFlipTest {
    @Test
    public void test1() {
        int[][] matrix = new int[][]{
                {0, 1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1}
        };
        int steps = new MatrixFlip().requiredFlips(matrix);
        assertThat(steps).isEqualTo(3);
    }


    @Test
    public void test2() {
        int[][] matrix = new int[][]{
                {0, 1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0}
        };
        int steps = new MatrixFlip().requiredFlips(matrix);
        assertThat(steps).isEqualTo(3);
    }
}
