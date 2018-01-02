package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.util.FileHelper;
import com.scavi.brainsqueeze.util.StringHelper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.google.common.truth.Truth.*;

public class Day22SporificaVirusTest {
    @Test
    public void test1() {
        char[][] grid = new char[][]{
                "..#".toCharArray(),
                "#..".toCharArray(),
                "...".toCharArray()
        };
        int infected = new Day22SporificaVirus().solveA(grid);
        assertThat(infected).isEqualTo(5587);
    }


    @Test
    public void test2() {
        char[][] grid = new char[][]{
                "..#".toCharArray(),
                "#..".toCharArray(),
                "...".toCharArray()
        };
        int infected = new Day22SporificaVirus().solveB(grid);
        assertThat(infected).isEqualTo(2511944);
    }


    @Test
    public void testQuestion1() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day22.txt");
        char[][] grid = StringHelper.toCharArray(FileHelper.readLines(inputFile));
        int infected = new Day22SporificaVirus().solveA(grid);
        assertThat(infected).isEqualTo(5322);
    }



    @Test
    public void testQuestion2() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day22.txt");
        char[][] grid = StringHelper.toCharArray(FileHelper.readLines(inputFile));
        int infected = new Day22SporificaVirus().solveB(grid);
        assertThat(infected).isEqualTo(2512079);
    }
}
