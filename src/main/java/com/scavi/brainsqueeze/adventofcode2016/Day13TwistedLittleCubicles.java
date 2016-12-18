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
 * Question: http://adventofcode.com/2016/day/13
 *
 * @author Michael Heymel
 * @since 13/12/16
 */
public class Day13TwistedLittleCubicles {
    /**
     * Determines the shortest path from the start point to the end point while being able to move,
     * up, left, right
     *
     * @param gridSize  the size of the grid
     * @param favNumber the favorite number to create field
     * @param start     the start point
     * @param end       the end point
     * @return the distance (shortest path)
     */
    public int shortestPath(final int gridSize, final int favNumber, final Point start,
            final Point end) {
        MazeRun mazeRun = createMazeRunner(gridSize, favNumber, start, end);
        return mazeRun.findWay(start, end);
    }


    /**
     * Determines the steps in range within the given grid
     *
     * @param gridSize  the size of the grid
     * @param favNumber the favorite number to create field
     * @param start     the start point
     * @param end       the end point
     * @param maxRange  the max grid
     * @return the number of distinct fields
     */
    public int determineSteps(final int gridSize, final int favNumber, final Point start,
            final Point end, final int maxRange) {
        MazeRun mazeRun = createMazeRunner(gridSize, favNumber, start, end);
        mazeRun.findWay(start, end);
        return mazeRun.findStepsInRange(start, end, maxRange);
    }


    /**
     * Creates the maze runner for the given grid
     *
     * @param gridSize  the size of the grid
     * @param favNumber the favorite number to create field
     * @param start     the start point
     * @param end       the end point
     * @return the maze runner
     */
    private MazeRun createMazeRunner(final int gridSize, final int favNumber, final Point start,
            final Point end) {
        boolean[][] fieldDefinition = createFieldDefinition(gridSize, favNumber);
        Maze twistedCubicles = Maze.from(fieldDefinition);
        MazeRun mazeRun = new MazeRun(twistedCubicles);
        return mazeRun;
    }


    /**
     * Creates the field with the input instructions for the question. Calculates the position of x
     * and y to see if the binary representation of it, represents a wall or a field
     *
     * @param gridSize  the size of the grid
     * @param favNumber the favorite number to create field
     * @return the field while true represents a moveable field and false a wall
     */
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


    /**
     * Uses a formular to determine if x / y are a wall or an empty room
     *
     * @param x the x pos
     * @param y the y pos
     * @return the calculated value
     */
    private int calculate(final int x, final int y) {
        return (x * x) + (3 * x) + (2 * x * y) + y + (y * y);
    }
}
