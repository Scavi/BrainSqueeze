package com.scavi.brainsqueeze.adventofcode

import java.util.*
import kotlin.math.max
import kotlin.math.min

enum class Strategy { Plan, Reality }

class Day11SeatingSystem(val strategy: Strategy) {
    private val empty = 'L'
    private val occupied = '#'
    private val floor = '.'
    private val directions = listOf(Pair(+1, +1), Pair(+1, 0), Pair(-1, -1), Pair(0, +1),
            Pair(-1, +1), Pair(0, -1), Pair(-1, 0), Pair(+1, -1))

    fun solve(input: List<CharArray>): Int {
        var areMoving = true
        while (areMoving) {
            val movement = LinkedList<Action>()
            for (y in input.indices) {
                for (x in input[0].indices) {
                    val lookup = lookAround(input, x, y)
                    when (input[y][x]) {
                        empty -> if (!lookup.containsKey(occupied)) {
                            movement.add(Action(occupied, x, y))
                        }
                        occupied -> if (occupied in lookup &&
                                (lookup[occupied]!! >= if (strategy == Strategy.Plan) 4 else 5)) {
                            movement.add(Action(empty, x, y))
                        }
                    }
                }
            }
            for (move in movement) {
                input[move.y][move.x] = move.change
            }
            areMoving = movement.size > 0
        }
        return input.map { it.count { item -> item == occupied } }.sum()
    }

    private fun lookAround(input: List<CharArray>, row: Int, col: Int): Map<Char, Int> {
        val cache = mutableMapOf<Char, Int>()
        if (strategy == Strategy.Plan) {
            for (y in max(col - 1, 0)..min(col + 1, input.size - 1)) {
                for (x in max(row - 1, 0)..min(row + 1, input[0].size - 1)) {
                    if (y != col || x != row) {
                        if (input[y][x] in cache) {
                            cache[input[y][x]] = cache[input[y][x]]!!.plus(1)
                        } else {
                            cache[input[y][x]] = 1
                        }
                    }
                }
            }
        } else {
            for (direction in directions) {
                var x = row + direction.first
                var y = col + direction.second
                while (x >= 0 && x < input[0].size && y >= 0 && y < input.size) {
                    if (input[y][x] in cache) {
                        cache[input[y][x]] = cache[input[y][x]]!!.plus(1)
                    } else {
                        cache[input[y][x]] = 1
                    }
                    if (input[y][x] != floor) {
                        break
                    }
                    x += direction.first
                    y += direction.second
                }
            }
        }
        return cache
    }

    private data class Action(val change: Char, val x: Int, val y: Int)
}
