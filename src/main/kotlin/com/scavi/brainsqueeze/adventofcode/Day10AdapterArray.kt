package com.scavi.brainsqueeze.adventofcode

class Day10AdapterArray {
    fun solveA(input: MutableList<Int>): Int {
        val adapters = input.plus(0).sorted().toMutableList()
        adapters.add(adapters[adapters.size - 1] + 3)
        val joltDiff = mutableMapOf<Int, Int>()
        for (i in 0 until adapters.size - 1) {
            val diff = adapters[i + 1] - adapters[i]
            if (joltDiff.containsKey(diff)) {
                joltDiff[diff] = joltDiff[diff]!!.plus(1)
            } else {
                joltDiff[diff] = 1
            }
        }
        return joltDiff[1]!! * (joltDiff[3]!!)
    }

    fun solveB(input: MutableList<Int>): Long {
        input.sort()
        val dpCache = linkedMapOf<Int, Long>()
        dpCache[0] = 1
        for (i in input) {
            dpCache[i] = dpCache.getOrDefault(i - 1, 0L) + dpCache.getOrDefault(i - 2, 0L) + dpCache.getOrDefault(i - 3, 0L)
        }
        return dpCache[(input[input.size - 1])]!!
    }
}
