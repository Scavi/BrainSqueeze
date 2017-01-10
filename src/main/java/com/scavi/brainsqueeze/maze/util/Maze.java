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

package com.scavi.brainsqueeze.maze.util;

import com.google.common.base.Preconditions;
import com.scavi.brainsqueeze.util.Point;

import static com.scavi.brainsqueeze.maze.util.FieldType.Field;

/**
 * @author Michael Heymel
 * @since 18/11/16
 */
public class Maze {
    public static final int ILLEGAL_POSITION = -1;
    private final MazeField[][] _fields;
    private final int _mazeHeight;
    private final int _mazeWidth;


    /**
     * Constructor
     *
     * @param fields the fields of the maze
     */
    public Maze(final MazeField[][] fields) {
        Preconditions.checkNotNull(fields, "Illegal maze fields: <null>");
        Preconditions.checkArgument(fields.length != 0, "Illegal maze fields: <empty column>");
        Preconditions.checkArgument(fields[0].length != 0, "Illegal maze fields: <empty row>");
        _fields = fields;
        _mazeHeight = _fields.length;
        _mazeWidth = _fields[0].length;
    }


    /**
     * Re-initializes the field of the matrix
     *
     * @param startPosition the start position within the maze
     */
    public void reinitializeMaze(final Point startPosition) {
        for (int y = 0; y < _mazeHeight; ++y) {
            for (int x = 0; x < _mazeWidth; ++x) {
                _fields[y][x].initialize();
            }
        }
        int position = positionOfPoint(startPosition);
        getField(position).setStepsIfShorter(0);
    }


    /**
     * Verifies if the given point is inside the matrix
     *
     * @param point the point to validate
     * @return the point is inside the matrix
     */
    public boolean isInsideTheMaze(final Point point) {
        return positionOfPoint(point) < _mazeWidth * _mazeHeight;
    }


    /**
     * Translates the given point to it's integer representation
     *
     * @param point the point to convert
     * @return the position representation of the given point
     */
    public int positionOfPoint(final Point point) {
        return (point.getY() * _mazeWidth) + point.getX();
    }


    /**
     * Determines movement position up of the current position if possible. If it is not
     * possible return <code>{@link #ILLEGAL_POSITION}</code>
     *
     * @param currentPosition the current position
     * @return the position or <code>{@link #ILLEGAL_POSITION}</code>
     */
    public int determineMoveUpPos(final int currentPosition) {
        int toPosition = currentPosition - _mazeWidth;
        if (toPosition >= 0) {
            return tryMove(currentPosition, toPosition) ? toPosition : ILLEGAL_POSITION;
        }
        return ILLEGAL_POSITION;
    }


    /**
     * Determines movement position below of the current position if possible. If it is not
     * possible return <code>{@link #ILLEGAL_POSITION}</code>
     *
     * @param currentPosition the current position
     * @return the position or <code>{@link #ILLEGAL_POSITION}</code>
     */
    public int determineMoveDownPos(final int currentPosition) {
        int toPosition = currentPosition + _mazeWidth;
        if (toPosition < (_mazeWidth * _mazeHeight)) {
            return tryMove(currentPosition, toPosition) ? toPosition : ILLEGAL_POSITION;
        }
        return ILLEGAL_POSITION;
    }


    /**
     * Determines movement position to the left of the current position if possible. If it is not
     * possible return <code>{@link #ILLEGAL_POSITION}</code>
     *
     * @param currentPosition the current position
     * @return the position or <code>{@link #ILLEGAL_POSITION}</code>
     */
    public int determineMoveLeftPos(final int currentPosition) {
        int toPosition = currentPosition - 1;
        if ((currentPosition % _mazeWidth) > (toPosition % _mazeWidth)) {
            return tryMove(currentPosition, toPosition) ? toPosition : ILLEGAL_POSITION;
        }
        return ILLEGAL_POSITION;
    }


    /**
     * Determines movement position to the right of the current position if possible. If it is not
     * possible return <code>{@link #ILLEGAL_POSITION}</code>
     *
     * @param currentPosition the current position
     * @return the position or <code>{@link #ILLEGAL_POSITION}</code>
     */
    public int determineMoveRightPos(final int currentPosition) {
        int toPosition = currentPosition + 1;
        if ((currentPosition % _mazeWidth) < (toPosition % _mazeWidth)) {
            return tryMove(currentPosition, toPosition) ? toPosition : ILLEGAL_POSITION;
        }
        return ILLEGAL_POSITION;
    }


    /**
     * Tries to move from the given position to the given position. Validates if the position is
     * inside the matrix (not <code>{@link #ILLEGAL_POSITION}</code>, if the field is accessible,
     * and if the move was quicker
     *
     * @param fromPosition the position to move from
     * @param toPosition   the position to move to
     * @return <code>true</code> move could be executed
     * <p/>
     * <code>false</code> the move could not be executed
     */
    private boolean tryMove(final int fromPosition, final int toPosition) {
        if (toPosition == ILLEGAL_POSITION || !isAccessible(toPosition)) {
            return false;
        }
        MazeField from = getField(fromPosition);
        MazeField to = getField(toPosition);
        return to.setStepsIfShorter(from.getSteps() + 1);
    }


    /**
     * The minimal required steps to reach this field
     *
     * @param pos the current position representing the maze field by it's x,y coordinates
     * @return the minimal amount of steps that are required to reach the field from the original
     * start point
     */
    public int stepsRequired(final int pos) {
        return getField(pos).getSteps();
    }


    /**
     * Validates if the field is accessible (and not blocked / wall)
     *
     * @param position the current position representing the maze field by it's x,y coordinates
     * @return <code>true</code> the field is accessible
     * <p/>
     * <code>false</code> the field is blocked
     */
    public boolean isAccessible(final Point position) {
        return isAccessible(positionOfPoint(position));
    }


    /**
     * Validates if the field is accessible (and not blocked / wall)
     *
     * @param pos the current position representing the maze field by it's x,y coordinates
     * @return <code>true</code> the field is accessible
     * <p/>
     * <code>false</code> the field is blocked
     */
    private boolean isAccessible(final int pos) {
        return getField(pos).getType() == Field;
    }


    /**
     * A helper method to determine the field within the matrix by calculating it's x,y coordinates
     * by the given position
     *
     * @param pos the current position representing the maze field by its x,y coordinates
     * @return the maze field
     */
    private MazeField getField(final int pos) {
        return _fields[pos / _mazeWidth][pos % _mazeWidth];
    }


    /**
     * Helper method to create a maze from the given boolean array. In case of <code>true</code> the
     * field is accessible, otherwise not
     *
     * @param structure the maze structure
     * @return the maze based on the given structure
     */
    public static Maze from(final boolean[][] structure) {
        Preconditions.checkNotNull(structure, "Illegal maze fields: <null >");
        Preconditions.checkArgument(structure.length != 0, "Illegal maze fields: <empty column>");
        Preconditions.checkArgument(structure[0].length != 0, "Illegal maze fields: <empty row>");

        MazeField[][] mazeFields = new MazeField[structure.length][structure[0].length];

        for (int y = 0; y < structure.length; ++y) {
            for (int x = 0; x < structure[0].length; ++x) {
                mazeFields[y][x] = new MazeField(structure[y][x]);
            }
        }
        return new Maze(mazeFields);
    }


    /**
     * Helper method to create a maze from a given String array. The structure supports wall / non
     * wall
     *
     * @param structure the string array
     * @param wall      the representing character for a wall
     * @return the maze based on the given structure
     */
    public static Maze from(final String[] structure, final char wall) {
        Preconditions.checkNotNull(structure, "Illegal maze fields: <null >");
        Preconditions.checkArgument(structure.length != 0, "Illegal maze fields: <empty column>");

        int length = -1;
        MazeField[][] mazeFields = new MazeField[structure.length][structure[0].length()];
        for (int y = 0; y < structure.length; ++y) {
            for (int x = 0; x < structure[y].length(); ++x) {
                if (length != -1) {
                    Preconditions.checkArgument(length == structure[y].length(),
                            String.format("Illegal structure. Length is not equal (%s -> %s)",
                                    length,
                                    structure[y].length()));
                }
                mazeFields[y][x] = new MazeField(structure[y].charAt(x) != wall);
                length = structure[y].length();
            }
        }
        return new Maze(mazeFields);
    }
}
