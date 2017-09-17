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
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Scavenger on 5/14/2017.
 */
public class BinaryTreeStoreRestoreTest {

    @Test
    public void test1() {
        Node<Integer> root = new Node<>(5);
        Node<Integer> l1 = new Node<>(3);
        Node<Integer> ll1 = new Node<>(1);
        Node<Integer> r1 = new Node<>(7);
        Node<Integer> rl1 = new Node<>(6);
        Node<Integer> rr1 = new Node<>(10);

        root.setLeft(l1);
        l1.setLeft(ll1);
        root.setRight(r1);
        r1.setLeft(rl1);
        r1.setRight(rr1);

        BinaryTreeStoreRestore binaryTreeStoreRestore = new BinaryTreeStoreRestore();
        List<Integer> result = binaryTreeStoreRestore.store(root);
        Assert.assertEquals(13, result.size());
        int i = 0;
    }

}
