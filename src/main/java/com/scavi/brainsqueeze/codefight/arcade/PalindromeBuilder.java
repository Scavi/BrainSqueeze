package com.scavi.brainsqueeze.codefight.arcade;

public class PalindromeBuilder {
    String buildPalindrome(String input) {
        StringBuilder result = new StringBuilder(input.length());
        for (int i = 0; i < input.length(); ++i) {
            if (isPalindrome(input, i)) {
                result.append(input);
                for (int j = i - 1; j >= 0; --j) {
                    result.append(input.charAt(j));
                }
                break;
            }
        }
        return result.toString();
    }


    private boolean isPalindrome(final String text, final int from) {
        int l = from;
        int r = text.length() - 1;
        while (l <= r && text.charAt(l) == text.charAt(r)) {
            l++;
            r--;
        }
        return l >= r;
    }
}