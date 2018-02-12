package com.scavi.brainsqueeze.codefight.i.dp;


public class MapDecoding {
    private final int MOD = 1000000007;

    /**
     * A top secret message containing uppercase letters from 'A' to 'Z' has been encoded as numbers using the
     * following mapping:
     * <p>
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * You are an FBI agent and you need to determine the total number of ways that the message can be decoded.
     * <p>
     * Since the answer could be very large, take it modulo 109 + 7.
     *
     * @param message the message to decode
     * @return the ways to decode the message
     */
    int mapDecoding(String message) {
        int prev = 0;
        int current = 1;
        // each iteration compares the current digit and (except for the first iteration) the last number that gets
        // generated from the last and the current
        for (int i = 0; i < message.length(); ++i) {
            int twoDigits = i > 0 ? Integer.parseInt(message.substring(i - 1, i + 1)) : -1;
            // if we have 00 inside of the message it is an illegal encoding.
            if (twoDigits == 0) {
                return 0;
            }
            int tmp = 0;
            if (message.charAt(i) - 48 > 0) {
                tmp = current;
            }
            // 0 values will be ignored (this also allows us to react on values like ...30... that can't get decoded
            if (twoDigits >= 10 && twoDigits <= 26) {
                tmp += prev;
            }
            prev = current;
            current = tmp % MOD;
        }
        return current;
    }
}
