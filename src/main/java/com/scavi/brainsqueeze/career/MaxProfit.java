package com.scavi.brainsqueeze.career;

import javax.annotation.Nonnull;

public class MaxProfit {
    public int maxProfit(@Nonnull int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int low = prices[0];
        int high = Integer.MIN_VALUE;
        int max = 0;
        int current;
        for (int i = 1; i < prices.length; ++i) {
            current = prices[i];
            if (high < current) {
                high = current;
                max = Math.max(high - low, max);
            } else if (current > high) {
                high = Integer.MIN_VALUE;
                low = current;
            }
        }
        return max;
    }
}
