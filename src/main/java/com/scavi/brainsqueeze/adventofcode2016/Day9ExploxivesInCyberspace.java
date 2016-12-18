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

package com.scavi.brainsqueeze.adventofcode2016;

import com.google.common.base.Preconditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Solves both questions http://adventofcode.com/2016/day/9
 *
 * @author Michael Heymel
 * @since 09/12/16
 */
public class Day9ExploxivesInCyberspace {
    private final Pattern CHAR_TO_REPEAT_LOOKUP = Pattern.compile("(?<=\\()[^x]*");
    private final Pattern REPEATS_LOOKUP = Pattern.compile("(?<=x)[^\\)]*");
    private final boolean _isSuperEncoded;


    /**
     * Constructor
     * (not super encoded)
     */
    public Day9ExploxivesInCyberspace() {
        this(false);
    }


    /**
     * Constructor
     *
     * @param isSuperEncoded <code>true</code>encoded strings that wrap further encoded strings will
     *                       influence them, e.g. "(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX ->
     *                       ABCABCABCNYNYNYPQRSTPQRSTABCABCABCNYNYNYPQRSTPQRSTABCABCABCNYNYNYPQRSTPQRSTX"
     *                       <code>false</code> else
     */
    public Day9ExploxivesInCyberspace(final boolean isSuperEncoded) {
        _isSuperEncoded = isSuperEncoded;
    }


    /**
     * Decodes the given input array and calculates all decoded length together
     *
     * @param decodingInput the decoding input
     * @return the length of the decoded input
     */
    public long decode(final String[] decodingInput) {
        long decodedLength = 0;
        for (String toDecode : decodingInput) {
            decodedLength += decodeString(toDecode.replaceAll("\\s", ""), 0, toDecode.length());
        }
        return decodedLength;
    }


    /**
     * Decodes the given input
     *
     * @param encoded  the encoded string
     * @param startPos the current start position
     * @param end      the current end position
     * @return the length of the decoded input
     */
    private long decodeString(final String encoded, final int startPos, final int end) {
        long decodedLength = 0;
        for (int i = startPos; i < end; ++i) {
            // an encoded position was found
            if (encoded.charAt(i) == '(') {
                int endPos = encoded.indexOf(")", i);

                // determine the decoded information (e.g. "(5x3)")
                String decodeInformation = encoded.substring(i, endPos);
                Matcher charToRepeatMatcher = CHAR_TO_REPEAT_LOOKUP.matcher(decodeInformation);
                Matcher repeatsMatcher = REPEATS_LOOKUP.matcher(decodeInformation);
                Preconditions.checkArgument(charToRepeatMatcher.find() && repeatsMatcher.find(),
                        "Illegal decode information in: " + decodeInformation);
                int numOfRepeatChars = Integer.parseInt(charToRepeatMatcher.group());
                int repeats = Integer.parseInt(repeatsMatcher.group());

                // in case it is super decoded
                if (_isSuperEncoded && hasDecodingInformation(encoded, endPos, numOfRepeatChars)) {
                    decodedLength += (repeats *
                            decodeString(encoded, endPos + 1, endPos + numOfRepeatChars));
                    i = endPos + numOfRepeatChars;
                }
                // no super decoding, just calculate and set the position
                else {
                    decodedLength += (numOfRepeatChars * repeats);
                    i = endPos + numOfRepeatChars;
                }
            } else {
                ++decodedLength;
            }
        }
        return decodedLength;
    }


    /**
     * This method validates if the substring between the current pos + 1 and the char lookup
     * position range has another encoded position
     *
     * @param encoded    the encoded string
     * @param pos        the position where to start to look from
     * @param charLookup the position till to look
     * @return <code>true</code> the string has encoding information <br><code>false</code> the
     * string doesn't has encoding information
     */
    private boolean hasDecodingInformation(final String encoded, int pos, final int charLookup) {
        pos++;
        return pos + charLookup <= encoded.length() &&
                encoded.substring(pos, pos + charLookup).contains("(");
    }
}