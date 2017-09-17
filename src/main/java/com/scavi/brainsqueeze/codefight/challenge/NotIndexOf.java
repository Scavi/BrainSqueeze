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

package com.scavi.brainsqueeze.codefight.challenge;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Scavenger on 6/18/2017.
 */
public class NotIndexOf {
    public int notIndexOf(String givenString, String value) {
        if (givenString == null || value == null || value.length() > givenString.length() || givenString.isEmpty() || value.isEmpty()) {
            return -1;
        }
        boolean[] dpCache = createCache(givenString, value);
        for (int i = 0; i < dpCache.length; ++i) {
            if (!dpCache[i]) {
                return i;
            }
        }
        return -1;
    }

    private boolean[] createCache(String givenString, String value) {
        boolean[] cache = new boolean[givenString.length() - value.length() + 1];
        Map<Character, List<Integer>> valueReferences = new HashMap<>();
        for (int i = 0; i < value.length(); ++i) {
            if (valueReferences.containsKey(value.charAt(i))) {
                valueReferences.get(value.charAt(i)).add(i);
            } else {
                List<Integer> newReference = new LinkedList<>();
                newReference.add(i);
                valueReferences.put(value.charAt(i), newReference);
            }
        }
        for (int i = 0; i < givenString.length(); ++i) {
            char c = givenString.charAt(i);
            if (valueReferences.containsKey(c)) {
                for (int position : valueReferences.get(c)) {
                    int offset = i - position;
                    if (offset >= 0 && offset < cache.length) {
                        cache[offset] = true;
                    }
                }
            }
        }
        return cache;
    }
}