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

public class Sum34 {

    int sum34(int n) {
        long r = 2;
        for (int i = 1; i < n; ++i) {
            r += b(n, i);
        }
        return (int)((r % 9 == 0 && r != 0) ? 9 : r % 9);
    }

    long b(int n, int k) {
        int r = 1;
        if (k > n - k)
            k = n - k;
        for (int i = 0; i < k; ++i) {
            r *= (n - i);
            r /= (i + 1);
        }
        return r;
    }
}
