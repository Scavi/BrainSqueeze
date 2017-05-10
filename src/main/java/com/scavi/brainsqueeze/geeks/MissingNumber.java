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

package com.scavi.brainsqueeze.geeks;

import com.google.common.base.Preconditions;

/**
 * Question: http://www.geeksforgeeks.org/find-missing-number-another-array-shuffled-copy/
 *
 * @author Michael Heymel
 * @since 5/9/2017
 */
public class MissingNumber {

    /**
     * Determines the missing number using xOR.
     * <p>
     * example:
     * Input1: 3 2 4
     * Input2: 4 1 2 3
     * <p>
     * Calculation:
     * 0011 ^ 0010 = 0001 ^ 0100 = 0101
     * <p>
     * 0100 ^ 0001 = 0101 ^ 0010 = 0111 ^ 0011 = 0100
     *
     * @param input1 the input 1
     * @param input2 the input 2
     * @return the missing number
     */
    public int findMissingNumber(int[] input1, int[] input2) {
        Preconditions.checkNotNull(input1, "Illegal input 1");
        Preconditions.checkNotNull(input2, "Illegal input 2");
        int xOR1 = 0;
        int xOR2 = 0;
        for (int i = 0; i < input1.length; ++i) {
            xOR1 ^= input1[i];
        }
        for (int i = 0; i < input2.length; ++i) {
            xOR2 ^= input2[i];
        }
        return xOR1 ^ xOR2;
    }
}
