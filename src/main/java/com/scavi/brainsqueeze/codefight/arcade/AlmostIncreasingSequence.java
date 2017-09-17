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

package com.scavi.brainsqueeze.codefight.arcade;

public class AlmostIncreasingSequence {
    boolean almostIncreasingSequence(int[] sequence) {

        int t = 123456;
        int t0 = (t) % 10;
        int i1 = (t / 10) % 10;
        int i2 = (t / 100) % 10;
        int i3 = (t / 1000) % 10;


        if (sequence.length <= 2) {
            return true;
        }

        int prevCache = 0;
        int skipped = 0;
        int prevCompare = sequence[0];
        for (int i = 1; i < sequence.length && skipped < 2; ++i) {
            int current = sequence[i];
            if (prevCompare >= current) {
                skipped++;
                if (i >= 2) {
                    if (current > prevCache) {
                        prevCompare = current;
                    }
                } else {
                    prevCompare = Math.min(prevCompare, current);
                }
            } else {
                prevCache = prevCompare;
                prevCompare = current;
            }
        }
        return skipped < 2;
    }
}
