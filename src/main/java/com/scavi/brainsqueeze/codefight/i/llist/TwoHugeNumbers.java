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

package com.scavi.brainsqueeze.codefight.i.llist;

import com.scavi.brainsqueeze.codefight.util.ListNode;

import java.math.BigDecimal;

/**
 * Created by Scavenger on 7/9/2017.
 */
public class TwoHugeNumbers {
    ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
        BigDecimal valueA = from(a);
        BigDecimal valueB = from(b);
        BigDecimal result = valueA.add(valueB);
        return to(result);
    }

    private ListNode<Integer> to(BigDecimal number) {
        String numberTmp = String.valueOf(number);

        int lookupLength = numberTmp.length() % 4;
        lookupLength = lookupLength == 0 ? 4 : lookupLength;
        String tmp = numberTmp.substring(0, lookupLength);
        numberTmp = numberTmp.substring(lookupLength, numberTmp.length());
        ListNode<Integer> root = new ListNode<>(Integer.parseInt(tmp));
        ListNode<Integer> current = root;
        while (!numberTmp.isEmpty()) {
            tmp = numberTmp.substring(0, 4);
            numberTmp = numberTmp.substring(4, numberTmp.length());
            ListNode<Integer> newNode = new ListNode<>(Integer.parseInt(tmp));
            current.next = newNode;
            current = newNode;
        }
        return root;
    }

    private BigDecimal from(ListNode<Integer> number) {
        StringBuilder converted = new StringBuilder();
        int i = 0;
        ListNode<Integer> current = number;
        while (current != null) {
            if (i == 0) {
                converted.append(current.value);
            } else {
                converted.append(String.format("%04d", current.value));
            }
            i++;
            current = current.next;
        }
        return new BigDecimal(converted.toString());
    }
}
