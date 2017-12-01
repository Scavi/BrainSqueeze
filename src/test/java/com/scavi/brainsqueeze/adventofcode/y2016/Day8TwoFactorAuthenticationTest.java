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

import com.scavi.brainsqueeze.adventofcode.y2016.Day8TwoFactorAuthentication;
import com.scavi.brainsqueeze.util.FileHelper;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * @author Michael Heymel
 * @since 09/12/16
 */
public class Day8TwoFactorAuthenticationTest {
    @Test
    public void test1() {
        String[] input = new String[]{"rect 3x2", "rotate column x=1 by 1", "rotate row y=0 by 4",
                                      "rotate column x=1 by 1"};
        Day8TwoFactorAuthentication twoFactorAuthentication = new Day8TwoFactorAuthentication();
        int count = twoFactorAuthentication.countLidPixels(input, 7, 3);
        Assert.assertEquals(6, count);
    }


    @Test
    public void testQuestion1() throws Exception {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2016/Day8.txt");
        String[] input = FileHelper.readLines(inputFile);
        Day8TwoFactorAuthentication twoFactorAuthentication = new Day8TwoFactorAuthentication();
        int count = twoFactorAuthentication.countLidPixels(input, 50, 6);
        Assert.assertEquals(110, count);
    }

    @Test
    public void testQuestion2() throws Exception {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2016/Day8.txt");
        String[] input = FileHelper.readLines(inputFile);
        Day8TwoFactorAuthentication twoFactorAuthentication = new Day8TwoFactorAuthentication();
        int count = twoFactorAuthentication.countLidPixels(input, 50, 6);
        // print buffer
        Assert.assertEquals(110, count);
    }
}