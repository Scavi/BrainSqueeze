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
import com.scavi.brainsqueeze.util.StringHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Question: http://adventofcode.com/2016/day/15
 *
 * @author Michael Heymel
 * @since 16/12/16
 */
public class Day15TimingIsEverything {
    private final static Pattern POSITIONS = Pattern.compile("(?<=(has))[^p]*");
    private final static Pattern CURRENT_POSITION = Pattern.compile("(?<=(at\\sposition))[^\\.]*");


    /**
     * I want my shiny capsule! ;-)
     *
     * @param input the input
     * @return the first time / position to get the shiny capsule
     */
    public int wantMyCapsule(final String[] input) {
        Preconditions.checkNotNull(input, "Illegal disc input: <null>");
        Preconditions.checkArgument(input.length > 0, "Illegal disc input: 0");
        List<Disc> discs = transform(input);
        int time = 0;
        boolean haveCapsule = false;

        do {
            for (int i = 0; i < discs.size(); ++i) {
                Disc disc = discs.get(i);
                if (((disc._currentPosition + time + i + 1) % disc._positions) != 0) {
                    break;
                }
                haveCapsule = i == discs.size() - 1;
            }
            time++;
        }
        while (!haveCapsule);
        return time - 1;
    }


    /**
     * Transforms the input setup to the disc helpers. This method assumes that the discs in the
     * input are valid
     *
     * @param input the input
     * @return the list of discs
     */
    private List<Disc> transform(final String[] input) {
        List<Disc> discs = new ArrayList<>(input.length);
        for (int i = 0; i < input.length; ++i) {
            discs.add(new Disc(StringHelper.fromInput(input[i], POSITIONS),
                    StringHelper.fromInput(input[i], CURRENT_POSITION)));
        }
        return discs;
    }


    private class Disc {
        private final int _positions;
        private final int _currentPosition;


        /**
         * Constructor
         *
         * @param positions       the amount of positions of the disc
         * @param currentPosition the current position of the disc
         */
        public Disc(final int positions, final int currentPosition) {
            _positions = positions;
            _currentPosition = currentPosition;
        }
    }
}
