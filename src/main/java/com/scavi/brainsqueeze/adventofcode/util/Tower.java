package com.scavi.brainsqueeze.adventofcode.util;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tower {
    private Map<String, Node> _allNodes = new HashMap<>();

    public Node add(final String name) {
        return add(name, Node.NO_WEIGHT);
    }

    public Node add(final String name, final int weight) {
        Node node;
        if (_allNodes.containsKey(name)) {
            node = _allNodes.get(name);
        } else {
            node = new Node(name, weight);
            _allNodes.put(name, node);
        }
        node.setWeight(weight != Node.NO_WEIGHT ? weight : node.getWeight());
        return node;
    }

    public Map<String, Node> getAllNodes() {
        return _allNodes;
    }


    public static class Node {
        private static final int NO_WEIGHT = -1;
        private final String _name;
        private int _weight;
        private final List<Node> _nodes = new LinkedList<>();

        public Node(final String name) {
            this(name, NO_WEIGHT);
        }

        public Node(final String name, final int weight) {
            _name = name;
            _weight = weight;
        }


        public String getName() {
            return _name;
        }


        public void setWeight(int weight) {
            _weight = weight;
        }

        public int getWeight() {
            return _weight;
        }

        public List<Node> getNodes() {
            return _nodes;
        }

        @Override
        public String toString() {
            return String.format("%s [%d]", getName(), getWeight());
        }
    }


    /**
     * Creates from the input of multiple lines, while each line has a pattern of "* (int) optional: [foo, bar, x]" a
     * graph. The int value will be set as weight of the current node
     * e.g.:
     * rtrbpze (337) -> xlhtsn, hyvee, cyxpp
     * psnhw (81)
     * ...
     *
     * @param input the input
     * @return the tower graph
     * @throws IllegalArgumentException
     */
    public static Tower from(@Nonnull final String[] input) throws IllegalArgumentException {
        Tower tower = new Tower();

        for (String current : input) {
            int reference = current.indexOf("->");
            String firstPart = current.substring(0, reference > 0 ? reference : current.length());
            Matcher weightMatcher = Pattern.compile("(?<=\\()\\d+[^\\)]*").matcher(firstPart);
            if (!weightMatcher.find()) {
                throw new IllegalArgumentException("Illegal pattern!");
            }

            String name = firstPart.substring(0, firstPart.indexOf(' '));
            int weight = Integer.parseInt(weightMatcher.group());
            Node rootNode = tower.add(name, weight);

            if (reference > 0) {
                StringTokenizer subNodes = new StringTokenizer(current.substring(reference + 3), ",");
                while (subNodes.hasMoreTokens()) {
                    String subNodeName = subNodes.nextToken().trim();
                    Node subNode = tower.add(subNodeName);
                    rootNode.getNodes().add(subNode);
                }
            }
        }
        return tower;
    }
}
