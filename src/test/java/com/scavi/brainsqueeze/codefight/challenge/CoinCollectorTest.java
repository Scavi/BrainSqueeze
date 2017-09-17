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

package com.scavi.brainsqueeze.codefight.challenge;

import com.scavi.brainsqueeze.codefight.challenge.CoinCollector;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Scavenger on 6/12/2017.
 */
public class CoinCollectorTest {

    @Test
    public void test1() {
        int[][] input = {{0, 1}, {1, 1}, {2, 0}, {1, 2}, {2, 2}, {2, 0}};
        int result = new CoinCollector().maximizeCoins(input);
        Assert.assertEquals(4, result);
    }

    @Test
    public void test2() {
        int[][] input = {{3, 3}, {1, 3}, {7, 4}, {4, 0}, {2, 2}, {7, 3}, {8, 8}, {3, 9}, {1, 8}, {6, 7}};
        int result = new CoinCollector().maximizeCoins(input);
        Assert.assertEquals(5, result);
    }

    @Test
    public void test3() {
        int[][] input = {{0, 0}};
        int result = new CoinCollector().maximizeCoins(input);
        Assert.assertEquals(1, result);
    }

    @Test
    public void test4() {
        int[][] input = {{0, 0}, {0, 1}, {1, 2}, {4, 3}, {8, 3}, {4, 6}, {7, 6}};
        int result = new CoinCollector().maximizeCoins(input);
        Assert.assertEquals(6, result);
    }

    @Test
    public void test5() {
        int[][] input = {{8, 3}, {6, 7}, {1, 5}, {10, 4}, {6, 2}, {5, 1}, {8, 0}, {10, 7}, {8, 6}, {0, 10}};
        int result = new CoinCollector().maximizeCoins(input);
        Assert.assertEquals(5, result);
    }

    @Test
    public void test6() {
        int[][] input = {{10, 1}, {9, 2}, {10, 2}};
        int result = new CoinCollector().maximizeCoins(input);
        Assert.assertEquals(2, result);
    }

    @Test
    public void test7() {
        int[][] input = {{10, 1}, {9, 2}, {11, 1}, {11, 1}};
        int result = new CoinCollector().maximizeCoins(input);
        Assert.assertEquals(3, result);
    }

    @Test
    public void test8() {
        int[][] input = {{2,15}, {15,2}, {5,5}, {5,5}, {6,6}, {17,2}, {11,4}, {18,2}, {19,2}, {20,2},};
        int result = new CoinCollector().maximizeCoins(input);
        Assert.assertEquals(5, result);
    }
}
