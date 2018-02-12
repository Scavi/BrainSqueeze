package com.scavi.brainsqueeze.codefight.i.dp;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class LongestIncreasingSubsequenceTest {

    @Test
    public void test1() {
        int[] input = new int[]{1, 231, 2, 4, 89, 32, 12, 234, 33, 90, 34, 100};
        int length = new LongestIncreasingSubsequence().longestIncreasingSubsequence(input);
        assertThat(length).isEqualTo(7);
    }
}
