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

package com.scavi.brainsqueeze.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 20/01/17
 */
public class WinePartyTest {
    @Test
    public void test1() {
        WineParty wineParty = new WineParty();
        int[][] guestArrivals =
                new int[][]{new int[]{1800, 1814}, new int[]{1801, 1812}, new int[]{1800, 1813},
                            new int[]{1810, 1814}, new int[]{1812, 1814}, new int[]{1910, 1914},
                            new int[]{1912, 1915},};
        int minWineGlasses = wineParty.minGlasses(guestArrivals);
        Assert.assertEquals(5, minWineGlasses);
    }


    @Test
    public void test2() {
        WineParty wineParty = new WineParty();
        int[][] guestArrivals =
                new int[][]{new int[]{1800, 1814}, new int[]{1801, 1812}, new int[]{1800, 1813},
                            new int[]{1810, 1814}, new int[]{1812, 1814}, new int[]{1910, 1914},
                            new int[]{1912, 1915}, new int[]{2000, 2100}, new int[]{2001, 2100},
                            new int[]{2002, 2100}, new int[]{2003, 2100}, new int[]{2004, 2100},
                            new int[]{2005, 2100}, new int[]{2006, 2100}, new int[]{2007, 2100},
                            new int[]{2008, 2100}, new int[]{2009, 2100}, new int[]{2010, 2100}};
        int minWineGlasses = wineParty.minGlasses(guestArrivals);
        Assert.assertEquals(11, minWineGlasses);
    }
}
