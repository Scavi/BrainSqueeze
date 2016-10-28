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
 * @since 28/10/16
 */
public class QueensPuzzleTest {

    @Test
    public void test1() {
        int[] expectedResultCount = new int[]{ 1,0,0,2,10,4,40,92,352,724 };
        QueensPuzzle queensPuzzle = new QueensPuzzle();
        for (int i = 0; i < expectedResultCount.length; ++i) {
            List<int[]> result = queensPuzzle.placeQueens(i + 1);
            Assert.assertEquals(expectedResultCount[i], result.size());
        }
    }
}
