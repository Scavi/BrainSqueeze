package com.scavi.brainsqueeze.adventofcode.y2017;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class SpiralMemoryTest {
    @Test
    public void test0() {
        new SpiralMemory().solveA(23);
        new SpiralMemory().solveA(19);
        new SpiralMemory().solveA(14);
        new SpiralMemory().solveA(11);
    }

    @Test
    public void test1() {
        int requiredSteps = new SpiralMemory().solveA(1024);
        assertThat(requiredSteps).isEqualTo(31);
    }

    @Test
    public void testQuestion1() {
        int requiredSteps = new SpiralMemory().solveA(289326);
        assertThat(requiredSteps).isEqualTo(419);
    }

    @Test
    public void testQuestion2() {
        int nextLargerValue = new SpiralMemory().solveB(289326);
        assertThat(nextLargerValue).isEqualTo(295229);
    }
}
