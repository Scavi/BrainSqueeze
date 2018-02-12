package com.scavi.brainsqueeze.codefight.challenge;

import java.util.ArrayList;
import java.util.List;

public class NCheckSum {
    List<int[]> r = new ArrayList<>();

    int[][] nckSum(int n, int k) {
        s(new int[k], 0, 0, n, 1);
        int[][] t = new int[r.size()][];
        int p = 0;
        for (int[] a : r) {
            t[p++] = a;
        }
        return t;
    }


    void s(int[] a, int s, int b, int n, int q) {
        if (b == a.length || s > n) {
            if (s == n) {
                r.add(a.clone());
            }
        } else {
            for (int i = q; i <= n; ++i) {
                s += i;
                a[b] = i;
                s(a, s, b + 1, n, i + 1);
                s -= i;
            }
        }
    }
}
