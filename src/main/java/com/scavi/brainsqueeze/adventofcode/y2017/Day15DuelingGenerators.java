package com.scavi.brainsqueeze.adventofcode.y2017;

import java.util.LinkedList;
import java.util.Queue;

public class Day15DuelingGenerators {
    private static final long MULTIPLY_A = 16807;
    private static final long MULTIPLY_B = 48271;
    private static final long DIVIDER = 2147483647;

    public int solveA(long generatorA, long generatorB) {
        int result = 0;
        for (int i = 0; i < 40000000; ++i) {
            generatorA = (generatorA * MULTIPLY_A) % DIVIDER;
            generatorB = (generatorB * MULTIPLY_B) % DIVIDER;
            result = createBinary(generatorA).equals(createBinary(generatorB)) ? result + 1 : result;
        }
        return result;
    }


    public int solveB(long generatorA, long generatorB) {
        int compareCount = 0;
        int result = 0;

        Queue<String> aData = new LinkedList<>();
        Queue<String> bData = new LinkedList<>();
        while (compareCount < 5000000) {
            generatorA = (generatorA * MULTIPLY_A) % DIVIDER;
            generatorB = (generatorB * MULTIPLY_B) % DIVIDER;
            if ((generatorA % 4) == 0) {
                aData.offer(createBinary(generatorA));
            }
            if ((generatorB % 8) == 0) {
                bData.offer(createBinary(generatorB));
            }
            while (!aData.isEmpty() && !bData.isEmpty()) {
                ++compareCount;
                result = aData.poll().equals(bData.poll()) ? result + 1 : result;
            }
        }
        return result;
    }

    private String createBinary(final long value) {
        return Long.toBinaryString((value & 0xffff) - ((value & 0x0800) << 1));
    }
}
