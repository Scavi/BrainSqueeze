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

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class SubsetSum {

    /**
     * Given an array of numbers arr, determine whether arr can be divided into two subsets for which the sum of
     * elements * in both subsets is the same.
     * <p>
     * Example:
     * For arr = [3, 5, 16, 8], the output should be
     * subsetSum(arr) = true.
     * <p>
     * It is possible to partition this array into two subsets that have a sum of 16: [16] and [3, 5, 8].
     * <p>
     * For arr = [5, 7, 1], the output should be
     * subsetSum(arr) = false.
     *
     * @param input
     * @return
     */
    public boolean isSubsetDividable(final int[] input) {
        if (input == null || input.length == 1) {
            return false;
        }
        int inputSum = IntStream.of(input).sum();
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


    /**
     * This method tries to find exactly k elements from the given data list that sum's up the given sum.
     * This method assumes that data and sum is positive.
     * The runtime of this method is O (n!) but has a lot of search pruning (stops at k times etc.)
     *
     * @param data the input data (assuming only positive numbers!)
     * @param k    the k elements to determine the sum
     * @param sum  the target sum
     * @return the result
     */
    public List<List<Integer>> findKElementsOfSum(@Nonnull final ArrayList<Integer> data, final int k, final int sum) {
        if (k < 0 || data.size() < k) {
            return null;
        }
        Collections.sort(data);
        List<List<Integer>> result = new ArrayList<>();
        findKElementsOfSum(result, data, 0, new Integer[k], 0, sum, 0);
        return result;
    }


    private void findKElementsOfSum(
            final List<List<Integer>> result,
            final List<Integer> data,
            final int dataPos,
            final Integer[] buffer,
            final int bufferPos,
            final int targetSum,
            final int currentSum) {

        if (currentSum > targetSum) {
            return;
        } else if (bufferPos == buffer.length) {
            if (targetSum == currentSum) {
                result.add(Arrays.asList(buffer.clone()));
            }
            return;
        }
        // k - 1 elements are already added to teh buffer (started ascending from the left side). Now search from the
        // right for the last value
        if (bufferPos == buffer.length - 1) {
            int diff = targetSum - currentSum;
            for (int i = data.size() - 1; i >= dataPos; --i) {
                if (data.get(i) == diff) {
                    buffer[bufferPos] = data.get(i);
                    findKElementsOfSum(result, data, dataPos + 1, buffer, bufferPos + 1, targetSum, currentSum +
                            buffer[bufferPos]);
                    break;
                } else {
                    if (data.get(i) < diff) {
                        break;
                    }
                }
            }
        } else {
            for (int i = dataPos; i < data.size(); ++i) {
                buffer[bufferPos] = data.get(i);
                findKElementsOfSum(result, data, dataPos + 1, buffer, bufferPos + 1, targetSum, currentSum +
                        buffer[bufferPos]);
            }
        }
    }
}
