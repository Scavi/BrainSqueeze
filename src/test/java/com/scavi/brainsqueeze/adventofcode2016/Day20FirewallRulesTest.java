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
 * @since 20/12/16
 */
public class Day20FirewallRulesTest {
    @Test
    public void test1() {
        Day20FirewallRules firewallRules = new Day20FirewallRules();
        String[] blackList = new String[]{"5-8", "0-2", "4-7"};
        long lowestIpAddress = firewallRules.findLowestIpAddress(blackList);
        Assert.assertEquals(3, lowestIpAddress);
    }


    @Test
    public void testQuestion1() throws Exception {
        Day20FirewallRules firewallRules = new Day20FirewallRules();
        File inputFile = FileHelper.forUnitTests("adventofcode2016/Day20.txt");
        String[] blackList = FileHelper.readLines(inputFile);
        long lowestIpAddress = firewallRules.findLowestIpAddress(blackList);
        Assert.assertEquals(17348574, lowestIpAddress);
    }


    @Test
    public void testQuestion2() throws Exception {
        Day20FirewallRules firewallRules = new Day20FirewallRules();
        File inputFile = FileHelper.forUnitTests("adventofcode2016/Day20.txt");
        String[] blackList = FileHelper.readLines(inputFile);
        long allowedIpAddresses = firewallRules.findAllowedIpAddresses(blackList);
        Assert.assertEquals(104, allowedIpAddresses);
    }
}
