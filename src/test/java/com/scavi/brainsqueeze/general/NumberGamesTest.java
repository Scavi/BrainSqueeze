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

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 16/09/16
 */
public class NumberGamesTest {

    @Test
    public void testPalindrome1() {
        NumberGames numberGames = new NumberGames();
        int result = numberGames.nextHigherPalindrome(198);
        Assert.assertEquals(202, result);
    }


    @Test
    public void testPalindrome2() {
        NumberGames numberGames = new NumberGames();
        int result = numberGames.nextHigherPalindrome(1);
        Assert.assertEquals(11, result);
    }


    @Test
    public void testPalindrome3() {
        NumberGames numberGames = new NumberGames();
        int result = numberGames.nextHigherPalindrome(599511);
        Assert.assertEquals(600006, result);
    }


    @Test
    public void testPalindrome4() {
        NumberGames numberGames = new NumberGames();
        int result = numberGames.nextHigherPalindrome(298);
        Assert.assertEquals(303, result);
    }


    @Test
    public void testSquareOfSorted1() {
        NumberGames numberGames = new NumberGames();
        int[] input = new int[]{1, 3, 5};
        int[] expectedOutput = new int[]{1, 9, 25};
        int[] output = numberGames.squareOfSortedData(input);
        Assert.assertArrayEquals(expectedOutput, output);
    }


    @Test
    public void testSquareOfSorted2() {
        NumberGames numberGames = new NumberGames();
        int[] input = new int[]{-1, -3, -5};
        int[] expectedOutput = new int[]{1, 9, 25};
        int[] output = numberGames.squareOfSortedData(input);
        Assert.assertArrayEquals(expectedOutput, output);
    }


    @Test
    public void testConvertPositiveNumber1() {
        NumberGames numberGames = new NumberGames();
        int input = 123456789;
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] result = numberGames.convertPositiveNumberToDigits(input);
        Assert.assertArrayEquals(expected, result);
    }


    @Test
    public void testConvertPositiveNumber2() {
        NumberGames numberGames = new NumberGames();
        int input = 0;
        int[] expected = new int[]{0};
        int[] result = numberGames.convertPositiveNumberToDigits(input);
        Assert.assertArrayEquals(expected, result);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testConvertPositiveNumber3() {
        NumberGames numberGames = new NumberGames();
        int input = -1;
        numberGames.convertPositiveNumberToDigits(-1);
    }
}
