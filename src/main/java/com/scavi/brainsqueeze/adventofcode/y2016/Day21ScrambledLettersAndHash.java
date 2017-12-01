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

package com.scavi.brainsqueeze.adventofcode.y2016;

import com.google.common.base.Preconditions;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Question: http://adventofcode.com/2016/day/21
 *
 * @author Michael Heymel
 * @since 21/12/16
 */
public class Day21ScrambledLettersAndHash {
    private static final Pattern POS_INSIDE =
            Pattern.compile("((?<=(position\\s))|(?<=(letter\\s)))[^\\s]*");
    private static final Pattern POS_END =
            Pattern.compile("((?<=(with\\sposition\\s))|(?<=(with\\sletter\\s)))[^$]*");
    private static final Pattern MOVE_POS_END = Pattern.compile("(?<=(to\\sposition\\s))[^$]*");
    private static final Pattern REVERSE_POS_INSIDE = Pattern.compile("(?<=(positions\\s))[^\\s]*");
    private static final Pattern REVERSE_POS_END = Pattern.compile("(?<=(through\\s))[^\\s]*");
    private static final Pattern ROTATE_POS_END = Pattern.compile("(?<=(letter\\s))[^$]*");
    private static final Pattern ROTATE_STEPS_COUNT =
            Pattern.compile("((?<=(right\\s))|(?<=(left\\s)))[^\\s]*");


    public String scramble(String password, final String[] operations) {
        return scramble(password != null ? password.toCharArray() : null, operations);
    }


    public String scramble(char[] password, final String[] operations) {
        Preconditions.checkNotNull(password, "Illegal password input: <null>");
        Preconditions.checkNotNull(operations, "Illegal operation input: <null>");
        for (String operation : operations) {
            if (operation.startsWith("swap")) {
                password = swap(password, operation);
            } else if (operation.startsWith("rotate")) {
                password = rotate(password, operation);
            } else if (operation.startsWith("reverse")) {
                password = reverse(password, operation);
            } else if (operation.startsWith("move")) {
                password = move(password, operation);
            } else {
                throw new UnsupportedOperationException("Illegal operation: " + operation);
            }
        }
        return String.valueOf(password);
    }


    public String unscramble(final String passwordResult, final String[] operations) {
        Preconditions.checkNotNull(passwordResult, "Illegal password input: <null>");
        Preconditions.checkNotNull(operations, "Illegal operation input: <null>");
        List<String> permutations = new LinkedList<>();
        createPermutations(passwordResult.toCharArray(),
                0,
                new char[passwordResult.length()],
                0,
                permutations);
        String password = null;
        for (int i = 0; i < permutations.size() && password == null; ++i) {
            password = scramble(permutations.get(i), operations);
            if (password.equals(passwordResult)) {
                password = permutations.get(i);
            } else {
                password = null;
            }
        }
        return password;
    }


    private List<String> createPermutations(final char[] input, final int startPos,
            final char[] buffer, final int bufferPos, List<String> permutations) {

        if (bufferPos == buffer.length) {
            permutations.add(String.valueOf(buffer));
        } else {
            for (int i = startPos; i < input.length; ++i) {
                buffer[bufferPos] = input[i];
                swap(input, startPos, i);
                createPermutations(input, startPos + 1, buffer, bufferPos + 1, permutations);
                swap(input, startPos, i);
            }
        }
        return permutations;
    }


    private char[] reverse(char[] password, final String operation) {
        Matcher insideMatcher = REVERSE_POS_INSIDE.matcher(operation);
        Matcher endMatcher = REVERSE_POS_END.matcher(operation);
        Preconditions.checkArgument(insideMatcher.find() && endMatcher.find(),
                "Illegal swap operation: " + operation);
        int pos1 = Integer.parseInt(insideMatcher.group());
        int pos2 = Integer.parseInt(endMatcher.group());
        while (pos2 > pos1) {
            password = swap(password, pos1, pos2);
            pos2--;
            pos1++;
        }
        return password;
    }


    private char[] rotate(final char[] password, final String operation) {
        boolean isRotateRight = true;
        int toRotate = 0;
        if (operation.startsWith("rotate based")) {
            Matcher endMatcher = ROTATE_POS_END.matcher(operation);
            Preconditions.checkArgument(endMatcher.find(),
                    "Illegal rotate based operation: " + operation);
            toRotate = parse(password, endMatcher.group());
            toRotate = 1 + toRotate + (toRotate >= 4 ? 1 : 0);
        } else {
            isRotateRight = !operation.contains("left");
            Matcher endMatcher = ROTATE_STEPS_COUNT.matcher(operation);
            Preconditions.checkArgument(endMatcher.find(),
                    "Illegal rotate operation: " + operation);
            toRotate = Integer.parseInt(endMatcher.group());
        }
        // toRotate = toRotate % password.length;
        char[] tmpPw = new char[password.length];
        if (isRotateRight) {
            for (int i = 0; i < tmpPw.length; ++i) {
                tmpPw[(i + toRotate) % tmpPw.length] = password[i];
            }
        } else {
            for (int i = 0; i < tmpPw.length; ++i) {
                tmpPw[i] = password[(i + toRotate) % tmpPw.length];
            }
        }
        return tmpPw;
    }


    private char[] swap(final char[] password, final String operation) {
        Matcher insideMatcher = POS_INSIDE.matcher(operation);
        Matcher endMatcher = POS_END.matcher(operation);
        Preconditions.checkArgument(insideMatcher.find() && endMatcher.find(),
                "Illegal swap operation: " + operation);
        int pos1 = parse(password, insideMatcher.group());
        int pos2 = parse(password, endMatcher.group());
        return swap(password, pos1, pos2);
    }


    private char[] swap(final char[] password, final int pos1, final int pos2) {
        if (pos1 != pos2) {
            password[pos1] ^= password[pos2];
            password[pos2] ^= password[pos1];
            password[pos1] ^= password[pos2];
        }
        return password;
    }


    private char[] move(final char[] password, final String operation) {
        Matcher insideMatcher = POS_INSIDE.matcher(operation);
        Matcher endMatcher = MOVE_POS_END.matcher(operation);
        Preconditions.checkArgument(insideMatcher.find() && endMatcher.find(),
                "Illegal move operation: " + operation);
        int pos1 = Integer.parseInt(insideMatcher.group());
        int pos2 = Integer.parseInt(endMatcher.group());
        StringBuilder tmpPw = new StringBuilder(password.length + 1);
        tmpPw.append(password);
        tmpPw.deleteCharAt(pos1);
        tmpPw.insert(pos2, password[pos1]);
        return tmpPw.toString().toCharArray();
    }


    private int parse(final char[] password, final String input) {
        int pos;
        try {
            pos = Integer.parseInt(input);
        }
        catch (NumberFormatException ex) {
            pos = String.valueOf(password).indexOf(input.charAt(0));
        }
        return pos;
    }
}
