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
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Scavenger on 5/28/2017.
 */
public class ListPalindromeTest {
    @Test
    public void test0() {
        ListNode<Integer> input = ListNode.from(new int[]{1, 2, 3, 4, 5});
        Assert.assertFalse(new ListPalindrome().isListPalindrome(input));
    }


    @Test
    public void test1() {
        ListNode<Integer> input = ListNode.from(new int[]{0, 1, 2, 1, 0});
        Assert.assertTrue(new ListPalindrome().isListPalindrome(input));
    }

    @Test
    public void test2() {
        ListNode<Integer> input = ListNode.from(new int[]{0, 1, 1, 0});
        Assert.assertTrue(new ListPalindrome().isListPalindrome(input));
    }


    @Test
    public void test3() {
        ListNode<Integer> l1 = new ListNode<>(0);
        Assert.assertTrue(new ListPalindrome().isListPalindrome(l1));
    }
}
