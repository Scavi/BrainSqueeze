package com.scavi.brainsqueeze.codefight.arcade;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class DigitsProductTest {
    @Test
    public void test1() {
        int result = new DigitsProduct().digitsProduct(12);
        assertThat(result).isEqualTo(26);
    }


    @Test
    public void test2() {
        int result = new DigitsProduct().digitsProduct(19);
        assertThat(result).isEqualTo(-1);
    }
}
