package com.scavi.brainsqueeze.codefight.i.dp;

public class RegularExpressionMatching {

    /**
     * Note: Avoid using regular expressions and implement regex matching yourself in your solution, since this is
     * what you would be asked to do during a real interview.
     * <p>
     * Implement regular expression matching with support for '.' and '*', given the following guidelines:
     * '.' Matches any single character.
     * '*' Matches zero or more of the element that comes before it.
     * <p>
     * The matching should cover the entire input string s. If the pattern p matches the input string s, return true,
     * otherwise return false.
     *
     * @param input   A string consisting of only lowercase English letters.
     * @param pattern A string consisting of only lowercase English letters and the characters . and *.
     * @return Return true if the pattern p matches the string s given the guidelines above, otherwise return false.
     */
    boolean regularExpressionMatching(String input, String pattern) {
        input = " " + input;
        pattern = " " + pattern;

        boolean[][] cache = createCache(input, pattern);
        for (int i = 1; i < input.length(); ++i) {
            for (int p = 1; p < pattern.length(); ++p) {
                // if the current character is equal or if the current pattern char represents any single character
                if (input.charAt(i) == pattern.charAt(p) || pattern.charAt(p) == '.') {
                    cache[i][p] = cache[i - 1][p - 1];
                }
                // matches 0:n of the previous character
                else if (pattern.charAt(p) == '*') {
                    // * + prev character occur 0 times
                    if (cache[i][p - 2]) {
                        cache[i][p] = true;
                    }
                    // * + prev character occur So either take left or up from the cache
                    else if ((input.charAt(i) == pattern.charAt(p - 1) || pattern.charAt(p - 1) == '.')) {
                        cache[i][p] = cache[i - 1][p] || cache[i][p - 1];
                    }
                }
            }
        }
        return cache[input.length() - 1][pattern.length() - 1];
    }

    private boolean[][] createCache(String input, String pattern) {
        boolean[][] cache = new boolean[input.length()][pattern.length()];
        cache[0][0] = true; // empty input matches empty pattern
        int lookup = 2;
        while (lookup < pattern.length() && pattern.charAt(lookup) == '*') {
            cache[0][lookup - 1] = true;
            cache[0][lookup] = true;
            lookup += 2;
        }
        return cache;
    }


//    boolean regularExpressionMatching(String input, String pattern) {
//        return regularExpressionMatching(input, 0, pattern, 0);
//    }
//
//
//    private boolean regularExpressionMatching(String input, int posI, String pattern, int posP) {
//        if (posI == input.length()) {
//            return isValidRestPattern(pattern, posP);
//        } else if (posP == pattern.length()) {
//            return false;
//        }
//
//        char currentPattern = pattern.charAt(posP);
//        if (currentPattern == '.') {
//            return regularExpressionMatching(input, posI + 1, pattern, posP + 1);
//        } else if (currentPattern == '*') {
//            char prevPattern = pattern.charAt(posP - 1);
//            if (prevPattern == '.' || prevPattern == input.charAt(posI)) {
//                return regularExpressionMatching(input, posI + 1, pattern, posP);
//            } else {
//                return regularExpressionMatching(input, posI, pattern, posP + 1);
//            }
//        }
//        if (currentPattern == input.charAt(posI)) {
//            return regularExpressionMatching(input, posI + 1, pattern, posP + 1);
//        }
//        return posP < pattern.length() - 1 && pattern.charAt(posP + 1) == '*' &&
//                regularExpressionMatching(input, posI, pattern, posP + 1);
//    }
//
//    private boolean isValidRestPattern(String pattern, int posP) {
//        if (posP == pattern.length() || (posP == pattern.length() - 1 && pattern.charAt(posP) == '*')) {
//            return true;
//        }
//        if (posP < pattern.length() - 1 && pattern.charAt(posP + 1) == '*') {
//            return isValidRestPattern(pattern, posP + 2);
//        }
//        return false;
//    }
}
