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
 * @since 04/11/16
 */
public class BfsTest {

    @Test
    public void testBfs1() {
        Node<Integer> nodeRR = new Node<>(80);
        Node<Integer> nodeRL = new Node<>(60);
        Node<Integer> nodeR = new Node<>(70, nodeRL, nodeRR);
        Node<Integer> nodeLR = new Node<>(40);
        Node<Integer> nodeLL = new Node<>(20);
        Node<Integer> nodeL = new Node<>(30, nodeLL, nodeLR);
        Node<Integer> root = new Node<>(50, nodeL, nodeR);

        BFS bfs = new BFS();
        Node<Integer> result = bfs.search(root, 20);
        Assert.assertTrue(result == nodeLL);
    }


    @Test
    public void testBfs2() {
        Node<Integer> nodeRR = new Node<>(80);
        Node<Integer> nodeRL = new Node<>(60);
        Node<Integer> nodeR = new Node<>(70, nodeRL, nodeRR);
        Node<Integer> nodeLR = new Node<>(40);
        Node<Integer> nodeLL = new Node<>(20);
        Node<Integer> nodeL = new Node<>(30, nodeLL, nodeLR);
        Node<Integer> root = new Node<>(50, nodeL, nodeR);

        BFS bfs = new BFS();
        Node<Integer> result = bfs.search(root, 42);
        Assert.assertNull(result);
    }


    @Test
    public void testBfs3() {
        BFS bfs = new BFS();
        Node<Integer> result = bfs.search(null, 42);
        Assert.assertNull(result);
    }


    @Test
    public void testBfs4() {
        Node<Integer> root = new Node<>(42);
        BFS bfs = new BFS();
        Node<Integer> result = bfs.search(root, null);
        Assert.assertNull(result);
    }
}