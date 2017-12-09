package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.util.FileHelper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.google.common.truth.Truth.*;

public class Day9StreamProcessingTest {
    @Test
    public void testQuestion1() {
        int score = new Day9StreamProcessing().solveA("{{{}}}");
        assertThat(score).isEqualTo(6);
    }


    @Test
    public void test2() {
        int score = new Day9StreamProcessing().solveA("{{{},{},{{}}}}");
        assertThat(score).isEqualTo(16);
    }


    @Test
    public void test3() {
        int score = new Day9StreamProcessing().solveA("{{<a!>},{<a!>},{<a!>},{<ab>}}");
        assertThat(score).isEqualTo(3);
    }


    @Test
    public void test4() {
        int garbage = new Day9StreamProcessing().solveB("{<{!>}>}");
        assertThat(garbage).isEqualTo(2);
    }


    @Test
    public void test5() {
        int garbage = new Day9StreamProcessing().solveB("{<!!!>>}");
        assertThat(garbage).isEqualTo(0);
    }


    @Test
    public void testQuestionA() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day9.txt");
        String[] input = FileHelper.readLines(inputFile);
        int score = new Day9StreamProcessing().solveA(input[0]);
        assertThat(score).isEqualTo(14204);
    }


    @Test
    public void testQuestionB() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day9.txt");
        String[] input = FileHelper.readLines(inputFile);
        int gargabe = new Day9StreamProcessing().solveB(input[0]);
        assertThat(gargabe).isEqualTo(6622);
    }
}
