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

package com.scavi.brainsqueeze.codefight.i;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Scavenger on 5/28/2017.
 */
public class RegexMatchingTest {
    @Test
    public void test1() {
        Assert.assertTrue(new RegexMatching().regexMatching("^code", "codefights"));
    }

    @Test
    public void test2() {
        Assert.assertTrue(new RegexMatching().regexMatching("hts$", "codefights"));
    }

    @Test
    public void test3() {
        Assert.assertTrue(new RegexMatching().regexMatching("^codefights$", "codefights"));
    }

    @Test
    public void test4() {
        Assert.assertFalse(new RegexMatching().regexMatching("^codefights$", "codefight"));
    }

    @Test
    public void test5() {
        Assert.assertTrue(new RegexMatching().regexMatching("codefi", "cookiecodefight"));
    }

    @Test
    public void test6() { Assert.assertTrue(new RegexMatching().regexMatching("abracadabra", "zzzaabracadabraabracadabra"));}
}
