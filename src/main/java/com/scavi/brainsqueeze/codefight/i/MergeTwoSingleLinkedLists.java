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

package com.scavi.brainsqueeze.codefight.i;

import com.scavi.brainsqueeze.codefight.util.ListNode;

/**
 * Created by Scavenger on 7/9/2017.
 */
public class MergeTwoSingleLinkedLists {
    ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> result = null;
        ListNode<Integer> currentNode = null;
        while (l1 != null || l2 != null) {
            Integer currentValue;
            if (l1 == null) {
                currentValue = l2.value;
                l2 = l2.next;
            } else if (l2 == null) {
                currentValue = l1.value;
                l1 = l1.next;
            } else if (l1.value > l2.value) {
                currentValue = l2.value;
                l2 = l2.next;
            } else {
                currentValue = l1.value;
                l1 = l1.next;
            }

            if (result == null) {
                result = new ListNode<>(currentValue);
                currentNode = result;
            } else {
                ListNode<Integer> newNode = new ListNode<>(currentValue);
                currentNode.next = newNode;
                currentNode = newNode;
            }
        }
        return result;
    }
}
