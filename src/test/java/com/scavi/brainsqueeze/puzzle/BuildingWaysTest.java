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

package com.scavi.brainsqueeze.puzzle;

import com.scavi.brainsqueeze.misc.BuildingWays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 20/11/16
 */
public class BuildingWaysTest {

    @Test
    public void testRecursive1() {
        BuildingWays ways = new BuildingWays();
        int output = ways.findWaysRecursive(3);
        Assert.assertEquals(4, output);
    }


    @Test
    public void testRecursive2() {
        BuildingWays ways = new BuildingWays();
        int output = ways.findWaysRecursive(1);
        Assert.assertEquals(1, output);
    }


    @Test
    public void testRecursive3() {
        BuildingWays ways = new BuildingWays();
        int output = ways.findWaysRecursive(10);
        Assert.assertEquals(274, output);
    }


    @Test
    public void testRecursive4() {
        BuildingWays ways = new BuildingWays();
        int output = ways.findWaysRecursive(17);
        Assert.assertEquals(19513, output);
    }


    @Test
    public void testRecursive5() {
        BuildingWays ways = new BuildingWays();
        int output = ways.findWaysRecursive(0);
        Assert.assertEquals(0, output);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testRecursive6() {
        BuildingWays ways = new BuildingWays();
        int output = ways.findWaysRecursive(-42);
        Assert.assertEquals(0, output);
    }


    @Test
    public void testDp1() {
        BuildingWays ways = new BuildingWays();
        int output = ways.findWaysDp(3);
        Assert.assertEquals(4, output);
    }


    @Test
    public void testDp2() {
        BuildingWays ways = new BuildingWays();
        int output = ways.findWaysDp(1);
        Assert.assertEquals(1, output);
    }


    @Test
    public void testDp3() {
        BuildingWays ways = new BuildingWays();
        int output = ways.findWaysDp(10);
        Assert.assertEquals(274, output);
    }


    @Test
    public void testDp4() {
        BuildingWays ways = new BuildingWays();
        int output = ways.findWaysDp(17);
        Assert.assertEquals(19513, output);
    }


    @Test
    public void testDp5() {
        BuildingWays ways = new BuildingWays();
        int output = ways.findWaysDp(0);
        Assert.assertEquals(0, output);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testDp6() {
        BuildingWays ways = new BuildingWays();
        int output = ways.findWaysDp(-42);
        Assert.assertEquals(0, output);
    }


    @Test
    public void testDp7() {
        BuildingWays ways = new BuildingWays();
        int output = ways.findWaysDp(57);
        Assert.assertEquals(2044889053, output);
    }
}
