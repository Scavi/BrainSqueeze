package com.scavi.brainsqueeze.career;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TemperatureLookup {

    /**
     * This method receives an array of temperatures and determines how many days needs to be waited until a warmer
     * day will come day, e.g.:
     * [73, 74, 75, 71, 70, 76, 72] -> [1, 1, 3, 2, 1, -1, -1] (-1 => brrrrr it won't get warmer ;-) )
     * <p>
     * The method uses a Heap to run in O (n * log n) and uses O (n) space for the result
     *
     * @param temperatures the array of temperatures
     * @return the result with the days to wait
     */
    public int[] findWarmerDays(final int[] temperatures) {
        if (temperatures == null || temperatures.length < 2) {
            return null;
        }

        int[] days = new int[temperatures.length];
        Arrays.fill(days, -1);

        PriorityQueue<Integer> posCache = new PriorityQueue<>((x, y) -> y-x);
        posCache.offer(0);
        for (int i = 1; i < temperatures.length; ++i) {
            while (!posCache.isEmpty() && temperatures[posCache.peek()] < temperatures[i]) {
                days[posCache.peek()] = i - posCache.poll();
            }
            posCache.offer(i);
        }
        return days;
    }
}
