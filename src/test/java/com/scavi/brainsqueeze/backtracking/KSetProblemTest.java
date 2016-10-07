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
 * @since 07/10/16
 */
public class KSetProblemTest {

    @Test
    public void testKSetGolum() {
        String input = "golum";
        int inputSetSize = 3;
        String[] expectedOutput =
                new String[]{"gol", "gou", "gom", "glu", "glm", "gum", "olu", "olm", "oum", "lum"};
        KSetProblem kSetProblem = new KSetProblem();
        List<String> output = kSetProblem.kSetOf(input, inputSetSize);
        Assert.assertEquals(expectedOutput.length, output.size());
        Assert.assertArrayEquals(expectedOutput, output.toArray(new String[output.size()]));
    }
}
