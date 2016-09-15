package com.scavi.brainsqueeze.general;

import com.scavi.braunsqueeze.util.SingleLinkedNode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Scavenger on 15/09/16.
 */
public class ListGamesTest {

    @Test
    public void testReverseSingleLinkedList() {
        SingleLinkedNode<Integer> node3 = new SingleLinkedNode<>(3);
        SingleLinkedNode<Integer> node2 = new SingleLinkedNode<>(2, node3);
        SingleLinkedNode<Integer> node1 = new SingleLinkedNode<>(1, node2);

        ListGames listGames = new ListGames();
        SingleLinkedNode<Integer> reversed = listGames.reverseSingleLinkedList(node1);

        Assert.assertEquals(node3, reversed);
        Assert.assertEquals(node2, reversed.getNext());
        Assert.assertEquals(node1, reversed.getNext().getNext());
    }
}
