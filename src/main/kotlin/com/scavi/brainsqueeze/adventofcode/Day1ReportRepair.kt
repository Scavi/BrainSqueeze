package com.scavi.brainsqueeze.adventofcode

class Day1ReportRepair {
    fun solveA(input: Set<Int>, target: Int): Int {
        input.forEach {
            if (target - it in input) {
                return it * (target - it)
            }
        }
        throw IllegalArgumentException("Unable to find the $target in the provided input set!")
    }

    fun solveB(input: Set<Int>, target: Int): Int {
        for (i in input.indices) {
            for (j in i + 1 until input.indices.last) {
                val lookup = target - input.elementAt(i) - input.elementAt(j)
                if (lookup in input) {
                    return lookup * input.elementAt(i) * input.elementAt(j)
                }
            }
        }
        throw IllegalArgumentException("Unable to find the $target in the provided input set!")
    }
}
