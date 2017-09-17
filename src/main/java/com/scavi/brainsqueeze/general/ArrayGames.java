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


    public int[] rearrange(int[] nums) {
        Preconditions.checkArgument(nums != null && nums.length >= 2,
                "Illegal input !No given values !");
        int sum = determineSum(nums);
        float average = ((float) sum) / (float) nums.length;
        int evenPos = 0;
        int oddPos = 1;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            int tmpNum = nums[i];
            if (tmpNum > average && (oddPos + 1) < nums.length) {
                result[oddPos] = tmpNum;
                oddPos += 2;
            } else {
                result[evenPos] = tmpNum;
                evenPos += 2;
            }
        }
        return result;
    }

    private int determineSum(int[] nums) {
        int sum = 0;
        for (int current : nums) {
            sum += current;
        }
        return sum;
    }

    /**
     * Question: https://www.careercup.com/question?id=5177437882155008
     * Find maximum contiguous subarray sum with size (the number of the element in the subarray) <= k
     *
     * @param input the input
     * @return the max sum
     */
    public int maxSum(final int[] input) {
        Preconditions.checkNotNull(input, "Illegal input!");
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < input.length; ++i) {
            currentSum = Math.max(currentSum + input[i], input[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }


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
     * Find the clostest pair in two sorted arrays
     *
     * @param sortedInput1 sorted input 1
     * @param sortedInput2 sorted input 2
     * @return the closest pair
     */
    public int[] findClosestPair(final int[] sortedInput1, final int[] sortedInput2) {
        Preconditions.checkNotNull(sortedInput1);
        Preconditions.checkNotNull(sortedInput2);

        int distance = Integer.MAX_VALUE;
        int value1 = 0, value2 = 0;
        int pos1 = 0, pos2 = 0;
        while (pos1 < sortedInput1.length && pos2 < sortedInput2.length && distance > 0) {
            int tmpDistance = Math.abs(sortedInput1[pos1] - sortedInput2[pos2]);

            if (tmpDistance < distance) {
                value1 = sortedInput1[pos1];
                value2 = sortedInput2[pos2];
                distance = tmpDistance;
            }

            if (sortedInput1[pos1] > sortedInput2[pos2]) {
                pos2++;
            } else {
                pos1++;
            }
        }
        return new int[]{value1, value2};
    }


    /**
     * This method determines the minimal entries within the given
     * <code>inputData</code> array that are next to each other, to create
     * a sum that is bigger than <code>sum</code>. The algorithm performs
     * in O(n) time.
     *
     * @param sum       the sum that have to be exceeded
     * @param inputData the input data array
     * @return the minimal number adjacent entries in the input data or <code>-1</code> in case no
     * result exists
     */
    public int minAdjacentLength(final int sum, final int[] inputData) {
        int retVal = Integer.MAX_VALUE;

        if (inputData != null && inputData.length > 0 && sum > 0) {

            int left = 0, tmp = 0, right;
            for (int i = 0; i < inputData.length && retVal > 1; ++i) {
                tmp += inputData[i];
                right = i + 1;

                while (tmp > sum && left < right) {
                    tmp -= inputData[left];
                    if (tmp == sum) {
                        retVal = Math.min(retVal, (right - left));
                    }
                    left++;
                }
                if (tmp == sum) {
                    retVal = Math.min(retVal, (right - left));
                }
            }
        }
        return retVal != Integer.MAX_VALUE ? retVal : -1;
    }
}
