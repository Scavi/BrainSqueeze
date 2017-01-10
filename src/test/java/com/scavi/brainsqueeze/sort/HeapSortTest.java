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

package com.scavi.brainsqueeze.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 10/01/17
 */
public class HeapSortTest {

    @Test
    public void test1() {
        Integer[] input = new Integer[]{1, 6, 3, 2, 5, 4, 9, 7, 8, 5};
        Integer[] expectedOutput = new Integer[]{1, 2, 3, 4, 5, 5, 6, 7, 8, 9};
        HeapSort<Integer> mergeSort = new HeapSort<>();
        Integer[] output = mergeSort.sort(input);
        Assert.assertArrayEquals(expectedOutput, output);
    }
}
