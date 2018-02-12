package com.scavi.brainsqueeze.codefight.i.hsq;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NextLarger {
    int[] nextLarger(int[] a) {
        int[] result = new int[a.length];
        Arrays.fill(result, -1);
        PriorityQueue<Integer> posCache = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        posCache.offer(0);

        for (int i = 1; i < a.length; ++i) {
            while (!posCache.isEmpty() && a[posCache.peek()] < a[i]) {
                result[posCache.poll()] = a[i];
            }
            posCache.offer(i);
        }
        return result;
    }
}
