package com.scavi.brainsqueeze.codefight.i.dp;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class ComposeRangesTest {
    @Test
    public void test1() {
        int[] nums = new int[]{-1, 0, 1, 2, 6, 7, 9};
        String[] expected = new String[]{"-1->2",
                "6->7",
                "9"};
        String[] result = new ComposeRanges().composeRanges(nums);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test2() {
        int[] nums = new int[]{1, 2};
        String[] expected = new String[]{"1->2"};
        String[] result = new ComposeRanges().composeRanges(nums);
        assertThat(result).isEqualTo(expected);
    }
}
