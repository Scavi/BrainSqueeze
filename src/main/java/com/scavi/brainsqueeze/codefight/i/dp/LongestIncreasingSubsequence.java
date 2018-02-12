package com.scavi.brainsqueeze.codefight.i.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {


    /**
     * Given a sequence of numbers in an array, find the length of its longest increasing subsequence (LIS).
     * The longest increasing subsequence is a subsequence of a given sequence in which the subsequence's elements
     * are in strictly increasing order, and in which the subsequence is as long as possible. This subsequence is not
     * necessarily contiguous or unique.
     *
     * @param sequence An array describing a sequence.
     *                 Guaranteed constraints:
     *                 1 ≤ sequence.length ≤ 1000,
     *                 0 ≤ sequence[i] ≤ 106.
     * @return The length of the longest increasing subsequence of a given sequence.
     */
    int longestIncreasingSubsequence(int[] sequence) {
        int maxLen = 1;

        int[] cache = new int[sequence.length];
        Arrays.fill(cache, 1);

        for (int i = 1; i < sequence.length; ++i) {
            for (int j = 0; j < i; ++j) {
                // iterate through all already visited input values. If the
                // current visited value is lower than the current one it
                // may be part of the "best" subsequence.
                if (sequence[i] > sequence[j] && cache[i] < cache[j] + 1) {
                    cache[i]++;
                    maxLen = Math.max(maxLen, cache[i]);
                }
            }
        }
        return maxLen;
    }

}
