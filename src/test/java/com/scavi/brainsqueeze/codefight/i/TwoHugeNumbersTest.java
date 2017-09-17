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
import com.scavi.brainsqueeze.codefight.utilities.CompareHelper;
import org.junit.Test;

/**
 * Created by Scavenger on 7/9/2017.
 */
public class TwoHugeNumbersTest {
    @Test
    public void test1() {
        ListNode<Integer> input1 = ListNode.from(new int[]{9876, 5432, 1999});
        ListNode<Integer> input2 = ListNode.from(new int[]{1, 8001});
        ListNode<Integer> result = new TwoHugeNumbers().addTwoHugeNumbers(input1, input2);
        CompareHelper.verify(result, new int[]{9876, 5434, 0});
    }
}
