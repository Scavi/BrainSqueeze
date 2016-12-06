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
import com.scavi.brainsqueeze.util.CommonLetters;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Michael Heymel
 * @since 06/12/16
 */
public class Day6SignalsAndNoises {
    private final boolean _isMaxHeap;


    public Day6SignalsAndNoises() {
        this(true);
    }


    public Day6SignalsAndNoises(final boolean isMaxHeap) {
        _isMaxHeap = isMaxHeap;
    }


    public String decrypt(final String[] messages) {
        Preconditions.checkNotNull(messages, "Illegal messages to decrypt: <null>");
        Preconditions.checkArgument(messages.length != 0, "Illegal message input: 0");
        int messageLength = messages[0].length();
        StringBuilder decryptedMessage = new StringBuilder(messageLength);

        for (int i = 0; i < messageLength; ++i) {
            Map<Character, Integer> countCache = new HashMap<>();
            for (String message : messages) {
                Preconditions.checkArgument(messageLength == message.length(),
                        String.format(
                                "Illegal message to decrypt! Expected length: %s, current length %s in %s",
                                messageLength,
                                message.length(),
                                message));
                if (countCache.containsKey(message.charAt(i))) {
                    countCache.put(message.charAt(i), countCache.get(message.charAt(i)) + 1);
                } else {
                    countCache.put(message.charAt(i), 1);
                }
            }
            PriorityQueue<CommonLetters> mostCommonLetters =
                    CommonLetters.from(messageLength, countCache, _isMaxHeap);
            decryptedMessage.append(mostCommonLetters.poll().getChar());
        }
        return decryptedMessage.toString();
    }
}
