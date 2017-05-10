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

package com.scavi.brainsqueeze.geeks;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 5/9/2017
 */
public class MissingNumberTest {

    @Test
    public void test1()
    {
        int[] input1 = {4, 8, 1, 3, 7};
        int[] input2 = {7, 4, 3, 1};
        int missingNumber = new MissingNumber().findMissingNumber(input1, input2);
        Assert.assertEquals(8, missingNumber);
    }

    @Test
    public void test2()
    {
        int[] input1 = {12, 10, 15, 23, 11, 30};
        int[] input2 = {15, 12, 23, 11, 30};
        int missingNumber = new MissingNumber().findMissingNumber(input1, input2);
        Assert.assertEquals(10, missingNumber);
    }


    @Test
    public void test3()
    {
        int[] input1 = {4, 8, 1, 3, 7};
        int[] input2 = {7, 4, 3, 1};
        int missingNumber = new MissingNumber().findMissingNumber(input2, input1);
        Assert.assertEquals(8, missingNumber);
    }

    @Test
    public void test4()
    {
        int[] input1 = {12, 10, 15, 23, 11, 30};
        int[] input2 = {15, 12, 23, 11, 30};
        int missingNumber = new MissingNumber().findMissingNumber(input2, input1);
        Assert.assertEquals(10, missingNumber);
    }
}
