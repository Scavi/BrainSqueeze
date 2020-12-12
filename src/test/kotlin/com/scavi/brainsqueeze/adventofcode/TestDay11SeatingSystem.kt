package com.scavi.brainsqueeze.adventofcode

import com.scavi.brainsqueeze.adventofcode.util.FileHelper
import org.junit.Test
import kotlin.test.assertEquals

class TestDay11SeatingSystem {
    private val dummyInput = listOf(
            "L.LL.LL.LL".toCharArray(),
            "LLLLLLL.LL".toCharArray(),
            "L.L.L..L..".toCharArray(),
            "LLLL.LL.LL".toCharArray(),
            "L.LL.LL.LL".toCharArray(),
            "L.LLLLL.LL".toCharArray(),
            "..L.L.....".toCharArray(),
            "LLLLLLLLLL".toCharArray(),
            "L.LLLLLL.L".toCharArray(),
            "L.LLLLL.LL".toCharArray()
    )

    @Test
    fun validateA1() {
        val output = Day11SeatingSystem(Strategy.Plan).solve(dummyInput)
        assertEquals(37, output)
    }

    @Test
    fun solveA() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day11.txt")
        val input = FileHelper.readAsCharArray(filePath)
        val output = Day11SeatingSystem(Strategy.Plan).solve(input)
        assertEquals(2468, output)
    }

    @Test
    fun validateB1() {
        val output = Day11SeatingSystem(Strategy.Reality).solve(dummyInput)
        assertEquals(26, output)
    }

    @Test
    fun solveB() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day11.txt")
        val input = FileHelper.readAsCharArray(filePath)
        val output = Day11SeatingSystem(Strategy.Reality).solve(input)
        assertEquals(2214, output)
    }
}
