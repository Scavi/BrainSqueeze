package com.scavi.brainsqueeze.adventofcode

class Day9EncodingError {

    fun solveA(input: List<Long>, preamble: Int): Long {
        for (i in preamble..input.size) {
            if (!isIn(input, input[i], i - preamble, i - 1)) {
                return input[i]
            }
        }
        error("wooot?")
    }

    fun solveB(input: List<Long>, invalidNumber: Long): Long {
        for (i in input.indices) {
            var sum = input[i]
            for (j in i + 1 until input.size) {
                sum += input[j]
                if (sum == invalidNumber) {
                    print("found!")
                    val tmpResult = input.subList(i, j + 1).sorted()
                    return tmpResult[0] + tmpResult[tmpResult.size - 1]
                }
            }
        }
        error("wooot?")
    }

    private fun isIn(input: List<Long>, value: Long, from: Int, to: Int): Boolean {
        for (i in from..to) {
            for (j in i + 1..to) {
                if (value == input[i] + input[j]) {
                    return true
                }
            }
        }
        return false
    }
}
