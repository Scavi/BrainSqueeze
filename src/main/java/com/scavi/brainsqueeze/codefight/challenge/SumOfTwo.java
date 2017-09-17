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

package com.scavi.brainsqueeze.codefight.challenge;

import java.util.Arrays;

/**
 * Created by Scavenger on 5/28/2017.
 * <p>
 * You have two integer arrays, a and b, and an integer target value v. Determine whether there is a pair of numbers,
 * where one number is taken from a and the other from b, that can be added together to get a sum of v. Return true if
 * such a pair exists, otherwise return false.
 * <p>
 * Example
 * <p>
 * For a = [1, 2, 3], b = [10, 20, 30, 40], and v = 42, the output should be
 * sumOfTwo(a, b, v) = true
 */
public class SumOfTwo {

    boolean sumOfTwo(int[] input1, int[] input2, int lookupSum) {
        if (input1 == null || input2 == null || input1.length == 0 || input2.length == 0) {
            return false;
        }
        Arrays.sort(input2);
        for (int current : input1) {
            int rest = lookupSum - current;
            if (Arrays.binarySearch(input2, rest) >= 0) {
                return true;
            }
        }
        return false;
    }
}
