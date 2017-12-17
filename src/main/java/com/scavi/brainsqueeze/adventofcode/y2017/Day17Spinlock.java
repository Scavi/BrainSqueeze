package com.scavi.brainsqueeze.adventofcode.y2017;

import java.util.ArrayList;
import java.util.List;

public class Day17Spinlock {

    public int solveA(final int steps) {
        List<Integer> whirlwind = new ArrayList<>(2018);
        int pos = 0;
        whirlwind.add(0);
        for (int i = 1; i < 2018; ++i) {
            pos = ((pos + steps) % whirlwind.size()) + 1;
            whirlwind.add(pos, i);
        }
        return whirlwind.get((pos + 1) % whirlwind.size());
    }


    public int solveB(final int steps) {
        int result = 0;
        int pos = 0;
        for (int i = 1; i <= 50000000; ++i) {
            pos = ((pos + steps) % i) + 1;
            result = pos == 1 ? i : result;
        }
        return result;
    }
}
