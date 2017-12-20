package com.scavi.brainsqueeze.codefight.arcade;

public class ValuesSumMinimization {
    int absoluteValuesSumMinimization(int[] input) {
        int split = input.length / 2;
        if (input.length % 2 == 1) {
            return input[split];
        }
        int left = absSumOf(input, input[split - 1]);
        int right = absSumOf(input, input[split]);
        return left == right || left < right ? input[split - 1] : input[split];
    }

    private int absSumOf(int[] input, int x) {
        int sum = 0;
        for (int i : input) {
            sum += Math.abs(i - x);
        }
        return sum;
    }
}
