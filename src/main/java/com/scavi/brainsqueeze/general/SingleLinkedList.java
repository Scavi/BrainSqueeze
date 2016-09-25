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

/**
 * @author Michael Heymel
 * @since 15/09/16
 */
public class SingleLinkedList {


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
