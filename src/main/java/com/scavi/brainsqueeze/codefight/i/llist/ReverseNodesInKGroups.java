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

package com.scavi.brainsqueeze.codefight.i.llist;

import com.scavi.brainsqueeze.codefight.util.ListNode;

/**
 * Created by Scavenger on 7/11/2017.
 */
public class ReverseNodesInKGroups {
    /**
     * Note: Your solution should have O(n) time complexity, where n is the number of element in l, and O(1)
     * additional space complexity, since this is what you would be asked to accomplish in an interview.
     * <p>
     * Given a linked list l, reverse its nodes k at a time and return the modified list. k is a positive integer
     * that is less than or equal to the length of l. If the number of nodes in the linked list is not a multiple of
     * k, then the nodes that are left out at the end should remain as-is.
     * <p>
     * You may not alter the values in the nodes - only the nodes themselves can be changed.
     *
     * @param l the list
     * @param k k elements to reverse
     * @return the reversed list
     */
    ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {
        if (k == 1) {
            return l;
        }
        return reverseNodesInKGroups(l, k, l.size());
    }

    private ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k, int remaining) {
        if (remaining < k) {
            return l;
        }

        ListNode<Integer> current = l;
        ListNode<Integer> prev = null;
        ListNode<Integer> next = null;
        for (int i = 0; i < k; ++i) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        if (next != null) {
            l.next = reverseNodesInKGroups(next, k, remaining - k);
        }
        return prev;
    }
}
