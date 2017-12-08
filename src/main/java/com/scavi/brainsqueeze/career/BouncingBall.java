package com.scavi.brainsqueeze.career;

import com.scavi.brainsqueeze.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BouncingBall {
    private final Set<Integer> _stickyLevels;

    public BouncingBall() {
        this(null);
    }

    public BouncingBall(final Set<Integer> stickyLevels) {
        _stickyLevels = stickyLevels;
    }


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


    /**
     * This solution uses a cache of the level to it's odd / equal information to store already calculated values.
     * The rest is the like the recursive solution that just follows all paths from the current leevel.
     *
     * @param level the level to bounce
     * @return the ways to bounce from the level
     */
    public long waysToBounceDP(final int level) {
        Map<Pair<Integer, Boolean>, Long> dpCache = new HashMap<>();
        return waysToBounceDP(level, dpCache, 0);
    }


    private long waysToBounceDP(final int level, Map<Pair<Integer, Boolean>, Long> dpCache, int it) {
        if (level < 0 || isStuck(level)) {
            return 0;
        } else if (level == 0) {
            return 1;
        }

        Pair<Integer, Boolean> lookup = new Pair<>(level, it % 2 != 0);
        if (dpCache.containsKey(lookup)) {
            return dpCache.get(lookup);
        }

        it++;
        long ways = waysToBounceDP(level - 1, dpCache, it);
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
        return _stickyLevels != null && _stickyLevels.contains(level);
    }
}


