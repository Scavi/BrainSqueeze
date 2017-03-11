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

package com.scavi.brainsqueeze.general;

import com.scavi.brainsqueeze.util.Node;
import com.scavi.brainsqueeze.util.DataList;

import java.util.List;

/**
 * @author Michael Heymel
 * @since 11/03/17
 */
public class TreeGames {

    /**
     * This method creates an array of linked lists containing the vertical lines of a a binary
     * search tree. The approach doesn't use a HashMap. It uses a similar memory optimized DLL
     * approach. The algorithm determines the width (in O(log n)) of the tree to create an array of
     * linked lists
     * <p/>
     * http://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
     *
     * @param root the root of the BST
     * @return
     */
    public <T extends Comparable<T>> List<T>[] verticalTreeLines(final Node<T> root) {
        if (root == null) {
            return null;
        }
        Structure treeStructure = treeStructure(root);
        DataList[] verticalLines = new DataList[treeStructure._width];
        verticalTreeLines(root, 0, verticalLines, treeStructure);
        return verticalLines;
    }


    /**
     * Determines the vertical lines of the tree by using preorder-traversal
     *
     * @param currentRoot   the current root
     * @param horizontalPos the horizontal position (distance to root)
     * @param verticalLines the cache for the created vertical lines
     * @param treeStructure general information about the tree
     */
    private <T extends Comparable<T>> void verticalTreeLines(final Node<T> currentRoot,
            int horizontalPos, final DataList<T>[] verticalLines, final Structure treeStructure) {
        if (currentRoot == null) {
            return;
        }
        int target = horizontalPos + treeStructure._maxLeft;
        if (verticalLines[target] == null) {
            verticalLines[target] = new DataList<>();
        }
        verticalLines[target].add(currentRoot.getValue());
        verticalTreeLines(currentRoot.getLeft(), horizontalPos - 1, verticalLines, treeStructure);
        verticalTreeLines(currentRoot.getRight(), horizontalPos + 1, verticalLines, treeStructure);
    }


    /**
     * This method is used to determine the width, the max left and max right position of the tree
     *
     * @param root the root of the tree
     * @return the general tree structure
     */
    private <T extends Comparable<T>> Structure treeStructure(final Node<T> root) {
        Structure structure = null;

        if (root != null) {
            structure = new Structure();
            structure._width = 1; // root;
            Node<T> current = root;
            while (current.getLeft() != null) {
                structure._width++;
                current = current.getLeft();
            }
            structure._maxLeft = structure._width - 1;
            current = root;
            while (current.getRight() != null) {
                structure._width++;
                current = current.getRight();
            }
            structure._maxRight = structure._width - structure._maxLeft - 1;
        }
        return structure;
    }


    private final class Structure {
        private int _width;
        private int _maxLeft;
        private int _maxRight;
    }
}
