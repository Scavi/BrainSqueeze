package com.scavi.brainsqueeze.adventofcode

class Day6CustomCustoms {
    fun solve(input: String, all: Boolean): Int {
        val groups = input.split("\n\n").map { group -> group.split("\n").map { it.toSet() } }
        return if (all) {
            groups.map { it.reduce(Set<Char>::union).size }.sum()
        } else {
            groups.map { it.reduce(Set<Char>::intersect).size }.sum()
        }
    }
}
