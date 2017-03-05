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

import com.google.common.base.Preconditions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Heymel
 * @since 05/02/17
 */
public class ArrayGames {

    /**
     * Find the sub-array with least average. Given an array arr[] of size n and integer k such that
     * k <= n.
     * <p>
     * Input:  arr[] = {3, 7, 90, 20, 10, 50, 40}, k = 3 Output: Subarray between indexes 3 and 5
     * The subarray {20, 10, 50} has the least average among all subarrays of size 3.
     * <p>
     * Input:  arr[] = {3, 7, 5, 20, -10, 0, 12}, k = 2 Output: Subarray between [4, 5] has minimum
     * average.
     * <p>
     * The algorithm takes O(n) time and O(1) space
     *
     * @param inputData   the input data
     * @param averageSize the average size
     * @return the positions within the subarray
     */
    public int[] leastAverage(final int[] inputData, final int averageSize) {
        Preconditions.checkNotNull(inputData, "Illegal input data: <null>");
        Preconditions.checkArgument(inputData.length >= averageSize,
                "Input data contains less elements than average size");

        int sum = 0;
        for (int i = 0; i < averageSize; ++i) {
            sum += inputData[i];
        }
        int[] result = new int[2];
        result[0] = 0;
        result[1] = averageSize - 1;
        int tmpSum = sum;
        for (int currentEnd = averageSize; currentEnd < inputData.length; ++currentEnd) {
            tmpSum -= inputData[currentEnd - averageSize];
            tmpSum += inputData[currentEnd];
            if (tmpSum < sum) {
                result[0] = currentEnd - averageSize + 1;
                result[1] = currentEnd;
            }
        }
        return result;
    }


    /**
     * Given an integer array, determine the longest sequence of adjacent value that will result in
     * a sum of 0. E.g.  1, 2, 3, 4, -9, 6, 7, -8, 1, 9 will result in 5 (from 4 to -8)
     * <p>
     * This method determines the longest sequence of integers that can get sum up to result in the
     * value of 0. This method runs in O(n) and uses O(m) space.
     *
     * @param inputData the input data
     * @return the longest sequence or <code>0</code>
     */
    public int determineLongestZeroSum(final int[] inputData) {
        Preconditions.checkNotNull(inputData, "Illegal input data: <null>");
        int longestSumZero = 0;
        if (inputData.length > 0) {
            final Map<Integer, Integer> cacheData = new HashMap<>();
            int currentSum = 0;
            for (int i = 0; i < inputData.length; ++i) {

                currentSum += inputData[i];
                if (currentSum == 0) {
                    longestSumZero = Math.max(longestSumZero, i);
                } else if (cacheData.get(currentSum) != null) {
                    longestSumZero = Math.max(longestSumZero, i - cacheData.get(currentSum));
                } else {
                    cacheData.put(currentSum, i);
                }
            }
        }
        return longestSumZero;
    }


    /**
     * Verify if a given lookup value is in a sorted matrix (where width and height are equal) in
     * better than O(n).
     *
     * @param matrix      the sorted matrix
     * @param lookupValue the lookup value for the matrix
     * @return <code>true</code> the value exists <p/> <code>false</code> the value doesn't exist
     */
    public boolean isValueExisting(final int[][] matrix, final int lookupValue) {
        Preconditions.checkNotNull(matrix, "Illegal input data: <null>");
        int height = matrix.length;
        int width = height > 0 ? matrix[0].length : 0;
        if (height == 0 || width == 0) {
            return false;
        }
        boolean isExisting = false;
        int left = 0;
        int right = height * width;

        while (!isExisting) {
            int mid = (right + left) / 2;
            int currentX = mid % height;
            int currentY = mid / width;

            if (matrix[currentY][currentX] == lookupValue) {
                isExisting = true;
            } else {
                if (matrix[currentY][currentX] > lookupValue) {
                    if (right == mid) {
                        return false;
                    }
                    right = mid;
                } else {
                    if (left == mid) {
                        return false;
                    }
                    left = mid;
                }
            }
        }
        return isExisting;
    }


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
                int pos = determineStartIndex(cache, 0, emptySlotPosition - 1, input[i]);
                cache[pos] = input[i];
            }
        }
        return emptySlotPosition;
    }


    private int determineStartIndex(final int[] input, int left, int right, final int key) {
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
}
