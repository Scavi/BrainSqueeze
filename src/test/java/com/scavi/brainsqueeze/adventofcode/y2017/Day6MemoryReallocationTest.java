package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.util.FileHelper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.google.common.truth.Truth.assertThat;

public class Day6MemoryReallocationTest {
    @Test
    public void test1() {
        int cycleAfter = new Day6MemoryReallocation().solveA(new int[]{0, 2, 7, 0});
        assertThat(cycleAfter).isEqualTo(5);
    }


    @Test
    public void testQuestion1() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day6.txt");
        int[][] tmpInput = FileHelper.toIntMatrix(inputFile);

        int cycleAfter = new Day6MemoryReallocation().solveA(tmpInput[0]);
        assertThat(cycleAfter).isEqualTo(5042);
    }


    @Test
    public void test2() {
        int cycleAfter = new Day6MemoryReallocation().solveB(new int[]{0, 2, 7, 0});
        assertThat(cycleAfter).isEqualTo(4);
    }


    @Test
    public void testQuestion2() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day6.txt");
        int[][] tmpInput = FileHelper.toIntMatrix(inputFile);

        int cycleAfter = new Day6MemoryReallocation().solveB(tmpInput[0]);
        assertThat(cycleAfter).isEqualTo(1086);
    }

}
