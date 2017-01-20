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

/**
 * @author Michael Heymel
 * @since 14/01/17
 */
public class InsertionSort<T extends Comparable<T>> {
    /**
     * Implements the Insertion Sort algorithm (without collections). This method
     * will sort the given values ascending. It is assumed that every entry in the
     * given array is not <code>null</code>
     * The Insertion Sort goes from right to left. A current value is compared
     * with his left neighbor and switched until no value is smaller than the current
     * one. The sort algorithm starts with the second element.
     * In the following an example of an insertion sort will be shown:
     * => the initial input
     * 0.) __5___2___4___6___1___3__
     * => the second element (2) will be compared with the first element (his
     * left neighbor 5) and switched
     * 1.) __2___5___4___6___1___3__
     * => the third element (4) will be compared with the second element (5) and
     * switched
     * 2.) __2___4___5___6___1___3__
     * => the fourth element (6) will be compared with the third element (5).
     * Because 6 > 5 no switching was done
     * 3.) __2___4___5___6___1___3__
     * => the fifth element (1) will be compared with the fourth element (6) and
     * switched, then 1 was compared with 5 and switched... until no left
     * neighbor is smaller than 1
     * 4.) __1___2___4___5___6___3__
     * => the sixth element (3) will be compared with the left neighbor (5) ...
     * then four. Because 2 is smaller than 3 and no entries were are the sort
     * algorithm stopped.
     * 5.) __1___2___3___4___5___6__
     * <p>
     * <br>
     * The insertion sort is a stable sorting algorithm.
     * This sort method works fast for few elements to sort.
     * The best running time is (Theata): O(n)
     * The average running time is (Theata): O(n²)
     * The worst running time is (Theata): O(n²)
     * <br>
     */
    public T[] sort(final T[] elementsToSort) {
        // only if enough entries to sort exists
        if (elementsToSort != null && elementsToSort.length > 0) {
            for (int i = 1; i < elementsToSort.length; ++i) {
                // the current element that will be put to left until it is
                // the lowest entry
                final T key = elementsToSort[i];

                // the position of the left neighbor of the key element
                int j = i - 1;

                // shift the element to the left side until the lowest
                // element is found or no
                // further neighbor to the left side exists
                while (j >= 0 && elementsToSort[j].compareTo(key) > 0) {
                    // take the left neighbor and set it as current one
                    elementsToSort[j + 1] = elementsToSort[j];
                    j--; // go a left step
                }
                // set the key to the found position
                elementsToSort[j + 1] = key;
            }
        }
        return elementsToSort;
    }
}