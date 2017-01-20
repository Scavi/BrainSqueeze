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
import java.util.List;

/**
 * @author Michael Heymel
 * @since 25/09/16
 */
public class BstGames {


    /**
     * Given the root of a Binary Tree along with two integer values. Assume that both integers are
     * present in the tree. Find the LCA (Least Common Ancestor) of the two nodes with values of the
     * given integers. 2 pass solution is easy. You must solve this in a single pass.
     * <p/>
     * Information: This is a simple version, assuming that the left side of the bst is greater than
     * the right side
     *
     * @param value1 the value of the first node
     * @param value2 the value of the second node
     * @return the LCA of both given values
     */
    public Node<Integer> findLCA(final Node<Integer> root, final int value1, final int value2) {
        if (root == null) {
            return null;
        }
        Node<Integer> result;
        if (root.getValue() >= value1 && root.getValue() <= value2 ||
                root.getValue() <= value1 && root.getValue() >= value2) {
            result = root;
        } else if (root.getValue() > value1) {
            result = findLCA(root.getLeft(), value1, value2);
        } else {
            result = findLCA(root.getRight(), value1, value2);
        }
        return result;
    }


    /**
     * Given a root node representing a BST, modify it so that all greater values are added to every
     * node.
     * <p/>
     * Input:
     * _______ 50
     * ___ 30      70
     * _ 20  40  60  80
     * <p/>
     * Expected output:
     * ________ 260
     * ___ 330       150
     * _ 350  300  210  80
     *
     * @param root the root of the BST
     * @return the root, containing all children with changed values
     */
    public Node<Integer> allGreaterValues(final Node<Integer> root) {
        if (root == null) {
            return null;
        }
        inorderRightTraversal(root, 0);
        return root;
    }


    /**
     * Does an inorder traversel (right) to add all greater values
     *
     * @param currentRoot the current root node
     * @param toAdd       the value to add
     * @return the new value (changed by the value of the current root) to add
     */
    private int inorderRightTraversal(final Node<Integer> currentRoot, int toAdd) {
        // traverse right
        if (currentRoot.getRight() != null) {
            toAdd = inorderRightTraversal(currentRoot.getRight(), toAdd);
        }
        // set a temp value, add the value to the node and increase the overall value to add
        int tmp = currentRoot.getValue();
        currentRoot.setValue(tmp + toAdd);
        toAdd += tmp;
        // traverse left
        if (currentRoot.getLeft() != null) {
            toAdd = inorderRightTraversal(currentRoot.getLeft(), toAdd);
        }
        return toAdd;
    }


    /**
     * Converts the given BST to a linked list in O(n)
     *
     * @param root the root
     * @return the converted linked list
     */
    public <T extends Comparable<T>> List<T> toList(final Node<T> root) {
        if (root == null) {
            return null;
        }
        List<T> result = new LinkedList<>();
        return toList(root, result);
    }


    /**
     * Converts the given BST to a linked list
     *
     * @param root   the root
     * @param result the list result
     * @return the converted linked list
     */
    private <T extends Comparable<T>> List<T> toList(final Node<T> root, final List<T> result) {
        if (root != null) {
            toList(root.getLeft(), result);
            result.add(root.getValue());
            toList(root.getRight(), result);
        }
        return result;
    }


    /**
     * Determines the k- min elements within the binary tree.
     * <p/>
     * http://www.geeksforgeeks.org/sum-k-smallest-elements-bst/
     * <p/>
     * The algorithm runs in O(k), since the node isn't augmented (containing the amount of
     * children from the current node)
     *
     * @param root      the root element of the bst
     * @param kElements the number of elements
     * @return the min-sum of k elements in the binary tree
     */
    public int kMin(final Node<Integer> root, final int kElements) {
        int[] cache = new int[]{0, kElements};
        kMin(root, cache);
        return cache[0];
    }


    /**
     * Determines the k- min elements within the binary tree using
     *
     * @param root  the root element of the bst
     * @param cache the first position within the array contains the number of min elements. The
     *              second of the remaining k-elements
     */
    private void kMin(final Node<Integer> root, final int[] cache) {
        if (root != null && root.getValue() != null && cache[1] > 0) {
            kMin(root.getLeft(), cache);
            if (root.getValue() != null && cache[1] > 0) {
                cache[0] += root.getValue();
                cache[1] -= 1;
                kMin(root.getRight(), cache);
            }
        }
    }
}
