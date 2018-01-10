package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.util.graph.Graph;
import com.scavi.brainsqueeze.util.graph.GraphEdge;

import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day24ElectromagneticMoat {

    public int solveA(@Nonnull final String[] puzzleInput) {
        Graph<Integer> bridgeGraph = createGraph(puzzleInput);
        int max = 0;
        for (GraphEdge<Integer> startEdge : bridgeGraph.getGraph().get(0).getEdges()) {
            Set<GraphEdge<Integer>> discoveredEdges = new HashSet<>();
            discoveredEdges.add(startEdge);
            max = Math.max(max, startEdge.getWeight() +
                    calcStrongestBridge(bridgeGraph, startEdge, discoveredEdges));
        }
        return max;
    }


    public int solveB(@Nonnull final String[] puzzleInput) {
        Graph<Integer> bridgeGraph = createGraph(puzzleInput);
        int[] longestBridge = new int[2];
        for (GraphEdge<Integer> startEdge : bridgeGraph.getGraph().get(0).getEdges()) {
            Set<GraphEdge<Integer>> discoveredEdges = new HashSet<>();
            discoveredEdges.add(startEdge);
            calcLongestBridge(bridgeGraph, startEdge, discoveredEdges, longestBridge, 1, startEdge.getWeight());
        }
        return longestBridge[1];
    }

    private int calcStrongestBridge(
            final Graph<Integer> bridgeGraph,
            GraphEdge<Integer> currentEdge,
            final Set<GraphEdge<Integer>> discoveredEdges) {

        int targetNode = currentEdge.getTo().getContent();
        List<GraphEdge<Integer>> followEdges = bridgeGraph.getGraph().get(targetNode).getEdges();
        int max = 0;
        for (GraphEdge<Integer> followEdge : followEdges) {
            if (!discoveredEdges.contains(followEdge)) {
                discoveredEdges.add(followEdge);
                int tmp = followEdge.getWeight() +
                        calcStrongestBridge(bridgeGraph, followEdge, discoveredEdges);
                max = Math.max(tmp, max);
                discoveredEdges.remove(followEdge);
            }
        }
        return max;
    }


    private void calcLongestBridge(
            final Graph<Integer> bridgeGraph,
            GraphEdge<Integer> currentEdge,
            final Set<GraphEdge<Integer>> discoveredEdges,
            int[] longestBridge,
            int level,
            int length) {

        if (level >= longestBridge[0]) {
            longestBridge[1] = level > longestBridge[0] ? length : Math.max(length, longestBridge[1]);
            longestBridge[0] = level;
        }
        int targetNode = currentEdge.getTo().getContent();
        List<GraphEdge<Integer>> followEdges = bridgeGraph.getGraph().get(targetNode).getEdges();

        for (GraphEdge<Integer> followEdge : followEdges) {
            if (!discoveredEdges.contains(followEdge)) {
                discoveredEdges.add(followEdge);
                calcLongestBridge(bridgeGraph, followEdge, discoveredEdges, longestBridge, level + 1,
                        length + followEdge.getWeight());
                discoveredEdges.remove(followEdge);
            }
        }
    }


    private Graph<Integer> createGraph(final String[] puzzleInput) {
        Graph<Integer> graph = new Graph<>();
        for (String input : puzzleInput) {
            String[] parts = input.split("/");
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            graph.addEdge(from, to, from + to);
        }
        return graph;
    }
}
