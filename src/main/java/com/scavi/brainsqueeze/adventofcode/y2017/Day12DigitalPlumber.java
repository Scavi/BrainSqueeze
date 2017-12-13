package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.adventofcode.util.AoCInputParser;
import com.scavi.brainsqueeze.util.graph.Graph;
import com.scavi.brainsqueeze.util.graph.GraphNode;
import com.scavi.brainsqueeze.util.graph.LookupState;

public class Day12DigitalPlumber {

    public int solveA(final String[] graphData) {
        Graph<Integer> graph = AoCInputParser.graphFrom(graphData);
        int cnt = 0;
        for (GraphNode<Integer> node : graph.getGraph().values()) {
            graph.reinitializeNodeStates();
            if (graph.dfs(node, 0)) {
                cnt++;
            }
        }
        return cnt;
    }

    public int solveB(final String[] graphData) {
        Graph<Integer> graph = AoCInputParser.graphFrom(graphData);
        int cnt = 0;
        for (GraphNode<Integer> node : graph.getGraph().values()) {
            if (node.getNodeState() == LookupState.Undiscovered) {
                cnt++;
            }
            graph.dfs(node, -1);
        }
        return cnt;
    }
}