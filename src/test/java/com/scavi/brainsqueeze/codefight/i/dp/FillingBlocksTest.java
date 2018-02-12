package com.scavi.brainsqueeze.codefight.i.dp;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class FillingBlocksTest {
    @Test
    public void test1() {
        int ways = new FillingBlocks().fillingBlocks(4);
        assertThat(ways).isEqualTo(36);
    }


    @Test
    public void test2() {
        int ways = new FillingBlocks().fillingBlocks(10);
        assertThat(ways).isEqualTo(18061);
    }
}
