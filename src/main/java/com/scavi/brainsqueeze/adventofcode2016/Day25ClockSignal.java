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

import com.scavi.brainsqueeze.adventofcode2016.ex.TransmitException;
import com.scavi.brainsqueeze.adventofcode2016.util.EBInstructionParser;
import com.scavi.brainsqueeze.adventofcode2016.util.SignalTransmit;

import java.util.HashMap;
import java.util.Map;

/**
 * Question: http://adventofcode.com/2016/day/25
 *
 * @author Michael Heymel
 * @since 25/12/16
 */
public class Day25ClockSignal {

    public int findBinaryClockSignalRegister(final String[] input) {
        int lowestClockSignal = 1;
        for (; lowestClockSignal < Integer.MAX_VALUE; ++lowestClockSignal) {
            try {
                Map<Character, Integer> registerValues = new HashMap<>();
                registerValues.put('a', lowestClockSignal);
                registerValues.put('b', 0);
                registerValues.put('c', 0);
                registerValues.put('d', 0);

                EBInstructionParser instructionParser =
                        new EBInstructionParser(new SignalTransmit(10000));
                instructionParser.determineRegisterValue(input, registerValues, 'a');
            }
            catch (TransmitException ex) {
                // try again...
            }
        }
        return lowestClockSignal;
    }

}
