package com.scavi.brainsqueeze.codefight.i.hsq;

import java.util.PriorityQueue;

public class KthLargest {


    /**
     * Find the kth largest element in an unsorted array. This will be the kth largest element in sorted order, not
     * the kth distinct element.
     *
     * @param nums all numbers
     * @param k    the k-th largest
     * @return the k-th largest element from the given number
     */
    int kthLargestElement(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else {
                if (minHeap.peek() < num) {
                    minHeap.poll();
                    minHeap.offer(num);
                }
            }
        }
        return minHeap.poll();
    }

}
