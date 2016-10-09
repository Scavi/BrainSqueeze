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

package com.scavi.brainsqueeze.dac;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 07/10/16
 */
public class AllHigherValuesTest {

    @Test
    public void test1() {
        int[] input = new int[]{3, 2, 1, 3};
        int[] expectedOutput = new int[]{0, 1, 1, 0};
        AllHigherValues allHigherValues = new AllHigherValues();
        int[] output = allHigherValues.findHigher(input);
        Assert.assertArrayEquals(output, expectedOutput);
    }


    @Test
    public void test2() {
        int[] input = new int[]{3, 4, 5, 9, 3, 2, 1, 4};
        int[] expectedOutput = new int[]{4, 2, 1, 0, 1, 1, 1, 0};
        AllHigherValues allHigherValues = new AllHigherValues();
        int[] output = allHigherValues.findHigher(input);
        Assert.assertArrayEquals(output, expectedOutput);
    }


    @Test
    public void test3() {
        int[] input = new int[]{3, 2, 1, 4, 3, 4, 5, 9};
        int[] expectedOutput = new int[]{4, 5, 5, 2, 3, 2, 1, 0};
        AllHigherValues allHigherValues = new AllHigherValues();
        int[] output = allHigherValues.findHigher(input);
        Assert.assertArrayEquals(output, expectedOutput);
    }
}
