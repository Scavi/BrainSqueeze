package com.scavi.brainsqueeze.career;

import javax.annotation.Nonnull;

public class FlipBinaryArray {

    /**
     * Given a binary array, you can flip 0 -> 1 or 1 -> 0 to make all the 1 are in the left part and all
     * the 0 in the right part.
     * e.g. 10110000 -> 1111000 only need one flip (index 1 0->1)
     * e.g. 00001 -> 10000 require 2 flips (index 0 0->1 and index 4 1->0)
     *
     * @param nums the given binary array
     * @return the number of min flips.
     */
    public int findMiniFlip(@Nonnull final int[] nums) {
        int[] fromLeft = new int[nums.length];
        int[] fromRight = new int[nums.length];

        int flipCount = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                flipCount++;
            }
            fromLeft[i] = flipCount;
        }

        flipCount = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] == 1) {
                flipCount++;
            }
            fromRight[i] = flipCount;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; ++i) {
            min = Math.min(min, fromLeft[i - 1] + fromRight[i]);
        }
        return min;
    }
}
