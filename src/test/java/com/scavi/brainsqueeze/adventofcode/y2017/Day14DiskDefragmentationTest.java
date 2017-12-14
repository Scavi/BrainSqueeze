package com.scavi.brainsqueeze.adventofcode.y2017;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class Day14DiskDefragmentationTest {

    @Test
    public void test1() {
        int squareCount = new Day14DiskDefragmentation().solveA("flqrgnkx");
        assertThat(squareCount).isEqualTo(8108);
    }


    @Test
    public void testQuestionA() {
        int squareCount = new Day14DiskDefragmentation().solveA("hfdlxzhv");
        assertThat(squareCount).isEqualTo(8230);
    }


    @Test
    public void testQuestionB() {
        int squareCount = new Day14DiskDefragmentation().solveB("hfdlxzhv");
        assertThat(squareCount).isEqualTo(1103);
    }
}
