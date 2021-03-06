package com.scavi.brainsqueeze.codefight.challenge;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class ForestGumpTest {
    @Test
    public void test1() {
        int pos = new ForestGump().runForerstRun(new int[]{1, 2, 3}, new int[]{1, 2, 3});
        assertThat(pos).isEqualTo(1);
    }

    @Test
    public void test2() {
        int pos = new ForestGump().runForerstRun(new int[]{1, 1, 1}, new int[]{0, 0, 3});
        assertThat(pos).isEqualTo(3);
    }
}
