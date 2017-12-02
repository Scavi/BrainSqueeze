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
}
