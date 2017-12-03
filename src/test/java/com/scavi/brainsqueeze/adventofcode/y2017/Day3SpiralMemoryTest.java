package com.scavi.brainsqueeze.adventofcode.y2017;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class Day3SpiralMemoryTest {
    @Test
    public void test0() {
        new Day3SpiralMemory().solveA(23);
        new Day3SpiralMemory().solveA(19);
        new Day3SpiralMemory().solveA(14);
        new Day3SpiralMemory().solveA(11);
    }

    @Test
    public void test1() {
        int requiredSteps = new Day3SpiralMemory().solveA(1024);
        assertThat(requiredSteps).isEqualTo(31);
    }

    @Test
    public void testQuestion1() {
        int requiredSteps = new Day3SpiralMemory().solveA(289326);
        assertThat(requiredSteps).isEqualTo(419);
    }

    @Test
    public void testQuestion2() {
        int nextLargerValue = new Day3SpiralMemory().solveB(289326);
        assertThat(nextLargerValue).isEqualTo(295229);
    }
}
