package com.scavi.brainsqueeze.codefight.i.tree;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindSubstrings {




    // TOO SLOW:
    String[] findSubstrings(String[] words, String[] parts) {
        //Arrays.sort(parts, (o1, o2) -> o2.length() - o1.length());
        for (int i = 0; i < words.length; ++i) {

            PriorityQueue<Pair> matching = new PriorityQueue<>((o1, o2) -> {
                if (o1._part.length() == o2._part.length()) {
                    return o1._pos - o2._pos;
                }
                return o2._part.length() - o1._part.length();
            });
            int max = 0;
            for (String part : parts) {
                int index = words[i].indexOf(part);
                if (index >= 0) {
                    if (max > part.length()) {
                        break;
                    }
                    max = part.length();
                    matching.add(new Pair(index, part));
                }
            }

            if (matching.size() > 0) {
                Pair toReplace = matching.poll();
                //Pattern pattern = Pattern.compile(toReplace._part);
                //Matcher matcher = pattern.matcher(words[i]);
                //words[i] = matcher.replaceFirst(String.format("[%s]", toReplace._part));
                words[i] = new StringBuilder(words[i]).replace(
                        toReplace._pos, toReplace._pos + toReplace._part.length(),
                        String.format("[%s]", toReplace._part)).toString();
            }
        }
        return words;
    }

    private class Pair {
        private int _pos;
        private String _part;

        Pair(final int pos, final String part) {
            _pos = pos;
            _part = part;
        }
    }
}
