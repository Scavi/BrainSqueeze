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

//    /**
//     * Does a topological sort of the given graph root nodes.
//     * The idea behind this topological sort approach is to use the count of anchestors and remove the nodes with
//     * the fewest anchestors first.
//     * This method expects the roots
//     *
//     * @param roots the root of the graph
//     * @return the topological sort of the graph
//     */
//    public <T> List<T> sort(final SimpleGraphNode<T>... roots) {
//        Preconditions.checkNotNull(roots, "Illegal graph: <null>");
//        Preconditions.checkArgument(roots.length != 0, "Illegal graph roots: 0");
//
//        PriorityQueue<SimpleGraphNode<T>> queue = new PriorityQueue<>(new PriorityComparator<T>());
//        HashSet known = new HashSet<>();
//        for (SimpleGraphNode<T> root : roots) {
//            convert(known, queue, root);
//        }
//
//        List<T> topSortOrder = new LinkedList<>();
//        boolean isSolvable = true;
//        while (isSolvable && queue.size() > 0) {
//            SimpleGraphNode<T> currentEntry = queue.poll();
//            if (currentEntry.getAncestors().size() > 0) {
//                isSolvable = false;
//            } else {
//                for (SimpleGraphNode<T> child : currentEntry.getChildren()) {
//                    Preconditions.checkArgument(child.removeAncestor(currentEntry),
//                            String.format("Illegal attempt to remove ancestor. Ancestor %s doesn't exists",
//                                    currentEntry.toString()));
//                    // remove and add the changed child again to the priority list due to the change of the ancestors.
//                    // Otherwise the priority queue won't get updated
//                    queue.remove(child);
//                    queue.add(child);
//                }
//                topSortOrder.add(currentEntry.getContent());
//            }
//        }
//        Preconditions.checkArgument(isSolvable, "A determination of the topological sort order is possible !");
//        return topSortOrder;
//    }
//
//    private <T> void convert(Set<SimpleGraphNode<T>> inserted, PriorityQueue<SimpleGraphNode<T>> queue,
//                             SimpleGraphNode<T> root) {
//        if (!inserted.contains(root)) {
//            queue.add(root);
//            inserted.add(root);
//        }
//        for (SimpleGraphNode<T> current : root.getChildren()) {
//            convert(inserted, queue, current);
//        }
//    }
//
//
//    private class PriorityComparator<T> implements Comparator<SimpleGraphNode<T>> {
//        @Override
//        public int compare(SimpleGraphNode<T> node1, SimpleGraphNode<T> node2) {
//            if (node1 == null) {
//                return 1;
//            } else if (node2 == null) {
//                return -1;
//            } else if (node1.getAncestors().size() ==
//                    node2.getAncestors().size()) {
//                return 0;
//            }
//            return node1.getAncestors().size() > node2.getAncestors().size() ?
//                    1 : -1;
//        }
//    }
}
