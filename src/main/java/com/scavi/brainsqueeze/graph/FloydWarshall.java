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

import com.google.common.base.Preconditions;

/**
 * @author Michael Heymel
 * @since 29/11/16
 */
public class FloydWarshall {
    public static final int UNKNOWN_DISTANCE = 10000000;

    public int[][] allPairsShortestPath(final int[][] matrix) {
        Preconditions.checkNotNull(matrix, "Illegal adjacency matrix: <null>");
        Preconditions.checkArgument(matrix.length == matrix[0].length,
                String.format(
                        "Illegal adjacency matrix! Width and height are not equal! (Width=%s, Height=%s",
                        matrix.length,
                        matrix[0].length));

        int pathLength = matrix.length;
        for (int i = 0; i < pathLength; ++i) {
            for (int j = 0; j < pathLength; ++j) {
                for (int k = 0; k < pathLength; ++k) {
                    int tmp1 = matrix[j][i] + matrix[i][k];
                    matrix[j][k] = Math.min(matrix[j][k], tmp1);
                }
            }
        }
        return matrix;
    }
}
