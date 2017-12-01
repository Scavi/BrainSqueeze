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


import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;


/**
 * Solves both questions http://adventofcode.com/2016/day/7
 *
 * @author Michael Heymel
 * @since 07/12/16
 */
public class Day7InternetProtocolVersion {
    private static final char OPEN_BRACKET = '[';
    private static final char CLOSE_BRACKET = ']';
    private final IAnalyzer _analyzer;


    Day7InternetProtocolVersion(final IAnalyzer analyzer) {
        _analyzer = analyzer;
    }


    int tlsIpSupportCount(final String[] addressInput) {
        Preconditions.checkNotNull(addressInput, "Illegal IPv7 ;P address input: <null>");
        int count = 0;
        for (String ipv7Address : addressInput) {
            if (_analyzer.isValid(ipv7Address)) {
                count++;
            }
        }
        return count;
    }


    interface IAnalyzer {
        boolean isValid(final String ipv7Address);
    }


    static class TransportLayerSnooping implements IAnalyzer {
        @Override
        public boolean isValid(final String address) {
            boolean isABBA = false;
            boolean isValidHypernetSequence = true;
            int from = 0;
            int to;
            char lookup = OPEN_BRACKET;
            do {
                to = address.indexOf(lookup, from);
                String lookupData = address.substring(from, to != -1 ? to : address.length());
                if (lookup == OPEN_BRACKET) {
                    if (!isABBA) {
                        isABBA = lookup(lookupData);
                    }
                    lookup = CLOSE_BRACKET;
                } else {
                    isValidHypernetSequence = !lookup(lookupData);
                    lookup = OPEN_BRACKET;
                }
                from = to + 1;
            }
            while (isValidHypernetSequence && to != -1);
            return isABBA && isValidHypernetSequence;
        }


        private boolean lookup(final String part) {
            boolean isValid = false;
            for (int i = 0; i < part.length() - 3 && !isValid; ++i) {
                isValid = part.charAt(i) == part.charAt(i + 3) &&
                        part.charAt(i) != part.charAt(i + 1) &&
                        part.charAt(i + 1) == part.charAt(i + 2);
            }
            return isValid;
        }
    }


    static class SuperSecretListening implements IAnalyzer {

        @Override
        public boolean isValid(final String address) {
            List<String> possibleBabData = determinePossibleBabData(address);
            boolean isBAB;
            int to, from = 0;
            do {
                to = address.indexOf(OPEN_BRACKET, from);
                String lookupData = address.substring(from, to != -1 ? to : address.length());
                isBAB = lookup(lookupData, possibleBabData);
                from = address.indexOf(CLOSE_BRACKET, to) + 1;
            }
            while (!isBAB && to != -1);
            return isBAB;
        }


        private boolean lookup(final String part, final List<String> possibleBabData) {
            boolean isValid = false;
            String match;
            for (int i = 0; i < part.length() - 2 && !isValid; ++i) {
                match = isAba(part, i) ? part.substring(i, i + 3) : null;
                if (match != null) {
                    for (int j = 0; j < possibleBabData.size() && !isValid; ++j) {
                        String possibleBab = possibleBabData.get(j);
                        for (int k = 0; k < possibleBab.length() - 2 && !isValid; ++k) {
                            isValid = isReversed(possibleBab.substring(k, k + 3), match);
                        }
                    }
                }
            }
            return isValid;
        }


        private boolean isAba(final String part, final int pos) {
            return part.charAt(pos) == part.charAt(pos + 2) &&
                    part.charAt(pos) != part.charAt(pos + 1);
        }


        private boolean isReversed(final String part, final String match) {
            return match.charAt(0) == part.charAt(1) && match.charAt(1) == part.charAt(0) &&
                    match.charAt(1) == part.charAt(2);
        }


        private List<String> determinePossibleBabData(final String address) {
            List<String> possibleBabData = new ArrayList<>();
            int from = address.indexOf(OPEN_BRACKET);
            while (from != -1) {
                ++from;
                possibleBabData.add(address.substring(from, address.indexOf(CLOSE_BRACKET, from)));
                from = address.indexOf(OPEN_BRACKET, from);
            }
            return possibleBabData;
        }
    }
}
