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
 * @since 19/03/17
 */

public class MaxSumTest {
    @Test
    public void testMaxSum1() {
        MaxSum maxSum = new MaxSum();
        int[] input = new int[]{31, -41, 59, 26, -53, 58, 97, -93, -23, 84};
        int max = maxSum.determineMaxSum(input);
        Assert.assertEquals(187, max);
    }
}