package com.scavi.brainsqueeze.dp;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class KnapsackProblemTest {
    @Test
    public void test1() {
        int[][] knapsack = new int[][]{{60, 20}, {20, 10}};

        int value = new KnapsackProblem().solveKnapsack(knapsack, 50);
        assertThat(value).isEqualTo(140);
    }

    @Test
    public void test2() {
        int[][] knapsack = new int[][]{{60, 20}, {20, 10}};

        int value = new KnapsackProblem().solveKnapsack(knapsack, 59);
        assertThat(value).isEqualTo(140);
    }
}
