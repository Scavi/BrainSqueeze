package com.scavi.brainsqueeze.puzzle;

/**
 * Created by Michael Heymel on 15/09/16.
 */
public class ArrayPuzzle {


    /**
     * Find the minimum of the sub-array of the given subarray size.
     *
     * @param input        the input array
     * @param subarraySize the size of the subarray
     * @return the minimum size
     */
    public int findMinimumOfSubarray(final int[] input, final int subarraySize) {

        if (input == null) {
            throw new IllegalArgumentException("Illegal input array: <null>");
        }
        if (input.length < subarraySize) {
            throw new IllegalArgumentException("Subarray size bigger then input array!");
        }

        int min = 0;
        for (int i = 0; i < subarraySize; ++i) {
            min += input[i];
        }

        int tmp = min;
        for (int i = subarraySize; i < input.length; ++i) {
            tmp -= input[i - subarraySize];
            tmp += input[i];
            min = Math.min(min, tmp);
        }
        return min;
    }


    /**
     * You have an unordered array X of n integers. Find the array M containing n elements where Mi
     * is the product of all integers in X except for Xi. You may not use division. You can use
     * extra memory. (Hint: There are solutions faster than O(n2).)
     * <p/>
     * For example with the integer array: 5 3 2 6 4
     * <p/>
     * 144 (3 * 2 * 6 * 4)
     * 240 (5 * 2 * 6 * 4)
     * 360 (5 * 3 * 6 * 4)
     * 120 (5 * 3 * 2 * 4)
     * 180 (5 * 3 * 2 * 6)
     * The algorithm runs with O(n) time and O(n) space.
     *
     * @param input the input array with the values
     * @return the input array with the values
     */
    public int[] solve(final int[] input) {
        if (input == null || input.length < 2) {
            throw new IllegalArgumentException("Input array needs at least the size of 2");
        }

        int inputLength = input.length;
        int[] leftToRight = new int[inputLength];
        int[] rightToLeft = new int[inputLength];
        prepareCaches(input, leftToRight, rightToLeft);

        int[] output = new int[inputLength];
        for (int i = 0; i < inputLength; ++i) {
            output[i] = leftToRight[i] * rightToLeft[i];
        }
        return output;
    }


    private void prepareCaches(int[] input, int[] leftToRight, int[] rightToLeft) {
        int inputLength = input.length;
        leftToRight[0] = 1;
        rightToLeft[inputLength - 1] = 1;

        // setup the left to right cache
        for (int i = 0; i < inputLength - 1; ++i) {
            leftToRight[i + 1] = input[i] * leftToRight[i];
        }

        // setup the right to left cache
        for (int i = inputLength - 1; i > 0; --i) {
            rightToLeft[i - 1] = input[i] * rightToLeft[i];
        }
    }
}
