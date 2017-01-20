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
public class QuickSort<T extends Comparable<T>> {
    /**
     * The quick sort algorithm, like merge sort, applies to the
     * divide-and-conquer-paradigm. <br>
     * Despite his slow worst-case running time, quick sort is often the best
     * practical choice for sorting because it is remarkably efficient on the
     * average. It also has the advantage of sorting in place and it works well
     * even in virtual-memory environments.<br>
     * <br>
     * The running time of quicksort depends on whether the partitioning is
     * balanced or unbalanced, which in turn depends on which elements are used
     * for partitioning. If the partitioning is balanced, the algorithm runs
     * asymptotically as fast as merge sort.<br>
     * The quicksort is a not stable sorting algorithm and sorts in place.<br>
     * <br>
     * The best running time is (Theata): O(n log(n))) <br>
     * The average running time is (Theata): O(n log(n)) <br>
     * The worst running time is (Theata): O(n²) <br>
     * <br>
     */
    public T[] sort(T[] elementsToSort) {
        if (elementsToSort != null && elementsToSort.length > 1) {
            elementsToSort = sort(elementsToSort, 0, elementsToSort.length - 1);
        }
        return elementsToSort;
    }


    /**
     * Do the quicksort. Picks a pivot element (start position) and "orders" all
     * lower entries to the left and all higher entries to the right side. Then
     * the method will sort all entries of the side and the right side recursive.
     *
     * @param elementsToSort the elements to sort
     * @param startPos       the start position to sort within the given array
     * @param endPos         the last position to sort within the given array
     * @return the sorted entries (also the entries in original array given array are also changed)
     */
    private T[] sort(T[] elementsToSort, final int startPos, final int endPos) {
        int indexLeft = startPos;
        int indexRight = endPos;

        if ((endPos - startPos) > 0) {
            // get the pivot element as the first one (currently only start pos.
            // This might cause a bad runtime - usually the determinition of the
            // pivot element should be done in a better way (e.g. random)
            final T pivotElement = elementsToSort[startPos];

            while (indexLeft < indexRight) {
                while (elementsToSort[indexLeft].compareTo(pivotElement) <= 0 &&
                        indexLeft <= endPos && indexRight > indexLeft) {
                    // the element is greater then the pivot so increment
                    // the position
                    indexLeft++;
                }
                while (elementsToSort[indexRight].compareTo(pivotElement) > 0 &&
                        indexRight >= startPos && indexRight >= indexLeft) {
                    // the element is not greater then the pivot so
                    // decrement the position
                    indexRight--;
                }
                // if the left seek index is smaller than the right index
                if (indexLeft < indexRight) {
                    switchElements(elementsToSort, indexLeft, indexRight);
                }
            }
            // after the iteration the last element has to switched with the
            // pivot
            elementsToSort = switchElements(elementsToSort, indexRight, startPos);
            // sort the left side
            elementsToSort = sort(elementsToSort, startPos, indexRight - 1);
            // sort the right side
            elementsToSort = sort(elementsToSort, indexRight + 1, endPos);
        }
        return elementsToSort;
    }


    /**
     * ++
     * This is a helper method to switch the given positions <code>pos1</code>
     * and <code>pos2</code> in the array <code>elementsToSort</code>. A
     * validation of the position isn't implemented
     *
     * @param elementsToSort the array with the entries to switch
     * @param pos1           the position one
     * @param pos2           the position two
     * @return the new array (also the entries in original array given array are also changed)
     */
    protected T[] switchElements(final T[] elementsToSort, final int pos1, final int pos2) {
        T tmpElement = elementsToSort[pos1];
        elementsToSort[pos1] = elementsToSort[pos2];
        elementsToSort[pos2] = tmpElement;
        return elementsToSort;
    }
}