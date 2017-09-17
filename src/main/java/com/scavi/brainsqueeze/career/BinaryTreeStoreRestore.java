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

package com.scavi.brainsqueeze.career;

import com.scavi.brainsqueeze.util.Node;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Scavenger on 5/14/2017.
 */
public class BinaryTreeStoreRestore {
    public List<Integer> store(Node<Integer> root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new LinkedList<>();
        store(root, result);
        return result;
    }

    private void store(Node<Integer> root, List<Integer> result) {
        if (root != null) {
            result.add(root.getValue());
            store(root.getLeft(), result);
            store(root.getRight(), result);
        } else {
            result.add(null);
        }
    }

}
