package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.util.FileHelper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.google.common.truth.Truth.*;

public class Day5MazeOfTwistyTrampolinesTest {

    @Test
    public void test1() {
        int[][] input = new int[][]{
                {0},
                {3},
                {0},
                {1},
                {-3}
        };
        int steps = new Day5MazeOfTwistyTrampolines().solve(input, false);
        assertThat(steps).isEqualTo(5);
    }

    @Test
    public void testQuestion1() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day5.txt");
        int[][] input = FileHelper.toIntMatrix(inputFile);

        int steps = new Day5MazeOfTwistyTrampolines().solve(input, false);
        assertThat(steps).isEqualTo(391540);
    }



    @Test
    public void test2() {
        int[][] input = new int[][]{
                {0},
                {3},
                {0},
                {1},
                {-3}
        };
        int steps = new Day5MazeOfTwistyTrampolines().solve(input, true);
        assertThat(steps).isEqualTo(10);
    }

    @Test
    public void testQuestion2() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day5.txt");
        int[][] input = FileHelper.toIntMatrix(inputFile);

        int steps = new Day5MazeOfTwistyTrampolines().solve(input, true);
        assertThat(steps).isEqualTo(30513679);
    }
}
