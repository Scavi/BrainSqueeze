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

import com.scavi.brainsqueeze.adventofcode.y2016.Day18LikeARogue;
import com.scavi.brainsqueeze.util.FileHelper;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * @author Michael Heymel
 * @since 18/12/16
 */
public class Day18LikeARogueTest {

    @Test
    public void test1() {
        Day18LikeARogue likeARogue = new Day18LikeARogue();
        int noOfSaveFields = likeARogue.findSaveFields("..^^.".toCharArray(), 3);
        Assert.assertEquals(6, noOfSaveFields);
    }


    @Test
    public void test2() {
        Day18LikeARogue likeARogue = new Day18LikeARogue();
        int noOfSaveFields = likeARogue.findSaveFields(".^^.^.^^^^".toCharArray(), 10);
        Assert.assertEquals(38, noOfSaveFields);
    }


    @Test
    public void testQuestion1() throws Exception {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2016/Day18.txt");
        String[] input = FileHelper.readLines(inputFile);

        Day18LikeARogue likeARogue = new Day18LikeARogue();
        int noOfSaveFields = likeARogue.findSaveFields(input[0].toCharArray(), 40);
        Assert.assertEquals(1987, noOfSaveFields);
    }


    @Test
    public void testQuestion2() throws Exception {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2016/Day18.txt");
        String[] input = FileHelper.readLines(inputFile);

        Day18LikeARogue likeARogue = new Day18LikeARogue();
        int noOfSaveFields = likeARogue.findSaveFields(input[0].toCharArray(), 400000);
        Assert.assertEquals(19984714, noOfSaveFields);
    }
}
