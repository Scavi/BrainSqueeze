package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.util.FileHelper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.google.common.truth.Truth.*;

public class Day2CorruptionChecksumTest {
    @Test
    public void test1() {
        int[][] input = new int[][]{
                {5, 1, 9, 5},
                {7, 5, 3, 7},
                {2, 4, 6, 8}
        };
        int sum = new Day2CorruptionChecksum().solveA(input);
        assertThat(sum).isEqualTo(18);
    }

    @Test
    public void testQuestion1() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day2.txt");
        int[][] input = FileHelper.toIntMatrix(inputFile);
        int sum = new Day2CorruptionChecksum().solveA(input);
        assertThat(sum).isEqualTo(42299);
    }


    @Test
    public void test2() {
        int[][] input = new int[][]{
                {5, 9, 2, 8},
                {9, 4, 7, 3},
                {3, 8, 6, 5}
        };
        int sum = new Day2CorruptionChecksum().solveB(input);
        assertThat(sum).isEqualTo(9);
    }


    @Test
    public void testQuestion2() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day2.txt");
        int[][] input = FileHelper.toIntMatrix(inputFile);
        int sum = new Day2CorruptionChecksum().solveB(input);
        assertThat(sum).isEqualTo(277);
    }
}
