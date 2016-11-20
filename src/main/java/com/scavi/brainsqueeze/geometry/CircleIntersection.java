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

package com.scavi.brainsqueeze.geometry;

import com.scavi.brainsqueeze.util.Circle;

import java.util.Random;

/**
 * @author Michael Heymel
 * @since 15/11/16
 */
public class CircleIntersection {
    private Random _random = new Random();


    /**
     * This method validates if two circles within the given array of circles have an intersection.
     * The algorithm uses some sort of quick sort to determine if circles have an intersection.
     * In the worst case, the method will take O(n^2), on average or best case it runs in O(n log n)
     * The method will change the order of the circles in the array.
     *
     * @param circles the circles to validate
     * @return <code>true</code> at least two circles have an intersection
     * <p/>
     * <code>false</code> the circles in the given array don't have an intersection.
     */
    public boolean areIntersectingCirclesExists(final Circle[] circles) {
        if (circles == null || circles.length < 2) {
            return false;
        }
        return areIntersectingCirclesExists(circles, 0, circles.length - 1);
    }


    /**
     * This method validates if two circles within the given array of circles have an intersection.
     * The algorithm uses some sort of quick sort to determine if circles have an intersection.
     * In the worst case, the method will take O(n^2), on average or best case it runs in O(n log n)
     *
     * @param circles  the circles to validate
     * @param startPos the current start pos
     * @param endPos   the current end
     * @return <code>true</code> at least two circles have an intersection
     * <p/>
     * <code>false</code> the circles in the given array don't have an intersection.
     */
    private boolean areIntersectingCirclesExists(final Circle[] circles, final int startPos,
            final int endPos) {

        boolean isIntersection = false;
        if (endPos > startPos) {
            int pivotPos = determinePivotPos(startPos, endPos);
            if (pivotPos != startPos) {
                switchElements(circles, startPos, pivotPos);
            }
            Circle pivot = circles[startPos];

            int indexLeft = startPos + 1;
            int indexRight = endPos;
            while (indexRight > indexLeft && !isIntersection) {

                while (circles[indexLeft].compareTo(pivot) <= 0 && indexLeft < indexRight &&
                        indexLeft <= endPos) {
                    isIntersection = circles[indexLeft].isIntersection(pivot);
                    indexLeft++;
                }
                while (circles[indexRight].compareTo(pivot) > 0 && indexRight >= indexLeft &&
                        indexRight >= startPos) {
                    isIntersection = circles[indexRight].isIntersection(pivot);
                    indexRight--;
                }
                if (indexLeft < indexRight) {
                    switchElements(circles, indexLeft, indexRight);
                }
            }


            if (!isIntersection) {
                switchElements(circles, indexRight, startPos);
                isIntersection = areIntersectingCirclesExists(circles, startPos, indexRight - 1);
                if (!isIntersection) {
                    isIntersection = areIntersectingCirclesExists(circles, indexRight + 1, endPos);
                }
            }
        }
        return isIntersection;
    }


    /**
     * Determines the pivot pos (median of 3). This should reduce the probability an O(n^2) runtime.
     *
     * @param startPos the start pos of the array
     * @param endPos   the end pos of the array
     * @return the pivot pos
     */
    private int determinePivotPos(final int startPos, final int endPos) {
        int base = endPos - startPos;
        int pos1 = _random.nextInt(base);
        int pos2 = _random.nextInt(base);
        int pos3 = _random.nextInt(base);
        int mid = Math.min(Math.max(pos1, pos2), pos3);
        return mid + startPos;
    }


    /**
     * Switches pos1 and pos2 in the given array
     *
     * @param circles the circles to validate
     * @param pos1    the position 1 to switch
     * @param pos2    the position 2 to switch
     */
    private void switchElements(final Circle[] circles, final int pos1, final int pos2) {
        if (pos1 != pos2) {
            Circle tmp = circles[pos1];
            circles[pos1] = circles[pos2];
            circles[pos2] = tmp;
        }
    }

}
