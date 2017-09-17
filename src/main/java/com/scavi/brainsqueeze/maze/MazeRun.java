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

package com.scavi.brainsqueeze.maze;

import com.google.common.base.Preconditions;
import com.scavi.brainsqueeze.maze.util.Maze;
import com.scavi.brainsqueeze.util.Point;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Michael Heymel
 * @since 18/11/16
 */
public class MazeRun {
    private final Maze _maze;
    private int _movableFieldsInRange;


    /**
     * Constructor
     *
     * @param maze the maze
     */
    public MazeRun(final Maze maze) {
        Preconditions.checkNotNull(maze, "Illegal maze: <null>");
        _maze = maze;
    }


    /**
     * Find the shortest way from the starting point to the given end point using O (n + m) time on
     * the given matrix.
     *
     * @param startPoint the start point
     * @param endPoint   the end point
     * @return the number of steps to find the way from start to end
     */
    public int findWay(final Point startPoint, final Point endPoint) {
        return findWay(startPoint, endPoint, Integer.MAX_VALUE);
    }


    /**
     * Find all unique steps in the given range
     *
     * @param startPoint the start point
     * @param endPoint   the end point
     * @param maxRange   the max distance / range from the start point
     * @return the movable fields in range
     */
    public int findStepsInRange(final Point startPoint, final Point endPoint, final int maxRange) {
        _movableFieldsInRange = 0;
        findWay(startPoint, endPoint, maxRange);
        return _movableFieldsInRange;
    }


    /**
     * Find the shortest way from the starting point to the given end point using O (n + m) time on
     * the given matrix.
     *
     * @param startPoint the start point
     * @param endPoint   the end point
     * @param maxRange   the max distance / range from the start point
     * @return the number of steps to find the way from start to end
     */
    private int findWay(final Point startPoint, final Point endPoint, final int maxRange) {
        Preconditions.checkNotNull(startPoint, "Illegal start position: <null>");
        Preconditions.checkNotNull(endPoint, "Illegal end position: <null>");
        validatePosition(startPoint);
        validatePosition(endPoint);

        _maze.reinitializeMaze(startPoint);

        int targetPosition = _maze.positionOfPoint(endPoint);
        int numberOfSteps = Integer.MAX_VALUE;

        Queue<Integer> steps = new LinkedList<>();
        steps.add(_maze.positionOfPoint(startPoint));
        while (steps.size() > 0) {
            int currentPos = steps.poll();

            if (_maze.stepsRequired(currentPos) < maxRange) {
                _movableFieldsInRange++;
            }

            if (currentPos == targetPosition) {
                numberOfSteps = Math.min(numberOfSteps, _maze.stepsRequired(currentPos));
            } else {
                // determines the position to move up / down / left / right from the current
                // position and determines if it is possible to move
                tryAddStep(_maze.determineMoveUpPos(currentPos), steps);
                tryAddStep(_maze.determineMoveDownPos(currentPos), steps);
                tryAddStep(_maze.determineMoveLeftPos(currentPos), steps);
                tryAddStep(_maze.determineMoveRightPos(currentPos), steps);
            }
        }
        return numberOfSteps;
    }


    /**
     * Verifies if the step is valid and adds it to the existing queue of steps
     *
     * @param nextPos the next position
     * @param steps   the bfs-queue for the steps
     */
    private void tryAddStep(final int nextPos, final Queue<Integer> steps) {
        if (nextPos != Maze.ILLEGAL_POSITION) {
            steps.add(nextPos);
        }
    }


    /**
     * Validate that the given position is inside the matrix and that the field is accessible (not
     * inside a wall)
     *
     * @param position the position to set
     */
    private void validatePosition(final Point position) {
        boolean isInside = _maze.isInsideTheMaze(position);
        Preconditions.checkArgument(isInside,
                String.format("Position %s is outside of the maze !", position));
        boolean isAccessible = _maze.isAccessible(position);
        Preconditions.checkArgument(isAccessible,
                String.format("Position %s is inside of the wall !", position));
    }
}
