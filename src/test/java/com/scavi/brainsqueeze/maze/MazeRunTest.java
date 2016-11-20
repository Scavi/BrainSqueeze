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

import com.scavi.brainsqueeze.maze.util.Maze;
import com.scavi.brainsqueeze.util.Point;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 18/11/16
 */
public class MazeRunTest {

    @Test
    public void testValidWayInMaze1() {
        boolean[][] fieldStructure = new boolean[][]{{true, false, false, false, false, false},
                                                     {true, true, true, false, true, true},
                                                     {true, false, false, false, true, false},
                                                     {true, true, true, true, true, true}};
        Point startPoint = new Point(0, 2);
        Point endPoint = new Point(5, 1);
        Maze maze = Maze.from(fieldStructure);
        MazeRun mazeRunner = new MazeRun(maze);

        int requiredSteps = mazeRunner.findWay(startPoint, endPoint);
        Assert.assertEquals(8, requiredSteps);
    }


    @Test
    public void testValidWayInMaze2() {
        boolean[][] fieldStructure = new boolean[][]{{true, false, true, true, true, false},
                                                     {true, true, true, false, true, true},
                                                     {true, false, false, false, true, false},
                                                     {true, true, true, true, true, true}};
        Point startPoint = new Point(0, 2);
        Point endPoint = new Point(3, 0);
        Maze maze = Maze.from(fieldStructure);
        MazeRun mazeRunner = new MazeRun(maze);

        int requiredSteps = mazeRunner.findWay(startPoint, endPoint);
        Assert.assertEquals(5, requiredSteps);
    }


    @Test
    public void testValidWayInMaze3() {
        boolean[][] fieldStructure = new boolean[][]{{true, false, true, true, true, false},
                                                     {true, false, false, false, true, true},
                                                     {true, false, false, false, true, false},
                                                     {true, true, true, true, true, true}};
        Point startPoint = new Point(0, 2);
        Point endPoint = new Point(3, 0);
        Maze maze = Maze.from(fieldStructure);
        MazeRun mazeRunner = new MazeRun(maze);

        int requiredSteps = mazeRunner.findWay(startPoint, endPoint);
        Assert.assertEquals(9, requiredSteps);
    }


    @Test
    public void testInvalidWayInMaze1() {
        boolean[][] fieldStructure = new boolean[][]{{true, false, true, true, false, false},
                                                     {true, false, false, false, true, true},
                                                     {true, false, false, false, true, false},
                                                     {true, true, true, true, true, true}};
        Point startPoint = new Point(0, 2);
        Point endPoint = new Point(3, 0);
        Maze maze = Maze.from(fieldStructure);
        MazeRun mazeRunner = new MazeRun(maze);

        int requiredSteps = mazeRunner.findWay(startPoint, endPoint);
        Assert.assertEquals(Integer.MAX_VALUE, requiredSteps);
    }
}
