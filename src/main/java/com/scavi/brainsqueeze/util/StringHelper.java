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

package com.scavi.brainsqueeze.util;

import com.google.common.base.Preconditions;

import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Michael Heymel
 * @since 15/12/16
 */
public class StringHelper {
    public static final String EMPTY = "";
    private static final char[] HEX =
            new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static String[] BYTE_TO_HEX = new String[256];

    static {
        for (int i = 0; i < 256; ++i) {
            int high = i / 16;
            int low = i % 16;
            BYTE_TO_HEX[i] = EMPTY + HEX[high] + HEX[low];
        }
    }

    /**
     * Converts a given byte input to a hex string. Runs 4,x times quicker than
     * String.format("%1$032x", new BigInteger(1, byte[]));
     * <p/>
     * Copied the function from:
     * https://github.com/shaeberling/euler/blob/master/java/src/com/s13g/aoc/StringUtil.java
     *
     * @param bytes the input bytes
     * @return the hex string
     */
    public static String toHexString(final byte[] bytes) {
        final StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(BYTE_TO_HEX[b < 0 ? b + 256 : b]);
        }
        return builder.toString();
    }


    /**
     * Converts a given int input with ascii decimals to a hex string.
     *
     * @param input the input
     * @return the hex string
     */
    public static String toHexString(final int[] input) {
        final StringBuilder builder = new StringBuilder();
        for (int i : input) {
            builder.append(BYTE_TO_HEX[i]);
        }
        return builder.toString();
    }


    /**
     * Converts a hex string to the binary string and keeps the leading zeros
     *
     * @param hex the hex string to convert
     * @return the binary string
     */
    public static String fromHexToBinary(@Nonnull final String hex) {
        StringBuilder binary = new StringBuilder(hex.length() * 4);
        String temp;
        for (char c : hex.toCharArray()) {
            int dec = Integer.parseInt(String.valueOf(c), 16);
            temp = String.format("%s", Integer.toBinaryString(dec));
            if (temp.length() < 4) {
                binary.append("0000".substring(temp.length()));
            }
            binary.append(temp);
        }
        return binary.toString();
    }


    /**
     * Uses the pattern to extract the number from the input to create an int
     *
     * @param input   the input string
     * @param pattern the pattern to use
     * @return the extracted int
     */
    public static int fromInput(final String input, final Pattern pattern) {
        Matcher matcher = pattern.matcher(input);
        Preconditions.checkArgument(matcher.find(), "Illegal input to pattern!");
        return Integer.parseInt(matcher.group().trim());
    }


    /**
     * Returns the shortest string. In case one string is null, the other string will be returned
     *
     * @param string1 the string 1
     * @param string2 the string 2
     * @return the shortest string
     */
    public static String min(final String string1, final String string2) {
        if (string1 == null) {
            return string2;
        } else if (string2 == null) {
            return string1;
        }
        return string1.length() > string2.length() ? string2 : string1;
    }


    /**
     * Returns the shortest string. In case one string is null, the other string will be returned
     *
     * @param string1 the string 1
     * @param string2 the string 2
     * @return the shortest string
     */
    public static String max(final String string1, final String string2) {
        if (string1 == null) {
            return string2;
        } else if (string2 == null) {
            return string1;
        }
        return string1.length() > string2.length() ? string1 : string2;
    }


    /**
     * A split / tokenize method to reduce boilerplate code. Splits the input with the given delimiter and and
     * returns all token.
     *
     * @param input     the input to split
     * @param delimiter the delimiter to split
     * @return the tokens
     */
    public static String[] split(@Nonnull final String input, @Nonnull final String delimiter) {
        StringTokenizer registerTokens = new StringTokenizer(input, delimiter);
        List<String> result = new LinkedList<>();
        while (registerTokens.hasMoreTokens()) {
            result.add(registerTokens.nextToken().trim());
        }
        return result.toArray(new String[result.size()]);
    }


    /**
     * Converts a string array into a two dimensional char array. Assumes that every string has the same length
     *
     * @param input the input to convert
     * @return the two dimensional char array
     */
    public static char[][] toCharArray(@Nonnull final String[] input) {
        if (input.length == 0 || input[0].length() == 0) {
            return new char[0][0];
        }

        char[][] charArray = new char[input.length][input[0].length()];

        for (int y = 0; y < input.length; ++y) {
            for (int x = 0; x < input[0].length(); ++x) {
                charArray[y][x] = input[y].charAt(x);
            }
        }

        return charArray;
    }
}