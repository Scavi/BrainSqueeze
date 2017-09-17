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

public class Sum34Test {
    @Test
    public void test0() {
        int result = new Sum34().sum34(3);
        Assert.assertEquals(8, result);
    }

    @Test
    public void test1() {
        int result = new Sum34().sum34(4);
        Assert.assertEquals(7, result);
    }

    @Test
    public void test2() {
        int result = new Sum34().sum34(10);
        Assert.assertEquals(7, result);
    }

    @Test
    public void test3() {
        int result = new Sum34().sum34(2);
        Assert.assertEquals(4, result);
    }

    @Test
    public void test4() {
        int result = new Sum34().sum34(2);
        Assert.assertEquals(4, result);
    }

    @Test
    public void test5() {
        int result = new Sum34().sum34(100);
        Assert.assertEquals(115, result);
    }

    @Test
    public void test6() {
        int result = new Sum34().sum34(1234);
        Assert.assertEquals(1636, result);
    }

    @Test
    public void test7() {
        int result = new Sum34().sum34(19456);
        Assert.assertEquals(26143, result);
    }
}
