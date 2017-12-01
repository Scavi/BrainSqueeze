package com.scavi.brainsqueeze.codefight.challenge;

public class ConvolutedSummary {
    String convolutedSummary(String l) {
        char[] t = l.replaceAll("[^AaBbCcDdEeVvWwXxYyZz]", "").toCharArray();
        int i = 0;
        for (char c : t) {
            int p = c > 96 && c < 103 ? -32 : c > 85 && c < 91 ? 32 : 0;
            t[i++] = (char) (c + p);
        }
        return new String(t);
    }
}
