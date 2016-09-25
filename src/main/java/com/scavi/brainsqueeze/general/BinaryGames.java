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

/**
 * @author Michael Heymel
 * @since 25/09/16
 */
public class BinaryGames {

    /**
     * You are given an array of integers in the range of 1 to n. There are no duplicates
     * in the array. One of the integers is missing in the array. Determine the missing integer.
     * <p/>
     * Input: 1,4,5,3
     * <p/>
     * Output: 2
     *
     * @param input the input to find the missing number
     * @return the output
     */
    public int findMissingNumber(final int[] input) {
        if (input == null || input.length < 2) {
            throw new IllegalArgumentException(
                    "Illegal number input! At least 2 entries must exist!");
        }
        int numberCount = input.length;

        int tmp1 = input[0];
        for (int i = 1; i < numberCount; ++i) {
            tmp1 ^= input[i];
        }

        int tmp2 = 1;
        for (int i = 2; i <= numberCount + 1; ++i) {
            tmp2 ^= i;
        }
        return tmp1 ^ tmp2;
    }
}
