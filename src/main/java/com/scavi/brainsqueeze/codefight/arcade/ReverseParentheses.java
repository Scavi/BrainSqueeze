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

package com.scavi.brainsqueeze.codefight.arcade;

public class ReverseParentheses {

    private final char OPEN = '(';
    private final char CLOSE = ')';

    String reverseParentheses(String input) {
        String reversed = findClosingBracket(input, 0, OPEN, CLOSE);
        return reversed.replaceAll("\\(", "").replaceAll("\\)", "");
    }

    private String findClosingBracket(String data, int from, final char open, final char close) {
        if (from < 0) {
            return data;
        }
        int cntOpen = 0;
        int start = data.indexOf(open, from) + 1;
        int end = -1;

        if (start > 0) {
            for (int i = start; i < data.length() && end == -1; ++i) {
                if (data.charAt(i) == open) {
                    cntOpen++;
                } else if (data.charAt(i) == close) {
                    if (cntOpen-- == 0) {
                        end = i;
                    }
                }
            }

            if (end != -1) {
                String newContent = new StringBuilder(data.substring(start, end)).reverse().toString();
                data = data.substring(0, start) + newContent + data.substring(end);
            }
            data = findClosingBracket(data, start, open == OPEN ? CLOSE : OPEN, close == CLOSE ? OPEN : CLOSE);
        }
        return data;
    }


//    String reverseParentheses(String input) {
//        return input.contains("(") ?
//                reverseParentheses(reverseContent(input)) :
//                input;
//    }
//
//    private String reverseContent(String input) {
//        Matcher matcher = Pattern.compile("\\(([^()]*)\\)").matcher(input);
//        String bracketString = matcher.group(0);
//        //bracketString = new StringBuilder(bracketString.split("")).reverse().toString();
//        return "";
//    }
}
