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

import com.scavi.brainsqueeze.adventofcode2016.Day5NiceGameOfChess.PositionResultProcessor;
import com.scavi.brainsqueeze.adventofcode2016.Day5NiceGameOfChess.SimpleResultProcessor;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 06/12/16
 */
public class Day5NiceGameOfChessTest {

    @Test
    public void test1() throws Exception {
        String id = "abc";
        Day5NiceGameOfChess day5 = new Day5NiceGameOfChess(new SimpleResultProcessor());
        String password = day5.determinePassword(id);
        Assert.assertEquals("18f47a30", password);
    }


    @Test
    public void test2() throws Exception {
        String id = "abc";
        Day5NiceGameOfChess day5 = new Day5NiceGameOfChess(new PositionResultProcessor());
        String password = day5.determinePassword(id);
        Assert.assertEquals("05ace8e3", password);
    }


    @Test
    public void testQuestion1() throws Exception {
        String id = "cxdnnyjw";
        Day5NiceGameOfChess day5 = new Day5NiceGameOfChess(new SimpleResultProcessor());
        String password = day5.determinePassword(id);
        Assert.assertEquals("f77a0e6e", password);
    }


    @Test
    public void testQuestion2() throws Exception {
        String id = "cxdnnyjw";
        Day5NiceGameOfChess day5 = new Day5NiceGameOfChess(new PositionResultProcessor());
        String password = day5.determinePassword(id);
        Assert.assertEquals("999828ec", password);
    }
}
