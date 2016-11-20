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

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 15/11/16
 */
public class CircleTest {
    @Test
    public void testIntersectX() {
        Circle left = new Circle(-1, 1, 3);
        Circle right = new Circle(1, 1, 1);
        Assert.assertTrue(left.isIntersection(right));
        Assert.assertTrue(right.isIntersection(left));
    }


    @Test
    public void testIntersectUpY() {
        Circle up = new Circle(1, 3, 3);
        Circle down = new Circle(1, 0, 1);
        Assert.assertTrue(up.isIntersection(down));
        Assert.assertTrue(down.isIntersection(up));
    }


    @Test
    public void testOverlapCircle() {
        Circle in = new Circle(5, 5, 1);
        Circle out = new Circle(10, 10, 10);
        Assert.assertTrue(in.isIntersection(out));
        Assert.assertTrue(out.isIntersection(in));
    }


    @Test
    public void testNoIntersection() {
        Circle c1 = new Circle(3, 1, 1);
        Circle c2 = new Circle(6, 1, 1);
        Assert.assertFalse(c1.isIntersection(c2));
        Assert.assertFalse(c2.isIntersection(c1));
    }
}
