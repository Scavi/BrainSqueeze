package com.scavi.brainsqueeze.adventofcode

import com.scavi.brainsqueeze.adventofcode.util.FileHelper
import org.junit.Test
import kotlin.test.assertEquals

class TestDay5BinaryBoarding {
    @Test
    fun validateA1() {
        val a = 127 / 2

        val seatId = Day5BinaryBoarding().solve(listOf("FBFBBFFRLR"))
        assertEquals(357, seatId)
    }

    @Test
    fun validateA2() {
        val seatId = Day5BinaryBoarding().solve(listOf("BFFFBBFRRR"))
        assertEquals(567, seatId)
    }

    @Test
    fun validateA3() {
        val seatId = Day5BinaryBoarding().solve(listOf("FFFBBBFRRR"))
        assertEquals(119, seatId)
    }

    @Test
    fun validateA4() {
        val seatId = Day5BinaryBoarding().solve(listOf("BBFFBBFRLL"))
        assertEquals(820, seatId)
    }

    @Test
    fun solveA() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day5.txt")
        val input = filePath.reader().readLines()
        val seatId = Day5BinaryBoarding().solve(input)
        assertEquals(885, seatId)
    }

    @Test
    fun solveB() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day5.txt")
        val input = filePath.reader().readLines()
        val seatId = Day5BinaryBoarding().solve(input, true)
        assertEquals(623, seatId)
    }
}
