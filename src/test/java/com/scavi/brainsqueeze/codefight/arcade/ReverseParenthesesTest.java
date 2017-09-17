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

package com.scavi.brainsqueeze.codefight.arcade;

import org.junit.Assert;
import org.junit.Test;

public class ReverseParenthesesTest {
    @Test
    public void test1() {
        String result = new ReverseParentheses().reverseParentheses("a(bc)de");
        Assert.assertEquals("acbde", result);
    }

    @Test
    public void test2() {
        String result = new ReverseParentheses().reverseParentheses("Code(Cha(lle)nge)");
        Assert.assertEquals("CodeegnlleahC", result);
    }

    @Test
    public void test3() {
        String result = new ReverseParentheses().reverseParentheses("abc(cba)ab(bac)c");
        Assert.assertEquals("abcabcabcabc", result);
    }


    @Test
    public void test4() {
        String result = new ReverseParentheses().reverseParentheses("whereAreMyCookies");
        Assert.assertEquals("whereAreMyCookies", result);
    }
}
