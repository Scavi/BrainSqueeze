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

package com.scavi.brainsqueeze.puzzle;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 15/09/16
 */
public class ArrayPuzzleTest {

    @Test
    public void testArrayPuzzle() {
        ArrayPuzzle puzzle = new ArrayPuzzle();
        int[] input = {3, 5, 2, 4};
        int[] expOutput = {40, 24, 60, 30};
        int[] result = puzzle.solve(input);
        Assert.assertArrayEquals(expOutput, result);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testNullInput() {
        ArrayPuzzle puzzle = new ArrayPuzzle();
        puzzle.solve(null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void test1EntryInput() {
        ArrayPuzzle puzzle = new ArrayPuzzle();
        int[] input = {42};
        puzzle.solve(input);
    }


    @Test
    public void test1MinSubarraySize() {
        int[] input = new int[]{12, 1, 5, 7, 1, 2, 3};
        ArrayPuzzle puzzle = new ArrayPuzzle();
        int min = puzzle.findMinimumOfSubarray(input, 3);
        Assert.assertEquals(6, min);
    }


    @Test
    public void test2MinSubarraySize() {
        int[] input = {42};
        ArrayPuzzle puzzle = new ArrayPuzzle();
        int min = puzzle.findMinimumOfSubarray(input, 1);
        Assert.assertEquals(42, min);
    }


    @Test(expected = IllegalArgumentException.class)
    public void test3MinSubarraySize() {
        int[] input = {42};
        ArrayPuzzle puzzle = new ArrayPuzzle();
        puzzle.findMinimumOfSubarray(input, 2);
    }
}
