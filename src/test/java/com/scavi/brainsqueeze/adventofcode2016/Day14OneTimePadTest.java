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

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 14/12/16
 */
public class Day14OneTimePadTest {
    @Test
    public void test1() throws Exception {
        Day14OneTimePad oneTimePad = new Day14OneTimePad();
        int index = oneTimePad.findKeys("abc", 63);
        Assert.assertEquals(22728, index);
    }


    @Test
    public void testQuestion1() throws Exception {
        Day14OneTimePad oneTimePad = new Day14OneTimePad();
        int index = oneTimePad.findKeys("qzyelonm", 63);
        Assert.assertEquals(15168, index); // too high 15613
    }


    @Test
    public void testQuestion2() throws Exception {
        Day14OneTimePad oneTimePad = new Day14OneTimePad(2017);
        int index = oneTimePad.findKeys("qzyelonm", 63);
        Assert.assertEquals(20864, index); // too high 15613
    }
}


