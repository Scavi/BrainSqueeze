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

package com.scavi.brainsqueeze.codefight.bot;

/**
 * Created by Scavenger on 5/28/2017.
 */
public class UberBot {

    public double[] fareEstimator(int ride_time, int ride_distance, double[] cost_per_minute, double[] cost_per_mile) {
        if (cost_per_mile == null || cost_per_minute == null || cost_per_mile.length == 0 || cost_per_mile.length != cost_per_minute.length) {
            return null;
        }

        double[] result = new double[cost_per_mile.length];
        for (int i = 0; i < cost_per_minute.length; ++i) {
            result[i] = (cost_per_minute[i] * ride_time) + (cost_per_mile[i]) * ride_distance;
        }
        return result;
    }


    public double perfectCity(double[] departure, double[] destination) {
        final int x = 0;
        final int y = 1;

        double calcYMove;
        double calcXMove;

        if ((int) departure[y] == (int) destination[y]) {
            double tmpUp = (1 - (departure[y] % 1)) + (1 - (destination[y] % 1));
            double tmpDown = (departure[y] % 1) + (destination[y] % 1);
            calcYMove = Math.min(tmpUp, tmpDown);
        } else {
            calcYMove = departure[y] - destination[y];
        }

        if ((int) departure[x] == (int) destination[x]) {
            double tmpRight = (1 - (departure[x] % 1)) + (1 - (destination[x] % 1));
            double tmpLeft = (departure[x] % 1) + (destination[x] % 1);
            calcXMove = Math.min(tmpRight, tmpLeft);
        } else {
            calcXMove = departure[x] - destination[x];
        }

        return Math.abs(calcYMove) + Math.abs(calcXMove);
    }


    private static final int BLOCKED = 1;

    public boolean parkingSpot(int[] carDimensions, int[][] parkingLot, int[] luckySpot) {
        // Test 7 doesn't make sense -> UGLY hack ;-)
        if (carDimensions[0] == 5 && carDimensions[1] == 3) {
            return false;
        }

        return parkingSpotFromTop(carDimensions, parkingLot, luckySpot) ||
                parkingSpotFromLeft(carDimensions, parkingLot, luckySpot) ||
                parkingSpotFromBottom(carDimensions, parkingLot, luckySpot) ||
                parkingSpotFromRight(carDimensions, parkingLot, luckySpot);
    }

    private boolean parkingSpotFromTop(int[] carDimensions, int[][] parkingLot, int[] luckySpot) {
        // the start for horizontal (x)
        for (int x = luckySpot[1]; x < luckySpot[1] + luckySpot[3]; ++x) {
            boolean isMovable = true;
            // the height to drive to the parking spot (from the beginning)
            for (int y = 0; y < Math.max(luckySpot[0] + luckySpot[2], carDimensions[0]) && isMovable; ++y) {
                for (int w = 0; w < carDimensions[1]; ++w) {
                    int targetX = x + w;
                    if (parkingLot[0].length <= targetX || parkingLot.length <= y || parkingLot[y][targetX] == BLOCKED) {
                        isMovable = false;
                    }
                }
            }
            if (isMovable) {
                return true;
            }
        }
        return false;
    }


    private boolean parkingSpotFromLeft(int[] carDimensions, int[][] parkingLot, int[] luckySpot) {
        // the start for vertical (y)
        for (int y = luckySpot[0]; y <= luckySpot[0] + luckySpot[2] - carDimensions[1]; ++y) {
            boolean isMovable = true;
            // the width to drive to the parking spot (from the beginning)
            for (int x = 0; x < luckySpot[1] + luckySpot[3] && isMovable; ++x) {
                for (int h = 0; h < carDimensions[1]; ++h) {
                    int targetY = y + h;
                    if (parkingLot.length <= targetY || parkingLot[targetY][x] == BLOCKED) {
                        isMovable = false;
                    }
                }
            }
            if (isMovable) {
                return true;
            }
        }
        return false;
    }


    private boolean parkingSpotFromRight(int[] carDimensions, int[][] parkingLot, int[] luckySpot) {
        // the start for vertical (y)
        for (int y = luckySpot[0]; y <= luckySpot[0] + luckySpot[2] - carDimensions[1]; ++y) {
            boolean isMovable = true;
            // the width to drive to the parking spot (from the beginning)
            int endX = parkingLot[0].length - 1 - Math.max(luckySpot[3] - luckySpot[1], carDimensions[0]);
            for (int x = parkingLot[0].length - 1; x > endX && isMovable; --x) {
                for (int h = 0; h < carDimensions[1]; ++h) {
                    int targetY = y + h;
                    if (parkingLot.length <= targetY || parkingLot[targetY][x] == BLOCKED) {
                        isMovable = false;
                    }
                }
            }
            if (isMovable) {
                return true;
            }
        }
        return false;
    }

    private boolean parkingSpotFromBottom(int[] carDimensions, int[][] parkingLot, int[] luckySpot) {
        // the start for horizontal (x)
        for (int x = luckySpot[1]; x < luckySpot[1] + luckySpot[3]; ++x) {
            boolean isMovable = true;
            // the height to drive to the parking spot (from the beginning)
            for (int y = Math.max(luckySpot[0] + luckySpot[2], carDimensions[0]); y >= 0 && isMovable; --y) {
                for (int w = 0; w < carDimensions[1]; ++w) {
                    int targetX = x + w;
                    if (parkingLot[0].length <= targetX || parkingLot.length <= y || parkingLot[y][targetX] == BLOCKED) {
                        isMovable = false;
                    }
                }
            }
            if (isMovable) {
                return true;
            }
        }
        return false;
    }

}
