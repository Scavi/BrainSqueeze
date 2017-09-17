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

package com.scavi.brainsqueeze.career;

import java.util.*;

/**
 * Created by Scavenger on 5/14/2017.
 */
public class AnagramFinder {


    public List<String> findAnagrams(Set<String> input) {
        if (input == null || input.size() == 0) {
            return null;
        }
        Map<String, LinkedList<String>> cache = new HashMap<>((int) (input.size() / 0.75f));
        Iterator<String> inputIt = input.iterator();
        while (inputIt.hasNext()) {
            String current = inputIt.next();
            char[] tmp = current.toCharArray();
            Arrays.sort(tmp);
            String sorted = String.valueOf(tmp);

            if (cache.containsKey(sorted)) {
                cache.get(sorted).add(current);
                // in case anagrams don’t need to be together, the value could
                // already be added into a resultset. In this case, the loop
                // over the cache wouldn’t be required.
            } else {
                LinkedList<String> anagrams = new LinkedList<>();
                anagrams.add(current);
                cache.put(sorted, anagrams);
            }
        }

        List<String> result = new ArrayList<>(cache.size());
        for (Map.Entry<String, LinkedList<String>> current : cache.entrySet()) {
            if (current.getValue().size() > 1) {
                result.add(current.getValue().toString());
            }
        }
        return result;
    }
}
