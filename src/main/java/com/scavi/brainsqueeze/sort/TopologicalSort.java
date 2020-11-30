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

package com.scavi.brainsqueeze.sort;

import com.scavi.brainsqueeze.util.SimpleGraphNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Created by Scavenger on 5/14/2017.
 */
public class TopologicalSort {
    public <T> List<SimpleGraphNode<T>> sort(final List<SimpleGraphNode<T>> nodes) {
        List<SimpleGraphNode<T>> result = new Stack<>();
        Set<SimpleGraphNode<T>> known = new HashSet<>();

        for (SimpleGraphNode<T> node : nodes) {
            if (!known.contains(node)) {
                topologicalSort(result, known, node);
            }
        }
        return result;
    }


    private <T> void topologicalSort(List<SimpleGraphNode<T>> result, Set<SimpleGraphNode<T>> known,
                                     SimpleGraphNode<T> node) {
        known.add(node);
        if (node.getChildren().size() == 0) {
            result.add(0, node);
        } else {
            for (SimpleGraphNode<T> current : node.getChildren()) {
                if (!known.contains(current)) {
                    topologicalSort(result, known, current);
                }
            }
            result.add(0, node);
        }
    }


}
