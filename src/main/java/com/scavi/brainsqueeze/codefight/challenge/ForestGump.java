package com.scavi.brainsqueeze.codefight.challenge;

public class ForestGump {
    int i, m = Integer.MAX_VALUE, r = m;

    int runForerstRun(int[] distance, int[] shrimp) {
        for (int d : distance)
            r = shrimp[i++] - d >= 0 ? Math.min(r, i) : m;
        return r;
    }
}
