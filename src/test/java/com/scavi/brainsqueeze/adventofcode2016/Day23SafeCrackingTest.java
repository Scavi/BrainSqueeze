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
import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Heymel
 * @since 25/12/16
 */
public class Day23SafeCrackingTest {
    @Test
    public void test1() {
        String[] instructions =
                new String[]{"cpy 2 a", "tgl a", "tgl a", "tgl a", "cpy 1 a", "dec a", "dec a"};
        Day23SafeCracking safeCracking = new Day23SafeCracking();
        int registerValue = safeCracking.determineRegisterValue(instructions, 'a');
        Assert.assertEquals(3, registerValue);
    }


    @Test
    public void testQuestion1() throws Exception {
        Day23SafeCracking gridComputing = new Day23SafeCracking();
        File inputFile = FileHelper.forUnitTests("adventofcode2016/Day23.txt");
        String[] instructions = FileHelper.readLines(inputFile);
        Map<Character, Integer> registerValues = new HashMap<>();
        registerValues.put('a', 7);
        registerValues.put('b', 0);
        registerValues.put('c', 0);
        registerValues.put('d', 0);

        int registerValue = gridComputing.determineRegisterValue(instructions, registerValues, 'a');
        Assert.assertEquals(10223, registerValue);
    }


    @Test
    public void testQuestion2() throws Exception {
        Day23SafeCracking gridComputing = new Day23SafeCracking();
        File inputFile = FileHelper.forUnitTests("adventofcode2016/Day23.txt");
        String[] instructions = FileHelper.readLines(inputFile);
        Map<Character, Integer> registerValues = new HashMap<>();
        registerValues.put('a', 12);
        registerValues.put('b', 0);
        registerValues.put('c', 0);
        registerValues.put('d', 0);

        int registerValue = gridComputing.determineRegisterValue(instructions, registerValues, 'a');
        Assert.assertEquals(479006783, registerValue);
    }
}
