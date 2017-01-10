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

/**
 * @author Michael Heymel
 * @since 18/11/16
 */
public class MazeField {
    private final FieldType _type;
    private int _steps;


    /**
     * Constructor
     *
     * @param isAccessible <code>true</code> the field is accessible <p/> <code>false</code> the
     *                     field is not accessible
     */
    public MazeField(final boolean isAccessible) {
        this(isAccessible ? FieldType.Field : FieldType.Wall);
    }


    /**
     * Constructor
     *
     * @param type the type of the field
     */
    public MazeField(final FieldType type) {
        _type = type;
        initialize();
    }


    /**
     * Initializes the maze field
     */
    protected void initialize() {
        _steps = Integer.MAX_VALUE;
    }


    /**
     * Set the given step to reach the field, if not already a shorter way was found
     *
     * @param steps the new steps to set
     * @return <code>true</code> the given steps were set
     * <p/>
     * <code>false</code> the given step weren't set
     */
    protected boolean setStepsIfShorter(final int steps) {
        boolean isShorter = false;
        if (steps < _steps) {
            _steps = steps;
            isShorter = true;
        }
        return isShorter;
    }


    /**
     * @return The number of steps to reach the field from the original starting position
     */
    protected int getSteps() {
        return _steps;
    }


    /**
     * @return the type of the field
     */
    protected FieldType getType() {
        return _type;
    }


    /**
     * @return the definition of the field
     */
    @Override
    public String toString() {
        return _type == FieldType.Wall ? "#" : " ";
    }
}
