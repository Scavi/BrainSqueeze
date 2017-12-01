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

import com.scavi.brainsqueeze.adventofcode.y2016.Day16DragonChecksum;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 16/12/16
 */
public class Day16DragonChecksumTest {
    @Test
    public void test1() {
        Day16DragonChecksum dragonChecksum = new Day16DragonChecksum();
        String result = dragonChecksum.createDragonChecksum("10000", 20);
        Assert.assertEquals("01100", result);
    }


    @Test
    public void testQuestion1() {
        Day16DragonChecksum dragonChecksum = new Day16DragonChecksum();
        String result = dragonChecksum.createDragonChecksum("01110110101001000", 272);
        Assert.assertEquals("11100111011101111", result);
    }


    @Test
    public void testQuestion2() {
        Day16DragonChecksum dragonChecksum = new Day16DragonChecksum();
        String result = dragonChecksum.createDragonChecksum("01110110101001000", 35651584);
        Assert.assertEquals("10001110010000110", result);
    }
}
