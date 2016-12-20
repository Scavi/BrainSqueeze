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
 * @since 14/12/16
 */
public class Pair<T extends Comparable<T>, V> implements Comparable<Pair<T, V>> {
    private final T _key;
    private final V _value;


    /**
     * Constructor
     *
     * @param key   the key of the pair
     * @param value the value of the pair
     */
    public Pair(final T key, final V value) {
        _key = key;
        _value = value;
    }


    /**
     * @return the key of the pair
     */
    public T getKey() {
        return _key;
    }


    /**
     * @return the value of the pair
     */
    public V getValue() {
        return _value;
    }


    @Override
    public int compareTo(final Pair<T, V> toCompare) {
        return _key.compareTo(toCompare.getKey());
    }


    /**
     * @return key and value as string
     */
    @Override
    public String toString() {
        return String.format("[key=%s | value=%s]", _key, _value);
    }
}
