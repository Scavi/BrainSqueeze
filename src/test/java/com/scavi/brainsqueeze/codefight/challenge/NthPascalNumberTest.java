package com.scavi.brainsqueeze.codefight.challenge;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class NthPascalNumberTest {
    @Test
    public void test1() {
        int kthNumber = new NthPascalNumber().nthPascalNumber(5);
        assertThat(kthNumber).isEqualTo(2);
    }

    @Test
    public void test2() {
        int kthNumber = new NthPascalNumber().nthPascalNumber(10);
        assertThat(kthNumber).isEqualTo(1);
    }

    @Test
    public void test3() {
        int kthNumber = new NthPascalNumber().nthPascalNumber(33);
        assertThat(kthNumber).isEqualTo(35);
    }


    @Test
    public void test4() {
        int kthNumber = new NthPascalNumber().nthPascalNumber(100);
        assertThat(kthNumber).isEqualTo(1287);
    }
}
