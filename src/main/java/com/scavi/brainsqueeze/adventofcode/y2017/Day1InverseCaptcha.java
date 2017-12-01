package com.scavi.brainsqueeze.adventofcode.y2017;

public class Day1InverseCaptcha {
    public int solve(String input, boolean isAdjacent) {
        int result = 0;
        int split = isAdjacent ? 1 : input.length() / 2;
        for (int i = 0; i < input.length(); ++i) {
            if (input.charAt(i) == input.charAt((i + split) % input.length())) {
                result += Integer.parseInt("" + input.charAt(i));
            }
        }
        return result;
    }
}
