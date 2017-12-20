package com.scavi.brainsqueeze.codefight.arcade;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class PalindromeBuilderTest {

    @Test
    public void test1() {
        String result = new PalindromeBuilder().buildPalindrome("ababab");
        assertThat(result).isEqualTo("abababa");
    }


    @Test
    public void test2() {
        String result = new PalindromeBuilder().buildPalindrome("abcdc");
        assertThat(result).isEqualTo("abcdcba");
    }


    @Test
    public void test3() {
        String result = new PalindromeBuilder().buildPalindrome("abba");
        assertThat(result).isEqualTo("abba");
    }
}
