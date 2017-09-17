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

/**
 * Created by Scavenger on 8/2/2017.
 */
public class ChainReaction1 {
    int[][] f;
    int e;

    int[][] chainReaction1(int n, int[][] mA) {
        f = new int[n][n];
        e = n - 1;
        for (int[] m : mA) {
            p(m[1], m[0]);
        }
        return f;
    }

    void p(int x, int y) {
        if (x < 0 || x > e || y < 0 || y > e) {
            return;
        }
        int c = ++f[y][x];
        if (((x == 0 || x == e) && ((y == 0 || y == e) && c >= 2)) ||
                (((x == 0 || x == e || y == 0 || y == e)) && c >= 3) ||
                c >= 4) {
            f[y][x] = 0;
            p(x - 1, y);
            p(x + 1, y);
            p(x, y - 1);
            p(x, y + 1);
        }
    }
}
