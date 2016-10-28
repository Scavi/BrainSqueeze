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

package com.scavi.brainsqueeze.backtracking;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author Michael Heymel
 * @since 05/10/16
 */
public class PermutationTest {


    @Test
    public void test1() {
        String input = "abc";
        String[] expectedOutput = new String[]{"abc", "acb", "bac", "bca", "cab", "cba"};
        Permutation permutation = new Permutation();
        List<String> output = permutation.permutation1(input);

        Assert.assertEquals(expectedOutput.length, output.size());
        for (String expected : expectedOutput) {
            Assert.assertTrue(output.contains(expected));
        }
    }


    @Test
    public void test2() {
        String input = "elhlo";
        Permutation permutation = new Permutation();
        List<String> output = permutation.permutation1(input);
        Assert.assertEquals(120, output.size());
        Assert.assertTrue(output.contains("hello"));
    }
}
