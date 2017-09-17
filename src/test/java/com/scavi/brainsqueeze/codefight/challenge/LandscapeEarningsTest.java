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

package com.scavi.brainsqueeze.codefight.challenge;

import org.junit.Assert;
import org.junit.Test;

public class LandscapeEarningsTest {
    @Test
    public void test1() {
        int earnings = new LandscapeEarnings().landscapingEarnings(9);
        Assert.assertEquals(7, earnings);
    }

    @Test
    public void test2() {
        int earnings = new LandscapeEarnings().landscapingEarnings(20);
        Assert.assertEquals(16, earnings);
    }

    @Test
    public void test3() {
        int earnings = new LandscapeEarnings().landscapingEarnings(119);
        Assert.assertEquals(71, earnings);
    }


    @Test
    public void test4() {
        int earnings = new LandscapeEarnings().landscapingEarnings(200);
        Assert.assertEquals(357, earnings);
    }



    @Test
    public void test5() {
        int earnings = new LandscapeEarnings().landscapingEarnings(1200);
        Assert.assertEquals(3000, earnings);
    }
}
