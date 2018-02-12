package com.scavi.brainsqueeze.codefight.i.dp;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class ClimbingStairsTest {
    @Test
    public void test1() {
        int ways = new ClimbingStairs().climbingStairs(4);
        assertThat(ways).isEqualTo(5);
    }


    @Test
    public void test2() {
        int ways = new ClimbingStairs().climbingStairs(20);
        assertThat(ways).isEqualTo(10946);
    }
}
