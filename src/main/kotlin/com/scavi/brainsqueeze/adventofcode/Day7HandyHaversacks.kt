package com.scavi.brainsqueeze.adventofcode

import com.scavi.brainsqueeze.adventofcode.util.GraphAccess
import java.lang.IllegalArgumentException


class Day7HandyHaversacks {
    private val bagSplit = """[a-z]*\s[a-z]*(?=\sbag)|((?<=\s)\d+)""".toRegex()

    fun solveA(input: List<String>): Int {
        val graph = createGraphAccess(input)
        return graph.findPossiblePathTo("shiny gold")
    }

    fun solveB(input: List<String>): Int {
        val graph = createGraphAccess(input)
        return calc(graph, "shiny gold") - 1
    }

    private fun calc(graphAccess: GraphAccess<String>, bagName: String): Int {
        if (graphAccess.getGraph()[bagName]?.isEmpty() ?: error("Unknown bag: $bagName")) {
            return 1
        }
        var count = 1
        for (nextBag in graphAccess.getGraph()[bagName] ?: error("Unknown bag: $bagName")) {
            count += nextBag.weight * calc(graphAccess, nextBag.targetNode)
        }
        return count
    }

    private fun createGraphAccess(input: List<String>): GraphAccess<String> {
        val graphAccess = GraphAccess<String>()
        for (rule in input) {
            val tokens = split(rule)
            if (tokens.size >= 3) {
                for (i in 1 until tokens.size step 2) {
                    graphAccess.addEdge(tokens[0], tokens[i + 1], tokens[i].toInt())
                }
            } else {
                if (tokens.size != 2) {
                    throw IllegalArgumentException("woot?!")
                }
            }
        }
        return graphAccess
    }

    fun split(input: String) = bagSplit.findAll(input).map { it.groupValues[0] }.toList()
}
