package com.scavi.brainsqueeze.codefight.challenge;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class WalkTest {

    @Test
    public void test1() {
        int output = new Walk().toAndFro(1, 10, 8);
        assertThat(output).isEqualTo(9);
    }


    @Test
    public void test2() {
        int output = new Walk().toAndFro(10, 4, 8);
        assertThat(output).isEqualTo(6);
    }


    @Test
    public void test3() {
        int output = new Walk().toAndFro(2, 4, 3);
        assertThat(output).isEqualTo(3);
    }


    @Test
    public void test4() {
        int output = new Walk().toAndFro(4, 2, 6);
        assertThat(output).isEqualTo(2);
    }
}
