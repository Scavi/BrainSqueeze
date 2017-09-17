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

public class TuneUpTest {
    @Test
    public void test1() {
        String tune = new TuneUp().tuneUp(440);
        Assert.assertEquals("A", tune);
    }


    @Test
    public void test2() {
        String tune = new TuneUp().tuneUp(466.164);
        Assert.assertEquals("Bb", tune);
    }

    @Test
    public void test3() {
        String tune = new TuneUp().tuneUp(493.883);
        Assert.assertEquals("B", tune);
    }
}
