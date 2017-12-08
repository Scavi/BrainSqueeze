package com.scavi.brainsqueeze.career;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

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
    public void testStickyRecursive() {
        Set<Integer> stickyLevel = new HashSet<>();
        stickyLevel.add(3);
        int ways = new BouncingBall(stickyLevel).waysToBounce(5);
        assertThat(ways).isEqualTo(3);
    }

    @Test
    public void testDP() {
        int[][] tests = getInput();
        for (int[] test : tests) {
            validateDpSolution(test);
        }
    }

    @Test
    public void testHighLevelDP() {
        long result = new BouncingBall().waysToBounceDP(1000);
        assertThat(result).isEqualTo(4534738885923899843L);
    }


    @Test
    public void testStickyDP() {
        Set<Integer> stickyLevel = new HashSet<>();
        stickyLevel.add(3);
        long ways = new BouncingBall(stickyLevel).waysToBounceDP(5);
        assertThat(ways).isEqualTo(3);
    }

    private void validateRecursiveSolution(final int[] bouncesToExpectedResult) {
        int bounces = new BouncingBall().waysToBounce(bouncesToExpectedResult[0]);
        assertThat(bounces).isEqualTo(bouncesToExpectedResult[1]);
    }

    private void validateDpSolution(final int[] bouncesToExpectedResult) {
        long bounces = new BouncingBall().waysToBounceDP(bouncesToExpectedResult[0]);
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
