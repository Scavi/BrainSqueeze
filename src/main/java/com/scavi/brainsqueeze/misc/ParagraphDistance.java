package com.scavi.brainsqueeze.misc;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ParagraphDistance {
    public int shortestDistance(@Nonnull final String paragraph, @Nonnull final String lookupParagraph) {
        if (lookupParagraph.length() == 0) {
            throw new IllegalArgumentException();
        }

        String[] lookupWords = lookupParagraph.split(" ");
        Map<String, Integer> foundWordCount = new HashMap<>();
        Set<String> searchWords = new HashSet<>();
        initialize(lookupWords, foundWordCount, searchWords);

        int startSlidingWindow = 0;
        int currentWordCount = 0;
        int minWordCount = Integer.MAX_VALUE;
        StringBuilder currentWord = new StringBuilder();
        for (int i = 0; i < paragraph.length(); ++i) {
            char c = paragraph.charAt(i);

            if (isInWord(c)) {
                currentWord.append(c);
            } else {
                String word = currentWord.toString();
                currentWord = new StringBuilder();
                // test the current word
                if (word.length() > 0) {
                    currentWordCount++;
                    // found the word, remove it from the search words and increment the existence count for the
                    // sliding window
                    if (foundWordCount.containsKey(word)) {
                        foundWordCount.put(word, foundWordCount.get(word) + 1);
                        if (searchWords.contains(word)) {
                            searchWords.remove(word);
                        }
                    }

                    if (searchWords.size() == 0) {
                        for (int j = startSlidingWindow; j < i; ++j) {
                            char c2 = paragraph.charAt(j);
                            if (isInWord(c2)) {
                                currentWord.append(c2);
                            } else {
                                if (currentWord.length() > 0) {
                                    String tmpWord = currentWord.toString();
                                    if (foundWordCount.containsKey(tmpWord)) {
                                        if (foundWordCount.getOrDefault(tmpWord, 0) > 1) {
                                            foundWordCount.put(tmpWord, foundWordCount.get(tmpWord) - 1);
                                        }
                                        // stop sliding
                                        else {
                                            break;
                                        }
                                    }
                                    startSlidingWindow = j;
                                    currentWordCount--;
                                }
                                currentWord = new StringBuilder();
                            }
                        }
                        minWordCount = Math.min(currentWordCount, minWordCount);
                    }
                }
                currentWord = new StringBuilder();
            }
        }
        return minWordCount;
    }


    private void initialize(final String[] lookupWords, final Map<String, Integer> foundWordCount, final Set<String>
            searchWords) {
        for (String lookupWord : lookupWords) {
            searchWords.add(lookupWord);
            foundWordCount.put(lookupWord, 0);
        }
    }


    private boolean isInWord(final char c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }
}
