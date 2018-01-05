package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.util.FileHelper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.google.common.truth.Truth.assertThat;

/**
 * @author Michael Heymel
 * @since 27.12.17
 */
public class Day23CoprocessorConflagrationTest {
    @Test
    public void testQuestionA() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day23.txt");
        String[] instructions = FileHelper.readLines(inputFile);
        int result = new Day23CoprocessorConflagration().solveA(instructions);
        assertThat(result).isEqualTo(4225);
    }


    @Test
    public void testQuestionB() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day23.txt");
        String[] instructions = FileHelper.readLines(inputFile);
        long result = new Day23CoprocessorConflagration().solveB(instructions);
        assertThat(result).isEqualTo(4225);
    }
}
