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

import com.scavi.brainsqueeze.codefight.challenge.NotIndexOf;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Scavenger on 6/18/2017.
 */
public class NotIndexOfTest {
    @Test
    public void test1() {
        int result = new NotIndexOf().notIndexOf("Welcome to CodeFights!", "Back to school");
        Assert.assertEquals(2, result);
    }


    @Test
    public void test2() {
        int result = new NotIndexOf().notIndexOf("abc", "abc");
        Assert.assertEquals(-1, result);
    }


    @Test
    public void test3() {
        int result = new NotIndexOf().notIndexOf("Zoo", "oo");
        Assert.assertEquals(-1, result);
    }


    @Test
    public void test4() {
        int result = new NotIndexOf().notIndexOf("Oh, some strange char", "0,sm tag h");
        Assert.assertEquals(10, result);
    }


    @Test
    public void test5() {
        int result = new NotIndexOf().notIndexOf("Oh, some strange char", "0,sm tag hr");
        Assert.assertEquals(-1, result);
    }
}
