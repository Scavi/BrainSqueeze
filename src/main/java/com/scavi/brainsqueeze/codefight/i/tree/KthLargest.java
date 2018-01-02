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

public class KthLargest {

    int kthLargestInBST(Tree<Integer> tree, int pos) {
        Meta meta = new Meta(pos);
        kthLargestInBST(tree, meta);
        return meta.getResult();
    }

    private void kthLargestInBST(Tree<Integer> tree, Meta meta) {
        if (tree == null) {
            return;
        }
        kthLargestInBST(tree.left, meta);
        if (meta.isReady()) {
            meta.setResult(tree.value);
        } else {
            kthLargestInBST(tree.right, meta);
        }
    }

    private class Meta {
        private final int _pos;
        private int _it;
        private int _result;

        Meta(int pos) {
            _pos = pos;
        }

        boolean isReady() {
            return ++_it == _pos;
        }

        void setResult(int result) {
            _result = result;
        }

        int getResult() {
            return _result;
        }
    }
}
