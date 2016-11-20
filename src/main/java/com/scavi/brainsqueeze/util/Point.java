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

package com.scavi.brainsqueeze.util;

/**
 * @author Michael Heymel
 * @since 23/09/16
 */
public class Point {
    private final int _x;
    private final int _y;


    /**
     * Constructor
     *
     * @param x the x position of the current point
     * @param y the y position of the current point
     */
    public Point(final int x, final int y) {
        this._x = x;
        this._y = y;
    }


    /**
     * Determines the distance between the current and the given point. All 8 movement directions
     * are allowed.
     * <p/>
     * This algorithm determines the max distance of x1 -> x2 and y1 -> y2. Because all 8 movement
     * directions are allowed, this is the distance between both points
     *
     * @param otherPoint the other point
     * @return the distance between the current point and the other point
     */
    public int distanceTo(final Point otherPoint) {

        int disX = Math.abs(_x - otherPoint.getX());
        int disY = Math.abs(_y - otherPoint.getY());
        return Math.max(disX, disY);
    }


    /**
     * @return the x position of the current point
     */
    public int getX() {
        return _x;
    }


    /**
     * @return the y position of the current point
     */
    public int getY() {
        return _y;
    }


    @Override
    public String toString() {
        return String.format("[ x=%s | y=%s ]", _x, _y);
    }
}
