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

package com.scavi.brainsqueeze.codefight.challenge;

import java.math.BigDecimal;

public class ProdInTable {
    int maxProdInTable(int[][] table) {
        BigDecimal max = new BigDecimal(0);
        for (int y = 0; y < table.length; ++y) {
            for (int x = 0; x < table[0].length; ++x) {
                BigDecimal value1 = findXMax(table, x, y);
                BigDecimal value2 = findCrossMax(table, x, y);
                BigDecimal tmp = value1.compareTo(value2) > 0 ? value1 : value2;
                max = max.compareTo(tmp) > 0 ? max : tmp;
            }
        }
        return  max.remainder(new BigDecimal(1000000007)).intValue();
    }

    private BigDecimal findXMax(int[][] table, int x, int y) {
        if (x < 0 || y < 0 || x >= table[0].length || y >= table.length) {
            return new BigDecimal(0);
        }
        BigDecimal value = new BigDecimal(table[y][x]);
        boolean isIterating = true;
        int iteration = 0;
        while (isIterating) {
            iteration++;
            if ((x - iteration >= 0 && (y - iteration >= 0) && table[y - iteration][x - iteration] > 0) &&
                    (x + iteration < table[0].length && (y - iteration >= 0) && table[y - iteration][x + iteration] > 0) &&
                    (x - iteration >= 0 && (y + iteration < table.length) && table[y + iteration][x - iteration] > 0) &&
                    (x + iteration < table[0].length && (y + iteration < table.length) && table[y + iteration][x - iteration] > 0)) {

                value = value.multiply(new BigDecimal(table[y - iteration][x - iteration]));
                value = value.multiply(new BigDecimal(table[y - iteration][x + iteration]));
                value = value.multiply(new BigDecimal(table[y + iteration][x - iteration]));
                value = value.multiply(new BigDecimal(table[y + iteration][x + iteration]));
            } else {
                isIterating = false;
            }
        }
        return value;
    }

    private BigDecimal findCrossMax(int[][] table, int x, int y) {
        if (x < 0 || y < 0 || x >= table[0].length || y >= table.length) {
            return new BigDecimal(0);
        }
        BigDecimal value = new BigDecimal(table[y][x]);
        boolean isIterating = true;
        int iteration = 0;
        while (isIterating) {
            iteration++;
            if ((x - iteration >= 0 && table[y][x - iteration] > 0) &&
                (x + iteration < table[0].length && table[y][x + iteration] > 0) &&
                (y - iteration >= 0 && table[y - iteration][x] > 0) &&
                (y + iteration < table.length && table[y + iteration][x] > 0)) {

                value = value.multiply(new BigDecimal(table[y][x - iteration]));
                value = value.multiply(new BigDecimal(table[y][x + iteration]));
                value = value.multiply(new BigDecimal(table[y - iteration][x]));
                value = value.multiply(new BigDecimal(table[y + iteration][x]));
            } else {
                isIterating = false;
            }
        }
        return value;
    }
}
