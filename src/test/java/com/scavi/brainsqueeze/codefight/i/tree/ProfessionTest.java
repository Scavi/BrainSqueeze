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

package com.scavi.brainsqueeze.codefight.i.tree;

import org.junit.Assert;
import org.junit.Test;

public class ProfessionTest {
    @Test
    public void test1() {
        String result = new Profession().findProfession(3,3 );
        Assert.assertEquals("Doctor", result);
    }


    @Test
    public void test2() {
        String result = new Profession().findProfession(4,2 );
        Assert.assertEquals("Doctor", result);
    }
}
