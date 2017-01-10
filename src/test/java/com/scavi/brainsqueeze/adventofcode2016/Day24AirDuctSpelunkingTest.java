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

import com.scavi.brainsqueeze.util.FileHelper;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * @author Michael Heymel
 * @since 25/12/16
 */
public class Day24AirDuctSpelunkingTest {
    @Test
    public void test1() {
        final String[] structure =
                new String[]{"###########",
                             "#0.1.....2#",
                             "#.#######.#",
                             "#4.......3#",
                             "###########"};
        Day24AirDuctSpelunking airDuctSpelunking = new Day24AirDuctSpelunking();
        int shortestPath = airDuctSpelunking.shortestBypass(structure);
        Assert.assertEquals(14, shortestPath);
    }


    @Test
    public void test2() {
        final String[] structure =
                new String[]{"###########",
                             "#0.1.....2#",
                             "####.####.#",
                             "#4.#.....3#",
                             "##...#5####"};
        Day24AirDuctSpelunking airDuctSpelunking = new Day24AirDuctSpelunking();
        int shortestPath = airDuctSpelunking.shortestBypass(structure);
        Assert.assertEquals(22, shortestPath);
    }


    @Test
    public void test3() {
        final String[] structure =
                new String[]{"###########",
                             "#0.1.....2#",
                             "#.#######.#",
                             "#4.......3#",
                             "###########"};
        Day24AirDuctSpelunking airDuctSpelunking = new Day24AirDuctSpelunking(true);
        int shortestPath = airDuctSpelunking.shortestBypass(structure);
        Assert.assertEquals(20, shortestPath);
    }


    @Test
    public void test4() {
        final String[] structure =
                new String[]{"###########",
                             "#0.1.....2#",
                             "####.####.#",
                             "#4.#.....3#",
                             "##...#5####"};
        Day24AirDuctSpelunking airDuctSpelunking = new Day24AirDuctSpelunking(true);
        int shortestPath = airDuctSpelunking.shortestBypass(structure);
        Assert.assertEquals(32, shortestPath);
    }


    @Test
    public void testQuestion1() throws Exception {
        File inputFile = FileHelper.forUnitTests("adventofcode2016/Day24.txt");
        String[] structure = FileHelper.readLines(inputFile);
        Day24AirDuctSpelunking airDuctSpelunking = new Day24AirDuctSpelunking();
        int shortestPath = airDuctSpelunking.shortestBypass(structure);
        Assert.assertEquals(462, shortestPath);
    }

    @Test
    public void testQuestion2() throws Exception {
        File inputFile = FileHelper.forUnitTests("adventofcode2016/Day24.txt");
        String[] structure = FileHelper.readLines(inputFile);
        Day24AirDuctSpelunking airDuctSpelunking = new Day24AirDuctSpelunking(true);
        int shortestPath = airDuctSpelunking.shortestBypass(structure);
        Assert.assertEquals(676, shortestPath);
    }
}
