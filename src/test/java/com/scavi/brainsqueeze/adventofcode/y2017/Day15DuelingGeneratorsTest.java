package com.scavi.brainsqueeze.adventofcode.y2017;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class Day15DuelingGeneratorsTest {
    @Test
    public void test1() {
        int result = new Day15DuelingGenerators().solveA(65, 8921);
        assertThat(result).isEqualTo(588);
    }

    @Test
    public void testQuestion1() {
        int result = new Day15DuelingGenerators().solveA(512, 191);
        assertThat(result).isEqualTo(567);
    }


    @Test
    public void test2() {
        int result = new Day15DuelingGenerators().solveB(65, 8921);
        assertThat(result).isEqualTo(309);
    }


    @Test
    public void testQuestion2() {
        int result = new Day15DuelingGenerators().solveB(512, 191);
        assertThat(result).isEqualTo(323);
    }
}
