package com.scavi.brainsqueeze.adventofcode.y2017;

public class Day15DuelingGenerators {
    private static final long MULTIPLY_A = 16807;
    private static final long MULTIPLY_B = 48271;
    private static final long DIVIDER = 2147483647;


    public int solveA(long generatorA, long generatorB) {
        int result = 0;
        for (int i = 0; i < 40000000; ++i) {
            generatorA = (generatorA * MULTIPLY_A) % DIVIDER;
            generatorB = (generatorB * MULTIPLY_B) % DIVIDER;
            result = last(generatorA) == last(generatorB) ? result + 1 : result;
        }
        return result;
    }

    public int solveB(long generatorA, long generatorB) {
        int compareCount = 0;
        int result = 0;

        while (compareCount < 5000000) {
            do {
                generatorA = (generatorA * MULTIPLY_A) % DIVIDER;
            } while ((generatorA % 4) != 0);
            do {
                generatorB = (generatorB * MULTIPLY_B) % DIVIDER;
            } while ((generatorB % 8) != 0);
            ++compareCount;
            result = last(generatorA) == last(generatorB) ? result + 1 : result;
        }
        return result;
    }

    private short last(final long value) {
        return (short) ((value & 0xffff) - ((value & 0x0800) << 1));
    }
}
