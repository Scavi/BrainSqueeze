/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.scavi.brainsqueeze.adventofcode2016;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Chars;
import com.scavi.brainsqueeze.util.CommonLetters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Solves the question http://adventofcode.com/2016/day/4
 *
 * @author Michael Heymel
 * @since 04/12/16
 */
public class Day4SecurityThroughObscurity {
    private static final Pattern ENCRYPTION_TEXT_LOOKUP = Pattern.compile("[^\\d]*");
    private static final Pattern CHECKSUM_LOOKUP = Pattern.compile("(?<=\\[)[^\\]]*");
    private static final Pattern ID_LOOKUP = Pattern.compile("\\d+");
    private static final char DIVIDER = '-';


    /**
     * Determines the id count of all valid encrypted names
     *
     * @param input the input containing all encrypted names, checksum and ids. Some of input are
     *              decoys
     * @return the id count
     */
    public int sectorIdSum(final String[] input) {
        Preconditions.checkNotNull(input, "Illegal encrypted names: <null>");
        int sum = 0;
        for (String name : input) {
            PriorityQueue<CommonLetters> mostCommonLetters = determineMostCommonLetters(name);
            Set<Character> checkSum = determineCheckSum(name);
            if (isCheckSumValid(mostCommonLetters, checkSum)) {
                sum += determineId(name);
            }
        }
        return sum;
    }


    /**
     * Decrypts all valid encrypted names and looks if the given name contains the lookupOutside name
     *
     * @param input      the input containing all encrypted names, checksum and ids. Some of input
     *                   are decoys
     * @param lookupName the lookupOutside name
     * @return the id of the value that was found
     */
    public int sectorIdLookup(final String[] input, final String lookupName) {
        Preconditions.checkNotNull(input, "Illegal encrypted names: <null>");
        Preconditions.checkNotNull(lookupName, "Illegal lookupOutside name: <null>");
        int id = -1;
        for (String name : input) {
            PriorityQueue<CommonLetters> mostCommonLetters = determineMostCommonLetters(name);
            Set<Character> checkSum = determineCheckSum(name);
            if (isCheckSumValid(mostCommonLetters, checkSum)) {
                String decryptedName = decrypt(name);
                if (decryptedName.contains(lookupName)) {
                    id = determineId(name);
                    break;
                }
            }
        }
        return id;
    }


    /**
     * Determines the id from the given name using the lookupOutside pattern. In case no idea exists, an
     * exception will be thrown
     *
     * @param encryptedName the current encrypted name
     * @return the id of the encrypted name
     */
    private int determineId(final String encryptedName) {
        Matcher idMatcher = ID_LOOKUP.matcher(encryptedName);
        Preconditions.checkArgument(idMatcher.find(),
                String.format("Missing id in %s", encryptedName));
        return Integer.parseInt(idMatcher.group());
    }


    /**
     * Decryptes the encrypted name
     *
     * @param encryptedName the name to encrypt
     * @return the decrypted name
     */
    private String decrypt(String encryptedName) {
        int base = 97;
        int id = determineId(encryptedName);
        encryptedName = determineEncryptedName(encryptedName);
        char[] buffer = new char[encryptedName.length()];
        for (int i = 0; i < buffer.length; ++i) {
            char tmp = encryptedName.charAt(i);
            if (tmp == DIVIDER) {
                tmp = ' ';
            } else {
                // magic line: 'a' represents 97 (ascii dec). Determines the ascii dec value of the
                // current char, set it zero based, add the cipher increment and keep it in the
                // alphabet (modulo 26). In the end, add the base again to come to the decimal
                // ascii value of the character
                tmp = (char) (((((int) tmp) - base + id) % 26) + base);
            }
            buffer[i] = tmp;
        }
        return String.valueOf(buffer).trim();
    }


    /**
     * Validate the checksum of the given entry.
     *
     * @param mostCommonLetters the priority queue containing all letters and it's occurrance
     *                          ordered alphanumerical in a max heap
     * @param checkSum          the set containing all letters of the checksum
     * @return <code>true</code> if the entry is valid<br><code>false</code> if not
     */
    private boolean isCheckSumValid(final PriorityQueue<CommonLetters> mostCommonLetters,
            final Set<Character> checkSum) {
        int cnt = 0;
        boolean isValid = true;
        while (mostCommonLetters.size() > 0 && cnt++ < 5 && isValid) {
            isValid = checkSum.contains(mostCommonLetters.poll().getChar());
        }
        return isValid;
    }


    /**
     * Determines the checksum as a hashset from the encrypted name
     *
     * @param encryptedName the encrypted name
     * @return the checksum as a hashset from the encrypted name
     */
    private Set<Character> determineCheckSum(final String encryptedName) {
        Matcher checksumMatcher = CHECKSUM_LOOKUP.matcher(encryptedName);
        Preconditions.checkArgument(checksumMatcher.find(),
                String.format("Missing checksum in %s", encryptedName));
        return new HashSet<>(Chars.asList(checksumMatcher.group().toCharArray()));
    }


    /**
     * Creates a priority queue with the most comon letters
     *
     * @param input the input string
     * @return the priority queue containing all letters and it's occurrance ordered alphanumerical
     * in a max heap
     */
    private PriorityQueue<CommonLetters> determineMostCommonLetters(final String input) {
        String encryptedName = determineEncryptedName(input);
        Map<Character, Integer> countCache = new HashMap<>();
        // extract all alphabetic characters from the given string and count the occurance
        for (char c : encryptedName.toCharArray()) {
            if (c != DIVIDER) {
                if (countCache.containsKey(c)) {
                    countCache.put(c, countCache.get(c) + 1);
                } else {
                    countCache.put(c, 1);
                }
            }
        }
        return CommonLetters.from(input.length(), countCache);
    }


    /**
     * Determines the encryption name from the given input
     *
     * @param input the input
     * @return the encrypted name
     */
    private String determineEncryptedName(final String input) {
        Matcher encryptionTextMatcher = ENCRYPTION_TEXT_LOOKUP.matcher(input);
        Preconditions.checkArgument(encryptionTextMatcher.find(),
                String.format("Missing encryption text in %s", input));
        return encryptionTextMatcher.group();
    }
}