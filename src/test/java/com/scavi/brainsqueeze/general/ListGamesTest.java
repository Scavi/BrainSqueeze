package com.scavi.brainsqueeze.general;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Michael Heymel on 18/09/16.
 */
public class ListGamesTest {

    @Test
    public void testListMerge1() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(new Integer[]{1, 3, 5, 7}));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(new Integer[]{2, 4, 6}));
        List<Integer> expected = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7}));
        ListGames listGames = new ListGames();
        List<Integer> output = listGames.merge(list1, list2, 7);
        Assert.assertEquals(expected, output);
    }


    @Test
    public void testListMerge2() {
        List<Integer> list1 = null;
        List<Integer> list2 = new ArrayList<>(Arrays.asList(new Integer[]{2, 4, 6}));
        List<Integer> expected = new ArrayList<>(Arrays.asList(new Integer[]{2, 4, 6}));
        ListGames listGames = new ListGames();
        List<Integer> output = listGames.merge(list1, list2, 3);
        Assert.assertEquals(expected, output);
    }


    @Test
    public void testListMerge3() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(new Integer[]{2}));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6}));
        List<Integer> expected = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 2, 3, 4, 5, 6}));
        ListGames listGames = new ListGames();
        List<Integer> output = listGames.merge(list1, list2, 7);
        Assert.assertEquals(expected, output);
    }


    @Test
    public void testListMerge4() {
        List<Integer> list1 = null;
        List<Integer> list2 = new ArrayList<>(Arrays.asList(new Integer[]{2, 4, 6}));
        List<Integer> expected = new ArrayList<>(Arrays.asList(new Integer[]{2, 4, 6, null, null}));
        ListGames listGames = new ListGames();
        List<Integer> output = listGames.merge(list1, list2, 5);
        Assert.assertEquals(expected, output);
    }
}
