package com.scavi.brainsqueeze.career;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class BenchPlaceTest {

    @Test
    public void test1() {
        boolean[] input = new boolean[]{true, false, false, true, false, true, false, false, false, true};
        int pos = new BenchPlace().findPlace(input);
        assertThat(pos).isEqualTo(7);
    }


    @Test
    public void test2() {
        boolean[] input = new boolean[]{false, false, false, true, true, true, false, false, false, false};
        int pos = new BenchPlace().findPlace(input);
        assertThat(pos).isEqualTo(9);
    }


    @Test
    public void test3() {
        boolean[] input = new boolean[]{false, false, false, true, true, true, false, true, true, true};
        int pos = new BenchPlace().findPlace(input);
        assertThat(pos).isEqualTo(0);
    }
}
