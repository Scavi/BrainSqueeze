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

import java.util.List;

/**
 * @author Michael Heymel
 * @since 25/09/16
 */
public class BstGamesTest {

    @Test
    public void testAllGreaterValues1() {
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


    @Test
    public void testLca1() {
        Node<Integer> nodeRR = new Node<>(80);
        Node<Integer> nodeRL = new Node<>(60);
        Node<Integer> nodeR = new Node<>(70, nodeRL, nodeRR);
        Node<Integer> nodeLR = new Node<>(40);
        Node<Integer> nodeLL = new Node<>(20);
        Node<Integer> nodeL = new Node<>(30, nodeLL, nodeLR);
        Node<Integer> root = new Node<>(50, nodeL, nodeR);

        BstGames bstGames = new BstGames();
        Node<Integer> result = bstGames.findLCA(root, 20, 40);
        Assert.assertEquals(30, result.getValue().intValue());
    }


    @Test
    public void testLca2() {
        Node<Integer> nodeRR = new Node<>(80);
        Node<Integer> nodeRL = new Node<>(60);
        Node<Integer> nodeR = new Node<>(70, nodeRL, nodeRR);
        Node<Integer> nodeLR = new Node<>(40);
        Node<Integer> nodeLL = new Node<>(20);
        Node<Integer> nodeL = new Node<>(30, nodeLL, nodeLR);
        Node<Integer> root = new Node<>(50, nodeL, nodeR);

        BstGames bstGames = new BstGames();
        Node<Integer> result = bstGames.findLCA(root, 40, 20);
        Assert.assertEquals(30, result.getValue().intValue());
    }


    @Test
    public void testLca3() {
        Node<Integer> nodeRR = new Node<>(80);
        Node<Integer> nodeRL = new Node<>(60);
        Node<Integer> nodeR = new Node<>(70, nodeRL, nodeRR);
        Node<Integer> nodeLR = new Node<>(40);
        Node<Integer> nodeLL = new Node<>(20);
        Node<Integer> nodeL = new Node<>(30, nodeLL, nodeLR);
        Node<Integer> root = new Node<>(50, nodeL, nodeR);

        BstGames bstGames = new BstGames();
        Node<Integer> result = bstGames.findLCA(root, 20, 70);
        Assert.assertEquals(50, result.getValue().intValue());
    }


    @Test
    public void testLca4() {
        Node<Integer> nodeRR = new Node<>(80);
        Node<Integer> nodeRL = new Node<>(60);
        Node<Integer> nodeR = new Node<>(70, nodeRL, nodeRR);
        Node<Integer> nodeLR = new Node<>(40);
        Node<Integer> nodeLL = new Node<>(20);
        Node<Integer> nodeL = new Node<>(30, nodeLL, nodeLR);
        Node<Integer> root = new Node<>(50, nodeL, nodeR);

        BstGames bstGames = new BstGames();
        Node<Integer> result = bstGames.findLCA(root, 20, 30);
        Assert.assertEquals(30, result.getValue().intValue());
    }


    @Test
    public void testBstToList1() {
        // input
        Node<Integer> nodeRR = new Node<>(80);
        Node<Integer> nodeRL = new Node<>(60);
        Node<Integer> nodeR = new Node<>(70, nodeRL, nodeRR);
        Node<Integer> nodeLR = new Node<>(40);
        Node<Integer> nodeLL = new Node<>(20);
        Node<Integer> nodeL = new Node<>(30, nodeLL, nodeLR);
        Node<Integer> root = new Node<>(50, nodeL, nodeR);

        Integer[] expected = new Integer[]{20, 30, 40, 50, 60, 70, 80};

        BstGames bstGames = new BstGames();
        List<Integer> result = bstGames.toList(root);
        Assert.assertArrayEquals(expected, result.toArray(new Integer[result.size()]));
    }


    @Test
    public void testKMin1() {
        Node<Integer> nodeRR = new Node<>(80);
        Node<Integer> nodeRL = new Node<>(60);
        Node<Integer> nodeR = new Node<>(70, nodeRL, nodeRR);
        Node<Integer> nodeLR = new Node<>(40);
        Node<Integer> nodeLL = new Node<>(20);
        Node<Integer> nodeL = new Node<>(30, nodeLL, nodeLR);
        Node<Integer> root = new Node<>(50, nodeL, nodeR);

        BstGames bstGames = new BstGames();
        int kMin = bstGames.kMin(root, 3);
        Assert.assertEquals(90, kMin);
    }


    @Test
    public void testMaxLeafs1() {
        Node<Integer> nodeRR = new Node<>(80);
        Node<Integer> nodeRL = new Node<>(60);
        Node<Integer> nodeR = new Node<>(70, nodeRL, nodeRR);
        Node<Integer> nodeLR = new Node<>(40);
        Node<Integer> nodeLL = new Node<>(20);
        Node<Integer> nodeL = new Node<>(30, nodeLL, nodeLR);
        Node<Integer> root = new Node<>(50, nodeL, nodeR);

        BstGames bstGames = new BstGames();
        int maxResult = bstGames.maxSumBetweenLeafs(root);
        Assert.assertEquals(270, maxResult);
    }


    @Test
    public void testMaxLeafs2() {
        Node<Integer> nodeRR = new Node<>(-30);
        Node<Integer> nodeRL = new Node<>(-19);
        Node<Integer> nodeR = new Node<>(-20, nodeRL, nodeRR);
        Node<Integer> nodeLR = new Node<>(40);
        Node<Integer> nodeLL = new Node<>(20);
        Node<Integer> nodeL = new Node<>(30, nodeLL, nodeLR);
        Node<Integer> root = new Node<>(-10, nodeL, nodeR);

        BstGames bstGames = new BstGames();
        int maxResult = bstGames.maxSumBetweenLeafs(root);
        Assert.assertEquals(90, maxResult);
    }

    @Test
    public void testDistance1() {
        Node<Integer> nodeLLLL = new Node<>(3);
        Node<Integer> nodeLLL = new Node<>(4);
        Node<Integer> nodeLL = new Node<>(12);
        Node<Integer> nodeL = new Node<>(5);
        Node<Integer> nodeLR = new Node<>(17);
        Node<Integer> root = new Node<>(10);
        Node<Integer> nodeR = new Node<>(7);
        Node<Integer> nodeRL = new Node<>(1);
        Node<Integer> nodeRR = new Node<>(2);

        nodeL.setLeft(nodeLL);
        nodeL.setRight(nodeLR);
        nodeLL.setLeft(nodeLLL);
        nodeLLL.setLeft(nodeLLLL);

        nodeR.setLeft(nodeRL);
        nodeR.setRight(nodeRR);

        root.setLeft(nodeL);
        root.setRight(nodeR);

        BstGames bstGames = new BstGames();
        int distance = bstGames.distance(root, nodeLLLL, nodeLR);
        Assert.assertEquals(4, distance);
    }
}
