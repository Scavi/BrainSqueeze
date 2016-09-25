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

package com.scavi.brainsqueeze.tree;

import com.scavi.brainsqueeze.util.Node;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 25/09/16
 */
public class BstGamesTest {

    @Test
    public void test1() {
        // input
        Node<Integer> nodeRR = new Node<>(80);
        Node<Integer> nodeRL = new Node<>(60);
        Node<Integer> nodeR = new Node<>(70, nodeRL, nodeRR);
        Node<Integer> nodeLR = new Node<>(40);
        Node<Integer> nodeLL = new Node<>(20);
        Node<Integer> nodeL = new Node<>(30, nodeLL, nodeLR);
        Node<Integer> root = new Node<>(50, nodeL, nodeR);

        // expected
        Node<Integer> expectedNodeRR = new Node<>(80);
        Node<Integer> expectedNodeRL = new Node<>(210);
        Node<Integer> expectedNodeR = new Node<>(150, expectedNodeRL, expectedNodeRR);
        Node<Integer> expectedNodeLR = new Node<>(300);
        Node<Integer> expectedNodeLL = new Node<>(350);
        Node<Integer> expectedNodeL = new Node<>(330, expectedNodeLL, expectedNodeLR);
        Node<Integer> expectedRoot = new Node<>(260, expectedNodeL, expectedNodeR);

        BstGames bstGames = new BstGames();
        Node<Integer> result = bstGames.allGreaterValues(root);

        Assert.assertTrue(expectedRoot.equals(result));
    }
}
