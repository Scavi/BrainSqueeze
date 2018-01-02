package com.scavi.brainsqueeze.codefight.i.ht;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class SwapLexOrderTest {
    @Test
    public void test1() {
        String result = new SwapLexOrder().swapLexOrder("abdc", new int[][]{{1, 4}, {3, 4}});
        assertThat(result).isEqualTo("dbca");
    }


    @Test
    public void test2() {
        String result = new SwapLexOrder().swapLexOrder("fixmfbhyutghwbyezkveyameoamqoi", new int[][]{{8, 5},
                {10, 8},
                {4, 18},
                {20, 12},
                {5, 2},
                {17, 2},
                {13, 25},
                {29, 12},
                {22, 2},
                {17, 11}});
        assertThat(result).isEqualTo("fzxmybhtuigowbyefkvhyameoamqei");
    }
}
