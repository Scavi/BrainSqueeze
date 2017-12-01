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

package com.scavi.brainsqueeze.adventofcode.y2016;

import com.google.common.base.Preconditions;

import java.util.Arrays;

/**
 * Solves the question http://adventofcode.com/2016/day/3
 *
 * @author Michael Heymel
 * @since 03/12/16
 */
public class Day3SquaresWithThreeSides {

    public int findPossibleHorizontalTriangles(final int[][] input) {
        Preconditions.checkNotNull(input, "Illegal input: <null>");
        int count = 0;
        for (int[] triangle : input) {
            Arrays.sort(triangle);
            count = (triangle[0] + triangle[1]) > triangle[2] ? ++count : count;
        }
        return count;
    }


    public int findPossibleVerticalTriangles(final int[][] input) {
        Preconditions.checkNotNull(input, "Illegal input: <null>");
        int count = 0;
        for (int j = 0; j < input[0].length; ++j) {
            for (int i = 0; i <= input.length - 3; i += 3) {
                int min1 = Math.min(input[i][j], input[i + 1][j]);
                int min2 = Math.min(input[i + 2][j], Math.max(input[i][j], input[i + 1][j]));
                int max = Math.max(input[i + 2][j], Math.max(input[i][j], input[i + 1][j]));
                count = (min1 + min2) > max ? ++count : count;
            }
        }
        return count;
    }
}
