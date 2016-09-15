package com.scavi.brainsqueeze.puzzle;

/**
 * Created by Scavenger on 15/09/16.
 */
public class ArrayPuzzle {


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
