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

package com.scavi.brainsqueeze.backtracking;

import com.google.common.base.Preconditions;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * The question was taken from: https://careercup.com/question?id=5732347262533632
 * <p>
 * You are given a scrambled input sentence. Each word is scrambled independently, and the results
 * are concatenated. So:
 * <p>
 * 'elhloothtedrowl' might become 'hello to the world'
 * <p>
 * You have a dictionary with all words in it. Unscramble the sentence.
 *
 * @author Michael Heymel
 * @since 28/10/16
 */
public class UnscrambleWords {
    private final Set<String> _dictionary;


    /**
     * Constructor
     *
     * @param dictionary the dictionary that contains all known words to unscramble the input
     *                   string
     */
    public UnscrambleWords(final Set<String> dictionary) {
        _dictionary = Preconditions.checkNotNull(dictionary, "Unsupported dictionary: <null>");
    }


    /**
     * Iterates through the given string and does a permutation for every part substring until a
     * word from the dictionary is found.
     * <p/>
     * The algorithm takes O(n * n!)
     * <p/>
     * Currently the algorithm uses a {@link Set} as dictionary. Due to this, every possible
     * permutation will be validated. In case of a customized datastrucutre (e.g. suffix tree) a
     * better search pruning would be possible
     *
     * @param input The input string to unscramble
     * @return a list with all found words.
     */
    public List<String> unscramble(final String input) {
        Preconditions.checkNotNull(input, "Unsupported input: <null>");
        List<String> words = new LinkedList<>();
        for (int from = 0, to = 1; to <= input.length(); ++to) {
            String part = input.substring(from, to);
            String foundWord = unscramble(part.toCharArray(), part.length());
            if (foundWord != null) {
                words.add(foundWord);
                from = to;
            } else if (to == input.length()) {
                throw new IllegalArgumentException(String.format(
                        "Incomplete result. The part '%s' wasn't identified!",
                        part));
            }
        }
        return words;
    }


    /**
     * Does the permutation to find the word
     *
     * @param input the input string
     * @param to    a helper variable
     * @return if the permutation of the given input is in the dictionary, else <code>null</code>
     */
    private String unscramble(final char[] input, int to) {
        String foundWord = null;
        if (_dictionary.contains(String.valueOf(input))) {
            foundWord = String.valueOf(input);
        } else {
            if (to > 1) {
                for (int i = 0; i < to && (foundWord == null); ++i) {
                    swap(input, i, to - 1);
                    // TODO: search pruning due to intelligent use of dictionary (e.g. suffix tree-> don’t
                    // follow a string-path that doesn't exist in the suffix tree)
                    foundWord = unscramble(input, to - 1);
                    swap(input, i, to - 1);
                }
            }
        }
        return foundWord;
    }


    /**
     * Swaps the <code>from</code> with the <code>to</code> within the given <code>input</code>
     * array
     *
     * @param input the input array
     * @param from  the position 1 to swap
     * @param to    the position 2 to swap
     */
    private void swap(final char[] input, final int from, final int to) {
        if (from != to) {
            char tmp = input[from];
            input[from] = input[to];
            input[to] = tmp;
        }
    }
}
