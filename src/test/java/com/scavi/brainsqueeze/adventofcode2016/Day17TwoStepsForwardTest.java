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

package com.scavi.brainsqueeze.adventofcode2016;

import com.scavi.brainsqueeze.util.StringHelper;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 17/12/16
 */
public class Day17TwoStepsForwardTest {

    @Test
    public void test1() throws Exception {
        Day17TwoStepsForward twoStepsForward = new Day17TwoStepsForward();
        String path = twoStepsForward.determinePath("ihgpwlah");
        Assert.assertEquals("DDRRRD", path);
    }


    @Test
    public void test2() throws Exception {
        Day17TwoStepsForward twoStepsForward = new Day17TwoStepsForward();
        String path = twoStepsForward.determinePath("kglvqrro");
        Assert.assertEquals("DDUDRLRRUDRD", path);
    }


    @Test
    public void test3() throws Exception {
        Day17TwoStepsForward twoStepsForward = new Day17TwoStepsForward();
        String path = twoStepsForward.determinePath("ulqzkmiv");
        Assert.assertEquals("DRURDRUDDLLDLUURRDULRLDUUDDDRR", path);
    }


    @Test
    public void test4() throws Exception {
        Day17TwoStepsForward twoStepsForward = new Day17TwoStepsForward(StringHelper::max);
        String path = twoStepsForward.determinePath("ihgpwlah");
        Assert.assertEquals(370, path.length());
    }


    @Test
    public void test5() throws Exception {
        Day17TwoStepsForward twoStepsForward = new Day17TwoStepsForward(StringHelper::max);
        String path = twoStepsForward.determinePath("kglvqrro");
        Assert.assertEquals(492, path.length());
    }


    @Test
    public void test6() throws Exception {
        Day17TwoStepsForward twoStepsForward = new Day17TwoStepsForward(StringHelper::max);
        String path = twoStepsForward.determinePath("ulqzkmiv");
        Assert.assertEquals(830, path.length());
    }


    @Test
    public void testQuestion1() throws Exception {
        Day17TwoStepsForward twoStepsForward = new Day17TwoStepsForward();
        String path = twoStepsForward.determinePath("yjjvjgan");
        Assert.assertEquals("RLDRUDRDDR", path);
    }


    @Test
    public void testQuestion2() throws Exception {
        Day17TwoStepsForward twoStepsForward = new Day17TwoStepsForward(StringHelper::max);
        String path = twoStepsForward.determinePath("yjjvjgan");
        Assert.assertEquals(498, path.length());
    }

}