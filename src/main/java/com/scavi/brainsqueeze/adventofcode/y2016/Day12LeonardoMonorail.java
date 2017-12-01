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

package com.scavi.brainsqueeze.adventofcode.y2016;

import com.scavi.brainsqueeze.adventofcode.util.EBInstructionParser;

import java.util.Map;

/**
 * Solves both questions http://adventofcode.com/2016/day/12
 *
 * @author Michael Heymel
 * @since 12/12/16
 */
public class Day12LeonardoMonorail {
    public int determineRegisterValue(final String[] input,
            final Map<Character, Integer> registerValues, final char lookup) {
        new EBInstructionParser().determineRegisterValue(input, registerValues, lookup);
        return registerValues.get(lookup);
    }
}