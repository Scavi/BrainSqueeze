package com.scavi.brainsqueeze.adventofcode.util;

import com.scavi.brainsqueeze.util.StringHelper;
import com.scavi.brainsqueeze.util.graph.Graph;

import javax.annotation.Nonnull;

public class AoCInputParser {

    /**
     * Creates an undirected {@link Graph} with {@link Integer} nodes from the given input:
     * SourceNode <-> TargetNodes, e.g.:
     * 2 <-> 0, 3, 4
     *
     * @param graphData the graph data
     * @return the graph
     */
    public static Graph<Integer> graphFrom(@Nonnull final String[] graphData) {
        Graph<Integer> graph = new Graph<>();
        for (String nodeConfig : graphData) {
            String[] nodes = StringHelper.split(nodeConfig, "<->");
            for (String targetNode : StringHelper.split(nodes[1], ",")) {
                graph.addEdge(Integer.parseInt(nodes[0]), Integer.parseInt(targetNode));
            }
        }
        return graph;
    }


    /**
     * Creates a two dimensional array of width 2 from the given input
     * Value1: Value2, e.g.:
     * 0: 3
     * 1: 2
     *
     * @param input
     * @return
     */
    public static int[][] arrayPairFrom(@Nonnull final String[] input) {
        int[][] pairs = new int[input.length][2];

        int pos = 0;
        for (String current : input) {
            String[] token = StringHelper.split(current, ":");
            pairs[pos][0] = Integer.parseInt(token[0]);
            pairs[pos][1] = Integer.parseInt(token[1]);
            pos++;
        }
        return pairs;
    }
}
