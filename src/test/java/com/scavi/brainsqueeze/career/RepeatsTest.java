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

package com.scavi.brainsqueeze.career;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Scavenger on 5/10/2017.
 */
public class RepeatsTest {
    @Test
    public void test1() {
        int[] input = {3, 3, 1, 2};
        List<Integer> result = new Repeats().findRepeat(input);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(Integer.valueOf(3), result.get(0));
    }

    @Test
    public void test2() {
        int[] input = {1, 3, 0, 2, 1, 4, 5, 3, 3, 0};
        List<Integer> result = new Repeats().findRepeat(input);
        Assert.assertEquals(3, result.size());
        Assert.assertTrue(result.contains(0));
        Assert.assertTrue(result.contains(1));
        Assert.assertTrue(result.contains(3));
    }

    @Test
    public void test3() {
        int[] input = {4, 2, 0, 5, 2, 0, 1};
        List<Integer> result = new Repeats().findRepeat(input);
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains(0));
        Assert.assertTrue(result.contains(2));
    }


    @Test
    public void test4() {
        int[] input = {1, 2, 3, 0, 0, 1, 3, 6, 6, 6};
        List<Integer> result = new Repeats().findRepeat(input);
        Assert.assertEquals(4, result.size());
        Assert.assertTrue(result.contains(0));
        Assert.assertTrue(result.contains(1));
        Assert.assertTrue(result.contains(3));
        Assert.assertTrue(result.contains(6));
    }
}
