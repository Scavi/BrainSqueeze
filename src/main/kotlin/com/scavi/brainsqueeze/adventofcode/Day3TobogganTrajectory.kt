package com.scavi.brainsqueeze.adventofcode

class Day3TobogganTrajectory {
    private val TREE = '#'
    fun solve(map: List<String>, slopes: Array<Pair<Int, Int>>): Long {
        val results = mutableListOf<Long>()
        for (slope in slopes) {
            var x = 0
            var treeCount = 0L
            for (i in map.indices step slope.second) {
                var row = map[i]
                // treeCount = if (row[x] == TREE) treeCount + 1 else treeCount
                if (row[x] == TREE) {
                    treeCount += 1
                }
                x = (x + slope.first) % row.length
            }
            results.add(treeCount)
        }
        // [57, 252, 64, 66, 43]
        // [252, 75, ...]
        return results.reduce { acc, i -> acc * i }
    }
}
