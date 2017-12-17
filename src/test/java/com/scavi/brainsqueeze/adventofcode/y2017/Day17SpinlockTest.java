package com.scavi.brainsqueeze.adventofcode.y2017;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class Day17SpinlockTest {
    @Test
    public void testQuestion1() {
        int shortCircuitValue = new Day17Spinlock().solveA(344);
        assertThat(shortCircuitValue).isEqualTo(996);
    }

    @Test
    public void testQuestion2() {
        int shortCircuitValue = new Day17Spinlock().solveB(344);
        assertThat(shortCircuitValue).isEqualTo(1898341);
    }
}
