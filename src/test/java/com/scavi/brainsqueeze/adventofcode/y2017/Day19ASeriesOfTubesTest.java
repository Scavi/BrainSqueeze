package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.util.FileHelper;
import com.scavi.brainsqueeze.util.StringHelper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.google.common.truth.Truth.assertThat;

public class Day19ASeriesOfTubesTest {

    @Test
    public void test1() {
        char[][] puzzle = StringHelper.toCharArray(new String[]{
                "     |          ",
                "     |  +--+    ",
                "     A  |  C    ",
                " F---|----E|--+ ",
                "     |  |  |  D ",
                "     +B-+  +--+ ",
                "                ",
        });
        String result = new Day19ASeriesOfTubes().solveA(puzzle);
        assertThat(result).isEqualTo("ABCDEF");
    }


    @Test
    public void testQuestion1() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day19.txt");
        char[][] puzzle = StringHelper.toCharArray(FileHelper.readLines(inputFile));

        String result = new Day19ASeriesOfTubes().solveA(puzzle);
        assertThat(result).isEqualTo("VTWBPYAQFU");
    }


    @Test
    public void testQuestionB() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day19.txt");
        char[][] puzzle = StringHelper.toCharArray(FileHelper.readLines(inputFile));

        long steps = new Day19ASeriesOfTubes().solveB(puzzle);
        assertThat(steps).isEqualTo(17358);
    }
}

