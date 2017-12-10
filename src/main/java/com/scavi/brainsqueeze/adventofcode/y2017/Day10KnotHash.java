package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.util.ArrayHelper;
import com.scavi.brainsqueeze.util.PrimitiveHelper;
import com.scavi.brainsqueeze.util.StringHelper;

import javax.annotation.Nonnull;

public class Day10KnotHash {
    public int solveA(@Nonnull final int[] testData, @Nonnull final int[] rangeData) {
        return solve(testData, rangeData, 1);
    }


    public String solveB(@Nonnull final int[] testData, @Nonnull final String range) {
        int[] suffix = new int[]{17, 31, 73, 47, 23};
        int[] tmpRange = PrimitiveHelper.toAsciiDec(range);
        int[] rangeData = ArrayHelper.merge(tmpRange, suffix);
        solve(testData, rangeData, 64);
        int[] denseHash = createDenseHash(testData);
        return StringHelper.toHexString(denseHash);
    }


    private int solve(@Nonnull final int[] testData, @Nonnull final int[] rangeData, final int iterations) {
        int length = testData.length;
        int skipSize = 0;
        int currentPos = 0;
        for (int i = 0; i < iterations; ++i) {
            for (int range : rangeData) {
                int targetPos = (currentPos + range - 1);
                int sourcePos = currentPos;
                while (sourcePos < targetPos) {
                    swap(testData, sourcePos % length, targetPos % length);
                    sourcePos++;
                    targetPos--;
                }
                currentPos = (currentPos + range + skipSize++) % length;
            }
        }
        return testData[0] * testData[1];
    }


    private int[] createDenseHash(final int[] testData) {
        int[] denseHash = new int[testData.length / 16];
        for (int i = 0; i < testData.length; ++i) {
            int pos = i / 16;
            denseHash[pos] ^= testData[i];
        }
        return denseHash;
    }


    private void swap(final int[] testData, final int pos1, final int pos2) {
        if (pos1 != pos2) {
            int tmp = testData[pos1];
            testData[pos1] = testData[pos2];
            testData[pos2] = tmp;
        }
    }
}
