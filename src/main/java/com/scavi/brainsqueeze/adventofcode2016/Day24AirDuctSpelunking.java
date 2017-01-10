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

import com.google.common.base.Preconditions;
import com.scavi.brainsqueeze.maze.MazeRun;
import com.scavi.brainsqueeze.maze.util.Maze;
import com.scavi.brainsqueeze.util.Point;

import java.util.LinkedList;
import java.util.List;

/**
 * Question: http://adventofcode.com/2016/day/24
 *
 * @author Michael Heymel
 * @since 25/12/16
 */
public class Day24AirDuctSpelunking {
    private final boolean _isToReturn;


    /**
     * Constructor
     */
    public Day24AirDuctSpelunking() {
        this(false);
    }


    /**
     * Constructor
     *
     * @param isToReturn <code>true</code> the robot has to return to the start point.
     *                   <p/>
     *                   <code>false</code> the robot has not to return to the start point
     */
    public Day24AirDuctSpelunking(final boolean isToReturn) {
        _isToReturn = isToReturn;
    }


    /**
     * Determines the start and all point's to visit from the given input structure and initiates
     * the bfs to find the shortest bypass
     *
     * @param structure the input structure
     * @return the amount of steps for the shortest bypass
     */
    public int shortestBypass(final String[] structure) {
        Preconditions.checkNotNull(structure, "Illegal structure: <null>");
        Preconditions.checkArgument(structure.length != 0, "Illegal maze fields: <empty column>");

        Maze airDuct = Maze.from(structure, '#');
        Point startPoint = null;
        List<Point> wayPoints = new LinkedList<>();
        // determine start point and all other points to visit
        for (int y = 0; y < structure.length; ++y) {
            for (int x = 0; x < structure[y].length(); ++x) {
                if (structure[y].charAt(x) == 48) {
                    startPoint = new Point(x, y, String.valueOf(structure[y].charAt(x)));
                } else if (structure[y].charAt(x) >= 49 && structure[y].charAt(x) <= 57) {
                    wayPoints.add(new Point(x, y, String.valueOf(structure[y].charAt(x))));
                }
            }
        }
        return shortestBypass(new MazeRun(airDuct),
                startPoint,
                startPoint,
                wayPoints.toArray(new Point[wayPoints.size()]),
                wayPoints.size() - 1,
                0);
    }


    /**
     * Determines the shortest bypass using backtracking
     *
     * @param robotRunner  the robot runner to determine the shortest bypass using bfs
     * @param startPoint   the initial start point
     * @param currentPoint the current point of the robot
     * @param waypoints    all way points to visit
     * @param level        the level determines the current iteration of the backtracking algorithm
     * @param distance     the current distance of the robot
     * @return the shortest bypass
     */
    private int shortestBypass(final MazeRun robotRunner, final Point startPoint,
            final Point currentPoint, final Point[] waypoints, int level, int distance) {
        int shortestPath = Integer.MAX_VALUE;
        // -1 is required because the first iteration is between the startpoint and all other points
        if (level == -1) {
            shortestPath = distance;
            if (_isToReturn) {
                shortestPath += robotRunner.findWay(currentPoint, startPoint);
            }
        } else {
            for (int i = 0; i <= level; ++i) {
                swap(waypoints, i, level);
                int currentDistance = robotRunner.findWay(currentPoint, waypoints[level]);
                int tmpShortestPath = shortestBypass(robotRunner,
                        startPoint,
                        waypoints[level],
                        waypoints,
                        level - 1,
                        distance + currentDistance);
                shortestPath = Math.min(shortestPath, tmpShortestPath);
                swap(waypoints, i, level);
            }
        }
        return shortestPath;
    }


    /**
     * Swaps pos1 and pos2 in the given input array
     *
     * @param waypoints the way points
     * @param pos1      position 1 to swap
     * @param pos2      position 2 to swap with
     */
    private void swap(final Point[] waypoints, final int pos1, final int pos2) {
        if (pos1 != pos2) {
            Point tmp = waypoints[pos1];
            waypoints[pos1] = waypoints[pos2];
            waypoints[pos2] = tmp;
        }
    }
}
