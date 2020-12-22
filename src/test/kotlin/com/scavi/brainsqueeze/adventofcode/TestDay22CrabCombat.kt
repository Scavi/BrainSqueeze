package com.scavi.brainsqueeze.adventofcode

import com.scavi.brainsqueeze.adventofcode.util.FileHelper
import org.junit.Test
import kotlin.test.assertEquals

class TestDay22CrabCombat {
    private val dummyInput = listOf("Player 1:", "9", "2", "6", "3", "1",
            "", "Player 2:", "5", "8", "4", "7", "10")

    @Test
    fun validateA1() {
        val day22 = Day22CrabCombat()
        val output = day22.solveA(dummyInput)
        assertEquals(306, output)
    }

    @Test
    fun validateB1() {
        val day22 = Day22CrabCombat()
        val output = day22.solveB(dummyInput)
        assertEquals(291, output)
    }

    @Test
    fun solveA() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day22.txt")
        val input = filePath.reader().readLines()
        val day22 = Day22CrabCombat()
        val output = day22.solveA(input)
        assertEquals(29764, output)
    }

    @Test
    fun solveB() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day22.txt")
        val input = filePath.reader().readLines()
        val day22 = Day22CrabCombat()
        val output = day22.solveB(input)
        assertEquals(32588, output)
    }
}
