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

package com.scavi.brainsqueeze.adventofcode2016.util;

import com.scavi.brainsqueeze.adventofcode2016.ex.TransmitException;

/**
 * @author Michael Heymel
 * @since 10/01/17
 */
public class SignalTransmit {
    private final int _expectedSignalCount;
    private int _receivedSignalCount = 0;


    /**
     * Constructor
     *
     * @param expectedSignalCount the expected amount of signals
     */
    public SignalTransmit(final int expectedSignalCount) {
        _expectedSignalCount = expectedSignalCount;
    }


    /**
     * Receives a transmission and validates that the signal matches the expectation
     *
     * @param information the transmission
     * @throws TransmitException
     */
    public void transmit(final Integer information) throws TransmitException {
        if (information == null || (_receivedSignalCount % 2) != information) {
            throw new TransmitException("Illegal signal information: " +
                    (information != null ? information : "<null>"));
        }
        _receivedSignalCount++;
    }


    /**
     * Validates if the transmission is finished or still more signals are expected
     *
     * @return <code>true</code> transmission is finished
     * <p/>
     * <code>false</code> transmission is not finished
     */
    public boolean isTransmissionFinished() {
        return _receivedSignalCount >= _expectedSignalCount;
    }
}
