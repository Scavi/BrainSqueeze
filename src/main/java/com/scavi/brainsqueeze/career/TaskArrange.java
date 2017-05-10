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

import com.google.common.base.Preconditions;

import java.util.*;

/**
 * @author Michael Heymel
 * @since 5/9/2017
 */
public class TaskArrange {
    private static final char IDLE = '_';

    public int rearrangeTasks(String tasks, int cooldown) {
        Preconditions.checkNotNull(tasks, "Illegal task input!");
        Preconditions.checkArgument(cooldown >= 0, "Illegal cooldown. The cooldown must be >= 0");

        PriorityQueue<PriorityPair> priorityTasks = create(tasks);
        StringBuilder result = new StringBuilder(tasks.length());

        while (priorityTasks.size() > 0) {

            Iterator<PriorityPair> priorityIterator = priorityTasks.iterator();

            boolean hasProcessed = false;
            int itCount = cooldown;
            while (itCount >= 0 && priorityIterator.hasNext()) {
                PriorityPair current = priorityIterator.next();

                int lookupPos = result.length() - cooldown;
                if (lookupPos < 0 || result.charAt(lookupPos) == current.getLetter()) {
                    result.append(current.getLetter());
                    current.decrement();
                    if (current.getCount() == 0) {
                        priorityIterator.remove();
                    }
                    hasProcessed = true;
                }
                itCount--;
            }
            if (!hasProcessed) {
                result.append(IDLE);
            }
        }
        return result.length();
    }


    private PriorityQueue<PriorityPair> create(String tasks) {
        Map<Character, Integer> priorityCache = new HashMap<>();
        for (char letter : tasks.toCharArray()) {
            if (priorityCache.containsKey(letter)) {
                priorityCache.put(letter, priorityCache.get(letter) + 1);
            } else {
                priorityCache.put(letter, 1);
            }
        }

        PriorityQueue<PriorityPair> priorityTasks = new
                PriorityQueue<>(Comparator.reverseOrder());
        for (Map.Entry<Character, Integer> priorityEntry : priorityCache.entrySet()) {
            PriorityPair newPriority = new PriorityPair(
                    priorityEntry.getKey(), priorityEntry.getValue());
            priorityTasks.add(newPriority);
        }
        return priorityTasks;
    }


    private class PriorityPair implements Comparable<PriorityPair> {
        private final char _letter;
        private int _count;

        public PriorityPair(char letter, int count) {
            _letter = letter;
            _count = count;
        }

        public char getLetter() {
            return _letter;
        }

        public int getCount() {
            return _count;
        }

        public void decrement() {
            _count--;
        }

        @Override
        public int compareTo(PriorityPair pair) {
            if (pair == null) {
                return -1;
            }
            return _count - pair.getCount();
        }
    }

}
