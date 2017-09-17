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

import java.util.*;

/**
 * Created by Scavenger on 6/11/2017.
 */
public class AlphabetExercise {

    public int alphabetExercise(String[] vocabulary) {
        int minCharCount = 0;

        Map<Character, String> placedVocabulary = new HashMap<>();
        Map<Character, List<String>> charToRemainingCount = new HashMap<>();
        // setup the cache
        for (String voc : vocabulary) {
            Set<Character> used = new HashSet<>();
            for (char c : voc.toCharArray()) {
                if (!used.contains(c)) {
                    used.add(c);
                    if (charToRemainingCount.containsKey(c)) {
                        charToRemainingCount.get(c).add(voc);
                        charToRemainingCount.get(c).sort(new LengthComparator());
                    } else {
                        List<String> all = new LinkedList<>();
                        all.add(voc);
                        charToRemainingCount.put(c, all);
                    }
                }
            }
        }

        // sort the array and make sure that the shortest strings come first.
        Arrays.sort(vocabulary, new LengthComparator());

        int i = 0;
        while (charToRemainingCount.size() > 0) {
            String word = vocabulary[i];
            minCharCount += identify(word, charToRemainingCount, placedVocabulary);
            i++;
        }
        return minCharCount;
    }


    private int identify(String word, Map<Character, List<String>> charToRemainingCount, Map<Character, String> placedVocabulary) {
        int len = 0;
        Character toUse = identifyChar(word, charToRemainingCount);

        if (toUse != null) {
            charToRemainingCount.remove(toUse);
            len += word.length();
            updateCache(word, charToRemainingCount);
            //System.out.print(word);
            System.out.println(toUse + ": " + word);
            placedVocabulary.put(toUse, word);
        } else {
            System.out.println("Skipping word " + word);
        }
        return len;
    }


    private Character identifyChar(String word, Map<Character, List<String>> cache) {
        Character toUse = null;
        int lenNextPossible = word.length();
        for (char c : word.toCharArray()) {
            if (cache.containsKey(c)) {
                List<String> possibleVocabulary = cache.get(c);
                // last possible vocabulary - must be used.
                if (possibleVocabulary.size() == 1) {
                    return c;
                }
                int tmpLenNextPossible = least(word, possibleVocabulary);

                if (tmpLenNextPossible > lenNextPossible || toUse == null) {
                    toUse = c;
                    lenNextPossible = tmpLenNextPossible;
                }
            }
        }
        return toUse;
    }

    // TODO
    private int least(String word, List<String> possibleVocabulary) {
        int len = Integer.MAX_VALUE;
        for (String voc : possibleVocabulary) {
            if (!voc.equals((word))) {
                len = Math.min(len, voc.length());
            }
        }
        return len;
    }


    private void updateCache(String word, Map<Character, List<String>> cache) {
        Set<Character> used = new HashSet<>();
        for (char c : word.toCharArray()) {
            if (!used.contains(c)) {
                used.add(c);
                if (cache.containsKey(c)) {
                    cache.get(c).remove(word);
                }
            }
        }
    }

    private class LengthComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            if (s1.length() < s2.length()) {
                return -1;
            } else if (s1.length() > s2.length()) {
                return 1;
            }
            int cnt1 = differentCharCnt(s1);
            int cnt2 = differentCharCnt(s2);

            if (cnt1 < cnt2) {
                return 1;
            } else if (cnt1 > cnt2) {
                return -1;
            }
            return 0;
        }

        private int differentCharCnt(String input) {
            Set<Character> diffChars = new HashSet<>();

            for (char c : input.toCharArray()) {
                diffChars.add(c);
            }
            return diffChars.size();
        }
    }
}
