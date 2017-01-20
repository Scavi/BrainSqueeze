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
public class Day25ClockSignalTest {
    @Test
    public void testQuestion1() throws Exception {
        Day25ClockSignal clockSignal = new Day25ClockSignal();
        File inputFile = FileHelper.forUnitTests("adventofcode2016/Day25.txt");
        String[] instructions = FileHelper.readLines(inputFile);
        int registerValue = clockSignal.findBinaryClockSignalRegister(instructions);
        Assert.assertEquals(10223, registerValue);
    }
}
