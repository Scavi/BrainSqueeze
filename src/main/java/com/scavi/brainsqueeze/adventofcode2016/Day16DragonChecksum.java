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

/**
 * Question: http://adventofcode.com/2016/day/16
 *
 * @author Michael Heymel
 * @since 16/12/16
 */
public class Day16DragonChecksum {
    private final char ZERO = '0';
    private final char ONE = '1';


    /**
     * Creates a dragon checkums
     *
     * @param data       the data to convert
     * @param discLength the disc length
     * @return the created dragon checksum
     */
    public String createDragonChecksum(String data, final int discLength) {
        Preconditions.checkNotNull(data, "Illegal input data: <null>");
        Preconditions.checkArgument(discLength > 0,
                "Illegal disc length (must be > 0): " + discLength);

        while (data.length() < discLength) {
            data = createRandomData(data);
        }
        data = data.substring(0, discLength);
        return createChecksum(data);
    }


    /**
     * Creates the randomized data in the format <input_data>0<reversed_switched_input_data>
     *
     * @param inputData the input data
     * @return the randomized data
     */
    private String createRandomData(final String inputData) {
        StringBuilder randomData = new StringBuilder((inputData.length() * 2) + 1);
        randomData.append(inputData).append(ZERO);
        for (int i = inputData.length() - 1; i >= 0; --i) {
            randomData.append(inputData.charAt(i) == ZERO ? ONE : ZERO);
        }
        return randomData.toString();
    }


    /**
     * Creates a checksum by splitting up the input data as pair (e.g. the pairs for 001101  will be
     * 00 11 and 01). In case the pair is equal, a 1 will be set as checksum replacement, otherwise
     * 0. Continues as long as the generated checksum length is even.
     *
     * @param inputData the input data
     * @return the checkusum
     */
    private String createChecksum(String inputData) {
        while (inputData.length() % 2 == 0) {
            StringBuilder checkSumCreator = new StringBuilder(inputData.length());
            for (int i = 0; i < inputData.length(); i += 2) {
                if (inputData.charAt(i) == inputData.charAt(i + 1)) {
                    checkSumCreator.append(ONE);
                } else {
                    checkSumCreator.append(ZERO);
                }
            }
            inputData = checkSumCreator.toString();
        }
        return inputData;
    }
}