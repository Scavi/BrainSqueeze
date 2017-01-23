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

package com.scavi.brainsqueeze.dp;

import com.google.common.base.Preconditions;

/**
 * @author Michael Heymel
 * @since 20/01/17
 */
public class WineParty {
    private final int _partyStart;
    private final int _partyEnd;


    /**
     * Constructor
     * </p>
     * default from 18:00 to 23:59
     */
    public WineParty() {
        this(1800, 2359);
    }


    /**
     * Constructor
     * </p>
     *
     * @param partyStart the start time of the party
     * @param partyEnd   the end time of the party
     */
    public WineParty(final int partyStart, final int partyEnd) {
        _partyStart = partyStart;
        _partyEnd = partyEnd;
    }


    /**
     * Determines the minimum amount of wine glasses for the guests. The guest arrivals is expected
     * to contain a start and an end date.
     * <p/>
     * The method runs in O(n)
     *
     * @param guestArrivals an array for all guest arrival and departures
     * @return the minimum amount of wine glasses
     */
    public int minGlasses(final int[][] guestArrivals) {
        Preconditions.checkNotNull(guestArrivals);
        if (guestArrivals.length == 0) {
            return 0;
        }
        Preconditions.checkArgument(guestArrivals[0].length != 0,
                "Illegal guest information (expected 2): ",
                guestArrivals[0].length);

        int requiredGlasses = 0;
        int[] arrivalCache = new int[getBase()];
        int[] departureCache = new int[getBase()];
        fillCaches(guestArrivals, arrivalCache, departureCache);

        int tmp = 0;
        for (int i = 0; i < arrivalCache.length; ++i) {
            tmp += arrivalCache[i];
            requiredGlasses = Math.max(tmp, requiredGlasses);
            tmp -= departureCache[i];
        }
        return requiredGlasses;
    }


    /**
     * Fills a arrival and a departure cache for all guests
     *
     * @param guestArrivals  an array for all guest arrival and departures
     * @param arrivalCache   the arrival dp cache
     * @param departureCache the departure dp cache
     */
    private void fillCaches(final int[][] guestArrivals, final int[] arrivalCache,
            final int[] departureCache) {
        for (int i = 0; i < guestArrivals.length; ++i) {
            arrivalCache[guestArrivals[i][0] - _partyStart] += 1;
            departureCache[guestArrivals[i][1] - _partyStart] += 1;
        }
    }


    /**
     * @return the base for the party
     */
    private int getBase() {
        return _partyEnd - _partyStart;
    }
}
