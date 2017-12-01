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

package com.scavi.brainsqueeze.adventofcode.y2016;

import com.google.common.base.Preconditions;
import com.scavi.brainsqueeze.util.StringHelper;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Question: http://adventofcode.com/2016/day/14
 *
 * @author Michael Heymel
 * @since 14/12/16
 */
public class Day14OneTimePad {
    private final MessageDigest _md5;
    private final int _hashIterations;


    /**
     * Constructor
     */
    public Day14OneTimePad() throws NoSuchAlgorithmException {
        this(1);
    }


    /**
     * Constructor
     *
     * @param hashIterations the amount of iterations to create the md 5 hash
     */
    public Day14OneTimePad(final int hashIterations) throws NoSuchAlgorithmException {
        _hashIterations = hashIterations;
        _md5 = MessageDigest.getInstance("MD5");
    }


    /**
     * Find the position which contains the specified number of keys. E.g. if it is 64, find the
     * position of the 64 key.
     *
     * @param salt     the salt
     * @param noOfKeys the number of keys
     * @return the position of the specified number of key.
     */
    public int findKeys(final String salt, final int noOfKeys) throws UnsupportedEncodingException {
        Preconditions.checkNotNull(salt, "Illegal salt: <null>");
        List<String> keys = new ArrayList<>(noOfKeys);
        // cache for the already determined 5 digits cache
        LinkedHashMap<Integer, String> _sequenceCache = new LinkedHashMap<>();
        int cachePos = 0;
        // iterates from 0 to max value until 6 keys are found
        int i = 0;
        for (; i < Integer.MAX_VALUE && keys.size() <= noOfKeys; ++i) {
            String hashCode = createHash(salt + String.valueOf(i));
            // validates if the hash has 3 consecutive characters (like asdf777cookie)
            String seq = determineSequence(hashCode, 3);
            if (seq != null) {
                // creates a 5 character string based on the found sequence (e.g. 77777)
                seq = String.format("%s%s%s", seq, seq.charAt(0), seq.charAt(0));
                cachePos = Math.max(i, cachePos);
                boolean isKeyValid = false;
                // validates over the next 1000 values
                for (int j = i + 1; j <= i + 1000 && !isKeyValid; ++j) {
                    String validationLookup = null;
                    if (_sequenceCache.containsKey(j)) {
                        validationLookup = _sequenceCache.get(j);
                    } else {
                        if (j > cachePos) {
                            String validationHash = createHash(salt + String.valueOf(j));
                            validationLookup = determineSequence(validationHash, 5);
                        }
                    }
                    // lookup was successful. Found a hash with 5 digits
                    if (validationLookup != null) {
                        if (seq.equals(validationLookup)) {
                            isKeyValid = true;
                        } else {
                            _sequenceCache.put(j, validationLookup);
                        }
                    }
                    cachePos = Math.max(j, cachePos);
                }
                if (isKeyValid) {
                    keys.add(hashCode);
                }
            }
        }
        return i - 1;
    }


    /**
     * Creates a hash string
     *
     * @param hashBase the hash base (salt + counter)
     * @return the created hash
     */
    private String createHash(String hashBase) throws UnsupportedEncodingException {
        for (int i = 0; i < _hashIterations; ++i) {
            _md5.update(hashBase.getBytes("UTF-8"));
            hashBase = StringHelper.toHexString(_md5.digest());
        }
        return hashBase;
    }


    /**
     * Validate if the given hash contains the sequence of the specified length (e.g. abcaaa
     * contains 3x 'a')
     *
     * @param hash           the hash to validate
     * @param sequenceLength the length
     * @return the sequence that was found
     */
    private String determineSequence(final String hash, final int sequenceLength) {
        if (hash.length() < sequenceLength) {
            return null;
        }
        String match = null;
        for (int i = 0; i <= hash.length() - sequenceLength && match == null; ++i) {
            char current = hash.charAt(i);
            int lookupUntil = (i + sequenceLength - 1);
            for (int j = i + 1; j <= lookupUntil; ++j) {
                if (current != hash.charAt(j)) {
                    break;
                } else if (j == lookupUntil) {
                    match = hash.substring(i, j + 1);
                }
            }
        }
        return match;
    }
}