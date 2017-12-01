package com.scavi.brainsqueeze.career;

public class UnmatchedParentheses {
    /**
     * Write code to find unmatched parentheses and return it in the below format:
     * ((a) -> -10a1
     * (a)) -> 0a1-1
     * (((abc))((d))))) -> 000abc1100d111-1-1
     * <p/>
     * This algorithm runs with constant space and O(n) time.
     *
     * @param input the input
     * @return the decoded output.
     */
    public String decode(final String input) {
        if (input == null || input.length() == 0) {
            return null;
        }

        int balance = 0;
        for (char c : input.toCharArray()) {
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            }
        }

        StringBuilder result = new StringBuilder(input.length());
        int currentBracketBalance = 0;
        for (char c : input.toCharArray()) {
            if (c == '(') {
                currentBracketBalance++;
                if (balance > 0) {
                    result.append(-1);
                    balance--;
                } else {
                    result.append(0);
                }
            } else if (c == ')') {
                if (currentBracketBalance > 0) {
                    result.append(1);
                } else {
                    result.append(-1);
                }
                --currentBracketBalance;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
