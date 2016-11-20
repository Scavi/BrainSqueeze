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

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 18/11/16
 */
public class CircleIntersectionTest {


    @Test
    public void testExistingIntersection() {
        Circle[] circles =
                new Circle[]{new Circle(3, 0, 1), new Circle(10, 0, 1), new Circle(0, 0, 1),
                             new Circle(9, 0, 1), new Circle(6, 0, 1)};

        CircleIntersection intersectionValidator = new CircleIntersection();
        boolean isIntersection = intersectionValidator.areIntersectingCirclesExists(circles);
        Assert.assertTrue(isIntersection);
    }


    @Test
    public void testNoIntersection() {
        Circle[] circles = new Circle[]{
                new Circle(3, 0, 1), new Circle(12, 0, 1), new Circle(0, 0, 1), new Circle(9, 0, 1),
                new Circle(6, 0, 1)};

        CircleIntersection intersectionValidator = new CircleIntersection();
        boolean isIntersection = intersectionValidator.areIntersectingCirclesExists(circles);
        if (isIntersection) {
            intersectionValidator.areIntersectingCirclesExists(circles);
        }
        Assert.assertFalse(isIntersection);
    }
}
