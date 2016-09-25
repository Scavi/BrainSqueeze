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

import com.scavi.brainsqueeze.util.SingleLinkedNode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 15/09/16
 */
public class SingleLinkedListTest {

    @Test
    public void testReverseSingleLinkedList() {
        SingleLinkedNode<Integer> node3 = new SingleLinkedNode<>(3);
        SingleLinkedNode<Integer> node2 = new SingleLinkedNode<>(2, node3);
        SingleLinkedNode<Integer> node1 = new SingleLinkedNode<>(1, node2);

        SingleLinkedList listGames = new SingleLinkedList();
        SingleLinkedNode<Integer> reversed = listGames.reverseSingleLinkedList(node1);

        Assert.assertEquals(node3, reversed);
        Assert.assertEquals(node2, reversed.getNext());
        Assert.assertEquals(node1, reversed.getNext().getNext());
    }
}
