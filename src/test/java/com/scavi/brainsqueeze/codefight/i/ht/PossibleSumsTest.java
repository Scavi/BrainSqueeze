package com.scavi.brainsqueeze.codefight.i.ht;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class PossibleSumsTest {

    @Test
    public void test1() {
        int[] coins = {10, 50, 100};
        int[] quantity = {1, 2, 1};

        int result = new PossibleSums().possibleSums(coins, quantity);
        assertThat(result).isEqualTo(9);
    }

    @Test
    public void test2() {
        int[] coins = {10, 50, 100, 500};
        int[] quantity = {5, 3, 2, 2};

        int result = new PossibleSums().possibleSums(coins, quantity);
        assertThat(result).isEqualTo(122);
    }


    @Test
    public void test3() {
        int[] coins = {1, 2};
        int[] quantity = {50000, 2};

        int result = new PossibleSums().possibleSums(coins, quantity);
        assertThat(result).isEqualTo(50004);
    }
}
