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

import java.util.LinkedList;
import java.util.Objects;

/**
 * Created by Scavenger on 5/13/2017.
 */
public final class GraphNode<T> {
    private final T _content;
    private final LinkedList<GraphEdge<T>> _edges;
    private LookupState _nodeState = LookupState.Undiscovered;


    /**
     * Constructor
     *
     * @param content the content of the node
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
    public LinkedList<GraphEdge<T>> getEdges() {
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
    public GraphNode<T> setNodeState(final LookupState nodeState) {
        _nodeState = nodeState;
        return this;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != GraphNode.class) {
            return false;
        }
        GraphNode<T> toCompare = (GraphNode<T>) obj;
        return _content.equals(toCompare.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(_content);
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", String.valueOf(_content), _nodeState);
    }
}
