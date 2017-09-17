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

package com.scavi.brainsqueeze.career;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Scavenger on 5/14/2017.
 */
public class AnagramFinderTest {
    @Test
    public void test1() {
        Set<String> input = new HashSet<>(Arrays.asList("stop", "foo", "pots", "zzz", "tops"));
        List<String> anagrams = new AnagramFinder().findAnagrams(input);
        Assert.assertEquals(1, anagrams.size());
        Assert.assertEquals("[stop, tops, pots]", anagrams.get(0));
    }
}
