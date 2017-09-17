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

package com.scavi.brainsqueeze.dac;

import com.google.common.base.Preconditions;

/**
 * @author Michael Heymel
 * @since 19/03/17
 */
public class MaxSum {
    public int determineMaxSum(final int[] input) {
        Preconditions.checkNotNull(input);
        Preconditions.checkArgument(input.length > 0, "No input: no values!");

        return determineMaxSum(input, 0, input.length - 1);
    }


    private int determineMaxSum(final int[] input, final int left, final int right) {
        int sum = 0;

        if (left < right) {

            int mid = (left + right) / 2;

            int tmpLeft = 0, tmpRight = 0;
            for (int i = mid; mid >= left; --i) {
                tmpLeft += input[i];
            }
            for (int i = mid + 1; mid < right; ++i) {
                tmpRight += input[i];
            }



            int sumLeft = determineMaxSum(input, left, mid);
            int sumRight = determineMaxSum(input, mid + 1, right);



            sum = Math.max(sumLeft, Math.max(sumRight, sumLeft + sumRight));
        }
        return sum;
    }
}
