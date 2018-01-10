package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.util.FileHelper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.google.common.truth.Truth.assertThat;

public class Day21FractalArtTest {

    @Test
    public void test1() {
        String[] ruleData = new String[]{
                "../.# => ##./#../...",
                ".#./..#/### => #..#/..../..../#..#"
        };
        char[][] grid = new char[][]{
                ".#.".toCharArray(),
                "..#".toCharArray(),
                "###".toCharArray()
        };
        Day21FractalArt fractal = new Day21FractalArt();
        int lightedPixels = fractal.solveA(grid, ruleData, 2);
        assertThat(lightedPixels).isEqualTo(12);
    }


    @Test
    public void testQuestionA() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day21.txt");
        String[] ruleData = FileHelper.readLines(inputFile);
        char[][] grid = new char[][]{
                ".#.".toCharArray(),
                "..#".toCharArray(),
                "###".toCharArray()
        };
        Day21FractalArt fractal = new Day21FractalArt();
        int lightedPixels = fractal.solveA(grid, ruleData, 5);
        assertThat(lightedPixels).isEqualTo(12);
    }
}
