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

import com.scavi.brainsqueeze.adventofcode.y2016.Day11RadioisotopeThermoelectricGenerators;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 12/12/16
 */
public class Day11RadioisotopeThermoelectricGeneratorsTest {
    @Test
    public void test1() {
        String[] instructions = new String[]{
                "The first floor contains a hydrogen-compatible microchip and a lithium-compatible microchip.",
                "The second floor contains a hydrogen generator.",
                "The third floor contains a lithium generator.",
                "The fourth floor contains nothing relevant."};
        Day11RadioisotopeThermoelectricGenerators radioisotopeThermoelectricGenerators =
                new Day11RadioisotopeThermoelectricGenerators();
        int minSteps = radioisotopeThermoelectricGenerators.minNumberOfSteps(instructions);
        //Assert.assertEquals(11, minSteps);
    }
}
