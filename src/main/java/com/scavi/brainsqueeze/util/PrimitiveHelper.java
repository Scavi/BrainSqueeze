package com.scavi.brainsqueeze.util;

import javax.annotation.Nonnull;
import java.util.List;

public class PrimitiveHelper {
    /**
     * Converts a <code>List<Integer</code> to a primitive <code>int[]</code> array
     *
     * @param list the list to convert
     * @return the result
     */
    public static int[] toPrimitive(@Nonnull final List<Integer> list) {
        int[] res = new int[list.size()];
        int pos = 0;
        for (Integer i : list) {
            res[pos++] = i;
        }
        return res;
    }


    /**
     * Converts the characters of the given string to their corresponding ascii decimal
     *
     * @param input the input string
     * @return the result
     */
    public static int[] toAsciiDec(@Nonnull final String input) {
        int[] result = new int[input.length()];
        int pos = 0;
        for (char c : input.toCharArray()) {
            result[pos++] = c;
        }
        return result;
    }
}
