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
import com.scavi.brainsqueeze.util.CompareFunction;
import com.scavi.brainsqueeze.util.StringHelper;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


/**
 * @author Michael Heymel
 * @since 17/12/16
 */
public class Day17TwoStepsForward {
    private final int _targetPos = 15;
    private final int _roomSize = 4;
    private final Set<Character> _openDoorIdentifier = new HashSet<>();
    private final Direction[] _directionPriority =
            new Direction[]{Direction.D, Direction.R, Direction.U, Direction.L};
    private final CompareFunction<String, String> _compareFunction;


    /**
     * Constructor
     * <p/>
     * Uses the {@link StringHelper#min(String, String)} function to determine the path
     */
    public Day17TwoStepsForward() {
        this(StringHelper::min);
    }


    /**
     * Constructor
     *
     * @param compareFunction the compare function to use
     */
    public Day17TwoStepsForward(CompareFunction<String, String> compareFunction) {
        _openDoorIdentifier.addAll(Arrays.asList('b', 'c', 'd', 'e', 'f'));
        _compareFunction = compareFunction;
    }


    /**
     * Determine the path using the specified compare function (e.g. shortest or longest) in the
     * specified 4x4 grid. The path will be determined by using an md5 and verify if the
     * corresponding position is one of the open door identifier. Each step into a direction (up,
     * down...) will create a different hash
     *
     * @param input the input to create the hash to determine the direction
     * @return the path
     */
    public String determinePath(final String input)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Preconditions.checkNotNull(input, "Illegal input: <null>");
        return determinePath(input, "", 0);
    }


    /**
     * Uses BFS and recursion to determine the path
     *
     * @param input the input to create the hash to determine the direction
     * @param path  the current path
     * @param pos   the current position in the 4x4 grid
     * @return the path
     */
    private String determinePath(final String input, final String path, int pos)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {

        if (pos == _targetPos) {
            return path;
        }

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String targetPath = null;
        Queue<Direction> possibleDirections = new LinkedList<>();
        do {
            md5.update((input + path).getBytes("UTF-8"));
            String keyHash = StringHelper.toHexString(md5.digest());
            // try to find movable positions
            for (int i = 0; i < _directionPriority.length; ++i) {
                Direction currentDirection = _directionPriority[i];
                if (_openDoorIdentifier.contains(keyHash.charAt(currentDirection.getPosition()))) {
                    if (isMoveable(pos, currentDirection)) {
                        possibleDirections.add(currentDirection);
                    }
                }
            }

            // iterate through all possible directions to find the shortest path
            while (possibleDirections.size() > 0) {
                Direction currentDirection = possibleDirections.poll();
                switch (currentDirection) {
                    case U:
                        targetPath = _compareFunction.call(determinePath(input,
                                path + Direction.U.toString(),
                                pos - _roomSize), targetPath);
                        break;
                    case D:
                        targetPath = _compareFunction.call(determinePath(input,
                                path + Direction.D.toString(),
                                pos + _roomSize), targetPath);
                        break;
                    case L:
                        targetPath = _compareFunction.call(determinePath(input,
                                path + Direction.L.toString(),
                                pos - 1), targetPath);
                        break;
                    case R:
                        targetPath = _compareFunction.call(determinePath(input,
                                path + Direction.R.toString(),
                                pos + 1), targetPath);
                        break;
                }
            }
        }
        while (possibleDirections.size() > 0);
        return targetPath;
    }


    /**
     * A helper function to verify if the direction is moveable (or outside of the 4x4 grid)
     *
     * @param currentPosition the current position
     * @param direction       the direction to move
     * @return <code>true</code> move is possible <p/> <code>false</code> move is not possible
     */
    private boolean isMoveable(final int currentPosition, final Direction direction) {
        boolean isToMove = false;
        switch (direction) {
            case U:
                isToMove = currentPosition >= _roomSize;
                break;
            case D:
                isToMove = currentPosition <= _targetPos - _roomSize;
                break;
            case L:
                isToMove = (currentPosition % _roomSize) != 0;
                break;
            case R:
                isToMove = ((currentPosition + 1) % _roomSize) != 0;
                break;
        }
        return isToMove;
    }


    private enum Direction {
        U(0), D(1), L(2), R(3);
        private final int _position;


        /**
         * Constructor
         *
         * @param position the lookup position inside the generated hash
         */
        Direction(final int position) {
            _position = position;
        }


        /**
         * @return the lookup position inside the generated hash
         */
        public int getPosition() {
            return _position;
        }
    }
}
