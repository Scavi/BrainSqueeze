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

package com.scavi.brainsqueeze.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Heymel
 * @since 06/10/16
 */
public class Permutation {
    /**
     * Does a permutation using backtracking of the given input array
     *
     * @param input the input
     * @return the result of all permutations of the input array or <code>null</code> if no / an
     * empty input is given
     */
    public List<String> permutation1(final String input) {
        return permutation1(input != null ? input.toCharArray() : null);
    }


    /**
     * Does a permutation using backtracking of the given input array
     *
     * @param input the input
     * @return the result of all permutations of the input array or <code>null</code> if no / an
     * empty input is given
     */
    public List<String> permutation1(final char[] input) {
        if (input == null || input.length == 0) {
            return null;
        }
        int size = determinePermutationSize(input.length);
        List<String> results = new ArrayList<>(size);
        permutation1(input, input.length - 1, results);
        return results;
    }


    /**
     * Does a permutation using backtracking of the given input array and adds all results into the
     * result list
     *
     * @param input       the input array
     * @param inputLength the current input length (to switch with the current position)
     * @param results     all created permutation results
     */
    private void permutation1(final char[] input, final int inputLength,
            final List<String> results) {
        if (inputLength == 0) {
            results.add(String.valueOf(input));
        } else {
            for (int i = 0; i <= inputLength; ++i) {
                swap(input, i, inputLength);
                permutation1(input, inputLength - 1, results);
                swap(input, i, inputLength);
            }
        }
    }


    /**
     * Swaps the <code>pos1</code> with the <code>pos2</code> within the given <code>input</code>
     * array
     *
     * @param input the input array
     * @param pos1  the position 1 to swap
     * @param pos2  the position 2 to swap
     */
    private void swap(final char[] input, final int pos1, final int pos2) {
        char tmp = input[pos1];
        input[pos1] = input[pos2];
        input[pos2] = tmp;
    }


    /**
     * Determines the size required for the given permutation
     *
     * @param inputLength the input array length
     * @return the required size to store all permutations
     */
    private int determinePermutationSize(int inputLength) {
        int size = 1;
        while (inputLength > 1) {
            size *= inputLength;
            --inputLength;
        }
        return size;
    }
}
