package com.scavi.brainsqueeze.dp;

/**
 * Created by Michael Heymel on 23/09/16.
 */
public class CoinMachine {


    /**
     * Given a value N, if we want to make change for N cents, and we have infinite supply of each
     * of S = { S1, S2, ... , Sm} valued coins, how many ways can we make the change? The order of
     * coins doesn't matter.
     * <p/>
     * Example 1: for N = 4 and S = {1,2,3}, there are four solutions:
     * {1,1,1,1},{1,1,2},{2,2},{1,3}. Output: 4
     * <p/>
     * Example 2: For N = 10 and S = {2, 5, 3, 6} there are five solutions: {2,2,2,2,2}, {2,2,3,3},
     * {2,2,6}, {2,3,5} and {5,5}. Output: 5
     * <p/>
     * <p/>
     * This algorithm runs in O(n) * O(m) while n is the given exchange value and m is the number of
     * given coins. The algorithm uses O(n) space to create the dp cache.
     *
     * @param coins      an array of given coins
     * @param toExchange the given coins to exchange
     * @return the amount of possible solutions to exchange
     */
    public int numberOfCoins(final int[] coins, final int toExchange) {

        if (coins == null || coins.length == 0) {
            throw new IllegalArgumentException("Illegal coin data! Please specify one coin value.");
        } else if (toExchange < 0) {
            throw new IllegalArgumentException("A negative exchange is not supported!");
        }

        // +1 array size to construct in button up
        int[] cache = new int[toExchange + 1];
        cache[0] = 1;

        for (int i = 0; i < coins.length; ++i) {
            final int coinValue = coins[i];

            if (coinValue > 0) {
                for (int j = coinValue; j <= toExchange; ++j) {
                    cache[j] += cache[j - coinValue];
                }
            }
        }
        return cache[toExchange];
    }
}
