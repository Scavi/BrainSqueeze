package com.scavi.brainsqueeze.codefight.challenge;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class SmallestMultipleTest {
    @Test
    public void test1() {
        int result = new SmallestMultiple().findNthSmallestMultiple(new int[]{3, 5, 7}, 7);
        assertThat(result).isEqualTo(12);
    }


    @Test
    public void test2() {
        int result = new SmallestMultiple().findNthSmallestMultiple(new int[]{4, 10, 2}, 4);
        assertThat(result).isEqualTo(8);
    }
}
