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

package com.scavi.brainsqueeze.general;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Michael Heymel
 * @since 18/09/16
 */
public class ListGames {

    /**
     * Given two sorted lists and an integer max, merge the lists up to the maximum of the max
     * elements
     *
     * @param list1 the list 1
     * @param list2 the list 2
     * @param max   the maximum number
     * @return the merged list
     */
    public <T extends Comparable<T>> List<T> merge(List<T> list1, List<T> list2, final int max) {
        if (list1 == null) {
            list1 = new ArrayList<>(0);
        }
        if (list2 == null) {
            list2 = new ArrayList<>(0);
        }

        List<T> resultList = new ArrayList<>(max);
        int list1Pos = 0;
        int list2Pos = 0;
        for (int i = 0; i < max; ++i) {

            T value = null;
            if (list1Pos < list1.size() && list2Pos < list2.size()) {
                if (list1.get(list1Pos).compareTo(list2.get(list2Pos)) < 0) {
                    value = list1.get(list1Pos++);
                } else {
                    value = list2.get(list2Pos++);
                }
            } else if (list1Pos < list1.size()) {
                value = list1.get(list1Pos++);
            } else if (list2Pos < list2.size()) {
                value = list2.get(list2Pos++);
            }
            resultList.add(value);
        }
        return resultList;
    }
}
