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

/**
 * Created by Scavenger on 7/24/2017.
 */
public class MineSweeper {
    boolean minesweeper1(int[][] g) {
        int yL = g.length;
        int xL = g[0].length;
        for (int y = 0; y < yL; ++y) {
            for (int x = 0; x < xL; ++x) {
                if (g[y][x] != 9) {
                    int m = 0;
                    if (x > 0) {
                        if (g[y][x - 1] == 9) m++; // left
                        if (y > 0) {
                            if (g[y - 1][x - 1] == 9) m++; // top left
                        }
                        if (y < yL - 1 && g[y + 1][x - 1] == 9) m++; // bottom left
                    }
                    if (y > 0 && g[y - 1][x] == 9) m++; // top
                    if (y < yL - 1 && g[y + 1][x] == 9) m++; // bottom
                    if (x < xL - 1) {
                        if (g[y][x + 1] == 9) m++; // right
                        if (y > 0 && g[y - 1][x + 1] == 9) m++; // top right
                        if (y < yL - 1 && g[y + 1][x + 1] == 9) m++; // bottom right
                    }
                    if (m != g[y][x])
                        return false;
                }
            }
        }
        return true;
    }

}
