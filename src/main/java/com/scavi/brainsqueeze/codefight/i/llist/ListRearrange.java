package com.scavi.brainsqueeze.codefight.i.llist;

import com.scavi.brainsqueeze.codefight.util.ListNode;

public class ListRearrange {
    ListNode<Integer> rearrangeLastN(ListNode<Integer> l, int n) {
        int size = size(l);
        if (n == 0 || n == size || size == 0) {
            return l;
        }
        int p = size - n;
        ListNode<Integer> tmp = l;
        ListNode<Integer> newHead = null;
        for (int i = 1; i < size; ++i) {
            if (i == p) {
                newHead = tmp.next;
            }
            tmp = tmp.next;
        }
        tmp.next = l;
        for (int i = 0; i < size - n; ++i) {
            tmp = tmp.next;
        }
        tmp.next = null;
        return newHead;
    }


    public int size(ListNode<Integer> l) {
        int length = 0;
        ListNode<Integer> tmp = l;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }
}
