package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.util.StringHelper;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Day8IHeardYouLikeRegisters {

    public int solveA(@Nonnull final String[] input) {
        Map<String, Integer> registerAccess = new HashMap<>();
        createRegister(input, registerAccess);
        return Collections.max(registerAccess.values());
    }

    public int solveB(@Nonnull final String[] input) {
        Map<String, Integer> registerAccess = new HashMap<>();
        return createRegister(input, registerAccess);
    }

    private int createRegister(final String[] input, final Map<String, Integer> registerAccess) {
        int max = Integer.MIN_VALUE;
        for (String function : input) {
            String[] functionToken = StringHelper.split(function, " ");
            String registerKey = functionToken[0];
            int registerValue = registerAccess.getOrDefault(registerKey, 0);
            if (isOperationValid(registerAccess, functionToken)) {
                if (functionToken[1].equals("inc")) {
                    registerValue += Integer.parseInt(functionToken[2]);
                } else if (functionToken[1].equals("dec")) {
                    registerValue -= Integer.parseInt(functionToken[2]);
                } else {
                    throw new IllegalArgumentException("Unknown function: " + functionToken[1]);
                }
            }
            max = Math.max(max, registerValue);
            registerAccess.put(registerKey, registerValue);
        }
        return max;
    }

    private boolean isOperationValid(Map<String, Integer> registerAccess, final String[] functionToken) {
        boolean isValid;
        String registerKey = functionToken[4];
        int toCompare = Integer.parseInt(functionToken[6]);
        switch (functionToken[5]) {
            case ">":
                isValid = registerAccess.getOrDefault(registerKey, 0) > toCompare;
                break;
            case "<":
                isValid = registerAccess.getOrDefault(registerKey, 0) < toCompare;
                break;
            case ">=":
                isValid = registerAccess.getOrDefault(registerKey, 0) >= toCompare;
                break;
            case "<=":
                isValid = registerAccess.getOrDefault(registerKey, 0) <= toCompare;
                break;
            case "!=":
                isValid = registerAccess.getOrDefault(registerKey, 0) != toCompare;
                break;
            case "==":
                isValid = registerAccess.getOrDefault(registerKey, 0) == toCompare;
                break;
            default:
                throw new IllegalArgumentException("Unknown operation: " + functionToken[5]);

        }
        return isValid;
    }
}