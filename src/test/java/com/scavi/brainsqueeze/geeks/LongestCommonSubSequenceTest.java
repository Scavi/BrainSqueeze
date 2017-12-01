package com.scavi.brainsqueeze.geeks;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class LongestCommonSubSequenceTest {
    @Test
    public void test1() {
        int lcs = new LongestCommonSubSequence().longestSubPath("ABAB", "BABA");
        assertThat(3).isEqualTo(lcs);
    }


    @Test
    public void test2() {
        int lcs = new LongestCommonSubSequence().longestSubPath("ABAB", "BABA");
        assertThat(3).isEqualTo(lcs);
    }


    @Test
    public void test3() {
        int lcs = new LongestCommonSubSequence().longestSubPath("GEEEKFOO", "BLUUUFOO");
        assertThat(3).isEqualTo(lcs);
    }
}