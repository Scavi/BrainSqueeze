package com.scavi.brainsqueeze.career;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class BinaryStringInStringTest {

    @Test
    public void test1_1() {
        BinaryStringInString testBinString = new BinaryStringInString();
        boolean isExisting = testBinString.checkBinariesExisting("01100", 2);
        assertThat(isExisting).isTrue();
    }


    @Test
    public void test1_2() {
        BinaryStringInString testBinString = new BinaryStringInString();
        boolean isExisting = testBinString.checkBinariesExisting("0110", 3);
        assertThat(isExisting).isFalse();
    }


    @Test
    public void test2_1() {
        BinaryStringInString testBinString = new BinaryStringInString();
        String result = testBinString.stringOfAllBin(3);
        assertThat(result).isEqualTo("000001010011100101110111");
    }


    @Test
    public void test3_1() {
        BinaryStringInString testBinString = new BinaryStringInString();
        String result = testBinString.shortestStringOfAllBin(1);
        assertThat(result.length()).isEqualTo(2);
    }

    @Test
    public void test3_2() {
        BinaryStringInString testBinString = new BinaryStringInString();
        String result = testBinString.shortestStringOfAllBin(2);
        assertThat(result.length()).isEqualTo(5); // e.g. "11100"
    }


    @Test
    public void test3_3() {
        BinaryStringInString testBinString = new BinaryStringInString();
        String result = testBinString.shortestStringOfAllBin(3);
        assertThat(result.length()).isEqualTo(10);
    }


    @Test
    public void test3_4() {
        BinaryStringInString testBinString = new BinaryStringInString();
        String result = testBinString.shortestStringOfAllBin(4);
        assertThat(result.length()).isEqualTo(18);
    }


    @Test
    public void test3_5() {
        BinaryStringInString testBinString = new BinaryStringInString();
        String result = testBinString.shortestStringOfAllBin(5);
        assertThat(result.length()).isEqualTo(37);
    }

}
