package com.scavi.brainsqueeze.codefight.challenge;

public class Walk {
    int toAndFro(int a, int b, int t) {
        int d = Math.abs(b - a);
        return t < d ? a < b ? a + t : a - t : toAndFro(b, a, t - d);
    }



//    int toAndFro(int a, int b, int t) {
//        d = Math.abs(b - a);
//        p = t % d;
//        r = t / d;
//        return a < b ?
//                (r % 2 == 0) ? a + p : b - p :
//                (r % 2 != 0) ? b + p : a - p;
//    }
}
