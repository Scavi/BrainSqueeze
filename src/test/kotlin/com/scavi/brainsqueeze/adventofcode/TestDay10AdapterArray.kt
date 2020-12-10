package com.scavi.brainsqueeze.adventofcode

import com.scavi.brainsqueeze.adventofcode.util.FileHelper
import org.junit.Test
import kotlin.test.assertEquals

class TestDay10AdapterArray {
    private val dummyInput1 = mutableListOf(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4)
    private val dummyInput2 = mutableListOf(28, 33, 18, 42, 31, 14, 46, 20, 48, 47, 24, 23, 49, 45,
            19, 38, 39, 11, 1, 32, 25, 35, 8, 17, 7, 9, 4, 2, 34, 10, 3)

    @Test
    fun validateA1() {
        val day10 = Day10AdapterArray()
        val output = day10.solveA(dummyInput1)
        assertEquals(35, output)
    }

    @Test
    fun validateA2() {
        val day10 = Day10AdapterArray()
        val output = day10.solveA(dummyInput2)
        assertEquals(220, output)
    }

    @Test
    fun solveA() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day10.txt")
        val input = FileHelper.readAsIntList(filePath)
        val day10 = Day10AdapterArray()
        val output = day10.solveA(input)
        assertEquals(1690, output)
    }

    @Test
    fun validateB1() {
        val day10 = Day10AdapterArray()
        val output = day10.solveB(dummyInput1)
        assertEquals(8, output)
    }

    @Test
    fun validateB2() {
        val day10 = Day10AdapterArray()
        val output = day10.solveB(dummyInput2)
        assertEquals(19208, output)
    }

    @Test
    fun solveB() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day10.txt")
        val input = FileHelper.readAsIntList(filePath)
        val day10 = Day10AdapterArray()
        val output = day10.solveB(input)
        assertEquals(5289227976704, output)
    }
}
