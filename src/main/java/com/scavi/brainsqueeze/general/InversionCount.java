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

/**
 * @author Michael Heymel
 * @since 19/03/17
 */
public class InversionCount {


    /**
     * Do the count of Inversions in an array Inversion Count for an array indicates – how far (or
     * close) the array is from being sorted. If array is already sorted then inversion count is 0.
     * If array is sorted in reverse order that inversion count is the maximum. Formally speaking,
     * two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
     * The algorithm takes O(n log n) time and O(n) space
     *
     * @param input the given input array
     * @return the count of inversions
     */
    public int noOfInversions(final int[] input) {
        Preconditions.checkNotNull(input);
        int[] temp = new int[input.length];
        return split(input, temp, 0, input.length - 1);
    }


    private int split(final int[] input, final int[] temp, final int left, final int right) {
        int invNumber = 0;
        if (left < right) {

            final int median = (left + right) / 2;
            invNumber = split(input, temp, left, median);
            invNumber += split(input, temp, median + 1, right);
            invNumber += merge(input, temp, left, median + 1, right);
        }
        return invNumber;
    }


    private int merge(final int[] input, final int[] temp, final int left, final int median,
            final int right) {
        int invNumber = 0;

        int lookupLeft = left;
        int lookupRight = median;
        int tempIndex = left;

        // compare all elements of the left side with the the elements of the right side
        while (lookupLeft < median && lookupRight <= right) {
            if (input[lookupLeft] <= input[lookupRight]) {
                temp[tempIndex++] = input[lookupLeft++];

            } else {
                temp[tempIndex++] = input[lookupRight++];
                // At any step if a[lookupLeft] is greater than
                // a[lookupRight], then there are (mid – lookupLeft)
                // inversions, because left and right subarrays are sorted,
                // so all the remaining elements in left-subarray will be
                // greater than a[lookupRight]
                invNumber += (median - lookupLeft);
            }
        }
        // Copy the remaining elements of left subarray (if there are any) to temp
        while (lookupLeft < median) {
            temp[tempIndex++] = input[lookupLeft++];
        }
        // Copy the remaining elements of right subarray (if any exists) to temp
        while (lookupRight <= right) {
            temp[tempIndex++] = input[lookupRight++];
        }
        // Copy back the merged elements to original array
        for (tempIndex = left; tempIndex <= right; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }
        return invNumber;
    }
}
