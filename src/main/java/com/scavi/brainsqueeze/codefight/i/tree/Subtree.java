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

public class Subtree {
    public boolean isSubtree(Tree<Integer> t1, Tree<Integer> t2) {
        if (t1 != null && t2 == null) {
            return true;
        } else if ((t1 == null && t2 == null)) {
            return true;
        } else if (t1 == null || t1.value == null) {
            return false;
        } else if (t1.value.equals(t2.value)) {
            return compare(t1, t2);
        }
        return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
    }


    private boolean compare(Tree<Integer> t1, Tree<Integer> t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if ((t1 != null && t2 == null) || (t1 == null && t2 != null)) {
            return false;
        }
        return t1.value.equals(t2.value) && compare(t1.left, t2.left) && compare(t1.right, t2.right);
    }
}
