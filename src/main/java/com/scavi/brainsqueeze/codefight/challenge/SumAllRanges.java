package com.scavi.brainsqueeze.codefight.challenge;

import java.util.Arrays;

public class SumAllRanges {


    /**
     * Given an array array of positive integers, calculate the sum over the closed ranges defined by all the
     * possible pairs in array. Since this sum can be very large, return it modulo 109 + 7.
     * Question: https://codefights.com/challenge/p8MojWHSqbuvx5Shu
     * <p>
     * E.g. 1,5,2 -> [sumOf: 1,2 -> 1+2] + [sumOf: 1,5 -> 1+2+3+4+5] + [sumOf: 2,5 -> 2+3+4+5]
     * <p>
     * Solution-Hint:
     * https://www.wikihow.com/Sum-the-Integers-from-1-to-N
     * <p>
     * The sum between 1:N in a sorted and positive integer array can be expressed via (N * (N + 1)) / 2.
     * In case we have M:N it can be expressed as (N * (N + 1)) / 2 - ((M-1)((M-1) + 1)) / 2.
     * Based on this, we sort the array and do (N * (N + 1) / 2) - (L - P - 1) * (N * (N - 1) / 2)
     * while L is the length of the array and P the current position.
     * <p>
     * Due to this the algorithm runs in O(n log n) [basically O(n log n) + O(n)].
     *
     * @param input the input array.
     * @return
     */
    int sumAllRanges(int[] input) {
        Arrays.sort(input);
        long result = 0;
        int mod = 1000000007;
        for (int i = 0; i < input.length; i++) {
            // (N * (N + 1) / 2) (inclusive -> + 1)
            result += i * ((long) input[i] * (input[i] + 1) / 2);
            // (L - P - 1) * (N * (N - 1) / 2) (exclusive -> - 1)
            result -= (input.length - i - 1) * ((long) input[i] * (input[i] - 1) / 2);
            result %= mod;
        }
        return (int) result;
    }
}
