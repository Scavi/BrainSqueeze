package com.scavi.brainsqueeze.adventofcode

import com.scavi.brainsqueeze.adventofcode.util.FileHelper
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TestDay8HandheldHalting {
    private val inputDummy = mutableListOf("nop +0", "acc +1", "jmp +4", "acc +3", "jmp -3",
            "acc -99", "acc +1", "jmp -4", "acc +6")

    @Test
    fun validateA1() {
        val output = Day8HandheldHalting().solveA(inputDummy)
        assertEquals(5, output.first)
    }

    @Test
    fun validateB1() {
        val output = Day8HandheldHalting().solveB(inputDummy)
        assertEquals(8, output.first)
    }

    @Test
    fun solveA() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day8.txt")
        val input = filePath.reader().readLines().toMutableList()
        val output = Day8HandheldHalting().solveA(input)
        assertEquals(1723, output.first)
    }

    @Test
    fun solveB() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day8.txt")
        val input = filePath.reader().readLines().toMutableList()
        val output = Day8HandheldHalting().solveB(input)
        assertTrue(output.second)
        assertEquals(846, output.first)
    }
}
