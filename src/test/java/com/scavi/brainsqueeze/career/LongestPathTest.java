package com.scavi.brainsqueeze.career;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.*;
import static com.scavi.brainsqueeze.career.LongestPath.UndirectedGraphNode;

public class LongestPathTest {

    @Test
    public void test1() {
        UndirectedGraphNode node1_1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node1_2 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        UndirectedGraphNode node3 = new UndirectedGraphNode(3);
        UndirectedGraphNode node4 = new UndirectedGraphNode(4);
        UndirectedGraphNode node5 = new UndirectedGraphNode(5);
        UndirectedGraphNode node6 = new UndirectedGraphNode(6);
        UndirectedGraphNode node7 = new UndirectedGraphNode(7);

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

        List<UndirectedGraphNode> nodes = new ArrayList<>();
        nodes.addAll(Arrays.asList(node1_1, node1_2, node2, node3, node4, node5, node6, node7));

        int longestPath = new LongestPath().findLongestUniqueValuePath(nodes);
        assertThat(longestPath).isEqualTo(6);

    }
}
