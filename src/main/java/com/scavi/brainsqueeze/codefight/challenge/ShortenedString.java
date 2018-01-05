package com.scavi.brainsqueeze.codefight.challenge;

/**
 * @author Michael Heymel
 * @since 26.12.17
 */
public class ShortenedString {
    int j, v;

    String shortenedString(String s) {
        return d(new StringBuilder(s), 0, -1).toString();
    }

    StringBuilder d(StringBuilder s, int p, int o) {
        for (int i = p; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                s = d(s, i + 1, i + 1);
            } else if (c > 47 && c < 57) {
                j = 1;
                v = c - 48;
                s.replace(i, i + 1, "");
                while (j++ < v) {
                    s.insert(i + j, s.charAt(i - 1));
                }
            }
        }
        return s;
    }

}
