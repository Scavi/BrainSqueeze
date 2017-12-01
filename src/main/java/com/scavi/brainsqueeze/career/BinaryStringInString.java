package com.scavi.brainsqueeze.career;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class BinaryStringInString {
    /**
     * Given a string and integer k, check if this string contain all the binary strings of length k.
     * For example k is 2, then 00,10,01,11.
     * <p>
     * This algorithm uses a HashSet and stores all possible binaries. Then it iterates through the given string
     * once and compares the substrings of length k. Everytime the HashSet contains a substring, it will be removed
     * from this cache. If no entries are left in the HashSet, the string contains all binary strings of k
     * <p>
     * This algorithm uses O(2^k * k) space and runs in O(n * k) time (while n is the length of the input string)
     *
     * @param input the input string
     * @param k     the binary length k
     * @return <c>true</c> contains all binary strings of size k
     * <c>false</c> doesn't contain all binary strings of size k
     */
    public boolean checkBinariesExisting(final String input, final int k) {
        if (input == null || k > input.length()) {
            return false;
        }
        Set<String> binary = new HashSet<>();
        for (int i = 0; i < 1 << k; ++i) {
            binary.add(createBinString(k, i));
        }
        String temp;
        for (int i = 0; i <= input.length() - k && !binary.isEmpty(); ++i) {
            temp = input.substring(i, i + k);
            if (binary.contains(temp)) {
                binary.remove(temp);
            }
        }
        return binary.size() == 0;
    }


    /**
     * Follow up 1: find a string that can contain all binary strings of length k
     * <p>
     * Simply concat all the binary strings and return the overall result
     *
     * @param k the binary length k
     * @return the string representation of all bin
     */
    public String stringOfAllBin(final int k) {
        if (k < 0) {
            return null;
        }
        int length = 1 << k;
        StringBuilder temp = new StringBuilder(length * k);
        for (int i = 0; i < length; ++i) {
            temp.append(createBinString(k, i));
        }
        return temp.toString();
    }

    /**
     * Followup 2: find a shortest string that can contain all binary string of length.
     * <p>
     * The idea is to use backtracking to determine the possible solutions and only keep track of the shortest.
     * The start string (current) contains the binary representation of k - 1 and 0 to set the max deviation.
     * The algorithm runs in O(2^ (k² - 2) ) * k  and uses constant space.
     *
     * @param k the binary length k
     * @return the shortest string that contains all binaries of the given length k
     */
    public String shortestStringOfAllBin(final int k) {
        if (k < 0) {
            return null;
        }
        int length = 1 << k;
        String current = createBinString(k, length - 1) + createBinString(k, 0);
        return shortestStringOfAllBin(current, k, length - 2);
    }


    private String shortestStringOfAllBin(final String current, final int k, final int i) {
        if (i <= 0) {
            return current;
        } else {
            String newBinary = createBinString(k, i);

            String result = null;
            // search pruning - the new binary exists already in the current string
            if (Pattern.compile(newBinary).matcher(current).find()) {
                result = shortestStringOfAllBin(current, k, i - 1);
            }
            // the current newBinary doesn't exist yet in the current
            else {
                String tempResult = null;
                for (int j = newBinary.length(); j > 0; --j) {
                    String binaryPart = newBinary.substring(0, j);
                    String overlapping = newBinary.substring(j, newBinary.length());

                    // try to add the current string part from the left side
                    if (j == newBinary.length() || current.startsWith(overlapping)) {
                        tempResult = shortestStringOfAllBin(binaryPart + current, k, i - 1);
                    }
                    result = result == null || result.length() > tempResult.length() ? tempResult : result;

                    // try to add the current string part from the right side
                    if (j == newBinary.length() || current.endsWith(overlapping)) {
                        tempResult = shortestStringOfAllBin(current + binaryPart, k, i - 1);
                    }
                    result = result == null || result.length() > tempResult.length() ? tempResult : result;
                }
            }
            return result;
        }
    }


    private String createBinString(final int k, final int i) {
        return String.format("%0" + k + "d", Integer.valueOf(Integer.toBinaryString(i)));
    }
}
