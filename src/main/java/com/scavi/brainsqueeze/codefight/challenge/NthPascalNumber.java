package com.scavi.brainsqueeze.codefight.challenge;

public class NthPascalNumber {
    int t,n,k,i,r = 1;
    int nthPascalNumber(int v) {
        // determine k and n
        while (n + 1 + t <= v) {
            t += ++n;
            k = v - t -1;
        }
        // due to our determination n > k we can skip:
        // if ( k > n - k ) k = n - k;

        // determine the result using binomial coefficient
        while (i < k)
            r = (r * (n - i)) / (i++ + 1);

        return r;
    }
}
