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
import org.junit.Test;

import static com.scavi.brainsqueeze.codefight.utilities.CompareHelper.verify;

/**
 * Created by Scavenger on 7/8/2017.
 */
public class RemoveKFromListTest {
    @Test
    public void test1() {
        ListNode<Integer> input = ListNode.from(new int[]{3, 1, 2, 3, 4, 5});
        ListNode<Integer> result = new RemoveKFromList().removeKFromList(input, 3);
        verify(result, new int[]{1, 2, 4, 5});
    }


    @Test
    public void test2() {
        ListNode<Integer> input = ListNode.from(new int[]{3, 1, 2, 3, 4, 5, 3});
        ListNode<Integer> result = new RemoveKFromList().removeKFromList(input, 3);
        verify(result, new int[]{1, 2, 4, 5});
    }

    @Test
    public void test3() {
        ListNode<Integer> input = ListNode.from(new int[]{1, 2, 4, 5});
        ListNode<Integer> result = new RemoveKFromList().removeKFromList(input, 3);
        verify(result, new int[]{1, 2, 4, 5});
    }

    @Test
    public void test4() {
        ListNode<Integer> input = ListNode.from(new int[]{3, 3, 3});
        ListNode<Integer> result = new RemoveKFromList().removeKFromList(input, 3);
        verify(result, new int[]{});
    }
}
