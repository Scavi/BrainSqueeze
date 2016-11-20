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

import com.google.common.base.Preconditions;

/**
 * @author Michael Heymel
 * @since 15/11/16
 */
public class Circle implements Comparable<Circle> {

    private final Point _coordinate;
    private final int _radius;


    /**
     * Constructor
     *
     * @param x      the x coordinate of the center of the cycle
     * @param y      the y coordinate of the center of teh cycle
     * @param radius the radius of the cycle
     */
    public Circle(final int x, final int y, final int radius) {
        this(new Point(x, y), radius);
    }


    /**
     * Constructor
     *
     * @param coordinate the x and y coordinate of the center of the cycle
     * @param radius     the radius of the cycle
     */
    public Circle(final Point coordinate, final int radius) {
        Preconditions.checkNotNull(coordinate, "Illegal coordinate: <null>");
        _coordinate = coordinate;
        _radius = radius;
    }


    /**
     * Validates if the given circle intersects the current circle
     *
     * @param circle the circle to validate
     * @return <code>true</code> both circle intersect
     * <p/>
     * <code>false</code> both circle don't intersect
     */
    public boolean isIntersection(final Circle circle) {
        if (circle == null) {
            return false;
        }
        int distanceX = _coordinate.getX() - circle.getCoordinate().getX();
        int distanceY = _coordinate.getY() - circle.getCoordinate().getY();
        int distanceR = _radius + circle.getRadius();
        // TODO can be done quicker avoiding sqrt
        return Math.hypot(distanceX, distanceY) < distanceR;
    }


    /**
     * @return the x and y coordinate of the center of the cycle
     */
    public Point getCoordinate() {
        return _coordinate;
    }


    /**
     * @return the radius of the cycle
     */
    public int getRadius() {
        return _radius;
    }


    @Override
    public int compareTo(final Circle toCompare) {
        int toCompareRightSide = toCompare.getCoordinate().getX() + toCompare.getRadius();
        int thisRightSide = getCoordinate().getX() + getRadius();
        return thisRightSide - toCompareRightSide;
    }


    @Override
    public String toString() {
        return String.format("[ x=%s | y=%s ] (%s)",
                getCoordinate().getX(),
                getCoordinate().getY(),
                getRadius());
    }
}
