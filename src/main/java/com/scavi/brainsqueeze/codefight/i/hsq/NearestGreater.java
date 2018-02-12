package com.scavi.brainsqueeze.codefight.i.hsq;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NearestGreater {

    int[] nearestGreater(int[] a) {
        int[] result = new int[a.length];
        Arrays.fill(result, -1);
        PriorityQueue<Integer> pos = new PriorityQueue<>((o1, o2) -> o2 - o1);
        pos.offer(0);
        for (int i = 1; i < a.length; ++i) {
            while (!pos.isEmpty() && a[pos.peek()] < a[i]) {
                result[pos.poll()] = i;
            }
            pos.offer(i);
        }

        pos = new PriorityQueue<>();
        pos.offer(a.length - 1);
        for (int i = a.length - 2; i >= 0; --i) {
            while (!pos.isEmpty() && a[pos.peek()] < a[i]) {

                int tmp = pos.poll();
                if (a[tmp] <= a[i] && (Math.abs(tmp - i) <= Math.abs(tmp - result[tmp]) || result[tmp] == -1)) {
                    result[tmp] = i;
                }
            }
            pos.offer(i);
        }
        return result;
    }
}
