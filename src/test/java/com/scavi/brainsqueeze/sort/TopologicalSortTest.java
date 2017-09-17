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
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Scavenger on 5/14/2017.
 */
public class TopologicalSortTest {
    @Test
    public void test1() {
        SimpleGraphNode<String> nodeA = new SimpleGraphNode<>("A");
        SimpleGraphNode<String> nodeB = new SimpleGraphNode<>("B");
        SimpleGraphNode<String> nodeC = new SimpleGraphNode<>("C");
        SimpleGraphNode<String> nodeD = new SimpleGraphNode<>("D");
        SimpleGraphNode<String> nodeE = new SimpleGraphNode<>("E");
        SimpleGraphNode<String> nodeF = new SimpleGraphNode<>("F");

        nodeA.add(nodeB, nodeF);
        nodeB.add(nodeD);
        nodeC.add(nodeA, nodeD);
        nodeD.add(nodeE);
        nodeF.add(nodeB, nodeD, nodeE);

        TopologicalSort topologicalSort = new TopologicalSort();
        List<String> topologicalSorted = topologicalSort.sort(nodeC);
        List<String> expected = new ArrayList<>(Arrays.asList("C", "A", "F", "B", "D", "E"));
        for (int i = 0; i < expected.size(); ++i) {
            Assert.assertEquals(expected.get(i), topologicalSorted.get(i));
        }
    }
}
