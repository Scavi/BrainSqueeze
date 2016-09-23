package com.scavi.brainsqueeze.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Scavenger on 23/09/16.
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
