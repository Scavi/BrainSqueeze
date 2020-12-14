package com.scavi.brainsqueeze.adventofcode

import com.scavi.brainsqueeze.adventofcode.util.FileHelper
import org.junit.Test
import kotlin.test.assertEquals

class TestDay14DockingData {
    @Test
    fun validateA1() {
        val input = listOf(
                "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X",
                "mem[8] = 11",
                "mem[7] = 101",
                "mem[8] = 0")
        val output = Day14DockingData(false).solve(input)
        assertEquals(165, output)
    }

    @Test
    fun solveA() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day14.txt")
        val input = filePath.reader().readLines().toMutableList()
        val output = Day14DockingData(false).solve(input)
        assertEquals(16003257187056L, output)
    }

    @Test
    fun validateB1() {
        val input = listOf(
                "mask = 000000000000000000000000000000X1001X",
                "mem[42] = 100",
                "mask = 00000000000000000000000000000000X0XX",
                "mem[26] = 1"
        )
        val output = Day14DockingData(true).solve(input)
        assertEquals(208, output)
    }

    @Test
    fun solveB() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day14.txt")
        val input = filePath.reader().readLines().toMutableList()
        val output = Day14DockingData(true).solve(input)
        assertEquals(3219837697833L, output)
    }
}
