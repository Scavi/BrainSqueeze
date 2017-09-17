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

package com.scavi.brainsqueeze.codefight.i;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Scavenger on 7/3/2017.
 */
public class FirstNonRepeating {
    char firstNotRepeatingCharacter(String input) {
        LinkedHashMap<Character, Integer> buffer = new LinkedHashMap<>();
        for (char current : input.toCharArray()) {
            if (buffer.containsKey(current)) {
                buffer.replace(current, buffer.get(current) + 1);
            } else {
                buffer.put(current, 1);
            }
        }

        for (Map.Entry<Character, Integer> lookup : buffer.entrySet()) {
            if (lookup.getValue() == 1) {
                return lookup.getKey();
            }
        }
        return '_';
    }
}
