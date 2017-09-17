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

public class BoxPilesTest {
    @Test
    public void test1() {
        int result = new BoxPiles().boxPiles(new int[]{4, 3, 1, 1, 0, 0});
        Assert.assertEquals(2, result);
    }

    @Test
    public void test2() {
        int result = new BoxPiles().boxPiles(new int[]{4});
        Assert.assertEquals(1, result);
    }

    @Test
    public void test3() {
        int result = new BoxPiles().boxPiles(new int[]{4, 2, 4, 2});
        Assert.assertEquals(1, result);
    }
}
