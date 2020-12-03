package com.scavi.brainsqueeze.adventofcode

import com.scavi.brainsqueeze.adventofcode.util.FileHelper
import org.junit.Test
import kotlin.test.assertEquals

class TestDay2PasswordPhilosophy {
    @Test
    fun test1A() {
        val input = listOf("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc")
        val day2 = Day2PasswordPhilosophy()
        val result = day2.solveA(input, Day2PasswordPhilosophy()::oldPolicyRule)
        assertEquals(2, result)
    }

    @Test
    fun test1B() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day2.txt")
        val input = filePath.reader().readLines()
        val day2 = Day2PasswordPhilosophy()
        val result = day2.solveA(input, Day2PasswordPhilosophy()::oldPolicyRule)
        assertEquals(467, result)
    }

    @Test
    fun test2A() {
        val input = listOf("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc")
        val day2 = Day2PasswordPhilosophy()
        val result = day2.solveA(input, Day2PasswordPhilosophy()::newPolicyRule)
        assertEquals(1, result)
    }

    @Test
    fun test2B() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day2.txt")
        val input = filePath.reader().readLines()
        val day2 = Day2PasswordPhilosophy()
        val result = day2.solveA(input, Day2PasswordPhilosophy()::newPolicyRule)
        assertEquals(441, result)
    }
}
