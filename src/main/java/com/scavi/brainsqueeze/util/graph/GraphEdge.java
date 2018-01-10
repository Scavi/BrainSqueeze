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


import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Created by Scavenger on 5/13/2017.
 * A class to represent the edges between two nodes
 */
public class GraphEdge<T> {
    private final int _weight;
    private final GraphNode<T> _from;
    private final GraphNode<T> _to;


    /**
     * Constructor
     *
     * @param weight the weight to reach the node
     * @param from   the start point of the edge
     * @param to     the end point of the edge
     */
    public GraphEdge(final int weight, final GraphNode<T> from, final GraphNode<T> to) {
        _from = from;
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
     * @return the start point of the edge
     */
    public GraphNode<T> getFrom() {
        return _from;
    }


    /**
     * @return the end point of the edge
     */
    public GraphNode<T> getTo() {
        return _to;
    }


    @Override
    public int hashCode() {
        // needs to be reliable because in case _from -> _to or _to -> _from should be equal, even if they are
        // different objects
        return (_from.hashCode() + _to.hashCode()) / 13 * _weight << 3;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != GraphEdge.class) {
            return false;
        }
        GraphEdge<T> toCompare = (GraphEdge<T>) obj;
        return Objects.equal(_weight, toCompare.getWeight()) &&
                (Objects.equal(_from, toCompare.getFrom()) &&
                        Objects.equal(_to, toCompare.getTo())) ||
                (Objects.equal(_to, toCompare.getFrom()) &&
                        Objects.equal(_from, toCompare.getTo()));
    }


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("weight", getWeight()).add("from", getFrom()).add("to", getTo())
                .toString();
    }
}