package com.scavi.brainsqueeze.misc;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class PatternDigitMatcherTest {
    @Test
    public void test1() {
        assertThat(new PatternDigitMatcher().isMatch("abc", "abc")).isTrue();
    }


    @Test
    public void test2() {
        assertThat(new PatternDigitMatcher().isMatch("1oc3", "aoczzz")).isTrue();
    }


    @Test
    public void test3() {
        assertThat(new PatternDigitMatcher().isMatch("1oc3", "aoczzzz")).isFalse();
    }

}
