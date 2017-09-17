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

import java.util.*;

/**
 * Created by Scavenger on 5/28/2017.
 */
public class UniqueSubsets {

    public int[][] sumSubsets(int[] arr, int num) {

        if (arr == null || arr.length == 0 || num == 0) {
            return new int[][]{{}};
        }

        List<int[]> tmpResult = new LinkedList<>();
        int iteration = arr.length;
        while (iteration > 0) {
            int[] buffer = new int[iteration];
            sumSubsets(arr, 0, buffer, 0, num, tmpResult);
            iteration--;
        }
        tmpResult.sort(new IntArrayComparator());
        int[][] result = new int[tmpResult.size()][arr.length];
        int pos = 0;
        for (int[] tmp : tmpResult) {
            result[pos++] = tmp;
        }
        return result;
    }


    private void sumSubsets(
            int[] arr,
            int arrayPos,
            int[] buffer,
            int bufferPos,
            int num,
            List<int[]> result) {

        if (bufferPos == buffer.length) {
            if (num == 0) {
                if (isUnique(result, buffer)) {
                    result.add(Arrays.copyOfRange(buffer, 0, buffer.length));
                }
            }
        } else {
            if (num > 0) {
                int tmpNum = num;
                for (int i = arrayPos; i < arr.length; ++i) {
                    num -= arr[i];
                    buffer[bufferPos] = arr[i];
                    sumSubsets(arr, i + 1, buffer, bufferPos + 1, num, result);
                    num = tmpNum;
                }
            }
        }
    }

    private boolean isUnique(List<int[]> result, int[] buffer) {
        if (result.size() == 0) {
            return true;
        }
        for (int[] tmp : result) {
            if (Arrays.equals(tmp, buffer)) {
                return false;
            }
        }
        return true;
    }


    private class IntArrayComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] input1, int[] input2) {
            int minLength = Math.min(input1.length, input2.length);

            for (int i = 0; i < minLength; ++i) {
                if (input1[i] != input2[i]) {
                    return input1[i] - input2[i];
                }
            }

            if (input1.length == input2.length) {
                return 0;
            } else if (input1.length > input2.length) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
