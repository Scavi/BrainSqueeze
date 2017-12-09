package com.scavi.brainsqueeze.adventofcode.y2017;


import javax.annotation.Nonnull;

public class Day9StreamProcessing {
    private final int POS_SCORE = 0;
    private final int POS_GARBAGE = 1;

    public int solveA(@Nonnull final String input) {
        int[] result = new int[2];
        solve(input, result);
        return result[POS_SCORE];
    }

    public int solveB(@Nonnull final String input) {
        int[] result = new int[2];
        solve(input, result);
        return result[POS_GARBAGE];
    }

    private void solve(String input, int[] result) {
        int level = 0;
        for (int i = 0; i < input.length(); ++i) {
            if (input.charAt(i) == '{') {
                level++;
            } else if (input.charAt(i) == '}') {
                result[POS_SCORE] += level;
                level--;
            } else if (input.charAt(i) == '<') {
                boolean isEndOfGarbage = false;
                int garbage = 0;

                do {
                    i++;
                    if (input.charAt(i) == '>') {
                        isEndOfGarbage = true;
                    } else {
                        if (input.charAt(i) == '!') {
                            i++;
                        } else {
                            garbage++;
                        }
                    }
                } while (i < input.length() && !isEndOfGarbage);
                result[POS_GARBAGE] += garbage;
            }
        }
    }
}
