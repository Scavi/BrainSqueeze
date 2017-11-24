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

package com.scavi.brainsqueeze.career;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by Scavenger on 5/13/2017.
 */
public class ClosestPointsTest {
    @Test
    public void test1() {
        int[][] points = new int[][]{
                new int[]{-2, -3},
                new int[]{-1, 0},
                new int[]{-2, 4},
                new int[]{0, -2},
                new int[]{3, 2},
                new int[]{3, -5},
        };

        int[][] expectedResult = new int[][]{
                new int[]{0, -2},
                new int[]{-1, 0},
        };

        int[][] result = new ClosestPoints().findClosestPointsTo0(points, 2);
        assertThat(result.length).isEqualTo(2);
        assertThat(result).isEqualTo(expectedResult);
    }
}
