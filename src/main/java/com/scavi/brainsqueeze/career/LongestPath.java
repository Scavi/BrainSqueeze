package com.scavi.brainsqueeze.career;

import java.util.*;

public class LongestPath {
    static class GraphNode {
        int label;
        List<GraphNode> neighbors;

        GraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "" + label;
        }
    }


    /**
     * Finds the longest path of unique labels in the graph. This is an np-complete problem.
     * The algorithm runs in O(n * (n * m)) and uses O(1) space.
     *
     * @param nodes the nodes of the graph.
     * @return the longest path
     */
    public int findLongestUniqueValuePath(List<GraphNode> nodes) {
        int longestUniquePath = 0;
        for (GraphNode node : nodes) {
            Set<Integer> foundValues = new HashSet<>();
            foundValues.add(node.label);
            longestUniquePath = Math.max(longestUniquePath, findLongestUniqueValuePath(node, foundValues));
        }
        return longestUniquePath;
    }


    private int findLongestUniqueValuePath(GraphNode node, Set<Integer> foundValues) {
        int pathFromHere = 0;
        for (GraphNode neighborNode : node.neighbors) {
            if (!foundValues.contains(neighborNode.label)) {
                foundValues.add(neighborNode.label);
                pathFromHere = Math.max(pathFromHere, findLongestUniqueValuePath(neighborNode, foundValues));
            }
        }
        return 1 + pathFromHere;
    }


    /**
     * Finds the longest path in a directed acyclic graph.
     *
     * @param root the graph node
     * @return the node labels from the longest path
     */
    public List<Integer> findLongestPathInDAG(GraphNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> longestPath = new LinkedList<>();
        findLongestPathInDAG(root, longestPath);
        return longestPath;
    }


    /**
     * This approach uses a temp list that keeps track of the current path. If the current path is longer then a
     * overall known path, the known path will be updated
     * <p>
     * This method runs in O(n²).
     *
     * @param currentNode the current node to process
     * @param longestPath the longest path overall known
     * @return the temp path
     */
    private List<Integer> findLongestPathInDAG(GraphNode currentNode, List<Integer> longestPath) {
        if (currentNode == null) {
            return new ArrayList<>();
        }
        if (currentNode.neighbors.size() == 0) {
            return Arrays.asList(currentNode.label);
        }

        List<Integer> tempLongestPath = null;
        for (GraphNode node : currentNode.neighbors) {
            tempLongestPath = new LinkedList<>();
            tempLongestPath.add(currentNode.label);

            tempLongestPath.addAll(findLongestPathInDAG(node, longestPath));
            if (tempLongestPath.size() > longestPath.size()) {
                // ugly part -> improvable?
                longestPath.clear();
                longestPath.addAll(tempLongestPath);
            }
        }
        return tempLongestPath;
    }
}
