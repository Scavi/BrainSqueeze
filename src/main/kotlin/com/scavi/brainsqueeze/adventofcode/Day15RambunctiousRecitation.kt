package com.scavi.brainsqueeze.adventofcode

import kotlin.math.abs

class Day15RambunctiousRecitation {
    private class Rolling(value: Int) {
        private var pos = 0
        private val numbers = intArrayOf(-1, -1)

        init {
            add(value)
        }

        fun add(value: Int) {
            numbers[pos++ % this.numbers.size] = value
        }

        fun isFirstTime() = numbers[1] == -1
        fun diff() = abs(numbers[0] - numbers[1])
    }

    fun solve(input: String, iterations: Int = 2020): Int {
        val cache = linkedMapOf<Int, Rolling>()
        val numbers = input.split(",").map { it.toInt() }
        var last = Rolling(0)
        for (i in numbers.indices) {
            last = Rolling(i + 1)
            cache[numbers[i]] = last
        }
        var lastSpoken = -1
        for (i in numbers.size + 1 until iterations + 1) {
            lastSpoken = if (last.isFirstTime()) 0 else last.diff()
            if (lastSpoken in cache) {
                last = cache[lastSpoken]!!
                last.add(i)
            } else {
                last = Rolling(i)
                cache[lastSpoken] = last
            }
        }
        return lastSpoken
    }
}
