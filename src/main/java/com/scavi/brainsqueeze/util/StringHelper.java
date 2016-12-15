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

/**
 * @author Michael Heymel
 * @since 15/12/16
 */
public class StringHelper {
    public static final String EMPTY = "";
    private static final char[] HEX =
            new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
                       'f'};
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
}
