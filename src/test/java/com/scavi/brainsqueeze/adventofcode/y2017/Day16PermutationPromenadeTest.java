package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.util.FileHelper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.google.common.truth.Truth.assertThat;

public class Day16PermutationPromenadeTest {
    @Test
    public void test1() throws CloneNotSupportedException {
        String order = new Day16PermutationPromenade().solveA("s1,x3/4,pe/b", "abcde");
        assertThat(order).isEqualTo("baedc");
    }


    @Test
    public void testQuestionA() throws IOException, CloneNotSupportedException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day16.txt");
        String[] input = FileHelper.readLines(inputFile);
        String order = new Day16PermutationPromenade().solveA(input[0], "abcdefghijklmnop");
        assertThat(order).isEqualTo("glnacbhedpfjkiom");
    }

    @Test
    public void testQuestionB() throws IOException, CloneNotSupportedException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day16.txt");
        String[] input = FileHelper.readLines(inputFile);
        String order = new Day16PermutationPromenade().solveB(input[0], "abcdefghijklmnop");
        assertThat(order).isEqualTo("fmpanloehgkdcbji");
    }
}
