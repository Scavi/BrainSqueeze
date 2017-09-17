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

package com.scavi.brainsqueeze.codefight.arcade;

import org.junit.Assert;
import org.junit.Test;

public class AlmostIncreasingSequenceTest {

    @Test
    public void test1() {
        int[] input = new int[]{1, 2, 3, 4, 3, 6};
        boolean isAlmost = new AlmostIncreasingSequence().almostIncreasingSequence(input);
        Assert.assertTrue(isAlmost);
    }

    @Test
    public void test2() {
        int[] input = new int[]{1, 2, 5, 3, 5};
        boolean isAlmost = new AlmostIncreasingSequence().almostIncreasingSequence(input);
        Assert.assertTrue(isAlmost);
    }

    @Test
    public void test3() {
        int[] input = new int[]{1, 2, 1, 2};
        boolean isAlmost = new AlmostIncreasingSequence().almostIncreasingSequence(input);
        Assert.assertFalse(isAlmost);
    }

    @Test
    public void test4() {
        int[] input = new int[]{10, 1, 2, 3, 4, 5};
        boolean isAlmost = new AlmostIncreasingSequence().almostIncreasingSequence(input);
        Assert.assertTrue(isAlmost);
    }


    @Test
    public void test5() {
        int[] input = new int[]{1, 3, 2};
        boolean isAlmost = new AlmostIncreasingSequence().almostIncreasingSequence(input);
        Assert.assertTrue(isAlmost);
    }


    @Test
    public void test6() {
        int[] input = new int[]{1, 2, 5, 5, 5};
        boolean isAlmost = new AlmostIncreasingSequence().almostIncreasingSequence(input);
        Assert.assertFalse(isAlmost);
    }
}
