package com.scavi.brainsqueeze.codefight.i.dp;

public class ClimbingStairs {
    /**
     * You are climbing a staircase that has n steps. You can take the steps either 1 or 2 at a time. Calculate how
     * many distinct ways you can climb to the top of the staircase.
     *
     * @param n
     * @return
     */
    int climbingStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int prevprev = 1;
        int prev = 2;
        int current = 0;
        for (int i = 2; i < n; ++i) {
            current = prev + prevprev;
            prevprev = prev;
            prev = current;
        }
        return current;
    }
}
