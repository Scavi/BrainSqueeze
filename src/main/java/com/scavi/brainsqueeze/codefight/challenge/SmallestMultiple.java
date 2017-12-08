package com.scavi.brainsqueeze.codefight.challenge;

import java.util.TreeSet;

public class SmallestMultiple {
    public int findNthSmallestMultiple(int[] a, int n) {
        TreeSet<Object> s = new TreeSet<>();
        for (int i : a)
            for (int j = 1; j <= n; ++j)
                s.add(i * j);
        return (int) s.toArray()[n - 1];
    }
}
