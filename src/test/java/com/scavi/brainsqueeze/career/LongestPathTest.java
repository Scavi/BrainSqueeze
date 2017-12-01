package com.scavi.brainsqueeze.career;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.*;
import static com.scavi.brainsqueeze.career.LongestPath.GraphNode;

public class LongestPathTest {

    @Test
    public void test1() {
        GraphNode node1_1 = new GraphNode(1);
        GraphNode node1_2 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        GraphNode node5 = new GraphNode(5);
        GraphNode node6 = new GraphNode(6);
        GraphNode node7 = new GraphNode(7);

        node1_1.neighbors.add(node1_2);
        node1_1.neighbors.add(node3);

        node1_2.neighbors.add(node1_1);
        node1_2.neighbors.add(node4);

        node2.neighbors.add(node3);

        node4.neighbors.add(node3);
        node4.neighbors.add(node5);
        node4.neighbors.add(node1_2);

        node3.neighbors.add(node1_1);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node5.neighbors.add(node4);
        node5.neighbors.add(node6);

        node6.neighbors.add(node5);
        node6.neighbors.add(node7);

        node6.neighbors.add(node7);

        List<GraphNode> nodes = new ArrayList<>();
        nodes.addAll(Arrays.asList(node1_1, node1_2, node2, node3, node4, node5, node6, node7));

        int longestPath = new LongestPath().findLongestUniqueValuePath(nodes);
        assertThat(longestPath).isEqualTo(6);
    }


    /**
     * . 4 11
     * . | |
     * . 3 10
     * . | |
     * .1-2-5-6-12-13
     * .| ....|
     * 14....7-8-9
     * .|
     * 15
     */
    @Test
    public void testDAG() {
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        GraphNode node5 = new GraphNode(5);
        GraphNode node6 = new GraphNode(6);
        GraphNode node7 = new GraphNode(7);
        GraphNode node8 = new GraphNode(8);
        GraphNode node9 = new GraphNode(9);
        GraphNode node10 = new GraphNode(10);
        GraphNode node11 = new GraphNode(11);
        GraphNode node12 = new GraphNode(12);
        GraphNode node13 = new GraphNode(13);
        GraphNode node14 = new GraphNode(14);
        GraphNode node15 = new GraphNode(15);


        node1.neighbors.add(node2);
        node1.neighbors.add(node14);

        node2.neighbors.add(node3);
        node2.neighbors.add(node5);

        node3.neighbors.add(node4);

        node5.neighbors.add(node10);
        node5.neighbors.add(node6);

        node6.neighbors.add(node12);
        node6.neighbors.add(node7);

        node7.neighbors.add(node8);
        node8.neighbors.add(node9);

        node10.neighbors.add(node11);
        node12.neighbors.add(node13);
        node14.neighbors.add(node15);

        List<Integer> expectedLongestPath = new ArrayList<>(Arrays.asList(1, 2, 5, 6, 7, 8, 9));
        List<Integer> longestPath = new LongestPath().findLongestPathInDAG(node1);
        assertThat(longestPath).isEqualTo(expectedLongestPath);
    }
}
