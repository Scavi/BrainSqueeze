/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.scavi.brainsqueeze.tree;

import com.scavi.brainsqueeze.util.Graph;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 13/11/16
 */
public class GraphTest {
    /**
     * Iterates through an undirected graph using bfs and expect a value to be found
     */
    @Test
    public void testUndirectedGraphBfsValid() {
        Graph<Integer> graph = createDummy(false);
        for (int i = 1; i <= 6; ++i) {
            boolean isExisting = graph.isNodeExistingBfs(i);
            Assert.assertTrue(isExisting);
        }
    }


    /**
     * Iterates through an undirected graph using bfs and expect a value not to be found
     */
    @Test
    public void testUndirectedGraphBfsInvalid() {
        Graph<Integer> graph = createDummy(false);
        boolean isExisting = graph.isNodeExistingBfs(42);
        Assert.assertFalse(isExisting);
    }


    /**
     * Iterates through an undirected graph using bfs and expect a value to be found
     */
    @Test
    public void testDirectedGraphBfsValid() {
        Graph<Integer> graph = createDummy(true);
        for (int i = 1; i <= 6; ++i) {
            boolean isExisting = graph.isNodeExistingBfs(i);
            Assert.assertTrue(isExisting);
        }
    }


    /**
     * Iterates through an undirected graph using bfs and expect a value not to be found
     */
    @Test
    public void testDirectedGraphBfsInvalid() {
        Graph<Integer> graph = createDummy(true);
        boolean isExisting = graph.isNodeExistingBfs(42);
        Assert.assertFalse(isExisting);
    }


    /**
     * Iterates through an undirected graph using bfs and expect a value to be found
     */
    @Test
    public void testUndirectedGraphDfsValid() {
        Graph<Integer> graph = createDummy(false);
        for (int i = 1; i <= 6; ++i) {
            boolean isExisting = graph.isNodeExistingDfs(i);
            Assert.assertTrue(isExisting);
        }
    }


    /**
     * Iterates through an undirected graph using bfs and expect a value not to be found
     */
    @Test
    public void testUndirectedGraphDfsInvalid() {
        Graph<Integer> graph = createDummy(false);
        boolean isExisting = graph.isNodeExistingDfs(42);
        Assert.assertFalse(isExisting);
    }


    /**
     * Iterates through an undirected graph using bfs and expect a value to be found
     */
    @Test
    public void testDirectedGraphDfsValid() {
        Graph<Integer> graph = createDummy(true);
        for (int i = 1; i <= 6; ++i) {
            boolean isExisting = graph.isNodeExistingDfs(i);
            Assert.assertTrue(isExisting);
        }
    }


    /**
     * Iterates through an undirected graph using bfs and expect a value not to be found
     */
    @Test
    public void testDirectedGraphDfsInvalid() {
        Graph<Integer> graph = createDummy(true);
        boolean isExisting = graph.isNodeExistingDfs(42);
        Assert.assertFalse(isExisting);
    }


    /**
     * Test the depth-first-search for a node that doesn't exist
     */
    @Test
    public void testCircleGraphDfsInvalid() {

        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        boolean isExisting = graph.isNodeExistingDfs(42);
        Assert.assertFalse(isExisting);
    }


    /**
     * Creates a dummy graph
     *
     * @param isDirected <code>true</code> the graph is directed, an edge can be only be traversed
     *                   from the side where it is added
     *                   <p/>
     *                   <code>false</code> In an undirected graph, an edge can be traversed from
     *                   both sides
     * @return a dummy graph
     */
    static Graph<Integer> createDummy(boolean isDirected) {
        Graph<Integer> graph = new Graph<>(isDirected);
        graph.addEdge(1, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(10, 10); // dummy (a node that is not attached to the graph)
        return graph;
    }
}
