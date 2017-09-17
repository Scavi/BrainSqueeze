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

package com.scavi.brainsqueeze.codefight.i;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Scavenger on 7/5/2017.
 */
public class CryptoSolution {
    boolean isCryptSolution(String[] crypt, char[][] solution) {
        Map<Character, Character> solutionMap = toMap(solution);
        long value = 0;
        for (int i = 0; i < crypt.length; ++i) {
            String currentCrypt = crypt[i];
            try {
                long tmpValue = toLong(currentCrypt, solutionMap);
                if (i < 2) {
                    value += tmpValue;
                } else {
                    if (value != tmpValue) {
                        return false;
                    }
                }
            } catch (UnsupportedOperationException ex) {
                return false;
            }
        }
        return true;
    }

    private long toLong(String crypt, Map<Character, Character> solution) {
        if (solution.get(crypt.charAt(0)) == '0' && crypt.length() > 1) {
            throw new UnsupportedOperationException();
        }
        StringBuilder intValue = new StringBuilder();
        for (char c : crypt.toCharArray()) {
            intValue.append(solution.get(c));
        }
        return Long.parseLong(intValue.toString());
    }

    private Map<Character, Character> toMap(char[][] solution) {
        final Map<Character, Character> map = new HashMap<>();
        for (char[] current : solution) {
            map.put(current[0], current[1]);
        }
        return map;
    }
}
