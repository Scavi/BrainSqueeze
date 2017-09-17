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
 * Created by Scavenger on 5/28/2017.
 */
public class ListPalindrome {

    boolean isListPalindrome(ListNode<Integer> leftSide) {

        if (leftSide == null || leftSide.next == null) {
            return true;
        }

        // O(n) - determine the size of the list
        int listSize = sizeOfList(leftSide);
        int midPos = listSize / 2;
        ListNode<Integer> rightSide = reverseFrom(leftSide, midPos);

        for (int i = 0; i < midPos; ++i) {
            if (!leftSide.value.equals(rightSide.value)) {
                return false;
            }
            leftSide = leftSide.next;
            rightSide = rightSide.next;
        }
        return true;
    }


    private ListNode<Integer> reverseFrom(ListNode<Integer> list, int fromPos) {
        ListNode<Integer> next;
        ListNode<Integer> prev = null;

        while (fromPos >= 0) {
            list = list.next;
            fromPos--;
            if (fromPos == 0) {
                prev = list;
            }
        }

        ListNode<Integer> current = list;

        // 1 -> 2 -> 3 -> 4 -> 5 ==> 1 -> 2 -> 3 <-4 <-5
        // c=4 | p=3 | next=5
        // 1 -> 2 -> 3
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }


    private int sizeOfList(ListNode<Integer> listNode) {
        int size = 1;

        while (listNode.next != null) {
            size++;
            listNode = listNode.next;
        }
        return size;
    }
}


