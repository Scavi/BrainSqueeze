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

/**
 * Created by Scavenger on 5/9/2017.
 */
public class SumLookupTest {
    @Test
    public void test1() {
        int[] input = { 1, 7, 12, -3, 51 };
        boolean isSumExisting = new SumLookup().isSum(input, 16);
        Assert.assertTrue(isSumExisting);
    }

    @Test
    public void test2() {
        int[] input = { 1, -3, 7, 12, 51 };
        boolean isSumExisting = new SumLookup().isSum(input, 16);
        Assert.assertTrue(isSumExisting);
    }

    @Test
    public void test3() {
        int[] input = { 101, 1, -3, 7, 12, 51 };
        boolean isSumExisting = new SumLookup().isSum(input, 16);
        Assert.assertTrue(isSumExisting);
    }


    @Test
    public void test4() {
        int[] input = { 101, 1, -3, 7, 12, 51 };
        boolean isSumExisting = new SumLookup().isSum(input, 26);
        Assert.assertFalse(isSumExisting);
    }
}
