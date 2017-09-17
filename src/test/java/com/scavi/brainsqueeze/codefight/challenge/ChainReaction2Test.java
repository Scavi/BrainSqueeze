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

public class ChainReaction2Test {

    @Test
    public void test0() {
        int[][] moves = new int[][]{{0, 0}, {1, 1}, {0, 0}, {1, 1}};
        ChainReaction2 chain2 = new ChainReaction2();
        String result = chain2.chainReaction2(2, 2, moves);
    }

    @Test
    public void test1() {
        int[][] moves = new int[][]{{0, 0}, {0, 1}, {0, 0}};
        ChainReaction2 chain2 = new ChainReaction2();
        String result = chain2.chainReaction2(2, 2, moves);
        Assert.assertEquals("Red won", result);
    }


    @Test
    public void test2() {
        int[][] moves = new int[][]{{0, 0},
                {1, 1},
                {0, 0},
                {0, 0}};
        ChainReaction2 chain2 = new ChainReaction2();
        String result = chain2.chainReaction2(9, 6, moves);
        Assert.assertEquals("draw", result);
    }


    @Test
    public void test3() {
        int[][] moves = new int[][]{{0, 0},
                {8, 5},
                {0, 0},
                {8, 5},
                {0, 0},
                {8, 5},
                {0, 0},
                {8, 5},
                {7, 4},
                {1, 1},
                {7, 4},
                {1, 1},
                {7, 4},
                {1, 1},
                {7, 4}};
        ChainReaction2 chain2 = new ChainReaction2();
        String result = chain2.chainReaction2(9, 6, moves);
        Assert.assertEquals("draw", result);
    }

    @Test
    public void test4() {
        int[][] moves = new int[][]{{0, 0},
                {0, 5},
                {0, 1},
                {0, 4},
                {0, 2},
                {0, 3},
                {1, 0},
                {1, 5},
                {1, 0},
                {1, 5},
                {2, 0},
                {2, 5},
                {3, 0},
                {0, 3},
                {0, 1},
                {0, 4},
                {0, 2},
                {2, 5},
                {2, 0},
                {1, 5}};
        ChainReaction2 chain2 = new ChainReaction2();
        String result = chain2.chainReaction2(4, 6, moves);
        Assert.assertEquals("Green won", result);
    }

    @Test
    public void test5() {
        int[][] moves = new int[][]{{0, 0}, {1, 0}, {0, 0}};
        ChainReaction2 chain2 = new ChainReaction2();
        String result = chain2.chainReaction2(6, 1, moves);
        Assert.assertEquals("Red won", result);
    }
}
