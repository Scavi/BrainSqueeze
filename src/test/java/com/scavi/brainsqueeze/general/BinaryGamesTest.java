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

package com.scavi.brainsqueeze.general;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 25/09/16
 */
public class BinaryGamesTest {
    @Test
    public void testFindMissingNumber1() {
        BinaryGames games = new BinaryGames();
        int[] input = new int[]{4, 1, 3};
        int expectedOutput = 2;

        int result = games.findMissingNumber(input);
        Assert.assertEquals(expectedOutput, result);
    }


    @Test
    public void testFindMissingNumber2() {
        BinaryGames games = new BinaryGames();
        int[] input = new int[]{1, 4, 5, 3};
        int expectedOutput = 2;

        int result = games.findMissingNumber(input);
        Assert.assertEquals(expectedOutput, result);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testFindMissingNumber3() {
        BinaryGames games = new BinaryGames();
        int[] input = new int[]{1};
        games.findMissingNumber(input);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testFindMissingNumber4() {
        BinaryGames games = new BinaryGames();
        games.findMissingNumber(null);
    }
}
