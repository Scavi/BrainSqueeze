package com.scavi.brainsqueeze.adventofcode

import com.scavi.brainsqueeze.adventofcode.util.FileHelper
import org.junit.Test
import kotlin.test.assertEquals

class TestDay6CustomCustoms {
    @Test
    fun validateA1() {
        val sum = Day6CustomCustoms().solve("abcx\nabcy\nabcz\n", true)
        assertEquals(6, sum)
    }

    @Test
    fun validateA2() {
        val sum = Day6CustomCustoms().solve("abc\n\na\nb\nc\n\nab\nac\n\na\na\na\na\n\nb", true)
        assertEquals(11, sum)
    }

    @Test
    fun solveA() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day6.txt")
        val input = filePath.reader().readText()
        val sum = Day6CustomCustoms().solve(input, true)
        assertEquals(6703, sum)
    }

    @Test
    fun validateB1() {
        val sum = Day6CustomCustoms().solve("abc\n\na\nb\nc\n\nab\nac\n\na\na\na\na\n\nb", false)
        assertEquals(6, sum)
    }

    @Test
    fun solveB() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day6.txt")
        val input = filePath.reader().readText()
        val sum = Day6CustomCustoms().solve(input, false)
        assertEquals(3430, sum)
    }
}
