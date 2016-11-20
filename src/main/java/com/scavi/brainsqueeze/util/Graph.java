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

package com.scavi.brainsqueeze.util;

import com.google.common.base.Preconditions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


/**
 * @author Michael Heymel
 * @since 04/11/16
 */
public class Graph<T> {
    private final boolean _isDirected;
    private final Map<T, GraphNode> _adjacencyList;


    /**
     * Constructor for an undirected graph
     */
    public Graph() {
        this(false);
    }


    /**
     * Constructor
     *
     * @param isDirected <code>true</code> the graph is directed, an edge can be only be traversed
     *                   from the side where it is added
     *                   <p/>
     *                   <code>false</code> In an undirected graph, an edge can be traversed from
     *                   both sides
     */
    public Graph(final boolean isDirected) {
        _adjacencyList = new HashMap<>();
        _isDirected = isDirected;
    }


    /**
     * Adds an edge between the two given point data with the weight of 0 to the current graph.
     *
     * @param from the start point of the new edge to add
     * @param to   the end point of the new edge to add
     */
    public void addEdge(final T from, final T to) {
        addEdge(from, to, 0);
    }


    /**
     * Adds an edge between the two given point data with the given weight to the current graph.
     *
     * @param from   the start point of the new edge to add
     * @param to     the end point of the new edge to add
     * @param weight the weight between the two given points
     */
    public void addEdge(final T from, final T to, final int weight) {
        Preconditions.checkNotNull(from, "From node is: <null>");
        Preconditions.checkNotNull(to, "To node is: <null>");

        addEdgeToGraph(from, to, weight);
        if (!_isDirected) {

            addEdgeToGraph(to, from, weight);
        }
    }


    /**
     * Adds the two nodes and the edge to the existing graph. Verifies if the node is already in the
     * graph. If yes, the edge to the new node will be added (don't validate if the edge already
     * exists)
     *
     * @param from   the start point of the new edge to add
     * @param to     the end point of the new edge to add
     * @param weight the weight between the two given points
     */
    private void addEdgeToGraph(final T from, final T to, final int weight) {
        GraphNode fromGraphNode = addNodeToGraph(from);
        GraphNode toGraphNode = addNodeToGraph(to);
        GraphEdge edge = new GraphEdge(weight, toGraphNode);
        fromGraphNode.getEdges().add(edge);
    }


    /**
     * Tries to add the node value to the given graph. In case, the node already exists, the
     * existing node will be returned. Otherwise a new node will created and added
     *
     * @param value the value to add
     * @return the added graph node or the existing node, in case the node was already in the graph
     */
    private GraphNode addNodeToGraph(final T value) {
        GraphNode graphNode = new GraphNode(value);
        if (_adjacencyList.containsKey(value)) {
            graphNode = _adjacencyList.get(value);
        } else {
            _adjacencyList.put(value, graphNode);
        }
        return graphNode;
    }


    /**
     * Validates if the given node content exists in the graph by using breadth-first-search. The
     * algorithm runs in O(n + m)
     *
     * @param lookupValue the value too lookup
     * @return <code>true</code> the value exists in the graph
     * <p/>
     * <code>false</code> the value doesn't exist in the graph
     */
    public boolean isNodeExistingBfs(final T lookupValue) {
        Preconditions.checkNotNull(lookupValue, "Illegal lookup: <null>");
        // reset the search from previous searches
        reinitializeNodeStates();
        return bfs(lookupValue);
    }


    /**
     * Validates if the given node content exists in the graph by using breadth-first-search. The
     * algorithm runs in O(v + e), both directed and undirected graphs and takes O (k) space while
     * k is the number of nodes that needs to be stored at max (k might be m for certain graphs)
     *
     * @param lookupValue the value to search for
     * @return <code>true</code> the value exists in the graph
     * <p/>
     * <code>false</code> the value doesn't exist in the graph
     */
    private boolean bfs(final T lookupValue) {
        boolean wasFound = false;
        Queue<GraphNode> bfsQueue = new LinkedList<>();

        // iterate through all list. This will make sure, that also nodes that are not attached
        // to the graph will be iterated
        Iterator<Map.Entry<T, GraphNode>> graphIterator = _adjacencyList.entrySet().iterator();
        while (graphIterator.hasNext() && !wasFound) {
            GraphNode tmp = graphIterator.next().getValue();

            // only add undiscovered nodes for the further lookup
            if (tmp.getNodeState() == LookupState.Undiscovered) {
                bfsQueue.add(tmp.setNodeState(LookupState.Discovered));
            }
            // iterates through the queue until the entry was found. During iteration, edges that
            // are not discovered yet will be added to the queue
            while (bfsQueue.size() > 0 && !wasFound) {
                GraphNode currentNode = bfsQueue.poll();

                if (lookupValue.equals(currentNode.getContent())) {
                    wasFound = true;
                } else {
                    // adds all undiscovered nodes
                    for (GraphEdge edge : currentNode.getEdges()) {
                        if (edge.getTo().getNodeState() == LookupState.Undiscovered) {
                            bfsQueue.add(edge.getTo());
                        }
                    }
                    currentNode.setNodeState(LookupState.Processed);
                }
            }
        }
        return wasFound;
    }


    /**
     * Validates if the given node value exists in the current graph using depth-first-search. The
     * algorithm runs in O(v + e) both for directed and undirected graphs and doesn't take extra
     * space (except the method stack calls of the used recursion)
     *
     * @param lookupValue the value to search for
     * @return <code>true</code> the value exists in the graph
     * <p/>
     * <code>false</code> the value doesn't exist in the graph
     */
    public boolean isNodeExistingDfs(final T lookupValue) {
        Preconditions.checkNotNull(lookupValue, "Illegal lookup: <null>");
        // reset the search from previous searches
        reinitializeNodeStates();

        Iterator<Map.Entry<T, GraphNode>> graphIterator = _adjacencyList.entrySet().iterator();
        boolean wasFound = false;
        while (graphIterator.hasNext() && !wasFound) {
            GraphNode currentNode = graphIterator.next().getValue();
            if (currentNode.getNodeState() == LookupState.Undiscovered) {
                wasFound = dfs(currentNode.setNodeState(LookupState.Discovered), lookupValue);
                currentNode.setNodeState(LookupState.Processed);
            }
        }
        return wasFound;
    }


    /**
     * Validates if the given node value exists in the current graph using depth-first-search. The
     * algorithm runs in O(v + e) both for directed and undirected graphs and doesn't take extra
     * space (except the method stack calls of the used recursion)
     *
     * @param lookupValue the value to search for
     * @return <code>true</code> the value exists in the graph
     * <p/>
     * <code>false</code> the value doesn't exist in the graph
     */
    private boolean dfs(final GraphNode currentNode, final T lookupValue) {

        boolean wasFound = false;
        if (lookupValue.equals(currentNode.getContent())) {
            wasFound = true;
        } else {
            // follow only roots that were undiscovered
            for (int i = 0; i < currentNode.getEdges().size() && !wasFound; ++i) {
                GraphEdge currentEdge = currentNode.getEdges().get(i);
                if (currentEdge.getTo().getNodeState() == LookupState.Undiscovered) {
                    wasFound = dfs(currentEdge.getTo().setNodeState(LookupState.Discovered),
                            lookupValue);
                }
                currentEdge.getTo().setNodeState(LookupState.Processed);
            }
        }
        return wasFound;
    }


    /**
     * Re-initializes the nodes states to undiscovered
     */
    private void reinitializeNodeStates() {
        for (GraphNode current : _adjacencyList.values()) {
            current.setNodeState(LookupState.Undiscovered);
        }
    }


    /**
     * The class to represent a node in the graph
     */
    private final class GraphNode {
        private final T _content;
        private final LinkedList<GraphEdge> _edges;
        private LookupState _nodeState = LookupState.Undiscovered;


        /**
         * Constructor
         *
         * @param content the ocntent of the node
         */
        public GraphNode(final T content) {
            _content = content;
            _edges = new LinkedList<>();
        }


        /**
         * @return the content of the node
         */
        public T getContent() {
            return _content;
        }


        /**
         * @return all edges of the current node
         */
        public LinkedList<GraphEdge> getEdges() {
            return _edges;
        }


        /**
         * @return the current state of the node
         */
        public LookupState getNodeState() {
            return _nodeState;
        }


        /**
         * @param nodeState the current state of the node
         * @return this
         */
        public GraphNode setNodeState(final LookupState nodeState) {
            _nodeState = nodeState;
            return this;
        }


        @Override
        public String toString() {
            return String.format("%s (%s)", String.valueOf(_content), _nodeState);
        }
    }


    /**
     * A class to represent the edges between two nodes
     */
    private final class GraphEdge {
        private final int _weight;
        private final GraphNode _to;


        /**
         * Constructor
         *
         * @param weight the weight to reach the node
         * @param to     the end point of the edge
         */
        public GraphEdge(final int weight, final GraphNode to) {
            _weight = weight;
            _to = to;
        }


        /**
         * @return the weight to reach the node
         */
        public int getWeight() {
            return _weight;
        }


        /**
         * @return the end point of the edge
         */
        public GraphNode getTo() {
            return _to;
        }
    }


    /**
     * To support lookups in graphs with cycles
     */
    private enum LookupState {
        Undiscovered, Discovered, Processed
    }
}
