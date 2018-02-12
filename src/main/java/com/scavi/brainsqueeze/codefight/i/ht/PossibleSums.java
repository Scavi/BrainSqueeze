package com.scavi.brainsqueeze.codefight.i.ht;

import java.util.HashSet;
import java.util.Set;

public class PossibleSums {

    /**
     * You have a collection of coins, and you know the values of the coins and the quantity of each type of coin in
     * it. You want to know how many distinct sums you can make from non-empty groupings of these coins.
     * <p>
     * Example
     * <p>
     * For coins = [10, 50, 100] and quantity = [1, 2, 1], the output should be
     * possibleSums(coins, quantity) = 9.
     *
     * @param coins      the coins
     * @param quantities the quantity
     * @return the different sums
     */
    public int possibleSums(final int[] coins, final int[] quantities) {
        return possibleSums(new HashSet<>(), coins, quantities, 0, 0) - 1; // -1 because 0 is also in the result
    }


    private int possibleSums(final Set<Integer> sumCache, final int[] coins, final int[] quantities,
                             final int coinIt, final int sum) {
        int res = 0;
        if (coinIt == coins.length) {
            res = sumCache.contains(sum) ? 0 : 1;
            sumCache.add(sum);
        } else {
            for (int j = 0; j <= quantities[coinIt]; ++j) {
                int newSum = sum + (j * coins[coinIt]);
                res += possibleSums(sumCache, coins, quantities, coinIt + 1, newSum);
            }
        }
        return res;
    }
}
