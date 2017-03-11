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

package com.scavi.brainsqueeze.general;

import com.scavi.brainsqueeze.util.Node;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author Michael Heymel
 * @since 11/03/17
 */
public class TreeGamesTest {
    @Test
    public void testVerticalPrint1() {

        Node<Integer> root = new Node<Integer>(1);
        Node<Integer> l = new Node<Integer>(2);
        Node<Integer> ll = new Node<Integer>(4);
        Node<Integer> lr = new Node<Integer>(5);
        Node<Integer> r = new Node<Integer>(3);
        Node<Integer> rl = new Node<Integer>(6);
        Node<Integer> rr = new Node<Integer>(7);
        Node<Integer> rlr = new Node<Integer>(8);
        Node<Integer> rrr = new Node<Integer>(9);

        l.setLeft(ll);
        l.setRight(lr);
        r.setLeft(rl);
        r.setRight(rr);
        rl.setRight(rlr);
        rr.setRight(rrr);
        root.setLeft(l);
        root.setRight(r);

        TreeGames treeGames = new TreeGames();
        List<Integer>[] result = treeGames.verticalTreeLines(root);

        Assert.assertEquals(1, result[0].size());
        Assert.assertEquals(4, result[0].get(0).intValue());
        Assert.assertEquals(1, result[1].size());
        Assert.assertEquals(2, result[1].get(0).intValue());
        Assert.assertEquals(3, result[2].size());
        Assert.assertEquals(1, result[2].get(0).intValue());
        Assert.assertEquals(5, result[2].get(1).intValue());
        Assert.assertEquals(6, result[2].get(2).intValue());
        Assert.assertEquals(2, result[3].size());
        Assert.assertEquals(3, result[3].get(0).intValue());
        Assert.assertEquals(8, result[3].get(1).intValue());
        Assert.assertEquals(1, result[4].size());
        Assert.assertEquals(7, result[4].get(0).intValue());
        Assert.assertEquals(1, result[5].size());
        Assert.assertEquals(9, result[5].get(0).intValue());
    }
}
