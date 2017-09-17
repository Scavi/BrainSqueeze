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
 * @since 19/03/17
 */
public class MaxSum {

    /**
     * Determines the max sum of the given input array using dp. The algorithm runs in O(n) and uses
     * O(1) space.
     *
     * @param input the input
     * @return the max sum
     */
    public int determineMaxSum(final int[] input) {
        Preconditions.checkNotNull(input);
        Preconditions.checkArgument(input.length > 0, "No input: no values!");
        int max = input[0];
        int currentMax = input[0];
        for (int i = 1; i < input.length; ++i) {
            currentMax = Math.max(input[i], currentMax + input[i]);
            max = Math.max(max, currentMax);
        }
        return max;
    }
}
