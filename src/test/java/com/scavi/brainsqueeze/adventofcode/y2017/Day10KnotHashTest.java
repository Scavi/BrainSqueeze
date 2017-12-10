package com.scavi.brainsqueeze.adventofcode.y2017;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class Day10KnotHashTest {

    @Test
    public void test1() {
        int[] testData = createTestData(4);
        int[] range = new int[]{3, 4, 1, 5};

        int result = new Day10KnotHash().solveA(testData, range);
        assertThat(result).isEqualTo(12);
    }


    @Test
    public void test2() {
        int[] testData = createTestData(255);
        String result = new Day10KnotHash().solveB(testData, "");
        assertThat(result).isEqualTo("a2582a3a0e66e6e86e3812dcb672a272");
    }


    @Test
    public void test3() {
        String range = "1,2,3";
        int[] testData = createTestData(255);
        String result = new Day10KnotHash().solveB(testData, range);
        assertThat(result).isEqualTo("3efbe78a8d82f29979031a4aa0b16a9d");
    }


    @Test
    public void test4() {
        String range = "1,2,4";
        int[] testData = createTestData(255);
        String result = new Day10KnotHash().solveB(testData, range);
        assertThat(result).isEqualTo("63960835bcdc130f0b66d7ff4f6a5a8e");
    }



    @Test
    public void testQuestionA() {
        int[] testData = createTestData(255);
        int[] range = new int[]{106, 118, 236, 1, 130, 0, 235, 254, 59, 205, 2, 87, 129, 25, 255, 118};
        int result = new Day10KnotHash().solveA(testData, range);
        assertThat(result).isEqualTo(6909);
    }


    @Test
    public void testQuestionB() {
        //String range = "1,2,3";
        String range = "106,118,236,1,130,0,235,254,59,205,2,87,129,25,255,118";
        int[] testData = createTestData(255);
        String result = new Day10KnotHash().solveB(testData, range);
        assertThat(result).isEqualTo("3efbe78a8d82f29979031a4aa0b16a9d");
    }


    private int[] createTestData(final int range) {
        int[] testData = new int[range + 1];
        for (int i = 1; i <= range; ++i) {
            testData[i] = i;
        }
        return testData;
    }
}
