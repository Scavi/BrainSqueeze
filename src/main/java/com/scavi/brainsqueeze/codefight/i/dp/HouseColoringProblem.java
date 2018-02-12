package com.scavi.brainsqueeze.codefight.i.dp;

public class HouseColoringProblem {

    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;

    /**
     * In San Francisco, there is a row of several beautiful houses called the Painted Ladies. Each of the Painted
     * Ladies can be painted with one of three colors: red, blue or green. The cost of painting each house with a
     * certain color is different. cost[i][0] for each i is the cost of painting house i red, cost[i][1] is the cost
     * of painting it blue, and cost[i][2] is the cost of painting it green.
     * <p>
     * You want to paint all the houses in a way such that no two adjacent Painted Ladies have the same color. Find
     * the minimum cost to achieve this.In San Francisco, there is a row of several beautiful houses called the
     * Painted Ladies. Each of the Painted Ladies can be painted with one of three colors: red, blue or green. The
     * cost of painting each house with a certain color is different. cost[i][0] for each i is the cost of painting
     * house i red, cost[i][1] is the cost of painting it blue, and cost[i][2] is the cost of painting it green.
     * <p>
     * You want to paint all the houses in a way such that no two adjacent Painted Ladies have the same color. Find
     * the minimum cost to achieve this.
     * <p>
     * This approach uses dp and caches the previous results. The used formula is:
     * r = min(cost[i - 1, g], cost[i - 1, b])
     * g = min(cost[i - 1, b], cost[i - 1, r])
     * b = min(cost[i - 1, r], cost[i - 1, g])
     * This algorithm runs in O(n*m) time and could be done in place but it would change the cost input array. (It
     * could also be O(n) if we ignore the inner loop and access 0,1,2 direct)
     *
     * @param cost The costs of painting each Painted Lady a certain color following the guidelines: cost[i][0] for
     *             each i is the cost of painting house i red, cost[i][1] is the cost of painting it blue, and
     *             cost[i][2] is the cost of painting it green.
     * @return the min cost
     */
    int paintHouses(int[][] cost) {
        if (cost == null || cost.length == 0 || cost[0].length == 0) {
            return -1;
        }
        int[][] cache = new int[cost.length][cost[0].length];
        for (int x = 0; x < cost[0].length; ++x) {
            cache[0][x] = cost[0][x];
        }

        for (int y = 1; y < cache.length; ++y) {
            for (int x = 0; x < cache[0].length; ++x) {
                switch (x) {
                    case RED:
                        cache[y][x] = Math.min(cache[y - 1][GREEN], cache[y - 1][BLUE]) + cost[y][RED];
                        break;
                    case GREEN:
                        cache[y][x] = Math.min(cache[y - 1][RED], cache[y - 1][BLUE]) + cost[y][GREEN];
                        break;
                    case BLUE:
                        cache[y][x] = Math.min(cache[y - 1][GREEN], cache[y - 1][RED]) + cost[y][BLUE];
                        break;
                }
            }
        }
        return Math.min(cache[cache.length - 1][RED],
                Math.min(cache[cache.length - 1][GREEN], cache[cache.length - 1][BLUE]));
    }
}
