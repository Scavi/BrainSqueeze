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

/**
 * @author Michael Heymel
 * @since 25/09/16
 */
public class BstGames {


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
}
