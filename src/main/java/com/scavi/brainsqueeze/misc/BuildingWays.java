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

package com.scavi.brainsqueeze.misc;

import com.google.common.base.Preconditions;

/**
 * @author Michael Heymel
 * @since 20/11/16
 */
public class BuildingWays {
    private final int[] _steps = new int[]{1, 2, 3};


    /**
     * A building has n steps. A person can take 1,2 or 3 steps. In how many ways can a person reach
     * top of building.
     * <p/>
     * This method uses dynamic programming to calculate the required steps.
     * It uses O(n) additional space and runs in O(n * m) while m is the amount of possible steps
     * (currently only 3)
     *
     * @param height the height to the top of the building
     * @return the number of ways
     */
    public int findWaysDp(final int height) {
        Preconditions.checkArgument(height >= 0, "Illegal height! Height must be 0 or greater.");
        if (height == 0) {
            return 0;
        }
        int length = height + 1;
        int[] dpCache = new int[length];
        dpCache[0] = 1; // initialize

        for (int i = 1; i < length; ++i) {
            for (int j = 0; j < _steps.length; ++j) {
                if (i - _steps[j] >= 0) {
                    dpCache[i] += dpCache[i - _steps[j]];
                } else {
                    break;
                }
            }
        }
        return dpCache[length - 1];
    }


    /**
     * A building has n steps. A person can take 1,2 or 3 steps. In how many ways can a person reach
     * top of building.
     * <p/>
     * Determines the number of possible ways to the top using the specified step array using the
     * recursive approach. This method is basically some way of brute force. The dp approach works
     * way better and quicker
     *
     * @param height the height to the top of the building
     * @return the number of ways
     */
    public int findWaysRecursive(final int height) {
        Preconditions.checkArgument(height >= 0, "Illegal height! Height must be 0 or greater.");
        return height == 0 ? 0 : determineWaysRecursive(height);
    }


    /**
     * Determines the number of possible ways to the top using the specified
     * step array using the recursive approach
     *
     * @param height the height to the top of the building
     * @return the number of ways
     */
    private int determineWaysRecursive(final int height) {
        if (height == 0) {
            return 1;
        }
        int numberOfWays = 0;
        for (int i = 0; i < _steps.length; ++i) {
            final int currentStepSize = _steps[i];
            if ((height - currentStepSize) >= 0) {
                numberOfWays += determineWaysRecursive(height - currentStepSize);
            }
        }
        return numberOfWays;
    }
}
