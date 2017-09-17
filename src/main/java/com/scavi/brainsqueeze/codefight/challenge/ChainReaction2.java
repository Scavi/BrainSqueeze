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

public class ChainReaction2 {

    int[][] f;
    int r, g, h, w, c, t, s;
    boolean i, v, b;

    String chainReaction2(int n, int m, int[][] d) {
        f = new int[n][m];
        h = n - 1;
        w = m - 1;
        s = d.length + 100;
        for (int[] c : d) {
            i = !i;
            p(c[1], c[0]);
        }
        return r > 0 && g > 0 ? "draw" :
                (r == 0 ? "Green" : "Red") + " won";
    }

    void p(int x, int y) {
        if (x < 0 || x > w || y < 0 || y > h) return;
        if (s < 0 && (r == 0 || g == 0))
            return;
        s--;
        t = f[y][x];
        if ((i && t < 0) || (!i && t > 0)) {
            f[y][x] *= -1;
            r -= t;
            g += t;
        }
        if (i) {
            ++r;
            c = ++f[y][x];
        } else {
            ++g;
            c = --f[y][x];
        }
        c = c > 0 ? c : c * -1;
        v = x == 0 || x == w;
        b = y == 0 || y == h;
        if ((v && b && c >= 2) || ((v || b) && c >= 3) || c >= 4) {
            if (f[y][x] > 0) r -= c;
            else g -= c;
            f[y][x] = 0;
            p(x - 1, y);
            p(x + 1, y);
            p(x, y - 1);
            p(x, y + 1);
        }
    }
}
