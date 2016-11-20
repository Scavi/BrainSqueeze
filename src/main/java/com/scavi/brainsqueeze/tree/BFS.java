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

import com.scavi.brainsqueeze.util.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Michael Heymel
 * @since 04/11/16
 */
public class BFS {


    /**
     * Does a breadth-first-search of the given lookup value through all nodes of the root node
     *
     * @param root        the root node
     * @param lookupValue the lookup value
     * @return the first node containing the value that is equal to the given lookup value </p>
     * <code>null</code>, if root or lookup value are <code>null</code> or if no node exists to the
     * given value
     */
    public <T extends Comparable<T>> Node<T> search(final Node<T> root, final T lookupValue) {

        if (root == null || lookupValue == null) {
            return null;
        }

        Node<T> result = null;
        Node<T> currentNode = null;
        Queue<Node<T>> bfs = new LinkedList<>();
        bfs.add(root);
        while (bfs.size() > 0 && result == null) {

            currentNode = bfs.poll();
            if (currentNode != null) {
                if (lookupValue.equals(currentNode.getValue())) {
                    result = currentNode;
                } else {
                    if (currentNode.getLeft() != null) {
                        bfs.add(currentNode.getLeft());
                    }
                    if (currentNode.getRight() != null) {
                        bfs.add(currentNode.getRight());
                    }
                }
            }
        }
        return result;
    }
}
