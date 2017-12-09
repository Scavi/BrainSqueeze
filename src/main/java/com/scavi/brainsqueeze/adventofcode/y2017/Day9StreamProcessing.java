package com.scavi.brainsqueeze.adventofcode.y2017;


import javax.annotation.Nonnull;

public class Day9StreamProcessing {
    private final int POS_SCORE = 0;
    private final int POS_GARBAGE = 1;

    public int solveA(@Nonnull final String input) {
        int[] result = new int[2];
        solve(new StringBuilder(input), 1, result);
        return result[POS_SCORE];
    }

    public int solveB(@Nonnull final String input) {
        int[] result = new int[2];
        solve(new StringBuilder(input), 1, result);
        return result[POS_GARBAGE];
    }

    private void solve(final StringBuilder input, int level, int[] result) {
        while (input.length() > 0) {
            input.deleteCharAt(0);
            if (input.charAt(0) == '}') {
                result[POS_SCORE] += level;
                return;
            } else if (input.charAt(0) == '{') {
                solve(input, level + 1, result);
            } else if (input.charAt(0) == '<') {
                result[POS_GARBAGE] += removeGarbage(input);
            }
        }
    }

    private int removeGarbage(final StringBuilder input) {
        int garbage = 0;
        boolean isEndOfGarbage = false;
        input.deleteCharAt(0);
        while (input.length() > 0 && !isEndOfGarbage) {
            if (input.charAt(0) == '>') {
                isEndOfGarbage = true;
            } else {
                if (input.charAt(0) == '!') {
                    input.deleteCharAt(0);
                } else {
                    garbage++;
                }
                input.deleteCharAt(0);

            }
        }
        return garbage;
    }
}