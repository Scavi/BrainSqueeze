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

package com.scavi.brainsqueeze.dp;

import com.google.common.base.Preconditions;

/**
 * @author Michael Heymel
 * @since 23/01/17
 */
public class MaxInArray {


    /**
     * Determines the max dot product between the given input arrays. One of the arrays must have
     * less entries then the other. The missing entries will be filled up with '0'. The algorithm
     * <p/>
     * Question: http://www.geeksforgeeks.org/find-maximum-dot-product-two-arrays-insertion-0s/
     *
     * @param input1 the input array 1
     * @param input2 the input array 2
     * @return the max dot product between the given array
     */
    public int maxDotProduct(int[] input1, int[] input2) {
        Preconditions.checkNotNull(input1, "Illegal input1: <null>");
        Preconditions.checkNotNull(input2, "Illegal input2: <null>");
        Preconditions.checkArgument(input1.length != 0, "Illegal input1 length: 0");
        Preconditions.checkArgument(input2.length != 0, "Illegal input2 length: 0");
        Preconditions.checkArgument(input1.length != input2.length,
                "Illegal input! Array's must have different sizes!");
        return calculate(input1.length > input2.length ? input1 : input2,
                input1.length > input2.length ? input2 : input1);
    }


    /**
     * Determines the max dot product between the given input arrays. One of the arrays must have
     * less entries then the other. The missing entries will be filled up with '0'. The algorithm
     * takes O(n * m) time and space
     * <p/>
     * Question: http://www.geeksforgeeks.org/find-maximum-dot-product-two-arrays-insertion-0s/
     *
     * @param largerArray  the input array with more entries.
     * @param smallerArray the input array with less entries
     * @return the max dot product between the given array
     */
    private int calculate(final int[] largerArray, final int[] smallerArray) {
        int max = 0;
        int[][] dpCache = new int[smallerArray.length + 1][largerArray.length + 1];
        for (int sY = 1; sY <= smallerArray.length; ++sY) {
            for (int lX = 1; lX <= largerArray.length; ++lX) {
                int lastDpCache = dpCache[sY - 1][lX - 1];
                int largerArrayData = largerArray[lX - 1];
                int smallerArrayData = smallerArray[sY - 1];
                dpCache[sY][lX] = Math.max(lastDpCache + (smallerArrayData * largerArrayData),
                        dpCache[sY][lX - 1]);
                max = Math.max(dpCache[sY][lX], max);
            }
        }
        return max;
    }


    /**
     * This method determines the maximum sum path in across two arrays. The algorithm runs in O(n
     * + m) time.
     * <p/>
     * The question was taken from: http://www.geeksforgeeks.org/maximum-sum-path-across-two-arrays/
     *
     * @param input1 the input 1
     * @param input2 the input 2
     * @return the maximum sum across two arrays
     */
    public int maxSumPath(final int[] input1, final int[] input2) {
        Preconditions.checkNotNull(input1, "Illegal input1: <null>");
        Preconditions.checkNotNull(input2, "Illegal input2: <null>");
        Preconditions.checkArgument(input1.length != 0, "Illegal input1 length: 0");
        Preconditions.checkArgument(input2.length != 0, "Illegal input2 length: 0");

        int pos1 = 0;
        int pos2 = 0;
        int sumPath1 = 0;
        int sumPath2 = 0;

        while (input1.length > pos1 && input2.length > pos2) {
            // input1 is at the current position less then input2 and still not at the end,
            // move 2 forward
            while (input1.length > pos1 && input1[pos1] < input2[pos2]) {
                sumPath1 += input1[pos1];
                pos1++;
            }

            // input2 is at the current position less then input1 and still not at the end,
            // move 2 forward
            while (input2.length > pos2 && input2[pos2] < input1[pos1]) {
                sumPath2 += input2[pos2];
                pos2++;
            }

            // reached a positions in the arrays where the elements are equal. Due to this, it is
            // possible to switch from one array to another. In case the sum path 1 is higher it
            // could continue in the second array and visa verse
            if (input1.length > pos1 && input2.length > pos2 && input2[pos2] == input1[pos1]) {
                // add the equal array element to both sum path's and increases the position
                sumPath1 += input1[pos1++];
                sumPath2 += input2[pos2++];
                if (sumPath1 > sumPath2) {
                    sumPath2 = sumPath1;
                } else {
                    sumPath1 = sumPath2;
                }
            }
        }

        while (input1.length > pos1) {
            sumPath1 += input1[pos1];
            pos1++;
        }

        while (input2.length > pos2) {
            sumPath2 += input2[pos2];
            pos2++;
        }

        return Math.max(sumPath1, sumPath2);
    }
}
