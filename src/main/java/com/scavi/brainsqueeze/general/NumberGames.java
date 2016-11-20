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

import java.math.BigInteger;

/**
 * @author Michael Heymel
 * @since 15/09/16
 */
public class NumberGames {
    private static final int MAX_POT = 10;
    private static final int[] POT = new int[MAX_POT];

    /**
     * Initializes the cache
     */
    static {
        for (int i = 0; i < MAX_POT; ++i) {
            POT[i] = BigInteger.valueOf(10).pow(i).intValue();
        }
    }


    /**
     * Converts the given positive number to its digits
     *
     * @param number the number to convert
     * @return an array with the converted number
     */
    public int[] convertPositiveNumberToDigits(final int number) {
        Preconditions.checkArgument(number >= 0, "Only positive numbers supported");
        if (number == 0) {
            return new int[]{0};
        }

        int digitCount = String.valueOf(number).length();
        int[] digits = new int[digitCount];
        int pos = digitCount - 1;
        for (int i = 0; i < digitCount; ++i, --pos) {
            digits[pos] = noAtPos(number, i);
        }
        return digits;
    }


    /**
     * Given a sorted array of integers, return sorted array of squares of integers
     *
     * @param data the sorted input data
     * @return the array of squares
     */
    public int[] squareOfSortedData(final int[] data) {
        if (data == null || data.length == 0) {
            return data;
        }
        for (int i = 0; i < data.length; ++i) {
            data[i] = BigInteger.valueOf(data[i]).pow(2).intValue();
        }
        return data;
    }


    /**
     * Given a number find the next largest palindrome number (e.g. if number 100 -> 101, 999 ->
     * 1001)
     *
     * @param palindrome the input number
     * @return the output number
     */
    public int nextHigherPalindrome(int palindrome) {
        Preconditions.checkArgument(palindrome >= 0,
                "Illegal value! Only positive numbers allowed!");
        if (palindrome < 10) {
            return 11;
        }
        palindrome++;

        int palindromeLength = String.valueOf(palindrome).length();
        for (int i = 0; i < palindromeLength / 2; ) {
            int left = noAtPos(palindrome, palindromeLength - 1 + i);
            int right = noAtPos(palindrome, i);

            if (right > left) {
                palindrome += (10 - right) * POT[i];
                i = 0; // reset
            } else {
                palindrome += (left - right) * POT[i];
                ++i;
            }
        }
        return palindrome;
    }


    /**
     * Determines the number at the given position
     *
     * @param input the input number
     * @param pos   the position
     * @return the number at the position
     */
    private int noAtPos(final int input, final int pos) {
        return (input / POT[pos]) % 10;
    }
}
