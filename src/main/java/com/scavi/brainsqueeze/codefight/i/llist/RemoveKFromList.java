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
 * Created by Scavenger on 7/8/2017.
 */
public class RemoveKFromList {
    /**
     * Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in
     * the list, since this is what you'll be asked to do during an interview.
     * <p>
     * Given a singly linked list of integers l and an integer k, remove all elements from list l that have a value
     * equal to k.
     *
     * @param l the list
     * @param k the value to remove
     * @return the new list
     */
    ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        while (l != null && l.value == k) {
            l = l.next;
        }

        if (l != null) {
            ListNode<Integer> current = l;
            while (current != null) {
                ListNode<Integer> tmp = current.next;
                while (tmp != null && tmp.value == k) {
                    tmp = tmp.next;
                }
                current.next = tmp;
                current = current.next;
            }
        }
        return l;
    }
}
