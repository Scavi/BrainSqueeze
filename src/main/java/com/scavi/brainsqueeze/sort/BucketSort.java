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

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Michael Heymel
 * @since 14/01/17
 */
public class BucketSort {
    /**
     * Assumes an array of float values between 0 and 1 and sorts them in O(n).
     *
     * @param inputData the given input data to sort.
     * @return the sorted array
     */
    public Float[] sort(final Float[] inputData) {

        if (inputData != null) {
            final int sortDataLength = inputData.length;
            List<Float>[] bucket = createBucket(sortDataLength);

            // Put array elements in different buckets
            for (int i = 0; i < sortDataLength; ++i) {
                final int index = (int) (sortDataLength * inputData[i]);
                bucket[index].add(inputData[i]);
            }

            // sort all buckets
            for (int i = 0; i < sortDataLength; ++i) {
                Collections.sort(bucket[i]);
            }

            int index = 0;
            for (int i = 0; i < sortDataLength && index < sortDataLength; ++i) {
                final List<Float> tmpBucket = bucket[i];
                for (int j = 0; j < tmpBucket.size(); ++j) {
                    inputData[index++] = tmpBucket.get(j);
                }
            }
        }
        return inputData;
    }


    /**
     * Creates a buckets for each element to sort. Each bucket represents a
     * linked list for multiple elements
     *
     * @param length the length of the array too sort.
     * @return bucket
     */
    @SuppressWarnings(value = "unchecked")
    private final List<Float>[] createBucket(final int length) {
        // creates the empty bucket list
        final List<Float>[] searchData = new List[length];
        for (int i = 0; i < length; ++i) {
            searchData[i] = new LinkedList<>();
        }
        return searchData;
    }
}
