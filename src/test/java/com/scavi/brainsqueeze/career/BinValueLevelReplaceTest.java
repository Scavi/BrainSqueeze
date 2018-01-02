package com.scavi.brainsqueeze.career;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class BinValueLevelReplaceTest {
    @Test
    public void test1() {
        boolean isSet = new BinValueLevelReplace().isSet(0, 0);
        assertThat(isSet).isFalse();
    }


    @Test
    public void test2() {
        boolean isSet = new BinValueLevelReplace().isSet(1, 1);
        assertThat(isSet).isTrue();
    }


    @Test
    public void test3() {
        boolean isSet = new BinValueLevelReplace().isSet(3, 4);
        assertThat(isSet).isTrue();
    }


    @Test
    public void test4() {
        boolean isSet = new BinValueLevelReplace().isSet(4, 8);
        assertThat(isSet).isTrue();
    }


    @Test
    public void test5() {
        boolean isSet = new BinValueLevelReplace().isSet(4, 3);
        assertThat(isSet).isFalse();
    }
}
