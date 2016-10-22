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

package com.scavi.brainsqueeze.geeks;

/**
 * Question: http://www.geeksforgeeks.org/count-ways-spell-number-repeated-digits/
 * <p>
 * Given a string that contains digits of a number. The number may contain many same continuous
 * digits in it. The task is to count number of ways to spell the number. For example, consider
 * 8884441100, one can spell it simply as triple eight triple four double two and double zero. One
 * can also spell as double eight, eight, four, double four, two, two, double zero.
 * <p>
 * Examples: <br>
 * Input :  num = 100 <br>
 * Output : 2 <br>
 * The number 100 has only 2 possibilities, <br>
 * 1) one zero zero <br>
 * 2) one double zero. <br>
 * <p>
 * Input : num = 11112 <br>
 * Output: 8 <br>
 * 1 1 1 1 2, 11 1 1 2, 1 1 11 2, 1 11 1 2 <br>
 * 11 11 2, 1 111 2, 111 1 2, 1111 2<br>
 * <p>
 * Input : num = 8884441100 Output: 64
 * <p>
 * Input : num = 12345 Output: 1
 * <p>
 * Input : num = 11111 Output: 16
 *
 * @author Michael Heymel
 * @since 23/10/16
 */
public class CountWaysToSpellNumber {


    /**
     * Counts the ways to spell from the given number.
     *
     * @param number the number
     * @return the amount of ways to count the number
     */
    public int count(final String number) {
        if (number == null) {
            throw new IllegalArgumentException("Illegal input: <null>");
        }
        int equalEntryCount = 1;
        int waysToSpell = 0;
        for (int i = 1; i < number.length(); ++i) {
            // another equal number for the current block
            if (number.charAt(i - 1) == number.charAt(i)) {
                equalEntryCount++;
            }
            // different character. The end of the block of equal numbers is reached
            else {
                if (equalEntryCount > 1) {
                    waysToSpell += determineWaysToSpell(equalEntryCount);
                }
                equalEntryCount = 1;
            }
        }
        if (equalEntryCount > 1) {
            waysToSpell += determineWaysToSpell(equalEntryCount);
        }
        return waysToSpell;
    }


    /**
     * Determine the number of ways to spell
     *
     * @param equalEntryCount the number of equal entries in a row
     * @return the number of ways to spell
     */
    private int determineWaysToSpell(final int equalEntryCount) {
        return (1 << (equalEntryCount - 1));
    }
}
