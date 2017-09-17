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

/**
 * Created by Scavenger on 5/13/2017.
 * A class to represent the edges between two nodes
 */
public class GraphEdge<T> {
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
    public GraphNode<T> getTo() {
        return _to;
    }
}