package com.scavi.brainsqueeze.career;

import com.scavi.brainsqueeze.util.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class BouncingBall {

    public int waysToBounce(final int level) {
        return waysToBounce(level, 0);
    }

    private int waysToBounce(final int level, int it) {
        if (level < 0 || isStuck(level)) {
            return 0;
        } else if (level == 0) {
            return 1;
        }

        it++;
        int ways = waysToBounce(level - 1, it);
        if (it % 2 != 0) {
            ways += waysToBounce(level - 2, it);
        } else {
            ways += waysToBounce(level - 3, it);
        }
        ways += waysToBounce(level - 4, it);
        return ways;
    }


    public int waysToBounceDP(final int level) {
        Map<Pair<Integer, Boolean>, Integer> dpCache = new HashMap<>();
        return waysToBounceDP(level, dpCache, 0);
    }


    // TODO in progress 
    public int waysToBounceDP(final int level, Map<Pair<Integer, Boolean>, Integer> dpCache, int it) {
        if (level < 0 || isStuck(level)) {
            return 0;
        } else if (level == 0) {
            return 1;
        }

        Pair<Integer, Boolean> lookup = new Pair<>(it, it % 2 != 0);
        if (dpCache.containsKey(lookup)) {
            return dpCache.get(lookup);
        }

        it++;
        int ways = waysToBounceDP(level - 1, dpCache, it);
        if (it % 2 != 0) {
            ways += waysToBounceDP(level - 2, dpCache, it);
        } else {
            ways += waysToBounceDP(level - 3, dpCache, it);
        }
        ways += waysToBounceDP(level - 4, dpCache, it);

        dpCache.put(lookup, ways);
        return ways;
    }


    private boolean isStuck(int level) {
        return false;
    }
}


