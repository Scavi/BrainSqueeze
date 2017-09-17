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

package com.scavi.brainsqueeze.career;

import com.google.common.base.Preconditions;

/**
 * Created by Scavenger on 5/10/2017.
 */
public class CommonAlphabet {
    private final int ASCII_DEC_MASK = 64;


    /**
     * You are given 2 strings: string, strong. Find the common alphabets in two strings and print it.
     * i/p: string , strong
     * o/p: strng
     * </p>
     * The method stores each character of the first string in a long value as bit flags. Then all characters of
     * the second string will be compared with the binary representation of the first string.
     *
     * @param string1 the first string to compare
     * @param string2 the second string to compare
     * @return all common strings of string1 and string2
     */
    public String findCommonChars(String string1, String string2) {
        Preconditions.checkNotNull(string1, "Illegal string input1");
        Preconditions.checkNotNull(string2, "Illegal string input2");

        long string1Representation = createRepresentation(string1);
        StringBuilder commonChars = new StringBuilder(string2.length());

        for (char current : string2.toCharArray()) {
            long validate = 1 << current - ASCII_DEC_MASK;
            if ((validate & string1Representation) == validate) {
                commonChars.append(current);
            }
        }
        return commonChars.toString();
    }

    /**
     * Creates a binary representation of the input string, e.g.
     * A = (dec: 65) is a bit flag at the 1 position, a (dec :97) is a bit flag at the 33 position
     *
     * @param input the input string
     * @return the binary representation of the input string
     */
    private long createRepresentation(String input) {
        long result = 0;
        for (char current : input.toCharArray()) {
            result += 1 << current - ASCII_DEC_MASK;
        }
        return result;
    }
}
