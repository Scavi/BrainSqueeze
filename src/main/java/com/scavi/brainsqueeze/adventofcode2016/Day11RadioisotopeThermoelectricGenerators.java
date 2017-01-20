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

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Question: http://adventofcode.com/2016/day/11
 *
 * @author Michael Heymel
 * @since 12/12/16
 */
public class Day11RadioisotopeThermoelectricGenerators {
    private final Pattern _microchipPattern =
            Pattern.compile("(?<=\\s)[\\w]*(?=\\-compatible\\smicrochip)");
    private final Pattern _generatorPattern = Pattern.compile("(?<=\\s)[\\w]*(?=\\sgenerator)");


    public int minNumberOfSteps(final String[] setup) {
        Preconditions.checkNotNull(setup, "Illegal instruction set: <null>");
        int minSteps = Integer.MAX_VALUE;

        List<ArrayList<RadioisotopeComponent>> floorDefinition = createFloorDefinition(setup);


        return minSteps;
    }


    private List<ArrayList<RadioisotopeComponent>> createFloorDefinition(final String[] setup) {
        List<ArrayList<RadioisotopeComponent>> floorDefinition = new ArrayList<>(setup.length);

        for (int i = 0; i < setup.length; ++i) {
            Matcher microchipMatcher = _microchipPattern.matcher(setup[i]);
            Matcher generatorMatcher = _generatorPattern.matcher(setup[i]);
            if (microchipMatcher.find()) {

            }
            if (generatorMatcher.find()) {

            }
        }
        return floorDefinition;
    }


    private abstract class RadioisotopeComponent {

    }

    private class Generator extends RadioisotopeComponent {
        private final String _type;


        public Generator(final String type) {
            _type = type;
        }
    }

    private class Chip extends RadioisotopeComponent {
        private final String _type;


        public Chip(final String type) {
            _type = type;
        }
    }
}
