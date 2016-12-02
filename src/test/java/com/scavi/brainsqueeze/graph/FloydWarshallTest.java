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

package com.scavi.brainsqueeze.graph;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 02/12/16
 */
public class FloydWarshallTest {

    @Test
    public void test1() {

        final int max = FloydWarshall.UNKNOWN_DISTANCE;

        int[][] expectedOutput =
                new int[][]{{0, 10, 15, 5, 20}, {10, 0, 5, 5, 10}, {15, 5, 0, 10, 15},
                            {5, 5, 10, 0, 15}, {20, 10, 15, 15, 0}};

        int[][] matrixInput =
                new int[][]{{0, 10, max, 5, max}, {10, 0, 5, 5, 10}, {max, 5, 0, max, max},
                            {5, 5, max, 0, 20}, {max, 10, max, 20, 0}};

        FloydWarshall allPairsShortestPath = new FloydWarshall();
        matrixInput = allPairsShortestPath.allPairsShortestPath(matrixInput);

        for (int i = 0; i < expectedOutput.length; ++i) {
            Assert.assertArrayEquals(expectedOutput[i], matrixInput[i]);
        }
    }
}
