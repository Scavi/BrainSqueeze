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
 * @since 16/12/16
 */
public class Day15TimingIsEverythingTest {


    @Test
    public void test1() {
        String[] input = new String[]{"Disc #1 has 5 positions; at time=0, it is at position 4.",
                                      "Disc #2 has 2 positions; at time=0, it is at position 1."};
        Day15TimingIsEverything timingIsEverything = new Day15TimingIsEverything();
        int time = timingIsEverything.wantMyCapsule(input);
        Assert.assertEquals(5, time);
    }


    @Test
    public void testQuestion1() throws Exception {
        File inputFile = FileHelper.forUnitTests("adventofcode2016/Day15_1.txt");
        String[] input = FileHelper.readLines(inputFile);
        Day15TimingIsEverything timingIsEverything = new Day15TimingIsEverything();
        int time = timingIsEverything.wantMyCapsule(input);
        Assert.assertEquals(122318, time);
    }


    @Test
    public void testQuestion2() throws Exception {
        File inputFile = FileHelper.forUnitTests("adventofcode2016/Day15_2.txt");
        String[] input = FileHelper.readLines(inputFile);
        Day15TimingIsEverything timingIsEverything = new Day15TimingIsEverything();
        int time = timingIsEverything.wantMyCapsule(input);
        Assert.assertEquals(3208583, time);
    }
}
