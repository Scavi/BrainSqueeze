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

package com.scavi.brainsqueeze.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 21/09/16
 */
public class WaterGlassTowerTest {
    @Test
    public void test1() {
        WaterGlassTower glassTower = new WaterGlassTower();
        float result = glassTower.findWaterAmount(2.0f, 2, 2);
        Assert.assertEquals(0.5f, result, 0.0f);
    }


    @Test
    public void test2() {
        WaterGlassTower glassTower = new WaterGlassTower();
        float result = glassTower.findWaterAmount(10.0f, 4, 4);
        Assert.assertEquals(0.375f, result, 0.0f);
    }


    @Test
    public void test3() {
        WaterGlassTower glassTower = new WaterGlassTower();
        float result = glassTower.findWaterAmount(10.0f, 3, 4);
        Assert.assertEquals(1.0f, result, 0.0f);
    }


    @Test
    public void test4() {
        WaterGlassTower glassTower = new WaterGlassTower();
        float result = glassTower.findWaterAmount(20.0f, 3, 7);
        Assert.assertEquals(0.71875, result, 0.0f);
    }

    @Test
    public void test5() {
        WaterGlassTower glassTower = new WaterGlassTower();
        float result = glassTower.findWaterAmount(42.0f, 6, 6);
        Assert.assertEquals(0.34375f, result, 0.0f);
    }
}
