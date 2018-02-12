package com.scavi.brainsqueeze.codefight.challenge;

import org.junit.Test;
import static com.google.common.truth.Truth.*;

public class MSquareTest {
    @Test
    public void test1() {
        int r = new MSquare().mSquare(4);
        assertThat(r).isEqualTo(1);
    }


    @Test
    public void test2() {
        int r = new MSquare().mSquare(7);
        assertThat(r).isEqualTo(4);
    }


    @Test
    public void test3() {
        int r = new MSquare().mSquare(65533);
        assertThat(r).isEqualTo(2);
    }
}
