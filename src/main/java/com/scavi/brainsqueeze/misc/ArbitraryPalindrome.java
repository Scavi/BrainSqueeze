package com.scavi.brainsqueeze.misc;

import javax.annotation.Nonnull;

public class ArbitraryPalindrome {

    private static final int UPPER_REDUCTION = 64;
    private static final int LOWER_REDUCTION = 70;

    public boolean isPossiblePalindrome(@Nonnull final String input) {
        if (input.length() == 0) {
            return false;
        }
        long cache = 0;
        for (char current : input.toCharArray()) {
            // A-Z
            if (current >= 65 && current <= 90) {
                cache ^= (1 << (current - UPPER_REDUCTION));
            }
            // a-z
            else if (current >= 97 && current <= 122) {
                cache ^= (1 << (current - LOWER_REDUCTION));
            } else {
                throw new IllegalArgumentException("...");
            }
        }

        int bitCount = 0;
        while (cache > 0) {
            if ((cache & 1) == 1) {
                bitCount++;
                if (bitCount > 1) {
                    return false;
                }
            }
            cache >>= 1;
        }
        return true;
    }

}
