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

import com.google.common.base.Preconditions;
import com.scavi.brainsqueeze.util.SimpleGraphNode;

import java.util.*;

/**
 * Created by Scavenger on 5/14/2017.
 */
public class TopologicalSort {
    /**
     * Does a topological sort of the given graph. The simple graph node only supports graphs where every node is
     * attached to another node at least once (e.g. A->B->C D->E is not supported because D and E)
     *
     * @param root the root of the graph
     * @return the topological sort of the graph
     */
    public <T> List<T> sort(SimpleGraphNode<T> root) {
        Preconditions.checkNotNull(root, "Illegal graph: <null >");

        PriorityQueue<SimpleGraphNode<T>> queue = new PriorityQueue<>(new PriorityComparator<T>());
        convert(new HashSet<>(), queue, root);

        List<T> topSortOrder = new LinkedList<>();
        boolean isSolvable = true;
        while (isSolvable && queue.size() > 0) {
            SimpleGraphNode<T> currentEntry = queue.poll();
            if (currentEntry.getAncestors().size() > 0) {
                isSolvable = false;
            } else {
                for (SimpleGraphNode<T> child : currentEntry.getChildren()) {
                    Preconditions.checkArgument(child.removeAncestor(currentEntry),
                            String.format("Illegal attempt to remove ancestor. Ancestor %s doesn't exists",
                                    currentEntry.toString()));
                    // remove and add the changed child again to the priority list due to the change of the ancestors.
                    // Otherwise the priority queue won't get updated
                    queue.remove(child);
                    queue.add(child);
                }
                topSortOrder.add(currentEntry.getContent());
            }
        }
        Preconditions.checkArgument(isSolvable, "A determiniation of the topological sort order is possible !");
        return topSortOrder;
    }

    private <T> void convert(Set<SimpleGraphNode<T>> inserted, PriorityQueue<SimpleGraphNode<T>> queue,
                             SimpleGraphNode<T> root) {
        if (!inserted.contains(root)) {
            queue.add(root);
            inserted.add(root);
        }
        for (SimpleGraphNode<T> current : root.getChildren()) {
            convert(inserted, queue, current);
        }
    }


    private class PriorityComparator<T> implements Comparator<SimpleGraphNode<T>> {
        @Override
        public int compare(SimpleGraphNode<T> node1, SimpleGraphNode<T> node2) {
            if (node1 == null) {
                return 1;
            } else if (node2 == null) {
                return -1;
            } else if (node1.getAncestors().size() ==
                    node2.getAncestors().size()) {
                return 0;
            }
            return node1.getAncestors().size() > node2.getAncestors().size() ?
                    1 : -1;
        }
    }
}
