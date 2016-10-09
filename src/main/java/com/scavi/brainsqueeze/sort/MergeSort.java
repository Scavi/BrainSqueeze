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

import java.lang.reflect.Array;

/**
 * @author Michael Heymel
 * @since 07/10/16
 */
public class MergeSort<T extends Comparable<T>> {

    private final Class<T> _clazz;


    /**
     * Constructor
     *
     * @param clazz The clazz for the comparision
     */
    public MergeSort(final Class<T> clazz) {
        _clazz = clazz;
    }


    /**
     * The merge sort is a stable sorting algorithm. Unlike the insertion- or the heap
     * sort the merge sort doesn't sort in place (have to allocate new memory). The
     * merge sort uses the principles of divide and conquer.<br>
     * <br>
     * The merge sort takes the data and split them into pieces. The small pieces will
     * be merged.<br>
     * <br>
     * Start: 	 3--4--2--1--7--5--8--9--0--6<br>
     * Split:	 3--4--2--1--7  5--8--9--0--6<br>
     * Split:	 3--4--2  1--7  5--8--9  0--6<br>
     * Merge: 	 2--3--4  1--5--7--8--9  0--6<br>
     * Merge: 	 1--2--3--4--5--7--8--9  0--6<br>
     * Merge:    0--1--2--3--4--5--6--7--8--9<br>
     * <br>
     * The best running time is (Theata):  	  O(n log(n))
     * The average running time is (Theata):  O(n log(n))
     * The worst running time is (Theata):    O(n log(n))
     * <br>
     * To optimize the merge sort the insertion sort could be used to sort few
     * elements because the insertion sort is quick to sort few entries
     *
     * @param input the elements that have to be sorted using merge sort
     * @return the sorted elements
     */
    @SuppressWarnings("unchecked")
    public T[] sort(final T[] input) {
        if (input == null || input.length == 0) {
            return input;
        }
        T[] buffer = (T[]) Array.newInstance(_clazz, input.length);
        split(input, buffer, 0, input.length - 1);
        return buffer;
    }


    /**
     * "Divide" the input array into two parts
     *
     * @param input  the given input to sort
     * @param buffer the buffer to sort the elements
     * @param start  the current start position
     * @param end    the current end position
     */
    private void split(final T[] input, final T[] buffer, final int start, final int end) {

        if (start < end) {
            final int median = (end + start) / 2;
            split(input, buffer, start, median);
            split(input, buffer, median + 1, end);
            merge(input, buffer, start, median + 1, end);
        }
    }


    /**
     * Does the merging of the elements
     *
     * @param input  the given input to sort
     * @param buffer a sort buffer
     * @param start  the start position
     * @param median the median split position
     * @param end    the end position
     */
    private void merge(final T[] input, final T[] buffer, final int start, final int median,
            final int end) {

        int tempIndex = start;
        int currentLeft = start;
        int currentRight = median;

        // merge both given arrays
        while ((currentLeft < median) && currentRight <= end) {
            if (input[currentLeft].compareTo(input[currentRight]) <= 0) {
                buffer[tempIndex++] = input[currentLeft++];
            } else {
                buffer[tempIndex++] = input[currentRight++];
            }
        }
        // merge the rest of left
        while (currentLeft < median) {
            buffer[tempIndex++] = input[currentLeft++];
        }
        // merge the rest of right
        while (currentRight <= end) {
            buffer[tempIndex++] = input[currentRight++];
        }
        // copy back the merged items
        for (tempIndex = start; tempIndex <= end; tempIndex++) {
            input[tempIndex] = buffer[tempIndex];
        }
    }
}
