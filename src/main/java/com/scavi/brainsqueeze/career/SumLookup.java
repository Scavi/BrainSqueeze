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

package com.scavi.brainsqueeze.career;

import com.google.common.base.Preconditions;

/**
 * Created by Scavenger on 5/9/2017.
 */
public class SumLookup {
    public boolean isSum(int[] input, int sum) {
        Preconditions.checkNotNull(input, "Illegal input");
        if (input.length == 1) {
            return sum == input[0];
        }

        boolean isSumExisting = false;
        int left = 0;
        int right = 1;
        int tmpSum = input[left];
        while (right < input.length && !isSumExisting) {

            if (tmpSum < sum || left == right -1) {
                tmpSum += input[right];
                right++;
            } else if (tmpSum > sum) {
                if (input[right] < 0) {
                    tmpSum += input[right];
                    right++;
                } else {
                    tmpSum -= input[left];
                    left++;
                }
            } else {
                isSumExisting = true;
            }
        }
        return isSumExisting;
    }
}
