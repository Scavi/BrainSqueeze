package com.scavi.brainsqueeze.codefight.arcade;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class ValuesSumMinimizationTest {
    @Test
    public void test1() {
        int result = new ValuesSumMinimization().absoluteValuesSumMinimization(new int[]{-4, -1});
        assertThat(result).isEqualTo(-4);
    }
}
