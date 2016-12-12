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
 * @since 12/12/16
 */
public class Day12LeonardoMonorailTest {

    @Test
    public void test1() {
        String[] input = new String[]{"cpy 41 a", "inc a", "inc a", "dec a", "jnz a 2", "dec a"};
        Day12LeonardoMonorail leonardosMonorail = new Day12LeonardoMonorail();
        int value = leonardosMonorail.determineRegisterValue(input, getQ1StartMap(), 'a');
        Assert.assertEquals(42, value);
    }


    @Test
    public void testQuestion1() throws Exception {
        File inputFile = FileHelper.forUnitTests("adventofcode2016/Day12.txt");
        String[] instructions = FileHelper.readLines(inputFile);
        Day12LeonardoMonorail leonardosMonorail = new Day12LeonardoMonorail();
        int value = leonardosMonorail.determineRegisterValue(instructions, getQ1StartMap(), 'a');
        Assert.assertEquals(318077, value);
    }


    @Test
    public void testQuestion2() throws Exception {
        File inputFile = FileHelper.forUnitTests("adventofcode2016/Day12.txt");
        String[] instructions = FileHelper.readLines(inputFile);
        Day12LeonardoMonorail leonardosMonorail = new Day12LeonardoMonorail();
        int value = leonardosMonorail.determineRegisterValue(instructions, getQ2StartMap(), 'a');
        Assert.assertEquals(9227731, value);
    }


    private Map<Character, Integer> getQ1StartMap() {
        Map<Character, Integer> registerValues = new HashMap<>();
        registerValues.put('a', 0);
        registerValues.put('b', 0);
        registerValues.put('c', 0);
        registerValues.put('d', 0);
        return registerValues;
    }


    private Map<Character, Integer> getQ2StartMap() {
        Map<Character, Integer> registerValues = new HashMap<>();
        registerValues.put('a', 0);
        registerValues.put('b', 0);
        registerValues.put('c', 1);
        registerValues.put('d', 0);
        return registerValues;
    }
}
