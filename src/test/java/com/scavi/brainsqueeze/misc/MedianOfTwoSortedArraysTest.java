package com.scavi.brainsqueeze.misc;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static com.google.common.truth.Truth.*;

public class MedianOfTwoSortedArraysTest {
    @Test
    public void testOddCopied() {
        int[] input1 = new int[]{1, 3, 8, 9, 15};
        int[] input2 = new int[]{7, 11, 18, 19, 21, 25};
        double result = new MedianOfTwoSortedArrays().findMedianSortedArrayCopied(input1, input2);
        assertThat(result).isEqualTo(11.0);
    }

    @Test
    public void testEvenCopied() {
        int[] input1 = new int[]{23, 26, 31, 35};
        int[] input2 = new int[]{3, 5, 7, 9, 11, 16};
        double result = new MedianOfTwoSortedArrays().findMedianSortedArrayCopied(input1, input2);
        assertThat(result).isEqualTo(13.5);
    }


    @Test
    public void testOdd() {
        int[] input1 = new int[]{1, 3, 8, 9, 15};
        int[] input2 = new int[]{7, 11, 18, 19, 21, 25};
        double result = new MedianOfTwoSortedArrays().findMedianSortedArray(input1, input2);
        assertThat(result).isEqualTo(11.0);
    }

    @Test
    public void testEven() {
        int[] input1 = new int[]{23, 26, 31, 35};
        int[] input2 = new int[]{3, 5, 7, 9, 11, 16};
        double result = new MedianOfTwoSortedArrays().findMedianSortedArray(input1, input2);
        assertThat(result).isEqualTo(13.5);
    }


    @Test
    public void testPerf() {
        int max1 = 20000000;
        int max2 = 9999999;
        Random random = new Random();
        int[] input1 = new int[max1];
        int[] input2 = new int[max2];
        for (int i = 0; i < max1; ++i) {
            input1[i] = random.nextInt(Integer.MAX_VALUE);
        }
        for (int i = 0; i < max2; ++i) {
            input2[i] = random.nextInt(Integer.MAX_VALUE);
        }
        Arrays.sort(input1);
        Arrays.sort(input2);

        long s1 = System.nanoTime();
        new MedianOfTwoSortedArrays().findMedianSortedArrayCopied(input1, input2);
        long e1 = System.nanoTime();

        long s2 = System.nanoTime();
        new MedianOfTwoSortedArrays().findMedianSortedArray(input1, input2);
        long e2 = System.nanoTime();


        long r1 = e1 - s1;
        long r2 = e2 - s2;
        // log solution: 635166 , n/2 solution with less operations: 77198677
        // log solution: 707702 , n/2 solution with less operations: 74673545
        System.err.println(String.format("log solution: %d , n/2 solution with less operations: %d", r1, r2));
    }
}
