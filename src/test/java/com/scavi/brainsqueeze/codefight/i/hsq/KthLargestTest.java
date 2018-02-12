package com.scavi.brainsqueeze.codefight.i.hsq;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class KthLargestTest {

    @Test
    public void test1() {
        int output = new KthLargest().kthLargestElement(new int[]{7, 6, 5, 4, 3, 2, 1}, 2);
        assertThat(output).isEqualTo(6);
    }
}
