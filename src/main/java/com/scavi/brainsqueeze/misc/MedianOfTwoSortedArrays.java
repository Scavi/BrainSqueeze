package com.scavi.brainsqueeze.misc;

public class MedianOfTwoSortedArrays {

    /**
     * This solution is from https://www.youtube.com/watch?v=LPFhl65R7ww
     * (https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch
     * /MedianOfTwoSortedArrayOfDifferentLength.java). I didn't write the source code - it is only
     * for test purposes.
     * It solves the question in O(log(min(x,y)) time (but with more operations)
     */
    public double findMedianSortedArrayCopied(int[] input1, int[] input2) {
        //if input1 length is greater than switch them so that input1 is smaller than input2.
        if (input1.length > input2.length) {
            return findMedianSortedArrayCopied(input2, input1);
        }
        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length
                // combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }

        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }


    public double findMedianSortedArray(int[] input1, int[] input2) {
        boolean isEven = (input1.length + input2.length) % 2 == 0;
        int lookupPos = ((input1.length + input2.length) / 2) - (isEven ? 1 : 3);
        int pos1 = 0;
        int pos2 = 0;
        int last = -1;
        int result = -1;

        for (int i = 0; i <= lookupPos; ++i) {
            int value1 = pos1 < input1.length ? input1[pos1] : Integer.MAX_VALUE;
            int value2 = pos2 < input2.length ? input2[pos2] : Integer.MAX_VALUE;

            if (value1 < value2) {
                pos1++;
                result = input1[pos1];
            } else {
                pos2++;
                result = input2[pos2];
            }

            if (i < lookupPos) {
                last = result;
            }
        }
        return isEven ? ((double)(result + last) / 2) : result;
    }
}
