package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.util.FileHelper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.google.common.truth.Truth.*;

public class Day24ElectromagneticMoatTest {
    @Test
    public void test1() {
        String[] input = new String[]{
                "0/3",
                "3/7",
                "7/4"};
        int result = new Day24ElectromagneticMoat().solveA(input);
        assertThat(result).isEqualTo(24);
    }


    @Test
    public void test2() {
        String[] input = new String[]{
                "0/3",
                "3/10",
                "3/7",
                "10/0",
                "0/7",
                "7/4"};
        int result = new Day24ElectromagneticMoat().solveA(input);
        assertThat(result).isEqualTo(44);
    }

    @Test
    public void test3() {
        String[] input = new String[]{
                "0/2",
                "2/2",
                "2/3",
                "3/4",
                "3/5",
                "0/1",
                "10/1",
                "9/10"};
        int result = new Day24ElectromagneticMoat().solveA(input);
        assertThat(result).isEqualTo(31);
    }

    @Test
    public void test4() {
        String[] input = new String[]{
                "0/2",
                "2/2",
                "2/3",
                "3/5"};
        int result = new Day24ElectromagneticMoat().solveA(input);
        assertThat(result).isEqualTo(19);
    }


    @Test
    public void test5() {
        String[] input = new String[]{
                "0/2",
                "2/2",
                "2/4",
                "5/0",
                "3/5",
                "2/3",
                "4/0"};
        int result = new Day24ElectromagneticMoat().solveA(input);
        assertThat(result).isEqualTo(34);
    }


    @Test
    public void test6() {
        String[] input = new String[]{
                "0/2",
                "2/2",
                "2/3",
                "3/4",
                "3/5"};
        int result = new Day24ElectromagneticMoat().solveB(input);
        assertThat(result).isEqualTo(19);
    }


    @Test
    public void test7() {
        String[] input = new String[]{
                "0/2",
                "2/2",
                "2/3",
                "3/4",
                "3/5",
                "0/1",
                "10/1",
                "9/10"};
        int result = new Day24ElectromagneticMoat().solveB(input);
        assertThat(result).isEqualTo(19);
    }


    @Test
    public void testQuestion1() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day24.txt");
        String[] puzzleInput = FileHelper.readLines(inputFile);
        int result = new Day24ElectromagneticMoat().solveA(puzzleInput);
        assertThat(result).isEqualTo(1656);
    }


    @Test
    public void testQuestion2() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day24.txt");
        String[] puzzleInput = FileHelper.readLines(inputFile);
        int result = new Day24ElectromagneticMoat().solveB(puzzleInput);
        assertThat(result).isEqualTo(1642);
    }
}
