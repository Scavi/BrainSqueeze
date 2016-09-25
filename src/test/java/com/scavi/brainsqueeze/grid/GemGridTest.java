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

package com.scavi.brainsqueeze.grid;

import com.scavi.brainsqueeze.util.Point;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Michael Heymel
 * @since 23/09/16
 */
public class GemGridTest {

    @Test
    public void test1() {

        Calendar c = Calendar.getInstance();
        c.setTime(new Date(System.currentTimeMillis()));
        c.add(Calendar.DAY_OF_YEAR, 1);

        int d = c.get(Calendar.DAY_OF_WEEK);


        GemGrid gemGrid = new GemGrid();
        Point positionPlayer1 = new Point(0, 0);
        Point positionPlayer2 = new Point(3, 6);
        Point positionGem1 = new Point(1, 1);
        Point positionGem2 = new Point(1, 5);
        Point positionGem3 = new Point(3, 0);
        Point positionGem4 = new Point(3, 1);
        Point positionGem5 = new Point(2, 3);
        int minMoves = gemGrid.determineMinimumMoves(positionPlayer1,
                positionPlayer2,
                positionGem1,
                positionGem2,
                positionGem3,
                positionGem4,
                positionGem5);
        Assert.assertEquals(8, minMoves);
    }
}
