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

package com.scavi.brainsqueeze.codefight.i.tree;

import com.scavi.brainsqueeze.codefight.util.Tree;

import java.util.Deque;
import java.util.LinkedList;

public class Symmetric {
    public boolean isTreeSymmetric(Tree<Integer> tree) {
        if (tree == null || (tree.left == null && tree.right == null)) {
            return true;
        }
        Deque<Tree<Integer>> queue = new LinkedList<>();
        queue.addFirst(tree.left);
        queue.addLast(tree.right);
        boolean isSymmetric = true;
        while (!queue.isEmpty() && isSymmetric) {

            Tree<Integer> left = queue.pollFirst();
            Tree<Integer> right = queue.pollLast();

            if (left != null && right != null) {
                if (left.value.equals(right.value)) {
                    queue.addFirst(left.right);
                    queue.addFirst(left.left);
                    queue.addLast(right.left);
                    queue.addLast(right.right);
                } else {
                    isSymmetric = false;
                }
            } else if ((left == null && right != null) || left != null) {
                isSymmetric = false;
            }
        }
        return isSymmetric;
    }
}
