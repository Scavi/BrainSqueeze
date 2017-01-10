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

import com.google.common.base.Objects;

/**
 * @author Michael Heymel
 * @since 23/09/16
 */
public class Point {
    private final int _x;
    private final int _y;
    private final String _id;


    /**
     * Constructor
     *
     * @param x the x position of the current point
     * @param y the y position of the current point
     */
    public Point(final int x, final int y) {
        this(x, y, "");
    }


    /**
     * Constructor
     *
     * @param x  the x position of the current point
     * @param y  the y position of the current point
     * @param id the id of the point (optional)
     */
    public Point(final int x, final int y, final String id) {
        this._x = x;
        this._y = y;
        _id = id;
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
     * @return the hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(_x, _y);
    }


    /**
     * The equals method of the class
     *
     * @param obj the object to compare
     * @return true if objects are equal
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Point toCompare = (Point) obj;
        return Objects.equal(_x, toCompare.getX()) && Objects.equal(_y, toCompare.getY());
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
        return String.format("[ x=%s | y=%s | id=%s]", _x, _y, _id);
    }
}
