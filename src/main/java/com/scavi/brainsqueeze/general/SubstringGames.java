/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.scavi.brainsqueeze.general;

/**
 * @author Michael Heymel
 * @since 05/03/17
 */
public class SubstringGames {

    /**
     * Finds the longest increasing sub-sequence in the given input-array. The algorithm runs in O(n
     * log n)
     *
     * @param input the input array
     * @return the amount of longest increasing sub-sequence
     */
    public int findLongestIncreasingSubsequenceLength(final int[] input) {

        if (input == null || input.length == 0) {
            return -1;
        }
        // Add boundary case, when array size is one
        final int inputSize = input.length;
        int[] cache = new int[inputSize];
        cache[0] = input[0];

        int emptySlotPosition = 1; // always points empty slot

        for (int i = 1; i < inputSize; i++) {
            if (input[i] < cache[0]) {
                // new smallest value
                cache[0] = input[i];
            } else if (input[i] > cache[emptySlotPosition - 1]) {
                // A[i] wants to extend largest subsequence
                cache[emptySlotPosition++] = input[i];
            } else {
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in cache
                int pos = determineStartIndex(cache, emptySlotPosition - 1, input[i]);
                cache[pos] = input[i];
            }
        }
        return emptySlotPosition;
    }


    /**
     * Determine the start index for the key element using O(log n) ("quicksearch")
     *
     * @param input the cache-input
     * @param right the right side (length - 1) of the filled cache
     * @param key   the lookup key
     * @return the index
     */
    private int determineStartIndex(final int[] input, int right, final int key) {
        int left = 0;
        while (right - left > 1) {
            int median = (right + left) / 2;
            if (input[median] >= key) {
                right = median;
            } else {
                left = median;
            }
        }
        return right;
    }


    /**
     * Beside using a suffix-tree (which would take O(n)) it is also possible to use DP to determine
     * the longest substring. The solution takes O(n^2) space and runs in O(n^2).
     *
     * @param input the input
     * @return the palindrome sequence
     */
    public String longestPalindrome(final String input) {
        if (input == null || input.length() == 0) {
            return null;
        }
        int inputLength = input.length();
        int longestBegin = 0;
        int maxLen = 1;
        boolean[][] table = new boolean[inputLength][inputLength];
        // set the diagonal values to true because each letter is a palindrome to itself
        for (int i = 0; i < inputLength; i++) {
            table[i][i] = true;
        }
        // set the table for values that are next to each other
        for (int i = 0; i < inputLength - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                table[i][i + 1] = true;
                longestBegin = i;
                maxLen = 2;
            }
        }
        for (int len = 3; len <= inputLength; len++) {
            for (int i = 0; i < inputLength - len + 1; i++) {
                int j = i + len - 1;
                if (input.charAt(i) == input.charAt(j) && table[i + 1][j - 1]) {
                    table[i][j] = true;
                    longestBegin = i;
                    maxLen = len;
                }
            }
        }
        return input.substring(longestBegin, longestBegin + maxLen);
    }
}
