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
 * Created by Scavenger on 7/11/2017.
 */
public class ReverseNodesInKGroups {


    ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {
        if (l == null || l.next == null) {
            return l;
        }
        ListNode<Integer> root = null;
        ListNode<Integer> current = l;

        while (current.next != null) {
            ListNode<Integer> tmp = reverse(current, k - 1);
            if (root == null) {
                root = tmp;
            }
        }
        return root;
    }


    private ListNode<Integer> reverse(ListNode<Integer> node, int it) {
        if (node.next == null || it == 0) {
            return node;
        }
        ListNode<Integer> tmp = reverse(node.next, --it);
        if (it > 0) {
            ListNode<Integer> tmpNext = tmp.next;
            tmpNext.next = node;
        } else {
            tmp.next = node;
        }
        return tmp;
    }

//    ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {
//        if (l == null || l.next == null) {
//            return l;
//        }
//        ListNode<Integer> root = null;
//        ListNode<Integer> prev = l;
//        ListNode<Integer> current = l.next;
//        ListNode<Integer> next;
//        ListNode<Integer> bridge = null;
//        if (current.next != null) {
//            int it = k - 1;
//            while (current.next != null) {
//                next = current.next;
//                if (it > 0) {
//                    current.next = prev;
//                    prev = current;
//                    current = next;
//                    --it;
//                } else {
//                    if (bridge != null) {
//                        bridge.next = current;
//                    } else {
//                        root = prev;
//                    }
//                    bridge = prev;
//                    current.next = next;
//                    it = k - 1;
//                }
//            }
//        } else {
//            current.next = prev;
//            return current;
//        }
//        return root;
//    }
}
