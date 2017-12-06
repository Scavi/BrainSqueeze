package com.scavi.brainsqueeze.adventofcode.y2017;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Day6MemoryReallocation {
    public int solveA(final int[] input) {
        Set<String> cache = new HashSet<>();
        int cycle = 0;
        boolean foundCycle = false;
        while (!foundCycle) {
            String lookup = Arrays.toString(input);
            if (cache.contains(lookup)) {
                foundCycle = true;
            } else {
                cache.add(lookup);
                int pos = 0;
                for (int i = 1; i < input.length; ++i) {
                    pos = input[i] > input[pos] ? i : pos;
                }
                int overflow = input[pos];
                input[pos] = 0;

                for (int i = 0; i < overflow; ++i) {
                    input[++pos % input.length] += 1;
                }
                ++cycle;
            }
        }
        return cycle;
    }


    public int solveB(final int[] input) {
        solveA(input);
        return solveA(input);
    }


}
