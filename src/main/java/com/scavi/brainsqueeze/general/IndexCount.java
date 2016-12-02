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
 * @since 29/11/16
 */
public class IndexCount {

    /**
     * This method counts what values of the range index (starting with 0) will be in a given input
     * range index This method runs in O(n + k).
     * <p/>
     * Example:
     * <p/>
     * Input: 5-7, 1-4, 2-3, 6-8, 3-5 and a range index of 8 will result into:
     * <ul>
     * <li>position 0: 0</li>
     * <li>position 1: 1</li>
     * <li>position 2: 2</li>
     * <li>position 3: 3</li>
     * <li>position 4: 2</li>
     * <li>position 5: 2</li>
     * <li>position 6: 2</li>
     * <li>position 7: 2</li>
     * <li>position 8: 1</li>
     * </ul>
     *
     * @param rangeIndex the range index
     * @param inputRange the given input range
     * @return the index count to the given range index and ranges.
     */
    public int[] countIndex(final int rangeIndex, final Range... inputRange) {
        Preconditions.checkArgument(rangeIndex > 0, "The range index must be higher than 0");
        Preconditions.checkArgument(inputRange != null && inputRange.length > 0,
                "Illegal range! No range is given.");

        int[] result = new int[rangeIndex + 1];
        int[] startCache = new int[result.length];
        int[] endCache = new int[result.length];
        fillCaches(startCache, endCache, inputRange);

        int tmp = 0;
        for (int i = 0; i <= rangeIndex; ++i) {
            tmp += startCache[i];
            result[i] = tmp;
            tmp -= endCache[i];
        }
        return result;
    }


    /**
     * Initializes the start- and the end cache with the given input range. The start cache contains
     * a count of every starting position, the end cache contains the end of every position.
     *
     * @param startCache the start cache
     * @param endCache   the end cache
     * @param inputRange the given input range
     */
    private void fillCaches(final int[] startCache, final int[] endCache,
            final Range... inputRange) {
        for (Range range : inputRange) {
            if (range.getFrom() < startCache.length) {
                startCache[range.getFrom()] += 1;
            }
            if (range.getTo() < endCache.length) {
                endCache[range.getTo()] += 1;
            }
        }
    }


    protected static final class Range {
        private final int _from;
        private final int _to;


        /**
         * Constructor
         *
         * @param from start from
         * @param to   start to
         */
        public Range(final int from, final int to) {
            _from = from;
            _to = to;
        }


        /**
         * @return start from
         */
        public int getFrom() {
            return _from;
        }


        /**
         * @return start to
         */
        public int getTo() {
            return _to;
        }


        @Override
        public String toString() {
            return String.format("[ from=%s | to=%s ]", _from, _to);
        }
    }
}
