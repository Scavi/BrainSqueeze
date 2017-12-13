package com.scavi.brainsqueeze.util;

public class MathHelper {
    public static int gcd(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }
}
