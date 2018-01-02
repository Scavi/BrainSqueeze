package com.scavi.brainsqueeze.codefight.i.ht;

import java.util.HashSet;
import java.util.Set;

public class PossibleSums {

    public int possibleSums(final int[] coins, final int[] quantities) {
        return possibleSums(new HashSet<>(), coins, quantities, 0, 0) - 1;
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
