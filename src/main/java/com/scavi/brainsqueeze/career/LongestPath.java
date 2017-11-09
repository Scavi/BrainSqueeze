package com.scavi.brainsqueeze.career;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestPath {
    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }


    /**
     * Finds the longest path of unique labels in the graph. This is an np-complete problem.
     * The algorithm runs in O(n * (n * m)) and uses O(1) space.
     *
     * @param nodes the nodes of the graph.
     * @return the longest path
     */
    public int findLongestUniqueValuePath(List<UndirectedGraphNode> nodes) {
        int longestUniquePath = 0;
        for (UndirectedGraphNode node : nodes) {
            Set<Integer> foundValues = new HashSet<>();
            foundValues.add(node.label);
            longestUniquePath = Math.max(longestUniquePath, findLongestUniqueValuePath(node, foundValues));
        }
        return longestUniquePath;
    }


    private int findLongestUniqueValuePath(UndirectedGraphNode node, Set<Integer> foundValues) {
        int pathFromHere = 0;
        for (UndirectedGraphNode neighborNode : node.neighbors) {
            if (!foundValues.contains(neighborNode.label)) {
                foundValues.add(neighborNode.label);
                pathFromHere = Math.max(pathFromHere, findLongestUniqueValuePath(neighborNode, foundValues));
            }
        }
        return 1 + pathFromHere;
    }
}
