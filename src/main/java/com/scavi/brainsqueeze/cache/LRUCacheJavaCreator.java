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

package com.scavi.brainsqueeze.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Michael Heymel
 * @since 23/10/16
 */
public class LRUCacheJavaCreator {
    /**
     * Constructor
     */
    private LRUCacheJavaCreator() {

    }


    /**
     * Creates a LRU cache using a {@link LinkedHashMap}.
     *
     * @param size the size of the LRU cache
     * @return the LRU cache
     */
    public static <V, T> Map<V, T> from(final int size) {
        return new LinkedHashMap<V, T>(size * (4 / 3), 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<V, T> eldestEntry) {
                return size() > size;
            }
        };
    }
}
