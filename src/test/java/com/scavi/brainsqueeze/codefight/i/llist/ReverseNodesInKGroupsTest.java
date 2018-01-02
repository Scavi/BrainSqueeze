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
import com.scavi.brainsqueeze.codefight.utilities.CompareHelper;
import org.junit.Test;

/**
 * Created by Scavenger on 7/11/2017.
 */
public class ReverseNodesInKGroupsTest {


    @Test
    public void test1() {
        ListNode<Integer> input = ListNode.from(new int[]{1, 2, 3, 4});
        ListNode<Integer> output = new ReverseNodesInKGroups().reverseNodesInKGroups(input, 2);
        CompareHelper.verify(output, new int[]{2, 1, 4, 3});
    }


    @Test
    public void test2() {
        ListNode<Integer> input = ListNode.from(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        ListNode<Integer> output = new ReverseNodesInKGroups().reverseNodesInKGroups(input, 3);
        CompareHelper.verify(output, new int[]{3, 2, 1, 6, 5, 4, 7, 8});
    }

}
