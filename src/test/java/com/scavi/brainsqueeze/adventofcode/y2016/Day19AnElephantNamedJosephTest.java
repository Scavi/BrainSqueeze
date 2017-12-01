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

package com.scavi.brainsqueeze.adventofcode.y2016;

import com.scavi.brainsqueeze.adventofcode.y2016.Day19AnElephantNamedJoseph;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 19/12/16
 */
public class Day19AnElephantNamedJosephTest {
    @Test
    public void test1() {
        Day19AnElephantNamedJoseph anElephantNamedJoseph = new Day19AnElephantNamedJoseph();
        int pos = anElephantNamedJoseph.whoHasThePresentLeft(5);
        Assert.assertEquals(3, pos);
    }


    @Test
    public void test2() {
        Day19AnElephantNamedJoseph anElephantNamedJoseph = new Day19AnElephantNamedJoseph();
        int pos = anElephantNamedJoseph.whoHasThePresentOpposite(5);
        Assert.assertEquals(2, pos);
    }


    @Test
    public void test3() {
        Day19AnElephantNamedJoseph anElephantNamedJoseph = new Day19AnElephantNamedJoseph();
        int pos = anElephantNamedJoseph.whoHasThePresentOpposite(47);
        Assert.assertEquals(20, pos);
    }


    @Test
    public void test4() {
        Day19AnElephantNamedJoseph anElephantNamedJoseph = new Day19AnElephantNamedJoseph();
        int pos = anElephantNamedJoseph.whoHasThePresentOpposite(8);
        Assert.assertEquals(7, pos);
    }


    @Test
    public void test5() {
        Day19AnElephantNamedJoseph anElephantNamedJoseph = new Day19AnElephantNamedJoseph();
        int pos = anElephantNamedJoseph.whoHasThePresentOpposite(23);
        Assert.assertEquals(19, pos);
    }


    @Test
    public void test6() {
        Day19AnElephantNamedJoseph anElephantNamedJoseph = new Day19AnElephantNamedJoseph();
        int pos = anElephantNamedJoseph.whoHasThePresentOpposite(50);
        Assert.assertEquals(23, pos);
    }


    @Test
    public void test7() {
        Day19AnElephantNamedJoseph anElephantNamedJoseph = new Day19AnElephantNamedJoseph();
        int pos = anElephantNamedJoseph.whoHasThePresentOpposite(13);
        Assert.assertEquals(4, pos);
    }


    @Test
    public void testQuestion1() {
        Day19AnElephantNamedJoseph anElephantNamedJoseph = new Day19AnElephantNamedJoseph();
        int pos = anElephantNamedJoseph.whoHasThePresentLeft(3012210);
        Assert.assertEquals(1830117, pos);
    }


    @Test
    public void testQuestion2() {
        Day19AnElephantNamedJoseph anElephantNamedJoseph = new Day19AnElephantNamedJoseph();
        int pos = anElephantNamedJoseph.whoHasThePresentOpposite(3012210);
        Assert.assertEquals(1417887, pos);
    }
}
