package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.util.FileHelper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.google.common.truth.Truth.*;

public class Day18DuetTest {

    @Test
    public void test1() {
        String[] instructions = new String[]{
                "set a 1",
                "add a 2",
                "mul a a",
                "mod a 5",
                "snd a",
                "set a 0",
                "rcv a",
                "jgz a -1",
                "set a 1",
                "jgz a -2"
        };
        long result = new Day18Duet().solveA(instructions);
        assertThat(result).isEqualTo(4);
    }


    @Test
    public void test2() throws Exception {
        String[] instructions = new String[]{
                "snd 1",
                "snd 2",
                "snd p",
                "rcv a",
                "rcv b",
                "rcv c",
                "rcv d"
        };
        long result = new Day18Duet().solveB(instructions);
        assertThat(result).isEqualTo(3);
    }


    @Test
    public void testQuestionA() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day18.txt");
        String[] instructions = FileHelper.readLines(inputFile);
        long result = new Day18Duet().solveA(instructions);
        assertThat(result).isEqualTo(4601);
    }


    @Test
    public void testQuestionB() throws Exception {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day18.txt");
        String[] instructions = FileHelper.readLines(inputFile);
        long result = new Day18Duet().solveB(instructions);
        assertThat(result).isEqualTo(6858);
    }
}
