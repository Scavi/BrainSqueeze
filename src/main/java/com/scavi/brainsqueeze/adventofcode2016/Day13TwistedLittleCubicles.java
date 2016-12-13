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

package com.scavi.brainsqueeze.adventofcode2016;

import com.scavi.brainsqueeze.maze.MazeRun;
import com.scavi.brainsqueeze.maze.util.Maze;
import com.scavi.brainsqueeze.util.Point;

/**
 * @author Michael Heymel
 * @since 13/12/16
 */
public class Day13TwistedLittleCubicles {

    public int shortestPath(final int gridSize, final int favNumber, final Point start,
            final Point end) {
        boolean[][] fieldDefinition = createFieldDefinition(gridSize, favNumber);
        Maze twistedCubicles = Maze.from(fieldDefinition);
        MazeRun mazeRun = new MazeRun(twistedCubicles);
        return mazeRun.findWay(start, end);
    }


    private boolean[][] createFieldDefinition(final int gridSize, final int favNumber) {
        boolean[][] field = new boolean[gridSize][gridSize];
        for (int y = 0; y < gridSize; ++y) {
            for (int x = 0; x < gridSize; ++x) {
                int result = calculate(x, y) + favNumber;
                int noOfBits = 0;
                while (result > 0) {
                    if ((result & 1) != 0) {
                        noOfBits++;
                    }
                    result = result >> 1;
                }
                field[y][x] = noOfBits % 2 == 0;
            }
        }
        return field;
    }


    private int calculate(final int x, final int y) {
        return (x * x) + (3 * x) + (2 * x * y) + y + (y * y);
    }
}
