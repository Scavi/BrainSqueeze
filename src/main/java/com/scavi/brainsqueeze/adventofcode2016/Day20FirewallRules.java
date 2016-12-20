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
import com.scavi.brainsqueeze.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Question: http://adventofcode.com/2016/day/20
 *
 * @author Michael Heymel
 * @since 20/12/16
 */
public class Day20FirewallRules {
    /**
     * Find the lowest ip address that is not on the black list. This algorithm has a runtime of
     * O(n log n) for sorting + O(n) to determine the lowest ip address
     *
     * @param blackListData the black list ranges in the format long-long
     * @return the lowest valid ip address
     */
    public long findLowestIpAddress(final String[] blackListData) {
        Preconditions.checkNotNull(blackListData, "Illegal black list data: <null>");
        List<Pair<Long, Long>> blackList = from(blackListData);
        long lowestIp = 0;
        for (Pair<Long, Long> blackListEntry : blackList) {
            if (blackListEntry.getKey() <= lowestIp) {
                lowestIp = blackListEntry.getValue() + 1;
            } else {
                break;
            }
        }
        return lowestIp;
    }


    /**
     * Finds the amount of allowed ip addresses in the IP address range of 0 - 4294967295
     *
     * @param blackListData the black list ranges in the format long-long
     * @return the amount of not blocked ip addresses
     */
    public long findAllowedIpAddresses(final String[] blackListData) {
        Preconditions.checkNotNull(blackListData, "Illegal black list data: <null>");
        List<Pair<Long, Long>> blackList = from(blackListData);
        long allowedIpAddresses = 0;
        long lowestIp = 0;
        for (Pair<Long, Long> blackListEntry : blackList) {
            if (blackListEntry.getKey() > lowestIp) {
                allowedIpAddresses += blackListEntry.getKey() - lowestIp;
            }
            if (lowestIp < blackListEntry.getValue()) {
                lowestIp = blackListEntry.getValue() + 1;
            }
        }
        return allowedIpAddresses + (4294967295L - lowestIp) + 1;
    }


    /**
     * Creates a Pair<Long, Long> from the given black list data in the format long-long. Also sorts
     * the black list entries by their key
     *
     * @param blackListData the black list data
     * @return the sorted array list of black list entries
     */
    private List<Pair<Long, Long>> from(final String[] blackListData) {
        List<Pair<Long, Long>> blackList = new ArrayList<>(blackListData.length);
        for (String blackListIp : blackListData) {
            String[] range = blackListIp.split("-");
            blackList.add(new Pair<>(Long.parseLong(range[0]), Long.parseLong(range[1])));
        }
        Collections.sort(blackList);
        return blackList;
    }
}
