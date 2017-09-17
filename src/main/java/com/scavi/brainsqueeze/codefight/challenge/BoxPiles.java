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

import java.util.Arrays;

public class BoxPiles {
    int s, e, t, c, l;
    int boxPiles(int[] a) {
        Arrays.sort(a);
        l = a.length - 1;
        if (l == 0) return 1;
        t = e = l;
        while (s <= e) {
            c = a[t];
            if (c == 0)
                t--;
            if (c == 1)
                a[t] = a[s++];
            if (c > 1)
                a[t] = a[--e];
        }
        return l - t;
    }
}
