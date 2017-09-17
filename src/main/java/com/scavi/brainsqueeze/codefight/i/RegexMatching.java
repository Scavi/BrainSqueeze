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

package com.scavi.brainsqueeze.codefight.i;

import java.util.Arrays;

/**
 * Created by Scavenger on 5/28/2017.
 */
public class RegexMatching {
    boolean regexMatching(String pattern, String test) {
        // simple solution - but not sure if this was the purpose of the question
        // return Pattern.compile(p).matcher(t).find();
        if (pattern.charAt(0) == '^') {
            if (pattern.charAt(pattern.length() - 1) == '$') {
                return test.equals(pattern.substring(1, pattern.length() - 1));
            } else {
                return test.substring(0, pattern.length() - 1).equals(pattern.substring(1));
            }
        } else if (pattern.charAt(pattern.length() - 1) == '$') {
            return test.substring(test.length() - pattern.length() + 1).equals(pattern.substring(0, pattern.length() - 1));
        } else {
            //return test.toString().contains(pattern);
            return contains(test, pattern);
        }
    }


    private boolean contains(String test, String pattern) {
        int[] rightmost = new int[256];
        Arrays.fill(rightmost, -1);
        for (int i = 0; i < pattern.length(); i++) {
            rightmost[pattern.charAt(i)] = i;
        }
        for (int i = 0; i <= test.length() - pattern.length(); ) {
            boolean isValid = true;
            for (int j = pattern.length() - 1; j >= 0 && isValid; j--) {
                if (pattern.charAt(j) != test.charAt(i + j)) {
                    i += Math.max(1, j - rightmost[test.charAt(i + j)]);
                    isValid = false;
                }
            }
            if (isValid) return true;
        }
        return false;
    }


//    boolean regexMatching(String pattern, String test) {
//        boolean isStartMatch = false;
//        boolean isEndMatch = false;
//        if (pattern.charAt(0) == '^') {
//            pattern = pattern.substring(1);
//            isStartMatch = true;
//        }
//        if (pattern.charAt(pattern.length() - 1) == '$') {
//            pattern = pattern.substring(0, pattern.length() - 1);
//            isEndMatch = true;
//        }
//
//        if (isStartMatch && isEndMatch) {
//            return pattern.length() == test.length() && pattern.equals(test);
//        } else if (isStartMatch) {
//            return pattern.equals(test.substring(0, pattern.length()));
//        } else if (isEndMatch) {
//            return pattern.equals(test.substring(test.length() - pattern.length()));
//        } else {
//            return test.contains(pattern);
//        }
//    }
}
