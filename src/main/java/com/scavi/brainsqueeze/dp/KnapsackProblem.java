package com.scavi.brainsqueeze.dp;

public class KnapsackProblem {
    private static final int VALUE_POS = 0;
    private static final int WEIGHT_POS = 1;

    /**
     * This method uses dynamic programming to solve the given knapsack problem.
     *
     * @param knapsackData   a two dimensional array with all knapsack data. The first
     *                       entry contains the value, the corresponding second value
     *                       contains the weight, like:<br>
     *                       <p>
     *                       [60][20] = value of 60 for the weight of 20<br>
     *                       [20][10] = value of 20 for the weight of 10<br>
     *                       ...
     * @param knapsackWeight the maximal allowed weight
     * @return the maximal value
     */
    public int solveKnapsack(final int[][] knapsackData, final int knapsackWeight) {

        if (knapsackData == null || knapsackData.length == 0 ||
                knapsackData[0].length != 2) {
            return 0;
        }
        int tmpCalculation = 0;
        final int valueCount = knapsackData.length;
        // assumes that all array positions will be initialized with 0
        final int[][] cache = new int[valueCount + 1][knapsackWeight + 1];
        // construct the dynamic programming cache in a up-bottom way while
        // iterating over all values
        for (int y = 1; y <= valueCount; ++y) {
            // create for every value for every weight position the maximum
            // current value.
            for (int x = 1; x <= knapsackWeight; ++x) {
                // make sure, that the current weight value of the knapsack data
                // is equal or higher then the current weight position
                if (knapsackData[y - 1][WEIGHT_POS] <= x) {

                    // goes to the left side in the cache and selects the
                    // already calculated value. The steps to the left depend on
                    // the weight of the current knapsack data, e.g. weight = 2
                    // and value 3, then the calculation would look like
                    //         !       ! (pos is 3 > weight 2 and pos is
                    //                                      5 > 2*2 weight)
                    // 0 | 0 | 3 | 3 | 6 | 6 ...
                    tmpCalculation = cache[y][x - knapsackData[y - 1][WEIGHT_POS]]
                            + knapsackData[y - 1][VALUE_POS];
                    // compares the current calculated value with the value of
                    // the upper row.
                    cache[y][x] = Math.max(tmpCalculation, cache[y - 1][x]);
                } else {
                    cache[y][x] = Math.max(cache[y - 1][x], cache[y][x - 1]);
                }
            }
        }
        return cache[valueCount][knapsackWeight];
    }

}
