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
 * Created by Scavenger on 6/12/2017.
 */
public class CoinCollector {
    private static final int MAX = 1001;
    private static final int POS_X = 0;
    private static final int POS_Y = 1;

    public int maximizeCoins(int[][] coins) {
        int cache[][] = new int[MAX][MAX];
        // map the input coin array to the cache. Duplicated input values
        // will considered
        for (int tmpCoins[] : coins) {
            cache[tmpCoins[POS_Y]][tmpCoins[POS_X]]++;
        }
        // fill the outer bounds from left to right and from bottom to up
        // e.g.
        // 0 0 0 0 =>*1 0 0 0
        // 0 1 1 0 =>*1 1 1 0
        // 1 1 0 0 => 1 1 0 0
        // 0 0 2 0 => 0 0 2 2
        // _________________*
        for (int i = 1; i < MAX; i++) {
            cache[i][0] += cache[i - 1][0];
            cache[0][i] += cache[0][i - 1];
        }
        // iterate from 1,1 the entire array and take max from bottom or left + the current position
        // e.g.
        // 1 0 0 0 => 1 3 4 4
        // 1 1 1 0 => 1 3 4 4
        // 1 1 0 0 => 1 2 2 2
        // 0 0 2 2 => 0 0 2 2
        for (int y = 1; y < MAX; y++) {
            for (int x = 1; x < MAX; x++) {
                cache[y][x] += Math.max(cache[y - 1][x], cache[y][x - 1]);
            }
        }
        return cache[MAX - 1][MAX - 1];
    }
}



