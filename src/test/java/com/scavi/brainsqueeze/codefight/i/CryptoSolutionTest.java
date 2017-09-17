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
 * Created by Scavenger on 7/5/2017.
 */
public class CryptoSolutionTest {
    @Test
    public void test1() {
        String[] crypt = new String[]{"A", "B", "C"};
        char[][] solution = new char[][]{{'A', '5'}, {'B', '6'}, {'C', '1'}};
        boolean isCrypto = new CryptoSolution().isCryptSolution(crypt, solution);
        Assert.assertFalse(isCrypto);
    }
}
