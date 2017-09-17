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

import java.util.*;

/**
 * Created by Scavenger on 5/14/2017.
 * <p>
 * A very simply class to represent a non directed graph via nodes.
 */
public class SimpleGraphNode<T> {
    private final T _content;
    private final List<SimpleGraphNode<T>> _children = new LinkedList<>();
    private final Set<SimpleGraphNode<T>> _ancestors = new HashSet<>();

    /**
     * Constructor
     *
     * @param content the content of the node
     */
    public SimpleGraphNode(T content) {
        _content = content;
    }

    @SafeVarargs
    public final void add(SimpleGraphNode<T>... entries) {
        if (entries != null) {
            for (SimpleGraphNode<T> entry : entries) {
                entry.addAncestor(this);
                _children.add(entry);
            }
        }
    }

    /**
     * Adds an ancestor to the current node (a node that is pointing to this node)
     *
     * @param ancestor the ancestor to add
     */
    private void addAncestor(SimpleGraphNode<T> ancestor) {
        if (!_ancestors.contains(ancestor)) {
            _ancestors.add(ancestor);
        }
    }

    /**
     * Removes an ancestor (a node that is pointing to this ndoe) from the given node
     *
     * @param ancestor the ancestor to remove
     * @return <code>true</code> the node was removed <br>
     * <code>false</code> no node was removed
     */
    public boolean removeAncestor(SimpleGraphNode<T> ancestor) {
        boolean wasRemoved = false;
        if (_ancestors.contains(ancestor)) {
            _ancestors.remove(ancestor);
            wasRemoved = true;
        }
        return wasRemoved;
    }

    /**
     * @return The content of the node
     */
    public T getContent() {
        return _content;
    }

    /**
     * @return All node child-references of the current node (the nodes, this node is pointing to)
     */
    public List<SimpleGraphNode<T>> getChildren() {
        return _children;
    }

    /**
     * @return All node ancestor-references of the current node (the nodes that are pointing to this node)
     */
    public Set<SimpleGraphNode<T>> getAncestors() {
        return _ancestors;
    }


    @Override
    public String toString() {
        return _content != null ? _content.toString() : null;
    }
}