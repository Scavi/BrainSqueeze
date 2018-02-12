package com.scavi.brainsqueeze.codefight.challenge;

public class MSquare {


    int mSquare(int n) {
        if (i(n)) return 1;
        while ((n & 3) == 0)
            n >>= 2;
        if ((n & 7) == 7) return 4;
        t = (int) (Math.sqrt(n));

        for (j = 1; j <= t; ++j)
            if (i(n - j * j))
                return 2;
        return 3;
    }

    int s, t, j;

    boolean i(int n) {
        s = (int) (Math.sqrt(n));
        return s * s == n;
    }

//    int i, j;
//
//    int mSquare(int n) {
//        if (n < 2) {
//            return n;
//        }
//        int[] t = new int[n + 1];
//        t[0] = 0;
//        t[1] = 1;
//        for (i = 2; i <= n; i++) {
//            t[i] = i;
//            for (j = 1; j * j <= i; j++) {
//                t[i] = Math.min(t[i], 1 + t[i - j * j]);
//            }
//        }
//        return t[n];
//    }


//    int mSquareRecursion(int n) {
//        int r = n;
//        if (n > 3) {
//            for (int i = (int)Math.sqrt(n); i > 0; --i) {
//                int t = (int)Math.pow(i, 2);
//                if (t <= n) {
//                    r = Math.min(r, 1+mSquareRecursion(n - t));
//                }
//            }
//        }
//        return r;
//    }
}
