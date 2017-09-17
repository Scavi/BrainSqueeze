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

import com.scavi.brainsqueeze.codefight.challenge.PrimeClimb;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Scavenger on 6/18/2017.
 */
public class PrimeClimbTest {
    @Test
    public void test1() {
        String result = new PrimeClimb().primeClimb(60);
        Assert.assertEquals("2235", result);
    }

    @Test
    public void test2() {
        String result = new PrimeClimb().primeClimb(20);
        Assert.assertEquals("225", result);
    }

    @Test
    public void test6() {
        String result = new PrimeClimb().primeClimb(4782969);
        Assert.assertEquals("314", result);
    }

    @Test
    public void test8() {
        String result = new PrimeClimb().primeClimb(15154747);
        Assert.assertEquals("101227661", result);
    }

    @Test
    public void test11() {
        String result = new PrimeClimb().primeClimb(2147117569);
        Assert.assertEquals("463372", result);

    }

    @Test
    public void test13() {
        String result = new PrimeClimb().primeClimb(2147483647);
        Assert.assertEquals("2147483647", result);

    }
}
