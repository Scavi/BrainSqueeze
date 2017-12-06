package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.util.FileHelper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.google.common.truth.Truth.*;

public class Day4HighEntropyPassphrasesTest {
    @Test
    public void testQuestion1() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day4.txt");
        String[] lines = FileHelper.readLines(inputFile);
        int cnt = new Day4HighEntropyPassphrases().solve(lines, false);
        assertThat(cnt).isEqualTo(455);
    }

    @Test
    public void testQuestion2() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day4.txt");
        String[] lines = FileHelper.readLines(inputFile);
        int cnt = new Day4HighEntropyPassphrases().solve(lines, true);
        assertThat(cnt).isEqualTo(186);
    }
}
