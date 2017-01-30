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

import com.google.common.base.Preconditions;

import java.util.LinkedList;
import java.util.List;

/**
 * Implement an efficient algorithm for listing all k-element subsets of n items.
 *
 * @author Michael Heymel
 * @since 07/10/16
 */
public class KSetProblem {

    /**
     * Creates all subsets of the given character array with the specified length of the
     * subsetSize, e.g. inputData golum and subsetSize 3:
     * {gol, gou, gom, glu, glm, gum, olu, olm, oum, lum }
     *
     * @param input   the input string
     * @param setSize the size of the sets
     * @return
     */
    public List<String> kSetOf(final String input, final int setSize) {
        return kSetOf(input != null ? input.toCharArray() : null, setSize);
    }


    /**
     * Creates all subsets of the given character array with the specified length of the
     * subsetSize, e.g. inputData golum and subsetSize 3:
     * {gol, gou, gom, glu, glm, gum, olu, olm, oum, lum }
     *
     * @param input   the input array
     * @param setSize the size of the sets
     */
    public List<String> kSetOf(final char[] input, final int setSize) {
        Preconditions.checkArgument(input != null && input.length > 0,
                "Illegal input declaration! Input needs at least one entry!");
        Preconditions.checkArgument(setSize >= 1 && input.length > setSize,
                "Illegal set size declaration! Set size must be smaller or equal than the given input.");
        List<String> results = new LinkedList<>();
        kSetOf(input, 0, new char[setSize], 0, results);
        return results;
    }


    /**
     * Creates all subsets of the given input data character array
     *
     * @param input     all substrings will be generated based on this input data string
     * @param inputPos  the position of the current input data character
     * @param buffer    a temporary buffer for all substrings
     * @param bufferPos the position within the buffer to store the current character of input data
     *                  in
     * @param results   all subsets (results)
     */
    private void kSetOf(final char[] input, final int inputPos, final char[] buffer,
            final int bufferPos, final List<String> results) {

        if (buffer.length == bufferPos) {
            results.add(String.valueOf(buffer));
        } else {
            for (int i = inputPos; i < input.length; ++i) {
                buffer[bufferPos] = input[i];
                kSetOf(input, i + 1, buffer, bufferPos + 1, results);
            }
        }
    }
}
