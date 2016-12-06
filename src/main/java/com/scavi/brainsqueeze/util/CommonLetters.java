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


import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * A helper class to determine the most common letter. The helper class is used for the heap
 *
 * @author Michael Heymel
 * @since 06/12/16
 */
public class CommonLetters implements Comparable<CommonLetters> {
    private int _count;
    private char _char;


    /**
     * Constructor
     *
     * @param count the count of the character
     * @param aChar the character
     */
    public CommonLetters(final int count, final char aChar) {
        _count = count;
        _char = aChar;
    }


    /**
     * Compares the given object first by the count and in case the count is equal, compares it
     * by the character
     *
     * @param toCompare the object to compare
     * @return If the counter is higher, return -1, if it is lower, 1, if it is equal, compare it by
     * the char
     */
    @Override
    public int compareTo(final CommonLetters toCompare) {
        if (_count < toCompare._count) {
            return -1;
        } else if (_count > toCompare._count) {
            return 1;
        } else {
            return _char > toCompare._char ? -1 : 1;
        }
    }


    /**
     * Increments the count
     */
    public void incrementCount() {
        _count++;
    }


    /**
     * @return the character
     */
    public char getChar() {
        return _char;
    }


    /**
     * A static helper method to create a priority queue (max heap) based on the given map
     *
     * @param length     the size of teh queue
     * @param countCache the cache
     * @return the max heap
     */
    public static PriorityQueue<CommonLetters> from(final int length,
            final Map<Character, Integer> countCache) {
        return from(length, countCache, true);
    }


    /**
     * A static helper method to create a priority queue based on the given map
     *
     * @param length     the size of the queue
     * @param countCache the cache
     * @param isMaxHeap  <code>true</code> it is a max heap<br><code>false</code> it is a min heap
     * @return the max heap
     */
    public static PriorityQueue<CommonLetters> from(final int length,
            final Map<Character, Integer> countCache, boolean isMaxHeap) {
        PriorityQueue<CommonLetters> mostCommonLetters;
        if (isMaxHeap) {
            mostCommonLetters = new PriorityQueue<>(length, Collections.reverseOrder());
        } else {
            mostCommonLetters = new PriorityQueue<>(length);
        }
        // use a max heap to store the characters with the highest occurrence first
        for (Map.Entry<Character, Integer> entry : countCache.entrySet()) {
            mostCommonLetters.offer(new CommonLetters(entry.getValue(), entry.getKey()));
        }
        return mostCommonLetters;
    }
}