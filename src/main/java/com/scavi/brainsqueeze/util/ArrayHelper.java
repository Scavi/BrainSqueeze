package com.scavi.brainsqueeze.util;

import javax.annotation.Nonnull;

public class ArrayHelper {

    /**
     * Creates a new array. Adds the elements of the first array from 0 to array1.length. Adds the elements of the
     * second array after the elements of the first
     *
     * @param array1 the array 1 to merge
     * @param array2 the array 2 to merge
     * @return the combined array
     */
    public static int[] merge(@Nonnull final int[] array1, @Nonnull final int[] array2) {
        int[] result = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, result, 0, array1.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }
}
