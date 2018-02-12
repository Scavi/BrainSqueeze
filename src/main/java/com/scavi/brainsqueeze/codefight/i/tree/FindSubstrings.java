package com.scavi.brainsqueeze.codefight.i.tree;

import java.util.HashMap;
import java.util.Map;

public class FindSubstrings {

    String[] findSubstrings(String[] words, String[] parts) {
        if (words == null || words.length == 0 || parts == null || parts.length == 0) {
            return words;
        }
        Trie partsTrie = Trie.from(parts);
        String[] output = new String[words.length];

        for (int j = 0; j < words.length; ++j) {
            StringBuilder word = new StringBuilder(words[j]);
            int from = -1;
            int length = 0;
            for (int i = 0; i < word.length(); ++i) {
                String found = partsTrie.containsFrom(word, i);
                if (found != null && found.length() > length) {
                    from = i;
                    length = found.length();
                }
            }

            if (from != -1) {
                word.insert(from, '[');
                word.insert(from + length + 1, ']');
            }
            output[j] = word.toString();
        }
        return output;
    }


    private static class Trie {
        private final TrieNode _root = new TrieNode();

        void insert(final String input) {
            if (input.isEmpty()) {
                return;
            }
            TrieNode currentNode = _root;
            for (char currentChar : input.toCharArray()) {
                if (currentNode.getData().containsKey(currentChar)) {
                    currentNode = currentNode.getData().get(currentChar);
                } else {
                    TrieNode newNode = new TrieNode();
                    currentNode.getData().put(currentChar, newNode);
                    currentNode = newNode;
                }
            }
            currentNode.markAsEndNode();
        }

        String containsFrom(StringBuilder lookup, int pos) {
            StringBuilder result = new StringBuilder();
            String contentToEndNode = null;
            TrieNode current = _root;
            for (int i = pos; i < lookup.length(); ++i) {
                char c = lookup.charAt(i);
                if (current.getData().containsKey(c)) {
                    current = current.getData().get(c);
                    result.append(c);
                    if (current.isEndNode()) {
                        contentToEndNode = result.toString();
                    }
                } else {
                    break;
                }
            }
            return contentToEndNode;
        }

        private class TrieNode {
            private Map<Character, TrieNode> _data = new HashMap<>();
            private boolean _isEndNode = false;

            boolean isEndNode() {
                return _isEndNode;
            }

            void markAsEndNode() {
                _isEndNode = true;
            }

            public Map<Character, TrieNode> getData() {
                return _data;
            }
        }


        public static Trie from(final String[] input) {
            Trie trie = new Trie();
            for (String current : input) {
                trie.insert(current);
            }
            return trie;
        }
    }

//
//    // TOO SLOW:
//    String[] findSubstrings(String[] words, String[] parts) {
//        //Arrays.sort(parts, (o1, o2) -> o2.length() - o1.length());
//        for (int i = 0; i < words.length; ++i) {
//
//            PriorityQueue<Pair> matching = new PriorityQueue<>((o1, o2) -> {
//                if (o1._part.length() == o2._part.length()) {
//                    return o1._pos - o2._pos;
//                }
//                return o2._part.length() - o1._part.length();
//            });
//            int max = 0;
//            for (String part : parts) {
//                int index = words[i].indexOf(part);
//                if (index >= 0) {
//                    if (max > part.length()) {
//                        break;
//                    }
//                    max = part.length();
//                    matching.add(new Pair(index, part));
//                }
//            }
//
//            if (matching.size() > 0) {
//                Pair toReplace = matching.poll();
//                //Pattern pattern = Pattern.compile(toReplace._part);
//                //Matcher matcher = pattern.matcher(words[i]);
//                //words[i] = matcher.replaceFirst(String.format("[%s]", toReplace._part));
//                words[i] = new StringBuilder(words[i]).replace(
//                        toReplace._pos, toReplace._pos + toReplace._part.length(),
//                        String.format("[%s]", toReplace._part)).toString();
//            }
//        }
//        return words;
//    }
//
//    private class Pair {
//        private int _pos;
//        private String _part;
//
//        Pair(final int pos, final String part) {
//            _pos = pos;
//            _part = part;
//        }
//    }
}
