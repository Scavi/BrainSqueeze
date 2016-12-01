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
import com.scavi.brainsqueeze.util.Point;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

import static com.scavi.brainsqueeze.adventofcode2016.Day1NoTimeForATaxicab.Direction.R;
import static com.scavi.brainsqueeze.adventofcode2016.Day1NoTimeForATaxicab.Heading.East;
import static com.scavi.brainsqueeze.adventofcode2016.Day1NoTimeForATaxicab.Heading.North;
import static com.scavi.brainsqueeze.adventofcode2016.Day1NoTimeForATaxicab.Heading.South;
import static com.scavi.brainsqueeze.adventofcode2016.Day1NoTimeForATaxicab.Heading.West;

/**
 * Solves the question: http://adventofcode.com/2016/day/1
 *
 * @author Michael Heymel
 * @since 01/12/16
 */
class Day1NoTimeForATaxicab {
    private static final int POS_LOOKUP = -1;

    enum Heading {North, East, West, South}

    enum Direction {
        R, L;
    }


    /**
     * Determines the shortest distance to the Easter Bunny Headquarter
     *
     * @param movementSequence the given movement sequence instructions
     * @return the shortest distance
     */
    public int shortestDistance(final Move... movementSequence) {
        Preconditions.checkNotNull(movementSequence, "Illegal movement sequence: <null>");
        Preconditions.checkArgument(movementSequence.length > 0,
                "Illegal movement sequence: 0 instructions");
        return findEasterBunnyHeadquarter(movementSequence)[0];
    }


    /**
     * Then, you notice the instructions continue on the back of the Recruiting Document. Easter
     * Bunny HQ is actually at the first location you visit twice.
     *
     * @param movementSequence the given movement sequence instructions
     * @return the distance to the first visited position
     */
    public int firstTwiceVisitedPosition(final Move... movementSequence) {
        Preconditions.checkNotNull(movementSequence, "Illegal movement sequence: <null>");
        Preconditions.checkArgument(movementSequence.length > 0,
                "Illegal movement sequence: 0 instructions");
        return findEasterBunnyHeadquarter(movementSequence)[1];
    }


    /**
     * Initiates the search for the Easter Bunny Headquarter
     *
     * @param movementSequence the given movement sequence instructions
     * @return the first position of the array contains the shortest distance, the second the
     * shortest distance to the position that was visited twice
     */
    private int[] findEasterBunnyHeadquarter(final Move... movementSequence) {
        int xPos = 0;
        int yPos = 0;
        Heading heading = null;

        Set<Point> positionCache = new HashSet<>();
        int firstTwiceVisited = POS_LOOKUP;
        // iterate through the movement sequene
        for (Move nextMove : movementSequence) {
            heading = determineHeading(heading, nextMove);
            switch (heading) {
                case North:
                    if (firstTwiceVisited == POS_LOOKUP) {
                        firstTwiceVisited = trackVertical(positionCache,
                                xPos,
                                yPos,
                                yPos + nextMove.getSteps());
                    }
                    yPos += nextMove.getSteps();
                    break;
                case East:
                    if (firstTwiceVisited == POS_LOOKUP) {
                        firstTwiceVisited = trackHorizontal(positionCache,
                                xPos,
                                xPos + nextMove.getSteps(),
                                yPos);
                    }
                    xPos += nextMove.getSteps();
                    break;
                case South:
                    if (firstTwiceVisited == POS_LOOKUP) {
                        firstTwiceVisited = trackVertical(positionCache,
                                xPos,
                                yPos,
                                yPos - nextMove.getSteps());
                    }
                    yPos -= nextMove.getSteps();
                    break;
                case West:
                    if (firstTwiceVisited == POS_LOOKUP) {
                        firstTwiceVisited = trackHorizontal(positionCache,
                                xPos,
                                xPos - nextMove.getSteps(),
                                yPos);
                    }
                    xPos -= nextMove.getSteps();
                    break;
            }
        }
        return new int[]{Math.abs(xPos) + Math.abs(yPos), firstTwiceVisited};
    }


    /**
     * Tracks the horizontal movement and saves the x,y positions into the cache. Also the method
     * validates if the position was already visited. In that case no further cache entries will be
     * added and the distance will be returned
     *
     * @param cache      the cache
     * @param xPos       the current x position
     * @param targetXPos the target x position
     * @param yPos       the current y position
     * @return the distance to the start point if the first visited point was found or -1
     */
    private int trackHorizontal(Set<Point> cache, int xPos, int targetXPos, int yPos) {
        int visitedPos = POS_LOOKUP;
        if (xPos != targetXPos) {
            while (xPos != targetXPos && visitedPos == POS_LOOKUP) {
                if (xPos > targetXPos) {
                    xPos--;
                } else {
                    xPos++;
                }
                Point newPoint = new Point(xPos, yPos);
                if (cache.contains(newPoint)) {
                    visitedPos = Math.abs(xPos) + Math.abs(yPos);
                } else {
                    cache.add(newPoint);
                }
            }
        }
        return visitedPos;
    }


    /**
     * Tracks the vertical movement and saves the x,y positions into the cache. Also the method
     * validates if the position was already visited. In that case no further cache entries will be
     * added and the distance will be returned
     *
     * @param cache      the cache
     * @param xPos       the current x position
     * @param yPos       the current y position
     * @param targetYPos the target y position
     * @return the distance to the start point if the first visited point was found or -1
     */
    private int trackVertical(Set<Point> cache, int xPos, int yPos, int targetYPos) {
        int visitedPos = POS_LOOKUP;
        if (yPos != targetYPos) {
            while (yPos != targetYPos && visitedPos == POS_LOOKUP) {
                if (yPos > targetYPos) {
                    yPos--;
                } else {
                    yPos++;
                }
                Point newPoint = new Point(xPos, yPos);
                if (cache.contains(newPoint)) {
                    visitedPos = Math.abs(xPos) + Math.abs(yPos);
                } else {
                    cache.add(newPoint);
                }
            }
        }
        return visitedPos;
    }


    /**
     * Determines the new heading
     *
     * @param currentHeading the current heading
     * @param nextMove       the next move
     * @return the new heading
     */
    private Heading determineHeading(final Heading currentHeading, final Move nextMove) {
        Heading newHeading;
        if (currentHeading == null) {
            newHeading = nextMove.getDirection() == R ? East : West;
        } else {
            switch (currentHeading) {
                case North:
                    newHeading = nextMove.getDirection() == R ? East : West;
                    break;
                case East:
                    newHeading = nextMove.getDirection() == R ? South : North;
                    break;
                case South:
                    newHeading = nextMove.getDirection() == R ? West : East;
                    break;
                case West:
                    newHeading = nextMove.getDirection() == R ? North : South;
                    break;
                default:
                    throw new IllegalArgumentException(
                            "Unsupported heading type: " + currentHeading);
            }
        }
        return newHeading;
    }


    static class Move {
        private final Direction _direction;
        private final int _steps;


        /**
         * Constructor
         *
         * @param steps     the amount of steps into the direction
         * @param direction the direction
         */
        public Move(final Direction direction, final int steps) {
            _direction = direction;
            _steps = steps;
        }


        /**
         * @return the amount of steps into the direction
         */
        public Direction getDirection() {
            return _direction;
        }


        /**
         * @return the direction
         */
        public int getSteps() {
            return _steps;
        }


        /**
         * a helper method to create a movement sequence based on an input string like "L1, R2, ..."
         *
         * @param input the input string
         * @return the movement array
         */
        public static Move[] from(final String input) {

            Pattern inputValidation = Pattern.compile("(L|R)\\d+");
            String[] moveInput = input.toUpperCase(Locale.getDefault()).split("\\s*,\\s*");
            Move[] moves = new Move[moveInput.length];

            for (int i = 0; i < moveInput.length; ++i) {
                Preconditions.checkArgument(inputValidation.matcher(moveInput[i]).matches(),
                        String.format(
                                "Unsupported movement instruction: %s. A direction and steps must be specified",
                                moveInput[i]));
                Direction direction = Direction.valueOf(moveInput[i].substring(0, 1));
                int steps = Integer.parseInt(moveInput[i].substring(1));
                moves[i] = new Move(direction, steps);
            }

            return moves;
        }
    }
}
