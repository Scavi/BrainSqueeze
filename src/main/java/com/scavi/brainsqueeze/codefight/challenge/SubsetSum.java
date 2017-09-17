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

package com.scavi.brainsqueeze.codefight.challenge;

import java.util.Arrays;

/**
 * Created by Scavenger on 5/28/2017.
 * <p>
 * Given an array of numbers arr, determine whether arr can be divided into two subsets for which the sum of elements in both subsets is the same.
 * <p>
 * Example
 * <p>
 * For arr = [3, 5, 16, 8], the output should be
 * subsetSum(arr) = true.
 * <p>
 * It is possible to partition this array into two subsets that have a sum of 16: [16] and [3, 5, 8].
 * <p>
 * For arr = [5, 7, 1], the output should be
 * subsetSum(arr) = false.
 */
public class SubsetSum {

    public boolean subsetSum(int[] input) {
        if (input == null || input.length == 1) {
            return false;
        }
        int inputSum = overallSum(input);
        if ((inputSum % 2) != 0) {
            return false;
        }
        boolean[][] cache = new boolean[(inputSum / 2) + 1][input.length + 1];
        Arrays.fill(cache[0], true);

        // y represents the current value of the overall sum lookup
        for (int y = 1; y < cache.length; ++y) {
            for (int x = 1; x < cache[0].length; ++x) {
                int tmpInput = input[x - 1];
                if (tmpInput <= y || cache[y][x - 1]) {
                    cache[y][x] = cache[y][x - 1] || cache[y - tmpInput][x - 1];
                }
            }
        }
        return cache[cache.length - 1][cache[0].length - 1];
    }


    private int overallSum(int[] input) {
        int sum = 0;
        for (int current : input) {
            sum += current;
        }
        return sum;
    }
}
