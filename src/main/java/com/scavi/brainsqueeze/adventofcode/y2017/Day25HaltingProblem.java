package com.scavi.brainsqueeze.adventofcode.y2017;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day25HaltingProblem {
    private static final Pattern INT_PATTERN = Pattern.compile("\\d");
    private static final Pattern STATE_PATTERN1 = Pattern.compile("(?<=(state\\s))[^:]*");
    private static final Pattern STATE_PATTERN2 = Pattern.compile("(?<=(state\\s))[^\\.]*");

    public int solveA(@Nonnull final String[] input, final int iterations, char state) {
        Map<Character, Operation> turinBlueprints = createTuringBlueprints(input);
        Set<Integer> flaggedPosition = new HashSet<>();
        int pos = 0;
        for (int i = 1; i <= iterations; ++i) {
            Operation currentOperation = turinBlueprints.get(state);
            // current value is 0
            if (!flaggedPosition.contains(pos)) {
                if (currentOperation.getIfWrite() == 1) {
                    flaggedPosition.add(pos);
                }
                pos += currentOperation.getIfMove();
                state = currentOperation.getIfContinue();
            }
            // current value is 1
            else {
                if (currentOperation.getElseWrite() == 0) {
                    flaggedPosition.remove(pos);
                }
                pos += currentOperation.getElseMove();
                state = currentOperation.getElseContinue();
            }
        }
        return flaggedPosition.size();
    }


    private Map<Character, Operation> createTuringBlueprints(final String[] input) {
        Map<Character, Operation> operations = new HashMap<>();
        for (int i = 0; i < input.length; ++i) {
            String tmp = input[i];
            if (!tmp.trim().isEmpty()) {
                Matcher matcher = STATE_PATTERN1.matcher(tmp);
                if (matcher.find()) {
                    char operation = matcher.group().charAt(0);
                    operations.put(operation, new Operation(input, i));
                    i += 8;
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
        return operations;
    }


    private class Operation {
        private int _ifValue;
        private int _ifWrite;
        private int _ifMove;
        private char _ifContinue;
        private int _elseValue;
        private int _elseWrite;
        private int _elseMove;
        private char _elseContinue;

        Operation(String[] blueprint, int pos) {
            _ifValue = readInt(blueprint[++pos]);
            _ifWrite = readInt(blueprint[++pos]);
            _ifMove = blueprint[++pos].contains("left") ? -1 : 1;
            _ifContinue = readState(blueprint[++pos]);

            _elseValue = readInt(blueprint[++pos]);
            _elseWrite = readInt(blueprint[++pos]);
            _elseMove = blueprint[++pos].contains("left") ? -1 : 1;
            _elseContinue = readState(blueprint[++pos]);
        }


        private int readInt(final String value) {
            Matcher intMatcher = INT_PATTERN.matcher(value);
            if (intMatcher.find()) {
                return Integer.parseInt(intMatcher.group());
            }
            throw new IllegalArgumentException();
        }

        private char readState(final String value) {
            Matcher stateMatcher = STATE_PATTERN2.matcher(value);
            if (stateMatcher.find()) {
                String tmp = stateMatcher.group().trim();
                if (tmp.length() == 1) {
                    return tmp.charAt(0);
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }

        public int getIfValue() {
            return _ifValue;
        }

        public int getIfWrite() {
            return _ifWrite;
        }

        public int getIfMove() {
            return _ifMove;
        }

        public char getIfContinue() {
            return _ifContinue;
        }

        public int getElseValue() {
            return _elseValue;
        }

        public int getElseWrite() {
            return _elseWrite;
        }

        public int getElseMove() {
            return _elseMove;
        }

        public char getElseContinue() {
            return _elseContinue;
        }
    }


//    In state A:
//    If the current value is 0:
//            - Write the value 1.
//            - Move one slot to the right.
//            - Continue with state B.
//    If the current value is 1:
//            - Write the value 0.
//            - Move one slot to the left.
//            - Continue with state C.
}
