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

/**
 * @author Michael Heymel
 * @since 07/10/16
 */
public class AllHigherValues {


    /**
     * Given an array of elements, return an array of values pertaining to how many elements are
     * greater than that element remaining in the array.
     * <p/>
     * E.g.
     * 3,2,1,4
     * 1,1,1,0 (explanation: 3 < 4, 2 < 4, 1 < 4, 4 (@end)
     *
     * @param input the input array with the numbers
     * @return the calculated output
     */
    public int[] findHigher(final int[] input) {
        if (input == null || input.length < 1) {
            throw new IllegalArgumentException("No input values are given!");
        }
        int[] output = new int[input.length];
        findHigher(input, output, 0, input.length - 1);
        return output;
    }


    /**
     * Divides the given input into two sides (left and right)
     *
     * @param input  the input array
     * @param output the calculated output
     * @param start  the current start
     * @param end    the current end
     */
    private void findHigher(final int[] input, final int[] output, final int start, final int end) {
        if (end > start) {
            int median = (end + start) / 2;
            findHigher(input, output, start, median);
            findHigher(input, output, median + 1, end);
            calculate(input, output, start, median + 1, end);
        }
    }


    /**
     * Does the calculation
     *
     * @param input  the input array
     * @param output the calculated output
     * @param start  the current start for the left side (until the median)
     * @param median the median position (where the right side starts)
     * @param end    the end for the right side
     */
    private void calculate(final int[] input, final int[] output, final int start, final int median,
            final int end) {
        for (int i = start; i < median; ++i) {
            for (int j = median; j <= end; ++j) {
                if (input[i] < input[j]) {
                    // use the already calculated position from the right side
                    output[i] += output[j] + 1;
                    break;
                }
            }
        }
    }
}
