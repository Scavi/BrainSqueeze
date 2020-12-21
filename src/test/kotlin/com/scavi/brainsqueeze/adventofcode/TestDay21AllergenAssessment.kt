package com.scavi.brainsqueeze.adventofcode

import com.scavi.brainsqueeze.adventofcode.util.FileHelper
import org.junit.Test
import kotlin.test.assertEquals

class TestDay21AllergenAssessment {
    private val dummyInput = listOf("mxmxvkd kfcds sqjhc nhms (contains dairy, fish)",
            "trh fvjkl sbzzf mxmxvkd (contains dairy)",
            "sqjhc fvjkl (contains soy)",
            "sqjhc mxmxvkd sbzzf (contains fish)")

    @Test
    fun validateA1() {
        val day21 = Day21AllergenAssessment()
        val output = day21.solveA(dummyInput)
        assertEquals(5, output)
    }

    @Test
    fun solveA() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day21.txt")
        val input = filePath.reader().readLines()
        val day21 = Day21AllergenAssessment()
        val output = day21.solveA(input)
        assertEquals(2573, output)
    }

    @Test
    fun validateB1() {
        val day21 = Day21AllergenAssessment()
        val output = day21.solveB(dummyInput)
        assertEquals("mxmxvkd,sqjhc,fvjkl", output)
    }

    @Test
    fun solveB() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day21.txt")
        val input = filePath.reader().readLines()
        val day21 = Day21AllergenAssessment()
        val output = day21.solveB(input)
        assertEquals("bjpkhx,nsnqf,snhph,zmfqpn,qrbnjtj,dbhfd,thn,sthnsg", output)
    }
}
