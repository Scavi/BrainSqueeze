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

package com.scavi.brainsqueeze.adventofcode.y2016;

import com.scavi.brainsqueeze.adventofcode.y2016.Day1NoTimeForATaxicab;
import org.junit.Assert;
import org.junit.Test;

import static com.scavi.brainsqueeze.adventofcode.y2016.Day1NoTimeForATaxicab.*;
import static com.scavi.brainsqueeze.adventofcode.y2016.Day1NoTimeForATaxicab.Direction.*;

/**
 * @author Michael Heymel
 * @since 01/12/16
 */
public class Day1NoTimeForATaxicabTest {

    /**
     * Following R2, L3 leaves you 2 blocks East and 3 blocks North, or 5 blocks away.
     */
    @Test
    public void testMoveValidation1() {
        Day1NoTimeForATaxicab noTaxiCab = new Day1NoTimeForATaxicab();
        int shortestDistance = noTaxiCab.shortestDistance(new Move(R, 2), new Move(L, 3));
        Assert.assertEquals(5, shortestDistance);
    }


    /**
     * R2, R2, R2 leaves you 2 blocks due South of your starting position, which is 2 blocks away.
     */
    @Test
    public void testMoveValidation2() {
        Day1NoTimeForATaxicab noTaxiCab = new Day1NoTimeForATaxicab();
        int shortestDistance =
                noTaxiCab.shortestDistance(new Move(R, 2), new Move(R, 2), new Move(R, 2));
        Assert.assertEquals(2, shortestDistance);
    }


    /**
     * R5, L5, R5, R3 leaves you 12 blocks away.
     */
    @Test
    public void testMoveValidation3() {
        Day1NoTimeForATaxicab noTaxiCab = new Day1NoTimeForATaxicab();
        int shortestDistance = noTaxiCab.shortestDistance(new Move(R, 5),
                new Move(L, 5),
                new Move(R, 5),
                new Move(R, 3));
        Assert.assertEquals(12, shortestDistance);
    }


    /**
     * Following R2, L3 leaves you 2 blocks East and 3 blocks North, or 5 blocks away. (string input
     * format)
     */
    @Test
    public void testMoveValidation4() {
        Day1NoTimeForATaxicab noTaxiCab = new Day1NoTimeForATaxicab();
        Move[] movementSequence = Move.from("R2, L3");
        int shortestDistance = noTaxiCab.shortestDistance(movementSequence);
        Assert.assertEquals(5, shortestDistance);
    }


    /**
     * R2, R2, R2 leaves you 2 blocks due South of your starting position, which is 2 blocks away.
     * (string input format)
     */
    @Test
    public void testMoveValidation5() {
        Day1NoTimeForATaxicab noTaxiCab = new Day1NoTimeForATaxicab();
        Move[] movementSequence = Move.from("R2, R2, R2");
        int shortestDistance = noTaxiCab.shortestDistance(movementSequence);
        Assert.assertEquals(2, shortestDistance);
    }


    /**
     * R5, L5, R5, R3 leaves you 12 blocks away. (string input format)
     */
    @Test
    public void testMoveValidation6() {
        Day1NoTimeForATaxicab noTaxiCab = new Day1NoTimeForATaxicab();
        Move[] movementSequence = Move.from("R5, L5, R5, R3");
        int shortestDistance = noTaxiCab.shortestDistance(movementSequence);
        Assert.assertEquals(12, shortestDistance);
    }


    /**
     * If your instructions are R8, R4, R4, R8, the first location you visit twice is 4 blocks away,
     * due East.
     */
    @Test
    public void testVisitedPositionValidation() {
        Day1NoTimeForATaxicab noTaxiCab = new Day1NoTimeForATaxicab();
        Move[] movementSequence = Move.from("R8, R4, R4, R8");
        int shortestDistance = noTaxiCab.firstTwiceVisitedPosition(movementSequence);
        Assert.assertEquals(4, shortestDistance);
    }


    /**
     * The first question
     */
    @Test
    public void testShortestDistance() {
        Day1NoTimeForATaxicab noTaxiCab = new Day1NoTimeForATaxicab();
        Move[] movementSequence = Move.from(
                "L5, R1, R4, L5, L4, R3, R1, L1, R4, R5, L1, L3, R4, L2, L4, R2, L4, L1, R3, R1, R1, " +
                        "L1, R1, L5, R5, R2, L5, R2, R1, L2, L4, L4, R191, R2, R5, R1, L1, L2, R5, L2, " +
                        "L3, R4, L1, L1, R1, R50, L1, R1, R76, R5, R4, R2, L5, L3, L5, R2, R1, L1, R2, " +
                        "L3, R4, R2, L1, L1, R4, L1, L1, R185, R1, L5, L4, L5, L3, R2, R3, R1, L5, R1, " +
                        "L3, L2, L2, R5, L1, L1, L3, R1, R4, L2, L1, L1, L3, L4, R5, L2, R3, R5, R1, L4, " +
                        "R5, L3, R3, R3, R1, R1, R5, R2, L2, R5, L5, L4, R4, R3, R5, R1, L3, R1, L2, L2, " +
                        "R3, R4, L1, R4, L1, R4, R3, L1, L4, L1, L5, L2, R2, L1, R1, L5, L3, R4, L1, R5, " +
                        "L5, L5, L1, L3, R1, R5, L2, L4, L5, L1, L1, L2, R5, R5, L4, R3, L2, L1, L3, L4, " +
                        "L5, L5, L2, R4, R3, L5, R4, R2, R1, L5");
        int shortestDistance = noTaxiCab.shortestDistance(movementSequence);
        Assert.assertEquals(242, shortestDistance);
    }


    /**
     * The second question
     */
    @Test
    public void testFirstTwiceVisitedPoint() {
        Day1NoTimeForATaxicab noTaxiCab = new Day1NoTimeForATaxicab();
        Move[] movementSequence = Move.from(
                "L5, R1, R4, L5, L4, R3, R1, L1, R4, R5, L1, L3, R4, L2, L4, R2, L4, L1, R3, R1, R1, " +
                        "L1, R1, L5, R5, R2, L5, R2, R1, L2, L4, L4, R191, R2, R5, R1, L1, L2, R5, L2, " +
                        "L3, R4, L1, L1, R1, R50, L1, R1, R76, R5, R4, R2, L5, L3, L5, R2, R1, L1, R2, " +
                        "L3, R4, R2, L1, L1, R4, L1, L1, R185, R1, L5, L4, L5, L3, R2, R3, R1, L5, R1, " +
                        "L3, L2, L2, R5, L1, L1, L3, R1, R4, L2, L1, L1, L3, L4, R5, L2, R3, R5, R1, L4, " +
                        "R5, L3, R3, R3, R1, R1, R5, R2, L2, R5, L5, L4, R4, R3, R5, R1, L3, R1, L2, L2, " +
                        "R3, R4, L1, R4, L1, R4, R3, L1, L4, L1, L5, L2, R2, L1, R1, L5, L3, R4, L1, R5, " +
                        "L5, L5, L1, L3, R1, R5, L2, L4, L5, L1, L1, L2, R5, R5, L4, R3, L2, L1, L3, L4, " +
                        "L5, L5, L2, R4, R3, L5, R4, R2, R1, L5");
        int shortestDistance = noTaxiCab.firstTwiceVisitedPosition(movementSequence);
        Assert.assertEquals(150, shortestDistance);
    }
}
