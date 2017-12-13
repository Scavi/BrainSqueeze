package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.util.FileHelper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.google.common.truth.Truth.*;

public class Day12DigitalPlumberTest {

    @Test
    public void test1() {
        String[] graphData = new String[]{
                "0 <-> 2",
                "1 <-> 1",
                "2 <-> 0, 3, 4",
                "3 <-> 2, 4",
                "4 <-> 2, 3, 6",
                "5 <-> 6",
                "6 <-> 4, 5"
        };
        int result = new Day12DigitalPlumber().solveA(graphData);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void test2() {
        String[] graphData = new String[]{
                "0 <-> 2",
                "1 <-> 1",
                "2 <-> 0, 3, 4",
                "3 <-> 2, 4",
                "4 <-> 2, 3, 6",
                "5 <-> 6",
                "6 <-> 4, 5"
        };
        int result = new Day12DigitalPlumber().solveB(graphData);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void testQuestionA() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day12.txt");
        String[] graphData = FileHelper.readLines(inputFile);
        int result = new Day12DigitalPlumber().solveA(graphData);
        assertThat(result).isEqualTo(152);
    }


    @Test
    public void testQuestionB() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day12.txt");
        String[] graphData = FileHelper.readLines(inputFile);
        int result = new Day12DigitalPlumber().solveB(graphData);
        assertThat(result).isEqualTo(186);
    }
}
