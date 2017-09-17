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

public class LandscapeEarnings {

//    int r, i, j, c;
//    int landscapingEarnings(int t) {
//        int[][] w = new int[][] { { 4,3 }, { 5,4 }, {10, 7}, {30, 14}, { 120, 300 } };
//
//        for (i = 0; i < 10; ++i) {
//            for (j = 0; j < 5; ++j) {
//
//            }
//        }
//        return r;
//    }

    int landscapingEarnings(int t) {
        return s(t, 0, 0);
    }

    int s(int t, int j, int c) {
        if (t < 0 || j > 10) return -1;
        if (t == 0) return c;

        int[][] w = new int[][]{{4, 3}, {5, 4}, {10, 7}, {30, 14}, {120, 300}};
        //int[][] w = new int[][] { { 120, 300 }, {30, 14}, {10, 7}, { 5,4 }, { 4,3 } };
        int r = 0;
        for (int i = 0; i < 5; ++i) {

            if (t < (11 - j) * 120) {
                int v = s(t - w[i][0], j + 1, c + w[i][1]);
                if (v == -1) break;
                r = Math.max(r, v);
            }
        }
        return r;
    }


//    int i, a;
//    int landscapingEarnings(int time) {
//        int[][] w = new int[][] { { 4,3 }, { 5,4 }, { 120, 300 } };
//        int[] c = new int[time + 1];
//
//        for (i = 4; i <=time; ++i) {
//            for (int j = 0; j < w.length; ++j) {
//                a = w[j][0];
//                if (i >= a)
//                    c[i] = Math.max(c[i], c[i - a] + w[j][1]);
//
//            }
//        }
//        return c[time];
//    }
}
