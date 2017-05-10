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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Scavenger on 5/10/2017.
 * <p>
 * Question: https://www.careercup.com/question?id=5745183166562304
 * Given an array of n elements which contains elements from 0 to n-1, with any of these numbers appearing any number
 * of times. Find these repeating numbers in O(n) and using only constant memory space.
 * Try to do it in one pass
 * example
 * [4, 2, 0, 5, 2, 0, 1] return: 0, 2
 * [1, 2, 3, 0, 0, 1, 3, 6, 6,6] return 0, 1, 3, 6
 */
public class Repeats {

    /**
     * Finds all repeating numbers in the given input array while setting a value to it's corresponding position in
     * the array to verify if the number already were placed.
     * e.g.:
     * Input: 3,3,1,2
     * [i=0] realCurrent = 3, targetValidation = 0 (2 / 4) => set value nums[3] += 3 * 4 => nums[3] = 14;
     * [i=1] realCurrent = 3, targetValidation = 3 (14 / 4) => value exists, add as repeat
     * ...
     *
     * @param nums the given input array
     * @return the list with all distinct repeats
     */
    public List<Integer> findRepeat(int[] nums) {
        Preconditions.checkNotNull(nums, "Illegal numbers!");

        Set<Integer> repeats = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            int realCurrent = nums[i] % nums.length;
            int targetValidation = nums[realCurrent] / nums.length;
            if (realCurrent == targetValidation) {
                if (!repeats.contains(realCurrent)) {
                    repeats.add(realCurrent);
                }
            } else {
                nums[realCurrent] += realCurrent * nums.length;
            }
        }
        return new ArrayList<>(repeats);
    }
}
