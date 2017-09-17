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
 * Created by Scavenger on 6/18/2017.
 */
public class TripletSum {
    boolean tripletSum(int x, int[] a) {
        Arrays.sort(a);
        boolean isExisting = false;
        for (int i = 0; i < a.length - 2 && !isExisting; ++i) {
            int j = i + 1;
            int k = a.length - 1;
            while (j < k && !isExisting) {
                int sum = a[i] + a[j] + a[k];
                if (sum == x) {
                    isExisting = true;
                } else if (sum < x) {
                    ++j;
                } else {
                    --k;
                }
            }
        }
        return isExisting;
    }
}
