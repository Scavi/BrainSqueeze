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
 * @since 21/12/16
 */
public class Day21ScrambledLettersAndHashTest {
    @Test
    public void testSwap1() {
        String[] operations =
                new String[]{"swap position 4 with position 0", "swap letter d with letter b"};
        Day21ScrambledLettersAndHash scrambler = new Day21ScrambledLettersAndHash();
        String password = scrambler.scramble("abcde", operations);
        Assert.assertEquals("edcba", password);
    }


    @Test
    public void testMove1() {
        String[] operations =
                new String[]{"move position 1 to position 4", "move position 3 to position 0"};
        Day21ScrambledLettersAndHash scrambler = new Day21ScrambledLettersAndHash();
        String password = scrambler.scramble("bcdea", operations);
        Assert.assertEquals("abdec", password);
    }


    @Test
    public void testReverse() {
        String[] operations = new String[]{"reverse positions 0 through 4"};
        Day21ScrambledLettersAndHash scrambler = new Day21ScrambledLettersAndHash();
        String password = scrambler.scramble("edcba", operations);
        Assert.assertEquals("abcde", password);
    }


    @Test
    public void testRotate1() {
        String[] operations = new String[]{"rotate left 1 step"};
        Day21ScrambledLettersAndHash scrambler = new Day21ScrambledLettersAndHash();
        String password = scrambler.scramble("abcde", operations);
        Assert.assertEquals("bcdea", password);
    }


    @Test
    public void testRotate2() {
        String[] operations = new String[]{"rotate right 2 steps"};
        Day21ScrambledLettersAndHash scrambler = new Day21ScrambledLettersAndHash();
        String password = scrambler.scramble("abcde", operations);
        Assert.assertEquals("deabc", password);
    }


    @Test
    public void testRotate3() {
        String[] operations = new String[]{"rotate based on position of letter b",
                                           "rotate based on position of letter d"};
        Day21ScrambledLettersAndHash scrambler = new Day21ScrambledLettersAndHash();
        String password = scrambler.scramble("abdec", operations);
        Assert.assertEquals("decab", password);
    }


    @Test
    public void test1() {
        String[] operations =
                new String[]{"swap position 4 with position 0", "swap letter d with letter b",
                             "reverse positions 0 through 4", "rotate left 1 step",
                             "move position 1 to position 4", "move position 3 to position 0",
                             "rotate based on position of letter b",
                             "rotate based on position of letter d"};
        Day21ScrambledLettersAndHash scrambler = new Day21ScrambledLettersAndHash();
        String password = scrambler.scramble("abcde", operations);
        Assert.assertEquals("decab", password);
    }


    @Test
    public void testQuestion1() throws Exception {
        Day21ScrambledLettersAndHash scrambler = new Day21ScrambledLettersAndHash();
        File inputFile = FileHelper.forUnitTests("adventofcode2016/Day21.txt");
        String[] operations = FileHelper.readLines(inputFile);
        String password = scrambler.scramble("abcdefgh", operations);
        Assert.assertEquals("dgfaehcb", password);
    }


    @Test
    public void testQuestion2() throws Exception {
        Day21ScrambledLettersAndHash scrambler = new Day21ScrambledLettersAndHash();
        File inputFile = FileHelper.forUnitTests("adventofcode2016/Day21.txt");
        String[] operations = FileHelper.readLines(inputFile);
        String password = scrambler.unscramble("fbgdceah", operations);
        Assert.assertEquals("fdhgacbe", password);
    }
}
