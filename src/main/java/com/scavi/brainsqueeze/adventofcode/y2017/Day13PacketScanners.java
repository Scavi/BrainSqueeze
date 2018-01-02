package com.scavi.brainsqueeze.adventofcode.y2017;

import com.google.common.math.IntMath;
import com.scavi.brainsqueeze.adventofcode.util.AoCInputParser;

public class Day13PacketScanners {
    private static final int DEPTH = 0;
    private static final int RANGE = 1;

    public int solveA(final String[] input) {
        return solve(input, 0, false);
    }

    public int solveB(final String[] input) {
        int delay = 0;
        while (solve(input, delay, true) != 0) {
            delay++;
        }
        return delay;
    }

    private int solve(final String[] input, final int offset, final boolean isSneaking) {
        int[][] scanner = AoCInputParser.arrayPairFrom(input);
        int scannerRange = scanner[scanner.length - 1][DEPTH];
        int severity = 0;

        int tmp, lookup;
        int scannerPos = 0;
        for (int i = 0; i <= scannerRange; ++i) {
            int depth = scanner[scannerPos][DEPTH];
            if (i == depth) {
                tmp = i + offset;
                lookup = (scanner[scannerPos][RANGE] - 1) * 2;
                // due to the top down movement, the scanner reaches the top position at (depth - 1) * 2,
                // e.g. for depth 3, it is 0, 4, 8, 12, 16...
                if (IntMath.gcd(tmp, lookup) == lookup) {
                    if (isSneaking) {
                        return -1;
                    }
                    severity += (i * scanner[scannerPos][RANGE]);
                }
                scannerPos++;
            }
        }
        return severity;
    }
}