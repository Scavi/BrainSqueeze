package com.scavi.brainsqueeze.codefight.arcade;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringsRearrangement {

    /**
     * Given an array of equal-length strings, check if it is possible to rearrange the strings in such a way that
     * after the rearrangement the strings at consecutive positions would differ by exactly one character.
     * This problem is np complete
     *
     * @param inputArray the input array
     * @return <code>true</code> the strings are arrangable <br/> <code>false</code> the strings are not arrangable
     */
    boolean stringsRearrangement(final String[] inputArray) {
        if (inputArray.length < 1) {
            return true;
        }
        Map<String, Integer> inputAccess = createInputAccess(inputArray);
        Map<String, Set<String>> correlationAccess = createCorrelationAccess(inputArray);

        boolean isRearangable = false;
        for (String current : inputArray) {
            inputAccess.put(current, inputAccess.get(current) - 1);
            isRearangable = dfs(inputAccess, correlationAccess, current, 0, inputArray.length);
            inputAccess.put(current, inputAccess.get(current) + 1);
            if (isRearangable) {
                break;
            }
        }
        return isRearangable;
    }


    /**
     * Correlation of existing elements to how many times they occur, e.g.:
     * "abc", "abx", "axx", "abx", "abc"
     * will result in
     * "abc" -> 2
     * "abx" -> 2
     * "axx" -> 1
     *
     * @param inputArray the input
     * @return the input access array.
     */
    private Map<String, Integer> createInputAccess(final String[] inputArray) {
        Map<String, Integer> inputAccess = new HashMap<>();
        for (String current : inputArray) {
            inputAccess.put(current, inputAccess.getOrDefault(current, 0) + 1);
        }
        return inputAccess;
    }

    /**
     * This method creates a correlation between the elements (which elements can be connected to each other
     *
     * @param inputArray the input
     * @return the possible correlations
     */
    private Map<String, Set<String>> createCorrelationAccess(final String[] inputArray) {
        Map<String, Set<String>> correlationAccess = new HashMap<>();
        for (int i = 0; i < inputArray.length; ++i) {
            if (!correlationAccess.containsKey(inputArray[i])) {
                Set<String> toConnect = new HashSet<>();
                for (int j = 0; j < inputArray.length; ++j) {
                    if (i != j && isConnectable(inputArray[i], inputArray[j]) && !toConnect.contains(inputArray[j])) {
                        toConnect.add(inputArray[j]);
                    }
                }
                correlationAccess.put(inputArray[i], toConnect);
            }
        }
        return correlationAccess;
    }

    /**
     * Verifies if two strings are connectable
     *
     * @param s1 the first string
     * @param s2 the second string
     * @return <code>true</code> they are connectable <br/>
     * <code>false</code> they are not conntectable
     */
    private boolean isConnectable(final String s1, final String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int distance = 0;
        for (int i = 0; i < s1.length(); ++i) {
            distance = s1.charAt(i) == s2.charAt(i) ? distance : distance + 1;
        }
        return distance == 1;
    }


    private boolean dfs(
            final Map<String, Integer> inputAccess,
            final Map<String, Set<String>> correlationAccess,
            final String path,
            final int level,
            final int target) {
        if (level == target - 1) {
            return true;
        }
        boolean isRearrangable = false;

        for (String continuePath : correlationAccess.get(path)) {

            if (inputAccess.getOrDefault(continuePath, 0) > 0) {
                inputAccess.put(continuePath, inputAccess.get(continuePath) - 1);
                isRearrangable = dfs(inputAccess, correlationAccess, continuePath, level + 1, target);
                inputAccess.put(continuePath, inputAccess.get(continuePath) + 1);
                if (isRearrangable) {
                    break;
                }
            }
        }
        return isRearrangable;
    }
}
