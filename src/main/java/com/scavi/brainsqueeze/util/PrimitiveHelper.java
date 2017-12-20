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
     * Creates token from the given input using the delimiter. Trims and converts the values to integer,
     * e.g. "1,2,3" -> int[]{1,2,3}
     *
     * @param input     the input string
     * @param delimiter the delimiter
     * @return the integer array from the input
     */
    public static int[] toIntArray(@Nonnull final String input, final String delimiter) {
        String[] tokens = input.split(delimiter);
        int[] intArray = new int[tokens.length];
        for (int i = 0; i < intArray.length; ++i) {
            intArray[i] = Integer.parseInt(tokens[i].trim());
        }
        return intArray;
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
