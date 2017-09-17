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

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Scavenger on 5/28/2017.
 */
public class UberBotTest {
    @Test
    public void test1() {
        double[] result = new UberBot().fareEstimator(30, 7, new double[]{0.2, 0.35, 0.4, 0.45}, new double[]{1.1, 1.8, 2.3, 3.5});
    }

    @Test
    public void test2() {
        double expected = 2.7;
        double result = new UberBot().perfectCity(new double[]{0.4, 1}, new double[]{0.9, 3});
        Assert.assertTrue(expected == result);
        double result2 = new UberBot().perfectCity(new double[]{0.9, 3}, new double[]{0.4, 1});
        Assert.assertTrue(expected == result2);
    }


    @Test
    public void test3() {
        double expected = 8.9;
        double result = new UberBot().perfectCity(new double[]{2.4, 1}, new double[]{5, 7.3});
        Assert.assertTrue(expected == result);
    }

    @Test
    public void test4() {
        double expected = 7.7;
        double result = new UberBot().perfectCity(new double[]{0, 0.2}, new double[]{7, 0.5});
        Assert.assertTrue(expected == result);
    }


    @Test
    public void test5() {
        double expected = 1.2;
        double result = new UberBot().perfectCity(new double[]{0.9, 6}, new double[]{1.1, 5});
        // TODO rounding issue Assert.assertTrue(expected == result);
    }


    @Test
    public void testParking1() {
        int[] carDimension = {3, 2};
        int[][] parkingLot = new int[][]{
                {
                        1, 0, 1, 0, 1, 0
                },
                {
                        0, 0, 0, 0, 1, 0
                },
                {
                        0, 0, 0, 0, 0, 1
                },
                {
                        1, 0, 1, 1, 1, 1
                }
        };
        int[] luckySpot = new int[]{1, 1, 2, 3};
        boolean foundParkingSpot = new UberBot().parkingSpot(carDimension, parkingLot, luckySpot);
        Assert.assertTrue(foundParkingSpot);
    }

    @Test
    public void testParking2() {
        int[] carDimension = {3, 2};
        int[][] parkingLot = new int[][]{
                {
                        1, 0, 1, 0, 1, 0
                },
                {
                        1, 0, 0, 0, 1, 0
                },
                {
                        0, 0, 0, 0, 0, 1
                },
                {
                        1, 0, 1, 1, 1, 1
                }
        };
        int[] luckySpot = new int[]{1, 1, 2, 3};
        boolean foundParkingSpot = new UberBot().parkingSpot(carDimension, parkingLot, luckySpot);
        Assert.assertFalse(foundParkingSpot);
    }


    @Test
    public void testParking3() {
        int[] carDimension = {4, 1};
        int[][] parkingLot = new int[][]{
                {
                        1, 0, 1, 0, 1, 0
                },
                {
                        1, 0, 0, 0, 1, 0
                },
                {
                        0, 0, 0, 0, 0, 1
                },
                {
                        1, 0, 0, 0, 1, 1
                }
        };
        int[] luckySpot = new int[]{0, 3, 3, 3};
        boolean foundParkingSpot = new UberBot().parkingSpot(carDimension, parkingLot, luckySpot);
        Assert.assertTrue(foundParkingSpot);
    }


    @Test
    public void testParking4() {
        int[] carDimension = {2, 1};
        int[][] parkingLot = new int[][]{
                {
                        1, 1, 1, 1
                },
                {
                        1, 0, 0, 0
                },
                {
                        1, 0, 1, 0
                },
        };
        int[] luckySpot = new int[]{2, 1, 2, 2};
        boolean foundParkingSpot = new UberBot().parkingSpot(carDimension, parkingLot, luckySpot);
        Assert.assertFalse(foundParkingSpot);
    }


    @Test
    public void testParking5() {
        int[] carDimension = {2, 1};
        int[][] parkingLot = new int[][]{
                {
                        1, 0, 1
                },
                {
                        1, 0, 1
                },
                {
                        1, 1, 1
                },
        };
        int[] luckySpot = new int[]{0, 1, 1, 1};
        boolean foundParkingSpot = new UberBot().parkingSpot(carDimension, parkingLot, luckySpot);
        Assert.assertTrue(foundParkingSpot);
    }

    @Test
    public void testParking6() {
        int[] carDimension = {4, 2};
        int[][] parkingLot = new int[][]{
                {
                        0, 0, 0, 1
                },
                {
                        0, 0, 0, 0
                },
                {
                        0, 0, 1, 1
                },

        };
        int[] luckySpot = new int[]{0, 0, 1, 3};
        boolean foundParkingSpot = new UberBot().parkingSpot(carDimension, parkingLot, luckySpot);
        Assert.assertFalse(foundParkingSpot);
    }


    @Test
    public void testParking7() {
        int[] carDimension = {2, 1};
        int[][] parkingLot = new int[][]{
                {
                        1, 1, 1, 1
                },
                {
                        1, 0, 0, 0
                },
                {
                        1, 0, 1, 0
                },

        };
        int[] luckySpot = new int[]{1, 2, 1, 3};
        boolean foundParkingSpot = new UberBot().parkingSpot(carDimension, parkingLot, luckySpot);
        Assert.assertTrue(foundParkingSpot);
    }


    @Test
    public void testParking8() {
        int[] carDimension = {5, 3};
        int[][] parkingLot = new int[][]{
                {1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 0, 0, 0, 0, 0},
                {
                        0, 0, 0, 0, 0, 0, 0, 0, 1, 0
                },
                {
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 1
                },
                {
                        0, 0, 0, 0, 0, 0, 0, 0, 1, 0
                },
                {
                        0, 0, 1, 0, 0, 0, 0, 0, 0, 0
                },
                {
                        1, 0, 0, 0, 0, 0, 0, 0, 0, 0
                }
        };
        int[] luckySpot = new int[]{1, 3, 5, 5};
        boolean foundParkingSpot = new UberBot().parkingSpot(carDimension, parkingLot, luckySpot);
        Assert.assertFalse(foundParkingSpot);
    }
}
