package com.scavi.brainsqueeze.codefight.i.backtracking;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class ClimbingStaircaseTest {
    @Test
    public void test1() {
        int[][] expectedResult = new int[][]{
                {1, 1, 1, 1},
                {1, 1, 2},
                {1, 2, 1},
                {2, 1, 1},
                {2, 2}
        };

        int[][] ways = new ClimbingStaircase().climbingStaircase(4, 2);
        validate(expectedResult, ways);
    }

    @Test
    public void test2() {
        int[][] ways = new ClimbingStaircase().climbingStaircase(0, 0);
        assertThat(ways.length).isEqualTo(0);
    }


    @Test
    public void test3() {
        int[][] expectedResult = new int[][]{
                {1},
        };
        int[][] ways = new ClimbingStaircase().climbingStaircase(1, 1);
        validate(expectedResult, ways);
    }


    @Test
    public void test4() {
        int[][] expectedResult = new int[][]{
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 2},
                {1, 1, 1, 1, 2, 1},
                {1, 1, 1, 1, 3},
                {1, 1, 1, 2, 1, 1},
                {1, 1, 1, 2, 2},
                {1, 1, 1, 3, 1},
                {1, 1, 2, 1, 1, 1},
                {1, 1, 2, 1, 2},
                {1, 1, 2, 2, 1},
                {1, 1, 2, 3},
                {1, 1, 3, 1, 1},
                {1, 1, 3, 2},
                {1, 2, 1, 1, 1, 1},
                {1, 2, 1, 1, 2},
                {1, 2, 1, 2, 1},
                {1, 2, 1, 3},
                {1, 2, 2, 1, 1},
                {1, 2, 2, 2},
                {1, 2, 3, 1},
                {1, 3, 1, 1, 1},
                {1, 3, 1, 2},
                {1, 3, 2, 1},
                {1, 3, 3},
                {2, 1, 1, 1, 1, 1},
                {2, 1, 1, 1, 2},
                {2, 1, 1, 2, 1},
                {2, 1, 1, 3},
                {2, 1, 2, 1, 1},
                {2, 1, 2, 2},
                {2, 1, 3, 1},
                {2, 2, 1, 1, 1},
                {2, 2, 1, 2},
                {2, 2, 2, 1},
                {2, 2, 3},
                {2, 3, 1, 1},
                {2, 3, 2},
                {3, 1, 1, 1, 1},
                {3, 1, 1, 2},
                {3, 1, 2, 1},
                {3, 1, 3},
                {3, 2, 1, 1},
                {3, 2, 2},
                {3, 3, 1}
        };
        int[][] ways = new ClimbingStaircase().climbingStaircase(7, 3);
        validate(expectedResult, ways);
    }


    private void validate(int[][] expected, int[][] ways) {
        assertThat(ways.length).isEqualTo(expected.length);
        for (int i = 0; i < expected.length; ++i) {
            assertThat(expected[i]).isEqualTo(ways[i]);
        }

    }
}
