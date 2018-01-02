package com.scavi.brainsqueeze.codefight.i.llist;

import com.scavi.brainsqueeze.codefight.util.ListNode;
import org.junit.Test;

import static com.scavi.brainsqueeze.codefight.utilities.CompareHelper.verify;

public class ListRearrangeTest {
    @Test
    public void test1() {
        ListNode<Integer> input = ListNode.from(new int[]{1, 2, 3, 4, 5});
        ListNode<Integer> result = new ListRearrange().rearrangeLastN(input, 3);
        verify(result, new int[]{3, 4, 5, 1, 2});
    }


    @Test
    public void test2() {
        ListNode<Integer> input = ListNode.from(new int[]{1, 2, 3, 4});
        ListNode<Integer> result = new ListRearrange().rearrangeLastN(input, 4);
        verify(result, new int[]{1, 2, 3, 4});
    }


    @Test
    public void test3() {
        ListNode<Integer> input = ListNode.from(new int[]{1, 2, 3, 4, 5, 6, 7});
        ListNode<Integer> result = new ListRearrange().rearrangeLastN(input, 1);
        verify(result, new int[]{7, 1, 2, 3, 4, 5, 6});
    }
}
