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

/**
 * @author Michael Heymel
 * @since 25/09/16
 */
public class Node<T extends Comparable<T>> {
    private T _value;
    private Node<T> _left;
    private Node<T> _right;


    /**
     * Constructor
     *
     * @param value the value of the node
     */
    public Node(final T value) {
        this(value, null, null);
    }


    /**
     * Constructor
     *
     * @param value the value of the node
     * @param left  the left node from the current node
     * @param right the right node from the current node
     */
    public Node(final T value, final Node<T> left, final Node<T> right) {
        _value = value;
        _left = left;
        _right = right;
    }


    /**
     * Compares the given node and all it's children with the current node
     *
     * @param toCompare the node to compare
     * @return <code>true</code> the given node and it's entire node structure are equal to the
     * current node <code>false</code> else
     */
    @Override
    public boolean equals(final Object toCompare) {
        if (!(toCompare instanceof Node)) {
            return false;
        }
        return compareNodes(this, (Node<T>) toCompare);
    }


    /**
     * Compares if the values and the structure of both given nodes are equal
     *
     * @param node1 the current node 1
     * @param node2 the current node 2
     * @return <code>true</code> the given node and it's entire node structure are equal to the
     * current node <code>false</code> else
     */
    private boolean compareNodes(final Node<T> node1, final Node<T> node2) {
        // pre-node validation
        if (node1 != null && node2 == null) {
            return false;
        } else if (node1 == null && node2 != null) {
            return false;
        } else if (node1 == null) {
            return true;
        }

        // value validation
        boolean areEqual =
                node1.getValue() != null && node1.getValue().compareTo(node2.getValue()) == 0 ||
                        node2.getValue() == null;
        areEqual &= compareNodes(node1.getLeft(), node2.getLeft());
        areEqual &= compareNodes(node1.getRight(), node2.getRight());
        return areEqual;
    }


    /**
     * @param value the value of the node
     */
    public void setValue(final T value) {
        _value = value;
    }


    /**
     * @return the value of the node
     */
    public T getValue() {
        return _value;
    }


    /**
     * @return the left node from the current node
     */
    public Node<T> getLeft() {
        return _left;
    }


    /**
     * @param left the left node from the current node
     */
    public void setLeft(final Node<T> left) {
        _left = left;
    }


    /**
     * @return the right node from the current node
     */
    public Node<T> getRight() {
        return _right;
    }


    /**
     * @param right the right node from the current node
     */
    public void setRight(final Node<T> right) {
        _right = right;
    }


    /**
     * @return string value information of the node
     */
    @Override
    public String toString() {
        return _value != null ? _value.toString() : "<null>";
    }
}
