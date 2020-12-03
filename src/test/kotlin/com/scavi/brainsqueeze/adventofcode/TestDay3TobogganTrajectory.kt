package com.scavi.brainsqueeze.adventofcode

import com.scavi.brainsqueeze.adventofcode.util.FileHelper
import org.junit.Test
import kotlin.test.assertEquals

class TestDay3TobogganTrajectory {
    private val inputDummy = listOf(
            "..##.......",
            "#...#...#..",
            ".#....#..#.",
            "..#.#...#.#",
            ".#...##..#.",
            "..#.##.....",
            ".#.#.#....#",
            ".#........#",
            "#.##...#...",
            "#...##....#",
            ".#..#...#.#"
    )
    private val slopesA = arrayOf(Pair(3, 1))
    private val slopesB = arrayOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2))


    @Test
    fun test1A() {
        val day3 = Day3TobogganTrajectory()
        val treeCount = day3.solve(inputDummy, slopesA)
        assertEquals(7, treeCount)
    }

    @Test
    fun test2A() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day3.txt")
        val map = filePath.reader().readLines()
        val day3 = Day3TobogganTrajectory()
        val treeCount = day3.solve(map, slopesA)
        assertEquals(252, treeCount)
    }

    @Test
    fun test1B() {
        val day3 = Day3TobogganTrajectory()
        val treeCount = day3.solve(inputDummy, slopesB)
        assertEquals(336, treeCount)
    }

    @Test
    fun test2B() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day3.txt")
        val map = filePath.reader().readLines()
        val day3 = Day3TobogganTrajectory()
        val treeCount = day3.solve(map, slopesB)
        assertEquals(2608962048, treeCount)
    }
}
