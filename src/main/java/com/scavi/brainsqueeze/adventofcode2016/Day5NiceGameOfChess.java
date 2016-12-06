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

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Michael Heymel
 * @since 06/12/16
 */
public class Day5NiceGameOfChess {
    private final IResultProcessor _resultProcessor;


    /**
     * Constructor
     *
     * @param resultProcessor the result processor to extract the password from the valid hash
     */
    public Day5NiceGameOfChess(final IResultProcessor resultProcessor) {
        _resultProcessor = resultProcessor;
    }


    /**
     * Uses MD5 do create a hash based on the given ID ans an increment between 0 and {@link
     * Integer#MAX_VALUE}. Every hash that starts with 00000 will be analyzed further and depending
     * on the result processor strategy a password will be created
     *
     * @param id the ID to determine the password
     * @return the determined password
     */
    public String determinePassword(final String id)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        int matchCount = 0;
        for (int i = 0; i < Integer.MAX_VALUE && matchCount != 8; ++i) {
            String input = id + i;
            md5.reset();
            md5.update(input.getBytes("UTF-8"));
            String hashCode = String.format("%1$032x", new BigInteger(1, md5.digest()));
            if (hashCode.startsWith("00000")) {
                if (_resultProcessor.tryProcessHash(hashCode)) {
                    matchCount++;
                }
            }
        }
        return _resultProcessor.getPassword();
    }


    public interface IResultProcessor {
        /**
         * Adds a hash code to the result processor
         *
         * @param hashCode the hash code
         * @return <code>true</code> the given hash code was processed, <code>false</code> the code
         * was not processed
         */
        boolean tryProcessHash(final String hashCode);


        /**
         * @return the created password
         */
        String getPassword();
    }

    public static class SimpleResultProcessor implements IResultProcessor {
        String _password = "";


        /**
         * Adds a hash code to the result processor
         *
         * @param hashCode the hash code
         * @return <code>true</code> the given hash code was processed
         */
        @Override
        public boolean tryProcessHash(final String hashCode) {
            _password += hashCode.substring(5, 6);
            return true;
        }


        /**
         * @return the created password based on the given hashes to process
         */
        @Override
        public String getPassword() {
            return _password;
        }
    }

    public static class PositionResultProcessor implements IResultProcessor {
        private final char ILLEGAL = '-';
        private final char[] _password = new char[8];


        /**
         * Constructor
         */
        public PositionResultProcessor() {
            for (int i = 0; i < _password.length; ++i) {
                _password[i] = ILLEGAL;
            }
        }


        /**
         * @param hashCode the hash code
         * @return <code>true</code> the given hash code was processed, <code>false</code> the code
         * was not processed
         */
        @Override
        public boolean tryProcessHash(final String hashCode) {
            try {
                // determines the position of the password char
                int pos = Integer.parseInt(hashCode.substring(5, 6));
                if (pos >= 0 && pos < 8 && _password[pos] == ILLEGAL) {
                    _password[pos] = hashCode.toCharArray()[6];
                    return true;
                }
            }
            catch (Exception ex) {
                // illegal hash code
            }
            return false;
        }


        /**
         * @return the created password based on the given hashes to process
         */
        @Override
        public String getPassword() {
            return String.valueOf(_password);
        }
    }
}