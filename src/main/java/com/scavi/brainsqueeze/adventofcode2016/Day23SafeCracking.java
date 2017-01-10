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

package com.scavi.brainsqueeze.adventofcode2016;

import com.scavi.brainsqueeze.adventofcode2016.util.EBInstructionParser;

import java.util.HashMap;
import java.util.Map;

/**
 * Question: http://adventofcode.com/2016/day/23
 *
 * @author Michael Heymel
 * @since 25/12/16
 */
public class Day23SafeCracking {
    public int determineRegisterValue(final String[] input, final char lookup) {
        Map<Character, Integer> registerValues = new HashMap<>();
        registerValues.put('a', 0);
        registerValues.put('b', 0);
        registerValues.put('c', 0);
        registerValues.put('d', 0);
        return determineRegisterValue(input, registerValues, lookup);
    }


    public int determineRegisterValue(final String[] input,
            final Map<Character, Integer> registerValues, final char lookup) {
        new EBInstructionParser().determineRegisterValue(input, registerValues, lookup);
        return registerValues.get(lookup);
    }
}
