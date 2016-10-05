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

package com.scavi.brainsqueeze.search;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 26/09/16
 */
public class SearchGamesTest {

    @Test
    public void testMedian1() {
        int[] input = new int[]{3, 2, 1, 4, 7, 6, 5, 8, 9};
        SearchGames searchGames = new SearchGames();
        int median = searchGames.determineMedian(input);
        Assert.assertEquals(5, median);
    }

    @Test
    public void testMedian2() {
        int[] input = new int[]{3, 2, 1, 4, 7, 6, 5, 8};
        SearchGames searchGames = new SearchGames();
        int median = searchGames.determineMedian(input);
        Assert.assertEquals(5, median);
    }
}
