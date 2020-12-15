package com.scavi.brainsqueeze.adventofcode

import org.junit.Test
import kotlin.test.assertEquals

class TestDay15RambunctiousRecitation {
    @Test
    fun validateA1() {
        val output = Day15RambunctiousRecitation().solve("0,3,6")
        assertEquals(436, output)
    }

    @Test
    fun solveA() {
        val output = Day15RambunctiousRecitation().solve("7,14,0,17,11,1,2")
        assertEquals(206, output)
    }

    @Test
    fun solveB() {
        val output = Day15RambunctiousRecitation().solve("7,14,0,17,11,1,2", 30000000)
        assertEquals(955, output)
    }
}
