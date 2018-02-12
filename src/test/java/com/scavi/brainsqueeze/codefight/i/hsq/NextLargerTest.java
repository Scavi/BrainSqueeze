package com.scavi.brainsqueeze.codefight.i.hsq;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class NextLargerTest {

    @Test
    public void test1() {
        int[] expected = new int[]{7, 7, -1, 4, 4, 4, 5, -1};
        int[] output = new NextLarger().nextLarger(new int[]{6, 2, 7, 3, 1, 0, 4, 5});
        assertThat(output).isEqualTo(expected);
    }
}
