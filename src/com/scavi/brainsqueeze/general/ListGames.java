package com.scavi.brainsqueeze.general;

import com.scavi.braunsqueeze.util.SingleLinkedNode;

/**
 * Created by Scavenger on 15/09/16.
 */
public class ListGames {


    /**
     * Write a function to reverse the direction of a given singly-linked list without recursion.
     * (after the reversal, all pointers should now point backwards)
     *
     * @param head the head of the single linked list
     * @return the new head of the single linked list
     */
    public <T> SingleLinkedNode<T> reverseSingleLinkedList(final SingleLinkedNode<T> head) {
        if (head == null) {
            return null;
        }
        SingleLinkedNode<T> prev = null;
        SingleLinkedNode<T> current = head;
        SingleLinkedNode<T> next;

        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        return prev;
    }
}
