package com.scavi.brainsqueeze.codefight.i.dp;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class MaximalSquareTest {
    @Test
    public void test1() {
        int largestSquare = new MaximalSquare().maximalSquare(new char[][]{
                {'1', '0', '1', '1', '1'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
                {'1', '0', '0', '1', '0'}
        });
        assertThat(largestSquare).isEqualTo(9);
    }
}
