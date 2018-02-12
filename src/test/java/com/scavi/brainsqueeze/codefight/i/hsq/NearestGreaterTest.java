package com.scavi.brainsqueeze.codefight.i.hsq;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class NearestGreaterTest {
    @Test
    public void test1() {
        int[] expected = new int[]{1, 4, 1, 2, -1, 4};
        int[] result = new NearestGreater().nearestGreater(new int[]{1, 4, 2, 1, 7, 6});
        assertThat(result).isEqualTo(expected);
    }
}
