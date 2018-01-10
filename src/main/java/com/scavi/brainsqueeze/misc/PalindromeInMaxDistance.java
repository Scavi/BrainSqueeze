package com.scavi.brainsqueeze.misc;

import javax.annotation.Nonnull;

public class PalindromeInMaxDistance {

    /**
     * Is the given string a palindrome with after removing maxDiff (or less characters).
     * This program calculates the edit distance and uses O(n²) space and O(n²) time.
     *
     * @param input   the string to test
     * @param maxDiff the max diff
     * @return <code>true</code> it is a palindrome, else <code>false</code>
     */
    public boolean isPalindrome(@Nonnull final String input, final int maxDiff) {
        if (input.length() < 2) {
            return true;
        } else if (maxDiff < 0) {
            return false;
        }
        String testPalindrome1 = " " + input;
        String testPalindrome2 = " " + new StringBuilder(input).reverse();
        int[][] dpCache = createDpCache(input);
        for (int i = 1; i < testPalindrome1.length(); ++i) {
            for (int j = 1; j < testPalindrome2.length(); ++j) {
                dpCache[i][j] = Math.min(dpCache[i - 1][j - 1], Math.min(dpCache[i][j - 1], dpCache[i - 1][j]));
                if (testPalindrome1.charAt(i) != testPalindrome2.charAt(j)) {
                    dpCache[i][j]++;
                }
            }
        }
        // * 2 because the same wrong character will be counted at the start and at the end in edit distance
        return dpCache[dpCache.length - 1][dpCache.length - 1] <= maxDiff * 2;
    }


    private int[][] createDpCache(final String input) {
        int[][] cache = new int[input.length() + 1][input.length() + 1];
        for (int i = 1; i < cache.length; ++i) {
            cache[i][0] = i;
            cache[0][i] = i;
        }
        return cache;
    }
}
