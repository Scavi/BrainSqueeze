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

import java.util.Locale;
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
    enum Heading {North, East, West, South}

    enum Direction {
        R, L;
    }


    /**
     * Determines the shortest
     *
     * @param movementSequence the given movement sequence
     * @return the shortest distance
     */
    public int shortestDistance(final Move... movementSequence) {
        Preconditions.checkNotNull(movementSequence, "Illegal movement sequence: <null>");
        Preconditions.checkArgument(movementSequence.length > 0,
                "Illegal movement sequence: 0 instructions");

        int xPos = 0;
        int yPos = 0;
        Heading heading = null;

        for (Move move : movementSequence) {
            heading = determineHeading(heading, move);

            switch (heading) {
                case North:
                    yPos += move.getSteps();
                    break;
                case East:
                    xPos += move.getSteps();
                    break;
                case South:
                    yPos -= move.getSteps();
                    break;
                case West:
                    xPos -= move.getSteps();
                    break;
            }
        }
        return Math.abs(xPos) + Math.abs(yPos);
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
