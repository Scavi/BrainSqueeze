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

package com.scavi.brainsqueeze.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 23/01/17
 */
public class MaxInArrayTest {

    @Test
    public void textMaxInArray1() {
        int[] input1 = new int[]{2, 3, 1, 7, 8};
        int[] input2 = new int[]{3, 6, 7};
        int retVal = new MaxInArray().maxDotProduct(input1, input2);
        Assert.assertEquals(107, retVal);
    }


    @Test
    public void testMaxInArray2() {
        int[] input1 = new int[]{1, 2, 3, 6, 1, 4};
        int[] input2 = new int[]{4, 5, 1};
        int retVal = new MaxInArray().maxDotProduct(input1, input2);
        Assert.assertEquals(46, retVal);
    }


    @Test
    public void testMaxInArray3() {
        int[] input1 = new int[]{0, 0};
        int[] input2 = new int[]{0};
        int retVal = new MaxInArray().maxDotProduct(input1, input2);
        Assert.assertEquals(0, retVal);
    }
}
