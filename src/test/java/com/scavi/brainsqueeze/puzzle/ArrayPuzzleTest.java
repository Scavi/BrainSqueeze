package com.scavi.brainsqueeze.puzzle;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Michael Heymel on 15/09/16.
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
