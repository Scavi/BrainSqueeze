package com.scavi.brainsqueeze.adventofcode

import com.scavi.brainsqueeze.adventofcode.util.FileHelper
import org.junit.Test
import kotlin.test.assertEquals

class TestDay9EncodingError {
    var dummyValue = listOf(35L, 20L, 15L, 25L, 47L, 40L, 62L, 55L, 65L, 95L, 102L, 117L, 150L,
            182L, 127L, 219L, 299L, 277L, 309L, 576L)

    @Test
    fun validateA1() {
        val day9 = Day9EncodingError()
        val output = day9.solveA(dummyValue, 5)
        assertEquals(127, output)
    }

    @Test
    fun solveA() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day9.txt")
        val input = FileHelper.readAsLongList(filePath)
        val day9 = Day9EncodingError()
        val output = day9.solveA(input, 25)
        assertEquals(1398413738, output)
    }

    @Test
    fun validateB1() {
        val day9 = Day9EncodingError()
        val output = day9.solveB(dummyValue, 127)
        assertEquals(62, output)
    }

    @Test
    fun solveB() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day9.txt")
        val input = FileHelper.readAsLongList(filePath)
        val day9 = Day9EncodingError()
        val output = day9.solveB(input, 1398413738)
        assertEquals(169521051, output)
    }
}
