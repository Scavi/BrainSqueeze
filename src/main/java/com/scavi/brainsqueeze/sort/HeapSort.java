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
 * @since 10/01/17
 */
public class HeapSort<T extends Comparable<T>> {
    /**
     * This heap sort uses the binary heap structure (put the data into an
     * array). The elements will be determined as described in the following:<br>
     * - Parent (i) return i / 2<br>
     * - Left (i) return 2 * i <br>
     * - Right (i) return (2 * i) + 1<br>
     * (to enhance the performance of determine the left / right position the
     * shifting of the bit position can be used)
     * <p>
     * We shall see that the basic operations on heaps run in time at most
     * proportional to the height of the tree and thus take O(n * log(n)) time.<br>
     * <p>
     * The HeapSort combines the better attributes of InsertionSort and
     * MergeSort. The sort algorithm has the running time O(n * log(n)) of the
     * MergeSort and runs in place like the InsertionSort. Unlike mergesort the
     * heapsort is not stable.
     */
    public T[] sort(T[] elementsToSort) {
        // builds the max heap as a preparation of the heap sort
        final T[] maxHeap = buildMaxHeap(elementsToSort);
        // do the heap sort
        elementsToSort = doMaxHeapSort(maxHeap);
        return elementsToSort;
    }


    /**
     * Starts the heap sort
     *
     * @param elements the elements to sort
     * @return the sorted elements
     */
    private T[] doMaxHeapSort(T[] elements) {
        int arrayPosDec = 1; // start
        int maxLen = elements.length - 1;

        for (int i = maxLen; i >= 1; --i, arrayPosDec++) {
            elements = switchElements(elements, 0, i);
            elements = maxHeapify(elements, 0, elements.length - arrayPosDec);
        }
        return elements;
    }


    /**
     * The BUILD-MAX-HEAP procedure, which runs in linear time, produces a
     * maxheap from an unordered input array. Creates a given elements into a max
     * heap.
     *
     * @param elements The elements for the heap
     * @return the given elements as a max heap.
     */
    private T[] buildMaxHeap(T[] elements) {
        if (elements != null && elements.length > 1) {
            int len = elements.length >> 1;
            for (int i = len - 1; i >= 0; --i) {
                elements = maxHeapify(elements, i, elements.length);
            }
        }
        return elements;
    }


    /**
     * In order to maintain the max-heap property, we call the procedure
     * MAX-HEAPIFY. Its inputs are an array an index pos and the length of
     * elements to access in the array (necessary for the sort).<br>
     * When it is called, maxHeapify assumes that the binary trees rooted at
     * leftChild(pos) / and rightChild(pos) / are maxheaps, but that
     * elementsToSort[i] might be smaller than its children, thus violating the
     * max-heap property. maxHeapify lets the value at elementsToSort[i]
     * "float down" in the max-heap so that the subtree rooted at index i obeys
     * the max-heap property. <br>
     * The maxHeapify procedure, which runs in O (log n) time, is the key to
     * maintaining the max-heap property.
     *
     * @param elements       the array of elements to heapify
     * @param currentPos     the position from which the method has to heapify the elements
     * @param elementsLength the lenght of the array that is access able for the iteration (e.g.
     *                       when this method is used for sorting not every element is access able
     */
    private T[] maxHeapify(T[] elements, final int currentPos, int elementsLength) {
        // determine the array position of the child's (left and right)
        final int leftChildPos = leftChildPos(currentPos);
        final int rightChildPos = rightChildPos(currentPos);

        // compare the three entries (currentPos, leftChildPos and rightchildPos)
        // to determine the largest entry... this one will be switched with the
        // current position
        int largestElementPos = -1;
        // determine the largest element from the given array while comparing the
        // element of the current position with his both child's (left / right)
        // ... do it left
        if (leftChildPos < elementsLength &&
                elements[leftChildPos].compareTo(elements[currentPos]) > 0) {
            largestElementPos = leftChildPos;
        } else {
            largestElementPos = currentPos;
        }

        // ... do the comparison for the right side
        if (rightChildPos < elementsLength &&
                elements[rightChildPos].compareTo(elements[largestElementPos]) > 0) {
            largestElementPos = rightChildPos;
        }

        // do heapify if necessary
        if (largestElementPos != currentPos) {
            // switch the elements
            elements = switchElements(elements, currentPos, largestElementPos);
            // further iteration...
            elements = maxHeapify(elements, largestElementPos, elementsLength);
        }
        return elements;
    }


    /**
     * Switch the elements <code>pos1</code> and <code>pos2</code> within the
     * elements.
     *
     * @param elements the array of elements
     * @param pos1     the first position to switch
     * @param pos2     the second position to switch
     * @return the array of elements where the two entries code>pos1</code> and <code>pos2</code>
     * are switched
     */
    private T[] switchElements(final T[] elements, final int pos1, final int pos2) {
        final T temp = elements[pos1];
        elements[pos1] = elements[pos2];
        elements[pos2] = temp;
        return elements;
    }


    /**
     * Shifts the given position <code>pos</code> to the right side to determine
     * the parent of the position within the heap (equivalent to (pos * 2) + 1) <br>
     * Set the method to static final and "hope" that the Java JIT compiler will
     * optimize the function to an inline method.
     *
     * @param pos the current position
     * @return the new position
     */
    private int parent(final int pos) {
        return (pos >> 1) + 1;
    }


    /**
     * Shifts the given position <code>pos</code> to the left side to determine
     * the left element from the position within the heap (equivalent to (pos *
     * 2)) <br>
     * Set the method to static final and "hope" that the Java JIT compiler will
     * optimize the function to an inline method.
     *
     * @param pos the current position
     * @return the new position
     */
    private int leftChildPos(final int pos) {
        return (pos << 1) + 1;
    }


    /**
     * Shifts the given position <code>pos</code> to the left side and adds a
     * low-order bit to determine the right element from the position the heap
     * (equivalent to (pos * 2) + 1) <br>
     * Set the method to static final and "hope" that the Java JIT compiler will
     * optimize the function to an inline method.
     *
     * @param pos the current position
     * @return the new position
     */
    private int rightChildPos(final int pos) {
        return (pos << 1) + 2;
    }
}