package com.scavi.brainsqueeze.career;

import javax.annotation.Nonnull;

public class BenchPlace {

    public int findPlace(@Nonnull final boolean[] input) {
        int pos = 0;
        int maxDistance = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < input.length; ++i) {
            if (input[i]) {
                if (left == 0 && !input[0]) {
                    pos = 0;
                } else {
                    pos = right - left > maxDistance ? left + ((right - left) / 2) : pos;
                }
                left = right;
            } else if (i == input.length - 1) {
                pos = right - left > maxDistance ? i : pos;
            } else {
                maxDistance = Math.max(maxDistance, right - left);
            }
            right++;
        }
        return pos;
    }
}
