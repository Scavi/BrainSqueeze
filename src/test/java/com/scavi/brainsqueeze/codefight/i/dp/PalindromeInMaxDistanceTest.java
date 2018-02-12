package com.scavi.brainsqueeze.codefight.i.dp;

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
    public void testIsNoPalindrome1() {
        String input = "abccbwq";
        boolean isPalindrome = new PalindromeInMaxDistance().isPalindrome(input, 1);
        assertThat(isPalindrome).isFalse();
    }


    @Test
    public void testIsNoPalindrome2() {
        String input = "rdtqkvwcsgs";
        boolean isPalindrome = new PalindromeInMaxDistance().isPalindrome(input, 6);
        assertThat(isPalindrome).isFalse();
    }


    @Test
    public void testIsNoPalindrome3() {
        String input = "acdcb";
        boolean isPalindrome = new PalindromeInMaxDistance().isPalindrome(input, 1);
        assertThat(isPalindrome).isFalse();
    }
}
