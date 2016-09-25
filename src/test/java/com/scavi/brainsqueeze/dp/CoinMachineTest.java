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
 * @since 23/09/16
 */
public class CoinMachineTest {
    @Test
    public void test1() {
        CoinMachine coinPossibilities = new CoinMachine();
        int[] coins = new int[]{1, 2, 3};
        int toExchange = 4;
        int possibilities = coinPossibilities.numberOfCoins(coins, toExchange);
        Assert.assertEquals(4, possibilities);
    }


    @Test
    public void test2() {
        CoinMachine coinPossibilities = new CoinMachine();
        int[] coins = new int[]{2, 5, 3, 6};
        int toExchange = 10;
        int possibilities = coinPossibilities.numberOfCoins(coins, toExchange);
        Assert.assertEquals(5, possibilities);
    }


    @Test
    public void test3() {
        CoinMachine coinPossibilities = new CoinMachine();
        int[] coins = new int[]{-3, 2, 5, 3, 6, 0};
        int toExchange = 10;
        int possibilities = coinPossibilities.numberOfCoins(coins, toExchange);
        Assert.assertEquals(5, possibilities);
    }


    @Test(expected = IllegalArgumentException.class)
    public void test4() {
        CoinMachine coinPossibilities = new CoinMachine();
        int[] coins = null;
        int toExchange = 4;
        coinPossibilities.numberOfCoins(coins, toExchange);
    }


    @Test(expected = IllegalArgumentException.class)
    public void test5() {
        CoinMachine coinPossibilities = new CoinMachine();
        int[] coins = new int[]{2, 5, 3, 6};
        int toExchange = -1;
        coinPossibilities.numberOfCoins(coins, toExchange);
    }
}
