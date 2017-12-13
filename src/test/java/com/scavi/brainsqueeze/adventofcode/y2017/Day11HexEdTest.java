package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.util.FileHelper;
import com.scavi.brainsqueeze.util.StringHelper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.google.common.truth.Truth.assertThat;

public class Day11HexEdTest {
    @Test
    public void test1() {
        String moves = "se,sw,se,sw,sw";
        int distance = new Day11HexEd().solveA(StringHelper.split(moves, ","));
        assertThat(distance).isEqualTo(3);
    }


    @Test
    public void test2() {
        String moves = "ne,ne,s,s";
        int distance = new Day11HexEd().solveA(StringHelper.split(moves, ","));
        assertThat(distance).isEqualTo(2);
    }


    @Test
    public void testQuestion1() throws IOException {
        int distance = new Day11HexEd().solveA(createMoves());
        assertThat(distance).isEqualTo(818);
    }


    @Test
    public void testQuestion2() throws IOException {
        int distance = new Day11HexEd().solveB(createMoves());
        assertThat(distance).isEqualTo(1596);
    }


    private String[] createMoves() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day11.txt");
        String[] input = FileHelper.readLines(inputFile);
        return StringHelper.split(input[0], ",");
    }
}
