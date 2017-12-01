package com.scavi.brainsqueeze.career;

import org.junit.Test;
import static com.google.common.truth.Truth.*;

public class FlipBinaryArrayTest {
    @Test
    public void test1() {
        int[] input = {1, 0, 1, 1, 0, 0, 0};
        int min = new FlipBinaryArray().findMiniFlip(input);
        assertThat(min).isEqualTo(1);
    }

    @Test
    public void test2() {
        int[] input = { 0, 0, 0, 0, 0, 1};
        int min = new FlipBinaryArray().findMiniFlip(input);
        assertThat(min).isEqualTo(2);
    }



    @Test
    public void test3() {
        int[] input = { 1, 0, 1, 0, 1, 0, 0, 1};
        int min = new FlipBinaryArray().findMiniFlip(input);
        assertThat(min).isEqualTo(3);
    }
}
