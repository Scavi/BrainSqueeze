package com.scavi.brainsqueeze.adventofcode

class Day8HandheldHalting {
    fun solveA(input: List<String>): Pair<Int, Boolean> {
        val instructions = input.map { it.split(" ") }.map { Pair(it[0], it[1].toInt()) }
        val posCache = mutableSetOf<Int>()
        var isRunning = true
        var isCancelled = true
        var accumulator = 0
        var pos = 0
        while (isRunning) {
            when {
                posCache.contains(pos) -> {
                    isRunning = false
                    isCancelled = false
                }
                pos == input.size -> {
                    isRunning = false
                    isCancelled = true
                }
                else -> {
                    posCache.add(pos)
                    when (instructions[pos].first) {
                        "nop" -> {
                            pos += 1
                        }
                        "acc" -> {
                            accumulator += instructions[pos].second
                            pos += 1
                        }
                        "jmp" -> {
                            pos += instructions[pos].second
                        }
                    }
                }
            }
        }
        return Pair(accumulator, isCancelled)
    }

    fun solveB(input: List<String>): Pair<Int, Boolean> {
        for (i in input.indices) {
            if (input[i].startsWith("jmp")) {
                val lookup = input.toMutableList()
                lookup[i] = lookup[i].replace("jmp", "nop")
                val output = solveA(lookup)
                if (output.second) {
                    return output
                }
            }
        }
        error("wooot?")
    }
}
