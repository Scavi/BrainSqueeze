package com.scavi.brainsqueeze.career;


import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Trie {
    private final char WILD_CARD = '*';
    private final TrieNode _root = new TrieNode();

    /**
     * Inserts the text into the current trie.
     *
     * @param text the text to isnert.
     */
    public void insert(@Nonnull final String text) {
        if (text.isEmpty()) {
            return;
        }

        TrieNode currentNode = _root;
        for (char currentChar : text.toCharArray()) {
            if (currentNode.getNodes().containsKey(currentChar)) {
                currentNode = currentNode.getNodes().get(currentChar);
            } else {
                TrieNode newNode = new TrieNode();
                currentNode.getNodes().put(currentChar, newNode);
                currentNode = newNode;
            }
        }
        currentNode.marAsEndNode();
    }

    /**
     * Verifies if the given search texts exists in the trie. Also supports the wild card, e.g.:
     * Hallo -> Ha*o => true
     *
     * @param text the text to search.
     * @return <code>true</code> the text exists <br/>
     * <code>false</code> the text doesn't exist
     */
    public boolean exists(@Nonnull final String text) {
        if (text.isEmpty()) {
            return false;
        }
        return exists(_root, text, 0);
    }


    private boolean exists(@Nonnull final TrieNode currentNode, @Nonnull final String text, final int pos) {
        if (pos >= text.length()) {
            return currentNode.isEndNode();
        }

        boolean isExisting = false;
        char currentChar = text.charAt(pos);
        if (currentChar == WILD_CARD) {
            currentChar = pos == text.length() - 1 ? WILD_CARD : text.charAt(pos + 1);

            List<TrieNode> searchAllResult = new LinkedList<>();
            // get the next char and find all nodes that have the next char
            searchAll(searchAllResult, currentNode, currentChar);

            // exception case - a wild card at the end of the string and results were found
            if (currentChar == WILD_CARD && searchAllResult.size() > 0) {
                return true;
            } else {
                for (TrieNode currentTest : searchAllResult) {
                    isExisting = exists(currentTest, text, pos + 2);
                    if (isExisting) {
                        break;
                    }
                }
            }
        } else if (currentNode.getNodes().containsKey(currentChar)) {
            isExisting = exists(currentNode.getNodes().get(currentChar), text, pos + 1);
        }
        return isExisting;
    }


    /**
     * Searches all the possible node paths recursively until the search char is found. These nodes will be
     * added to the possible result sets for further investigation.
     *
     * @param result      the list for all found nodes that matches
     * @param currentNode the current node for the recursion
     * @param searchChar  the char to search
     */
    private void searchAll(@Nonnull final List<TrieNode> result,
                           @Nonnull final TrieNode currentNode,
                           final char searchChar) {

        for (Map.Entry<Character, TrieNode> search : currentNode.getNodes().entrySet()) {
            // either the next character was found or it is a wild card at the end of the string
            // this searches for all possible strings
            if (search.getKey() == searchChar || (searchChar == WILD_CARD && search.getValue().isEndNode())) {
                result.add(search.getValue());
            } else {
                searchAll(result, search.getValue(), searchChar);
            }
        }
    }


    private class TrieNode {
        private final Map<Character, TrieNode> _nodes = new HashMap<>();
        private boolean _isEndNode = false;

        TrieNode marAsEndNode() {
            _isEndNode = true;
            return this;
        }

        boolean isEndNode() {
            return _isEndNode;
        }

        Map<Character, TrieNode> getNodes() {
            return _nodes;
        }
    }

}
