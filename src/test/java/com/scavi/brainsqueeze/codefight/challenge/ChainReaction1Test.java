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

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Scavenger on 8/2/2017.
 */
public class ChainReaction1Test {

    @Test
    public void test1() {
        int[][] moves = new int[][]{{0, 0}, {0, 0}};
        int[][] result = new ChainReaction1().chainReaction1(4, moves);
        int[][] expected = new int[][]{
                {0, 1, 0, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        verifyExpectedToResult(expected, result);
    }


    @Test
    public void test2() {
        int[][] moves = new int[][]{{1, 1},
                {1, 2},
                {1, 1},
                {1, 2},
                {1, 1},
                {1, 2},
                {1, 1}};
        int[][] result = new ChainReaction1().chainReaction1(4, moves);
        int[][] expected = new int[][]{{0, 1, 1, 0},
                {1, 1, 0, 1},
                {0, 1, 1, 0},
                {0, 0, 0, 0}};
        verifyExpectedToResult(expected, result);
    }

    private void verifyExpectedToResult(int[][] expected, int[][] result) {
        Assert.assertEquals(expected.length, result.length);
        Assert.assertEquals(expected[0].length, result[0].length);
        for (int y = 0; y < expected.length; ++y) {
            for (int x = 0; x < expected[0].length; ++x) {
                Assert.assertEquals(expected[y][x], result[y][x]);
            }
        }
    }
}
