package com.scavi.brainsqueeze.geeks;

import javax.annotation.Nonnull;

public class LongestCommonSubSequence {
//    public int longestSubPath(@Nonnull final String string1, @Nonnull final String string2) {
//
//        int[][] cache = new int[string1.length() + 1][string2.length() + 1];
//
////        int result = 0;
////        for (int y = 0; y <= string1.length(); ++y) {
////            for (int x = 0; x <= string2.length(); ++x) {
////
////                if (x == 0 || y == 0) {
////                    cache[y][x] = 0;
////                } else if (string1.charAt(y - 1) == string2.charAt(x - 1)) {
////                    cache[y][x] = 1 + cache[y - 1][x - 1] + 1;
////                    result = Math.max(result, cache[y][x]);
////                } else {
////                    cache[y][x] = 0;
////                }
////            }
////        }
////        return result;
//
//        int result = 0;
//        for (int y = 0; y < string1.length(); ++y) {
//            for (int x = 0; x < string2.length(); ++x) {
//                if (string1.charAt(y) == string2.charAt(x)) {
//                    cache[y][x] = 1 + cache[y - 1][x - 1];
//                    result = Math.max(result, cache[y][x]);
//                }
//            }
//        }
//        return result;
//    }


    public int longestSubPath(@Nonnull final String string1, @Nonnull final String string2) {
        int result = 0;
        int[][] cache = new int[string1.length() + 1][string2.length() + 1];
        for (int y = 1; y <= string1.length(); ++y) {
            for (int x = 1; x <= string2.length(); ++x) {
                if (string1.charAt(y - 1) == string2.charAt(x  - 1)) {
                    cache[y][x] = 1 + cache[y - 1][x - 1];
                    result = Math.max(result, cache[y][x]);
                } else {
                    cache[y][x] = cache[y][x - 1];
                }
            }
        }
        return result;
    }

    public int LCSubStr(char X[], char Y[], int m, int n)
    {
        // Create a table to store lengths of longest common suffixes of
        // substrings. Note that LCSuff[i][j] contains length of longest
        // common suffix of X[0..i-1] and Y[0..j-1]. The first row and
        // first column entries have no logical meaning, they are used only
        // for simplicity of program
        int LCStuff[][] = new int[m + 1][n + 1];
        int result = 0;  // To store length of the longest common substring

        // Following steps build LCSuff[m+1][n+1] in bottom up fashion
        for (int i = 0; i <= m; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                if (i == 0 || j == 0)
                    LCStuff[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                {
                    LCStuff[i][j] = LCStuff[i - 1][j - 1] + 1;
                    result = Integer.max(result, LCStuff[i][j]);
                }
                else
                    LCStuff[i][j] = 0;
            }
        }
        return result;
    }
}
