package com.scavi.brainsqueeze.codefight.i.hsq;

public class DecodeString {
    private final int CURRENT_POS = 0;
    private final int PROCESSED_POS = 1;

    public String decodeString(final String input) {
        return decodeString(input, new int[2]);
    }


    private String decodeString(final String input, final int[] posLookup) {
        StringBuilder result = new StringBuilder();
        for (int i = posLookup[CURRENT_POS]; i < input.length(); ++i) {
            char c = input.charAt(i);
            posLookup[PROCESSED_POS] = i;
            if (c >= 48 && c <= 57) {
                StringBuilder intBuilder = new StringBuilder();
                while (c >= 48 && c <= 57) {
                    intBuilder.append(c);
                    c = input.charAt(++i);
                }
                int multiplier = Integer.parseInt(intBuilder.toString());

                posLookup[CURRENT_POS] = i + 1;
                String tmp = decodeString(input, posLookup);
                for (int j = 0; j < multiplier; ++j) {
                    result.append(tmp);
                }
                i = posLookup[PROCESSED_POS];
            } else if (c == ']') {
                return result.toString();
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
