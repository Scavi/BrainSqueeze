package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.util.FileHelper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.google.common.truth.Truth.assertThat;

public class Day8IHeardYouLikeRegistersTest {
    @Test
    public void test1() {
        String[] input = new String[]{
                "b inc 5 if a > 1",
                "a inc 1 if b < 5",
                "c dec -10 if a >= 1",
                "c inc -20 if c == 10"
        };

        int max = new Day8IHeardYouLikeRegisters().solveA(input);
        assertThat(max).isEqualTo(1);
    }


    @Test
    public void testQuestionA() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day8.txt");
        String[] input = FileHelper.readLines(inputFile);
        int max = new Day8IHeardYouLikeRegisters().solveA(input);
        assertThat(max).isEqualTo(4647);
    }


    @Test
    public void testQuestionB() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day8.txt");
        String[] input = FileHelper.readLines(inputFile);
        int max = new Day8IHeardYouLikeRegisters().solveB(input);
        assertThat(max).isEqualTo(5590);
    }
}
