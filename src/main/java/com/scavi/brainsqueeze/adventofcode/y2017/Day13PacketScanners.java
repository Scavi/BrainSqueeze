package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.adventofcode.util.AoCInputParser;

public class Day13PacketScanners {
    private static final int DEPTH = 0;
    private static final int RANGE = 1;

    public int solveA(final String[] input) {
        int[][] scanner = AoCInputParser.arrayPairFrom(input);
        int scannerRange = scanner[scanner.length - 1][DEPTH];
        int severity = 0;
        int lookup;
        int scannerPos = 0;
        for (int i = 0; i <= scannerRange; ++i) {
            int depth = scanner[scannerPos][DEPTH];
            if (i == depth) {
                // due to the top down movement, the scanner reaches the top position at (depth - 1) * 2,
                // e.g. for depth 3, it is 0, 4, 8, 12, 16...
                lookup = (scanner[scannerPos][RANGE] - 1) * 2;
                if (i % lookup == 0) {
                    severity += (i * scanner[scannerPos][RANGE]);
                }
                scannerPos++;
            }
        }
        return severity;
    }

    public int solveBruteForceB(final String[] input) {
        int delay = 0;
//        while (solve(input, delay, true) != 0) {
//            delay++;
//        }
        return delay;
    }

    public int solveB(final String[] input) {
        int max = 15; //5000000;
        boolean[] toWait = new boolean[max];

        int[][] scanner = AoCInputParser.arrayPairFrom(input);
        int scannerRange = scanner[scanner.length - 1][DEPTH];

        int scannerPos = 0;
        for (int i = 0; i <= scannerRange; ++i) {
            int depth = scanner[scannerPos][DEPTH];
            if (i == depth) {

                int lookup = (scanner[scannerPos][RANGE] - 1) * 2;
                while (lookup < max) {
                    toWait[lookup] = true;
                    lookup += (scanner[scannerPos][RANGE] - 1) * 2;
                }
                scannerPos++;
            }
        }
        for (int i = 0; i < max; ++i) {
            if (!toWait[i]) {
                return i;
            }
        }
        return 0;
    }


//    private int solve(final String[] input, final int offset, final boolean isSneaking) {
//        int[][] scanner = AoCInputParser.arrayPairFrom(input);
//        int scannerRange = scanner[scanner.length - 1][DEPTH];
//        int severity = 0;
//
//        int tmp, lookup;
//        int scannerPos = 0;
//        for (int i = 0; i <= scannerRange; ++i) {
//            int depth = scanner[scannerPos][DEPTH];
//            if (i == depth) {
//                tmp = i + offset;
//                lookup = (scanner[scannerPos][RANGE] - 1) * 2;
//                // due to the top down movement, the scanner reaches the top position at (depth - 1) * 2,
//                // e.g. for depth 3, it is 0, 4, 8, 12, 16...
//                if (IntMath.gcd(tmp, lookup) == lookup) {
//                    if (isSneaking) {
//                        return -1;
//                    }
//                    severity += (i * scanner[scannerPos][RANGE]);
//                }
//                scannerPos++;
//            }
//        }
//        return severity;
//    }
}