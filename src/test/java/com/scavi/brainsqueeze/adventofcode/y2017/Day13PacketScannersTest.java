package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.util.FileHelper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.google.common.truth.Truth.*;

public class Day13PacketScannersTest {


    @Test
    public void testQuestion1() {
        String[] input = new String[]{
                "0: 3",
                "1: 2",
                "4: 4",
                "6: 4"
        };
        int severity = new Day13PacketScanners().solveA(input);
        assertThat(severity).isEqualTo(24);
    }


    @Test
    public void testQuestionA() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day13.txt");
        String[] scannerData = FileHelper.readLines(inputFile);
        int severity = new Day13PacketScanners().solveA(scannerData);
        assertThat(severity).isEqualTo(1844);
    }


    @Test
    public void testQuestionB() {
        String[] input = new String[]{
                "0: 3",
                "1: 2",
        };
        int severity = new Day13PacketScanners().solveB(input);
        assertThat(severity).isEqualTo(2);
    }

    @Test
    public void test2() {
        String[] input = new String[]{
                "0: 3",
                "1: 2",
                "4: 4",
                "6: 4"
        };
        int wait = new Day13PacketScanners().solveB(input);
        assertThat(wait).isEqualTo(10);
    }

//    @Test
//    public void testQuestionB() throws IOException {
//        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day13.txt");
//        String[] scannerData = FileHelper.readLines(inputFile);
//        int wait = new Day13PacketScanners().solveB(scannerData);
//        assertThat(wait).isEqualTo(3897604);
//    }
}
