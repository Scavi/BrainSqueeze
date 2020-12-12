package com.scavi.brainsqueeze.adventofcode

import com.scavi.brainsqueeze.adventofcode.util.FileHelper
import org.junit.Test
import kotlin.test.assertEquals


class TestDay12RainRisk {
    private val dummyInput = listOf("F10", "N3", "F7", "R90", "F11")

    @Test
    fun validateA1() {
        val output = Day12RainRisk().solve(dummyInput)
        assertEquals(25, output)
    }

    @Test
    fun solveA() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day12.txt")
        val input = filePath.reader().readLines()
        val output = Day12RainRisk().solve(input)
        assertEquals(1482, output)
    }

    @Test
    fun validateB1() {
        val output = Day12RainRisk(Day12RainRisk.WayPoint()).solve(dummyInput)
        assertEquals(286, output)
    }

    @Test
    fun solveB() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day12.txt")
        val input = filePath.reader().readLines()
        val output = Day12RainRisk(Day12RainRisk.WayPoint()).solve(input)
        assertEquals(48739, output)
    }
}
