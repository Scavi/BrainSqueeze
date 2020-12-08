package com.scavi.brainsqueeze.adventofcode

import com.scavi.brainsqueeze.adventofcode.util.FileHelper
import org.junit.Test
import kotlin.test.assertEquals

class TestDay7HandyHaversacks {
    private val dummyInput1 = listOf(
            "light red bags contain 1 bright white bag, 2 muted yellow bags.",
            "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
            "bright white bags contain 1 shiny gold bag.",
            "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
            "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
            "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
            "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
            "faded blue bags contain no other bags.",
            "dotted black bags contain no other bags.")

    private val dummyInput2 = listOf(
            "shiny gold bags contain 2 dark red bags.",
            "dark red bags contain 2 dark orange bags.",
            "dark orange bags contain 2 dark yellow bags.",
            "dark yellow bags contain 2 dark green bags.",
            "dark green bags contain 2 dark blue bags.",
            "dark blue bags contain 2 dark violet bags.",
            "dark violet bags contain no other bags."
    )

    @Test
    fun validateRegex() {
        val day7 = Day7HandyHaversacks()
        assertEquals(5, day7.split(dummyInput1[0]).size)
        assertEquals(5, day7.split(dummyInput1[1]).size)
        assertEquals(3, day7.split(dummyInput1[2]).size)
        assertEquals(5, day7.split(dummyInput1[3]).size)
        assertEquals(5, day7.split(dummyInput1[4]).size)
        assertEquals(5, day7.split(dummyInput1[5]).size)
        assertEquals(5, day7.split(dummyInput1[6]).size)
        assertEquals(2, day7.split(dummyInput1[7]).size)
        assertEquals(2, day7.split(dummyInput1[8]).size)
    }

    @Test
    fun validateA1() {
        val output = Day7HandyHaversacks().solveA(dummyInput1)
        assertEquals(4, output)
    }


    @Test
    fun solveA() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day7.txt")
        val input = filePath.reader().readLines()
        val output = Day7HandyHaversacks().solveA(input)
        assertEquals(335, output)
    }

    @Test
    fun validateB1() {
        val output = Day7HandyHaversacks().solveB(dummyInput1)
        assertEquals(32, output)
    }

    @Test
    fun validateB2() {
        val output = Day7HandyHaversacks().solveB(dummyInput2)
        assertEquals(126, output)
    }

    @Test
    fun solveB() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day7.txt")
        val input = filePath.reader().readLines()
        val output = Day7HandyHaversacks().solveB(input)
        assertEquals(2431, output)
    }
}
