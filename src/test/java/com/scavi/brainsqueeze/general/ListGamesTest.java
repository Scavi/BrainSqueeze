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

import com.scavi.brainsqueeze.util.SingleLinkedNode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Michael Heymel
 * @since 18/09/16
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


    @Test
    public void testMiddleElement1() {
        SingleLinkedNode<Integer> s3 = new SingleLinkedNode<>(3);
        SingleLinkedNode<Integer> s2 = new SingleLinkedNode<>(2, s3);
        SingleLinkedNode<Integer> s1 = new SingleLinkedNode<>(1, s2);
        ListGames listGames = new ListGames();
        int retVal = listGames.middleElement(s1);
        Assert.assertEquals(2, retVal);
    }

    @Test
    public void testMiddleElement2() {
        SingleLinkedNode<Integer> s2 = new SingleLinkedNode<>(2);
        SingleLinkedNode<Integer> s1 = new SingleLinkedNode<>(1, s2);
        ListGames listGames = new ListGames();
        int retVal = listGames.middleElement(s1);
        Assert.assertEquals(1, retVal);
    }

    @Test
    public void testMiddleElement3() {
        SingleLinkedNode<Integer> s5 = new SingleLinkedNode<>(5);
        SingleLinkedNode<Integer> s4 = new SingleLinkedNode<>(4, s5);
        SingleLinkedNode<Integer> s3 = new SingleLinkedNode<>(3, s4);
        SingleLinkedNode<Integer> s2 = new SingleLinkedNode<>(2, s3);
        SingleLinkedNode<Integer> s1 = new SingleLinkedNode<>(1, s2);
        ListGames listGames = new ListGames();
        int retVal = listGames.middleElement(s1);
        Assert.assertEquals(3, retVal);
    }
}
