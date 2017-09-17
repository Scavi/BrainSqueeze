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

package com.scavi.brainsqueeze.codefight.utilities;

import com.scavi.brainsqueeze.codefight.util.ListNode;
import org.junit.Assert;

/**
 * Created by Scavenger on 7/9/2017.
 */
public class CompareHelper {
    public static void verify(ListNode<Integer> result, int[] expected) {
        for (int currentExpected : expected) {
            Assert.assertEquals(Integer.valueOf(currentExpected), result.value);
            result = result.next;
        }
        Assert.assertNull(result);
    }
}
