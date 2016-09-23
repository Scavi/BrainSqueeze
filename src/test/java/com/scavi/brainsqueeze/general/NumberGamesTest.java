package com.scavi.brainsqueeze.general;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Michael Heymel on 16/09/16.
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
}
