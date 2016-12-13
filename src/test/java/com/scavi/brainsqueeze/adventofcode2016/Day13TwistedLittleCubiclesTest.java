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

import com.scavi.brainsqueeze.util.Point;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 13/12/16
 */
public class Day13TwistedLittleCubiclesTest {

    @Test
    public void test1() {
        Day13TwistedLittleCubicles twistedLittleCubicles = new Day13TwistedLittleCubicles();
        Point start = new Point(1, 1);
        Point end = new Point(7, 4);
        int shortestDistance = twistedLittleCubicles.shortestPath(10, 10, start, end);
        Assert.assertEquals(11, shortestDistance);
    }


    @Test
    public void testQuestion1() {
        Day13TwistedLittleCubicles twistedLittleCubicles = new Day13TwistedLittleCubicles();
        Point start = new Point(1, 1);
        Point end = new Point(31, 39);
        int shortestDistance = twistedLittleCubicles.shortestPath(41, 1364, start, end);
        Assert.assertEquals(86, shortestDistance);
    }


    @Test
    public void testQuestion2() {
        Day13TwistedLittleCubicles twistedLittleCubicles = new Day13TwistedLittleCubicles();
        Point start = new Point(1, 1);
        Point end = new Point(61, 63);
        int steps = twistedLittleCubicles.determineSteps(100, 1364, start, end, 50);
        Assert.assertEquals(127, steps);
    }
}
