package com.scavi.brainsqueeze.codefight.challenge;

public class ForestGump {
    int i,j,p;
    int runForerstRun(int[] d, int[] s) {
        for (; i < d.length; ++i) {
            int e = 0;
            for (j = i; j < d.length && e >= 0; ++j) {
                p = j % d.length;
                e += s[p] - d[p];
            }
            if (e >= 0)
                return i + 1;
        }
        return -1;
    }
}
