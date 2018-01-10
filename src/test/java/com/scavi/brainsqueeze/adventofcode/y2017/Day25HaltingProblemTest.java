package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.util.FileHelper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.google.common.truth.Truth.*;

public class Day25HaltingProblemTest {

    @Test
    public void test1() {
        String[] input = new String[]{"In state A:",
                "If the current value is 0:",
                "- Write the value 1.",
                "        - Move one slot to the right.",
                "        - Continue with state B.",
                "        If the current value is 1:",
                "- Write the value 0.",
                "        - Move one slot to the left.",
                "        - Continue with state B.",
                "",
                "        In state B:",
                "If the current value is 0:",
                "- Write the value 1.",
                "        - Move one slot to the left.",
                "        - Continue with state A.",
                "        If the current value is 1:",
                "- Write the value 1.",
                "        - Move one slot to the right.",
                "        - Continue with state A." };

        int diagnostic = new Day25HaltingProblem().solveA(input, 6, 'A');
        assertThat(diagnostic).isEqualTo(3);
    }


    @Test
    public void testQuestion1() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day25.txt");
        String[] puzzleInput = FileHelper.readLines(inputFile);
        int diagnostic = new Day25HaltingProblem().solveA(puzzleInput, 12656374, 'A');
        assertThat(diagnostic).isEqualTo(2526);
    }
}
