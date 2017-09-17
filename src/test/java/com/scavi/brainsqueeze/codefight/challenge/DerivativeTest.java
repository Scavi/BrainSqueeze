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

import com.scavi.brainsqueeze.codefight.challenge.Derivative;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Scavenger on 6/18/2017.
 */
public class DerivativeTest {
    @Test
    public void test1() {
        int result = new Derivative().derivative("3*x^2 - x^4 + 8", -2);
        Assert.assertEquals(20, result);
    }

    @Test
    public void test2() {
        int result = new Derivative().derivative("x", 1);
        Assert.assertEquals(1, result);
    }

    @Test
    public void test3() {
        int result = new Derivative().derivative("x", 2);
        Assert.assertEquals(1, result);
    }

    @Test
    public void test4() {
        int result = new Derivative().derivative("1000", 1);
        Assert.assertEquals(0, result);
    }

    @Test
    public void test5() {
        int result = new Derivative().derivative("2*x^3 + 10", 3);
        Assert.assertEquals(54, result);
    }

    @Test
    public void test6() {
        int result = new Derivative().derivative("-3*x^2 + x^3 - 1000", -1);
        Assert.assertEquals(9, result);
    }

    @Test
    public void test7() {
        int result = new Derivative().derivative("23*x^8 + 53*x - -97*x^5 - -44*x^2 + 36*x - 85*x^3 - -23*x", -4);
        Assert.assertEquals(-2894816, result);
    }

    @Test
    public void test8() {
        int result = new Derivative().derivative("-27*x + 43*x^7 - 89*x", -3);
        Assert.assertEquals(219313, result);
    }

    @Test
    public void test9() {
        int result = new Derivative().derivative("2*x^2 - -x^12 - 15*x^3 + 172*x", 0);
        Assert.assertEquals(172, result);
    }

    @Test
    public void test10() {
        int result = new Derivative().derivative("32*x^4 + 96*x^6 - 67*x^9 + 93*x^7", 3);
        Assert.assertEquals(-3338280, result);
    }

    @Test
    public void test11() {
        int result = new Derivative().derivative("-x - -x^2 + 5 - x^3", 2);
        Assert.assertEquals(-9, result);

    }
}
