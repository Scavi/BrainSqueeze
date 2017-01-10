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

import static com.scavi.brainsqueeze.adventofcode2016.Day10BalanceBots.*;

/**
 * @author Michael Heymel
 * @since 11/12/16
 */
public class Day10BalanceBotsTest {
    @Test
    public void test1() {
        String[] instructions =
                new String[]{"value 5 goes to bot 2", "bot 2 gives low to bot 1 and high to bot 0",
                             "value 3 goes to bot 1",
                             "bot 1 gives low to output 1 and high to bot 0",
                             "bot 0 gives low to output 2 and high to output 0",
                             "value 2 goes to bot 2"};
        Day10BalanceBots balanceBots = new Day10BalanceBots();
        Bot processingBot = balanceBots.lookupProcessingBot(instructions, 5, 2);
        Assert.assertEquals(2, processingBot.getBotId());
    }


    @Test
    public void test2() {
        String[] instructions =
                new String[]{"value 5 goes to bot 2", "bot 2 gives low to bot 1 and high to bot 0",
                             "value 3 goes to bot 1",
                             "bot 1 gives low to output 1 and high to bot 0",
                             "bot 0 gives low to output 2 and high to output 0",
                             "value 2 goes to bot 2"};
        Day10BalanceBots balanceBots = new Day10BalanceBots();
        Bot processingBot = balanceBots.lookupProcessingBot(instructions, 5, 5);
        Assert.assertNull(processingBot);
    }


    @Test
    public void testQuestion1() throws Exception {
        File inputFile = FileHelper.forUnitTests("adventofcode2016/Day10.txt");
        String[] instructions = FileHelper.readLines(inputFile);
        Day10BalanceBots balanceBots = new Day10BalanceBots();
        Bot processingBot = balanceBots.lookupProcessingBot(instructions, 61, 17);
        Assert.assertEquals(118, processingBot.getBotId());
    }


    @Test
    public void testQuestion2() throws Exception {
        File inputFile = FileHelper.forUnitTests("adventofcode2016/Day10.txt");
        String[] instructions = FileHelper.readLines(inputFile);
        Day10BalanceBots balanceBots = new Day10BalanceBots();
        long result = balanceBots.outputValues(instructions, 61, 17, 0, 1, 2);
        Assert.assertEquals(143153, result);
    }
}
