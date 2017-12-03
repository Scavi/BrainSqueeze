package com.scavi.brainsqueeze.career;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class MaxProfitTest {
    @Test
    public void test1() {
        int max = new MaxProfit().maxProfit(new int[]{9, 20, 5, 10});
        assertThat(max).isEqualTo(11);
    }
}
