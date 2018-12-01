package com.scavi.brainsqueeze.misc;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class ArbitraryPalindromeTest {
    @Test
    public void test1() {
        boolean isPalindrome = new ArbitraryPalindrome().isPossiblePalindrome("aabbcc");
        assertThat(isPalindrome).isTrue();
    }
    @Test
    public void test2() {
        boolean isPalindrome = new ArbitraryPalindrome().isPossiblePalindrome("aabdbcc");
        assertThat(isPalindrome).isTrue();
    }
    @Test
    public void test3() {
        boolean isPalindrome = new ArbitraryPalindrome().isPossiblePalindrome("aabbccasdf");
        assertThat(isPalindrome).isFalse();
    }

}
