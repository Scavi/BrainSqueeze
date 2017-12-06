package com.scavi.brainsqueeze.adventofcode.y2017;

import java.util.*;

public class Day4HighEntropyPassphrases {
    public int solve(final String[] input, final boolean isAnagram) {
        int validPasswords = 0;
        for (String passphrase : input) {
            Set<String> knownPassphrases = new HashSet<>();
            StringTokenizer tokenizer = new StringTokenizer(passphrase, " ");
            boolean isValid = true;
            while (isValid && tokenizer.hasMoreTokens()) {
                String password = tokenizer.nextToken();
                if (isAnagram) {
                    char[] tmp = password.toCharArray();
                    Arrays.sort(tmp);
                    password = new String(tmp);
                }
                isValid = !knownPassphrases.contains(password);
                knownPassphrases.add(password);
            }
            validPasswords = isValid ? validPasswords + 1 : validPasswords;
        }
        return validPasswords;
    }
}