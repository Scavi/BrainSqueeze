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

package com.scavi.brainsqueeze.search;

import com.google.common.base.Preconditions;

/**
 * @author Michael Heymel
 * @since 26/09/16
 */
public class SearchGames {
    /**
     * Determines the median of the given input array. In optimal case, the method runs in O(log n),
     * in the worst case it runs in O(n^2)
     *
     * @param input the input to find the median
     */
    public int determineMedian(final int[] input) {
        Preconditions.checkNotNull(input, "Illegal input to find the medium: <null>");
        if (input.length == 1) {
            return input[0];
        }
        determineMedian(input, 0, input.length - 1);
        return input[input.length / 2];
    }


    /**
     * Determines the median of the given input array
     *
     * @param input    the input to find the median
     * @param startPos the current start pos
     * @param endPos   the current end pos
     */
    private void determineMedian(final int[] input, final int startPos, final int endPos) {
        if (endPos > startPos) {
            int indexLeft = startPos;
            int indexRight = endPos;
            int pivotElement = input[indexLeft];

            while (indexLeft < indexRight) {
                while (input[indexLeft] <= pivotElement && indexLeft < indexRight &&
                        indexLeft <= endPos) {
                    indexLeft++;
                }
                while (input[indexRight] > pivotElement && indexLeft <= indexRight &&
                        indexRight >= startPos) {
                    indexRight--;
                }
                if (indexLeft < indexRight) {
                    switchElement(input, indexLeft, indexRight);
                }
            }
            switchElement(input, startPos, indexRight);

            if (startPos != indexLeft || endPos != indexRight) {
                if ((input.length / 2) < indexRight) {
                    determineMedian(input, startPos, indexRight);
                } else {
                    determineMedian(input, indexRight + 1, endPos);
                }
            }
        }
    }


    /**
     * Switches the element in place
     *
     * @param input the input to switch
     * @param pos1  the position 1 to exchange with position 2
     * @param pos2  the position 2 to exchange with position 1
     */
    private void switchElement(final int[] input, final int pos1, final int pos2) {
        if (pos1 != pos2) {
            input[pos1] ^= input[pos2];
            input[pos2] ^= input[pos1];
            input[pos1] ^= input[pos2];
        }
    }
}
