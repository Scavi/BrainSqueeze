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

import com.scavi.brainsqueeze.adventofcode.y2016.Day22GridComputing;
import com.scavi.brainsqueeze.util.FileHelper;

import org.junit.Assert;

import java.io.File;

/**
 * @author Michael Heymel
 * @since 25/12/16
 */
public class Day22GridComputingTest {

    //    @Test
    public void testQuestion1() throws Exception {
        Day22GridComputing gridComputing = new Day22GridComputing();
        File inputFile = FileHelper.forUnitTests("adventofcode/y2016/Day22.txt");
        String[] fileSystemInformation = FileHelper.readLines(inputFile);
        int viablePairCount = gridComputing.viablePairs(fileSystemInformation);
        Assert.assertEquals(0, viablePairCount);
    }
}
