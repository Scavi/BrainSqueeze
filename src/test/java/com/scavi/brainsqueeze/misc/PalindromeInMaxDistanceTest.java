package com.scavi.brainsqueeze.misc;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class PalindromeInMaxDistanceTest {

    @Test
    public void testIsPalindrome1() {
        String input = "abccbw";
        boolean isPalindrome = new PalindromeInMaxDistance().isPalindrome(input, 1);
        assertThat(isPalindrome).isTrue();
    }


    @Test
    public void testIsPalindrome2() {
        String input = "aaabccbwwa";
        boolean isPalindrome = new PalindromeInMaxDistance().isPalindrome(input, 2);
        assertThat(isPalindrome).isTrue();
    }


    @Test
    public void testIsNoPalindrome() {
        String input = "abccbwq";
        boolean isPalindrome = new PalindromeInMaxDistance().isPalindrome(input, 1);
        assertThat(isPalindrome).isFalse();
    }
}
