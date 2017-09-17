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

public class SumPath {

    public boolean hasPathWithGivenSum(Tree<Integer> tree, int target) {
        if (target == 0 && tree == null) {
            return true;
        }
        return hasPathWithGivenSum(tree, target, 0);
    }


    private boolean hasPathWithGivenSum(Tree<Integer> tree, int target, int current) {
        if (tree == null) {
            return false;
        }
        current += tree.value;
        if (tree.left == null && tree.right == null) {
            return target == current;
        }
        boolean isSum = hasPathWithGivenSum(tree.left, target, current);
        if (!isSum) {
            isSum = hasPathWithGivenSum(tree.right, target, current);
        }
        return isSum;
    }
}
