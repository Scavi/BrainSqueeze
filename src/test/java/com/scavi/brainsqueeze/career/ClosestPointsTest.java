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

package com.scavi.brainsqueeze.career;

import com.scavi.brainsqueeze.util.Point;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Scavenger on 5/13/2017.
 */
public class ClosestPointsTest {
    @Test
    public void test1() {
        Point pA = new Point(4, 2, "a");
        Point pB = new Point(6, 1, "b");
        Point pC = new Point(1, 1, "c");
        Point pD = new Point(5, 2, "d");
        Point pE = new Point(1, 3, "e");

        ArrayList<Point> input = new ArrayList<>(Arrays.asList(pA, pB, pC, pD, pE));
        Point pOrigin = new Point(0, 0, "o");
        List<Point> result = new ClosestPoints().findClosestPoints(input, pOrigin, 2);
        int i = 0;
    }
}
