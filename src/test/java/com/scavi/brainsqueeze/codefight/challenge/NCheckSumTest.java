package com.scavi.brainsqueeze.codefight.challenge;

import org.junit.Test;
import static com.google.common.truth.Truth.*;

public class NCheckSumTest {
    @Test
    public void test1() {
        int[][] result = new NCheckSum().nckSum(5, 2);
        assertThat(2).isEqualTo(result.length);
    }
}
