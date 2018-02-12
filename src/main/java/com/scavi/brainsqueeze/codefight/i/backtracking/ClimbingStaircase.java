package com.scavi.brainsqueeze.codefight.i.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ClimbingStaircase {
    int[][] climbingStaircase(int n, int k) {
        if (n == 0 || k == 0) {
            return new int[0][0];
        }
        List<int[]> result = new ArrayList<>();
        Stack<Integer> cache = new Stack<>();
        climbingStaircase(result, cache, 0, n, k);
        return from(result);
    }


    private void climbingStaircase(List<int[]> result, Stack<Integer> cache, int overallValue, int n, int k) {
        if (overallValue == n) {
            result.add(convert(cache));
            return;
        } else if (overallValue > n) {
            return;
        }
        for (int i = 1; i <= k; ++i) {
            cache.push(i);
            overallValue += i;
            climbingStaircase(result, cache, overallValue, n, k);
            overallValue -= i;
            cache.pop();
        }
    }


    private int[] convert(final Stack<Integer> cache) {
        int[] output = new int[cache.size()];
        for (int i = 0; i < cache.size(); ++i) {
            output[i] = cache.get(i);
        }
        return output;
    }


    private int[][] from(final List<int[]> result) {
        int[][] output = new int[result.size()][];
        int pos = 0;
        for (int[] tmp : result) {
            output[pos++] = tmp;
        }
        return output;
    }
}
