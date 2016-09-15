package com.scavi.brainsqueeze.puzzle;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Scavenger on 15/09/16.
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
}
