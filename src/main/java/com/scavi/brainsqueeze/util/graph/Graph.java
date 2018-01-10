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

package com.scavi.brainsqueeze.util.graph;

import com.google.common.base.Preconditions;

import java.util.*;

/**
 * @author Michael Heymel
 * @since 04/11/16
 */
public class Graph<T> {
    private final boolean _isDirected;
    private final Map<T, GraphNode<T>> _adjacencyList;


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
        GraphNode<T> fromGraphNode = addNodeToGraph(from);
        GraphNode<T> toGraphNode = addNodeToGraph(to);
        GraphEdge<T> edge = new GraphEdge<>(weight, fromGraphNode, toGraphNode);
        fromGraphNode.getEdges().add(edge);
    }


    /**
     * Tries to add the node value to the given graph. In case, the node already exists, the
     * existing node will be returned. Otherwise a new node will created and added
     *
     * @param value the value to add
     * @return the added graph node or the existing node, in case the node was already in the graph
     */
    private GraphNode<T> addNodeToGraph(final T value) {
        GraphNode<T> graphNode = new GraphNode<>(value);
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
     * @param lookupValue the value too lookupOutside
     * @return <code>true</code> the value exists in the graph
     * <p/>
     * <code>false</code> the value doesn't exist in the graph
     */
    public boolean isNodeExistingBfs(final T lookupValue) {
        Preconditions.checkNotNull(lookupValue, "Illegal lookupOutside: <null>");
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
        Queue<GraphNode<T>> bfsQueue = new LinkedList<>();

        // iterate through all list. This will make sure, that also nodes that are not attached
        // to the graph will be iterated
        Iterator<Map.Entry<T, GraphNode<T>>> graphIterator = _adjacencyList.entrySet().iterator();
        while (graphIterator.hasNext() && !wasFound) {
            GraphNode<T> tmp = graphIterator.next().getValue();

            // only add undiscovered nodes for the further lookupOutside
            if (tmp.getNodeState() == LookupState.Undiscovered) {
                bfsQueue.add(tmp.setNodeState(LookupState.Discovered));
            }
            // iterates through the queue until the entry was found. During iteration, edges that
            // are not discovered yet will be added to the queue
            while (bfsQueue.size() > 0 && !wasFound) {
                GraphNode<T> currentNode = bfsQueue.poll();

                if (lookupValue.equals(currentNode.getContent())) {
                    wasFound = true;
                } else {
                    // adds all undiscovered nodes
                    for (GraphEdge<T> edge : currentNode.getEdges()) {
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
        Preconditions.checkNotNull(lookupValue, "Illegal lookupOutside: <null>");
        // reset the search from previous searches
        reinitializeNodeStates();

        Iterator<Map.Entry<T, GraphNode<T>>> graphIterator = _adjacencyList.entrySet().iterator();
        boolean wasFound = false;
        while (graphIterator.hasNext() && !wasFound) {
            GraphNode<T> currentNode = graphIterator.next().getValue();
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
    public boolean dfs(final GraphNode<T> currentNode, final T lookupValue) {

        boolean wasFound = false;
        if (lookupValue.equals(currentNode.getContent())) {
            wasFound = true;
        } else {
            // follow only roots that were undiscovered
            for (int i = 0; i < currentNode.getEdges().size() && !wasFound; ++i) {
                GraphEdge<T> currentEdge = currentNode.getEdges().get(i);
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
    public void reinitializeNodeStates() {
        for (GraphNode current : _adjacencyList.values()) {
            current.setNodeState(LookupState.Undiscovered);
        }
    }

    /**
     * @return The map representing the adjacency "list"
     */
    public Map<T, GraphNode<T>> getGraph() {
        return _adjacencyList;
    }
}
