package com.scavi.brainsqueeze.codefight.i.dp;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class RegularExpressionMatchingTest {
    @Test
    public void test1() {
        boolean isMatch = new RegularExpressionMatching().regularExpressionMatching("bb", "b");
        assertThat(isMatch).isFalse();
    }


    @Test
    public void test2() {
        boolean isMatch = new RegularExpressionMatching().regularExpressionMatching("aaa", "ab*ac*a");
        assertThat(isMatch).isTrue();
    }


    @Test
    public void test3() {
        boolean isMatch = new RegularExpressionMatching().regularExpressionMatching("aaa", "aaaz");
        assertThat(isMatch).isFalse();
    }


    @Test
    public void test4() {
        boolean isMatch = new RegularExpressionMatching().regularExpressionMatching("a", "ab*");
        assertThat(isMatch).isTrue();
    }


    @Test
    public void test5() {
        boolean isMatch = new RegularExpressionMatching().regularExpressionMatching("zab", "z.*");
        assertThat(isMatch).isTrue();
    }


    @Test
    public void test6() {
        boolean isMatch = new RegularExpressionMatching().regularExpressionMatching("caab", "d*c*x*a*b");
        assertThat(isMatch).isTrue();
    }
}
