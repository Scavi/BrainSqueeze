package com.scavi.brainsqueeze.adventofcode

import com.scavi.brainsqueeze.adventofcode.util.FileHelper
import org.junit.Test
import kotlin.test.assertEquals

class TestDay18OperationOrder {
    @Test
    fun validateA1() {
        val day18 = Day18OperationOrder()
        val output = day18.solve(listOf("1 + 2 * 3 + 4 * 5 + 6"), day18::evalA)
        assertEquals(71, output)
    }

    @Test
    fun validateA2() {
        val day18 = Day18OperationOrder()
        val output = day18.solve(listOf("2 * 3 + (4 * 5)"), day18::evalA)
        assertEquals(26, output)
    }

    @Test
    fun validateA3() {
        val day18 = Day18OperationOrder()
        val output = day18.solve(listOf("5 + (8 * 3 + 9 + 3 * 4 * 3)"), day18::evalA)
        assertEquals(437, output)
    }

    @Test
    fun validateB1() {
        val day18 = Day18OperationOrder()
        val output = day18.solve(listOf("1 + 2 * 3 + 4 * 5 + 6"), day18::evalB)
        assertEquals(231, output)
    }

    @Test
    fun validateB2() {
        val day18 = Day18OperationOrder()
        val output = day18.solve(listOf("2 * 3 + (4 * 5)"), day18::evalB)
        assertEquals(46, output)
    }

    @Test
    fun validateB3() {
        val day18 = Day18OperationOrder()
        val output = day18.solve(listOf("5 + (8 * 3 + 9 + 3 * 4 * 3)"), day18::evalB)
        assertEquals(1445, output)
    }

    @Test
    fun validateB4() {
        val day18 = Day18OperationOrder()
        val output = day18.solve(listOf("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))"), day18::evalB)
        assertEquals(669060, output)
    }

    @Test
    fun validateB5() {
        val day18 = Day18OperationOrder()
        val output = day18.solve(listOf("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2"), day18::evalB)
        assertEquals(23340, output)
    }

    @Test
    fun solveA() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day18.txt")
        val input = filePath.reader().readLines()
        val day18 = Day18OperationOrder()
        val output = day18.solve(input, day18::evalA)
        assertEquals(131076645626, output)
    }

    @Test
    fun solveB() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day18.txt")
        val input = filePath.reader().readLines()
        val day18 = Day18OperationOrder()
        val output = day18.solve(input, day18::evalB)
        assertEquals(109418512161751, output)
    }
}
