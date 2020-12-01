package com.scavi.brainsqueeze.adventofcode

import com.scavi.brainsqueeze.adventofcode.util.FileHelper
import kotlin.test.Test
import kotlin.test.assertEquals

class Day1Test {
    @Test
    fun test1A() {
        val input = setOf(1721, 979, 366, 299, 675, 1456)
        val day1 = Day1ReportRepair()
        val result = day1.solveA(input, 2020)
        assertEquals(514579, result)
    }

    @Test
    fun test1B() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day1.txt")
        val input = FileHelper.readAsIntSet(filePath)
        val day1 = Day1ReportRepair()
        val result = day1.solveA(input, 2020)
        assertEquals(197451, result)
    }

    @Test
    fun test2A() {
        val input = setOf(1721, 979, 366, 299, 675, 1456)
        val day1 = Day1ReportRepair()
        val result = day1.solveB(input, 2020)
        assertEquals(241861950, result)
    }

    @Test
    fun test2B() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day1.txt")
        val input = FileHelper.readAsIntSet(filePath)
        val day1 = Day1ReportRepair()
        val result = day1.solveB(input, 2020)
        assertEquals(138233720, result)
    }
}


