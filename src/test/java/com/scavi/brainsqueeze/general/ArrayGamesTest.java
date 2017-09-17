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

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 05/02/17
 */
public class ArrayGamesTest {

    @Test
    public void testLeastAverage1() {
        ArrayGames arrayGames = new ArrayGames();
        int[] result = arrayGames.leastAverage(new int[]{3, 7, 90, 20, 10, 50, 40}, 3);
        Assert.assertEquals(3, result[0]);
        Assert.assertEquals(5, result[1]);
    }


    @Test
    public void testLeastAverage2() {
        ArrayGames arrayGames = new ArrayGames();
        int[] result = arrayGames.leastAverage(new int[]{3, 7, 5, 20, -10, 0, 12}, 2);
        Assert.assertEquals(4, result[0]);
        Assert.assertEquals(5, result[1]);
    }


    @Test
    public void testLongestZeroSum1() {
        ArrayGames arrayGames = new ArrayGames();
        int result = arrayGames.determineLongestZeroSum(new int[]{1, 2, 3, 4, -9, 6, 7, -8, 1, 9});
        Assert.assertEquals(5, result);
    }


    @Test
    public void test2DimArrayLookup1() {
        int[][] input = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 15, 16},
                {17, 18, 19, 20, 21}, {22, 23, 24, 25, 26}};
        ArrayGames arrayGames = new ArrayGames();
        for (int i = 1; i <= 26; ++i) {
            boolean isExisting = arrayGames.isValueExisting(input, i);

            if (i == 14) {
                Assert.assertFalse(isExisting);
            } else {
                Assert.assertTrue(isExisting);
            }
        }
    }

    @Test
    public void testMaxSum1() {
        int[] input = {-23, 1, 7, -5, 28, -48, 50};
        int sum = new ArrayGames().maxSum(input);
        Assert.assertEquals(50, sum);
    }

    @Test
    public void testMaxSum2() {
        int[] input = {-5, -10};
        int sum = new ArrayGames().maxSum(input);
        Assert.assertEquals(-5, sum);
    }

    @Test
    public void testMaxSum3() {
        int[] input = {-3, 10};
        int sum = new ArrayGames().maxSum(input);
        Assert.assertEquals(10, sum);
    }

    @Test
    public void testMaxSum4() {
        int[] input = {-2, 5, 60, -10, 23};
        int sum = new ArrayGames().maxSum(input);
        Assert.assertEquals(78, sum);
    }

    @Test
    public void testMaxSum5() {
        int[] input = {6, 2, 4, -1, 5, 9, -2, 10};
        int sum = new ArrayGames().maxSum(input);
        Assert.assertEquals(33, sum);
    }

    @Test
    public void testRearrange1() {
        int[] input = {5, 2, 3, 4, 1};
        int[] expected = {2, 5, 3, 4, 1};
        int[] output = new ArrayGames().rearrange(input);
        Assert.assertArrayEquals(expected, output);
    }
}
