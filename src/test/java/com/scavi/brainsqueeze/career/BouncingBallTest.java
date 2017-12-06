package com.scavi.brainsqueeze.career;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class BouncingBallTest {


    @Test
    public void testRecursive() {
        int[][] tests = getInput();
        for (int[] test : tests) {
            validateRecursiveSolution(test);
        }
    }


    @Test
    public void testDP() {
        int[][] tests = getInput();
        for (int[] test : tests) {
            validateDpSolution(test);
        }
    }


    private void validateRecursiveSolution(final int[] bouncesToExpectedResult) {
        int bounces = new BouncingBall().waysToBounce(bouncesToExpectedResult[0]);
        assertThat(bounces).isEqualTo(bouncesToExpectedResult[1]);
    }

    private void validateDpSolution(final int[] bouncesToExpectedResult) {
        int bounces = new BouncingBall().waysToBounceDP(bouncesToExpectedResult[0]);
        assertThat(bounces).isEqualTo(bouncesToExpectedResult[1]);
    }

    private int[][] getInput() {
        return new int[][]{
                new int[]{1, 1},
                new int[]{2, 2},
                new int[]{3, 2},
                new int[]{4, 5},
                new int[]{5, 8}
        };
    }
}
