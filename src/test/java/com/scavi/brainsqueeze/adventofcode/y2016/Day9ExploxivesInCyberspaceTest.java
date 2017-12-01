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

import com.scavi.brainsqueeze.adventofcode.y2016.Day9ExploxivesInCyberspace;
import com.scavi.brainsqueeze.util.FileHelper;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * @author Michael Heymel
 * @since 09/12/16
 */
public class Day9ExploxivesInCyberspaceTest {

    @Test
    public void test1() {
        String[] input = new String[]{"ADVENT"};
        Day9ExploxivesInCyberspace exploxivesInCyberspace = new Day9ExploxivesInCyberspace();
        long length = exploxivesInCyberspace.decode(input);
        Assert.assertEquals(6, length);
    }


    @Test
    public void test2() {
        String[] input = new String[]{"A(1x5)BC"}; // ABBBBBC
        Day9ExploxivesInCyberspace exploxivesInCyberspace = new Day9ExploxivesInCyberspace();
        long length = exploxivesInCyberspace.decode(input);
        Assert.assertEquals(7, length);
    }


    @Test
    public void test3() {
        String[] input = new String[]{"(3x3)XYZ"}; // XYZXYZXYZ
        Day9ExploxivesInCyberspace exploxivesInCyberspace = new Day9ExploxivesInCyberspace();
        long length = exploxivesInCyberspace.decode(input);
        Assert.assertEquals(9, length);
    }


    @Test
    public void test4() {
        String[] input = new String[]{"A(2x2)BCD(2x2)EFG"}; // ABCBCDEFEFG
        Day9ExploxivesInCyberspace exploxivesInCyberspace = new Day9ExploxivesInCyberspace();
        long length = exploxivesInCyberspace.decode(input);
        Assert.assertEquals(11, length);
    }


    @Test
    public void test5() {
        String[] input = new String[]{"(6x1)(1x3)A"}; // (1x3)A
        Day9ExploxivesInCyberspace exploxivesInCyberspace = new Day9ExploxivesInCyberspace();
        long length = exploxivesInCyberspace.decode(input);
        Assert.assertEquals(6, length);
    }


    @Test
    public void test6() {
        String[] input = new String[]{"X(8x2)(3x3)ABCY"}; // X(3x3)ABC(3x3)ABCY
        Day9ExploxivesInCyberspace exploxivesInCyberspace = new Day9ExploxivesInCyberspace();
        long length = exploxivesInCyberspace.decode(input);
        Assert.assertEquals(18, length);
    }


    @Test
    public void test7() {
        String[] input = new String[]{"(3x3)XYZ"}; // XYZXYZXYZ
        Day9ExploxivesInCyberspace exploxivesInCyberspace = new Day9ExploxivesInCyberspace(true);
        long length = exploxivesInCyberspace.decode(input);
        Assert.assertEquals(9, length);
    }


    @Test
    public void test8() {
        String[] input = new String[]{"X(8x2)(3x3)ABCY"};
        Day9ExploxivesInCyberspace exploxivesInCyberspace = new Day9ExploxivesInCyberspace(true);
        long length = exploxivesInCyberspace.decode(input);
        Assert.assertEquals("XABCABCABCABCABCABCY".length(), length);
    }


    @Test
    public void test9() {
        String[] input = new String[]{"(27x12)(20x12)(13x14)(7x10)(1x12)A"};
        Day9ExploxivesInCyberspace exploxivesInCyberspace = new Day9ExploxivesInCyberspace(true);
        long length = exploxivesInCyberspace.decode(input);
        Assert.assertEquals(241920, length);
    }


    @Test
    public void test10() {
        String[] input = new String[]{"(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX(18x9)(3x2)TWO(5x7)SEVEN"};
        Day9ExploxivesInCyberspace exploxivesInCyberspace = new Day9ExploxivesInCyberspace(true);
        long length = exploxivesInCyberspace.decode(input);
        Assert.assertEquals(445, length);
    }


    @Test
    public void test11() {
        String[] input = new String[]{"(15x3)(3x3)ABC(2x3)XY"};
        Day9ExploxivesInCyberspace exploxivesInCyberspace = new Day9ExploxivesInCyberspace(true);
        long length = exploxivesInCyberspace.decode(input);
        Assert.assertEquals("ABCABCABCNYNYNYABCABCABCNYNYNYABCABCABCNYNYNY".length(), length);
    }


    @Test
    public void test12() {
        String[] input = new String[]{"(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX"};
        Day9ExploxivesInCyberspace exploxivesInCyberspace = new Day9ExploxivesInCyberspace(true);
        long length = exploxivesInCyberspace.decode(input);
        Assert.assertEquals(
                "ABCABCABCNYNYNYPQRSTPQRSTABCABCABCNYNYNYPQRSTPQRSTABCABCABCNYNYNYPQRSTPQRSTX".length(),
                length);
    }


    @Test
    public void test13() {
        String[] input = new String[]{"X(8x2)(4x3)ABCD"};
        Day9ExploxivesInCyberspace exploxivesInCyberspace = new Day9ExploxivesInCyberspace(true);
        long length = exploxivesInCyberspace.decode(input);
        Assert.assertEquals(26, length);
    }


    @Test
    public void testQuestion1() throws Exception {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2016/Day9.txt");
        Day9ExploxivesInCyberspace exploxivesInCyberspace = new Day9ExploxivesInCyberspace();
        String[] input = FileHelper.readLines(inputFile);
        long length = exploxivesInCyberspace.decode(input);
        Assert.assertEquals(123908, length);
    }


    @Test
    public void testQuestion2() throws Exception {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2016/Day9.txt");
        Day9ExploxivesInCyberspace exploxivesInCyberspace = new Day9ExploxivesInCyberspace(true);
        String[] input = FileHelper.readLines(inputFile);
        long length = exploxivesInCyberspace.decode(input);
        Assert.assertEquals(10755693147L, length);
    }
}
