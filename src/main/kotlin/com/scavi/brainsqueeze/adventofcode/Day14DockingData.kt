package com.scavi.brainsqueeze.adventofcode

import kotlin.math.pow

class Day14DockingData(val isFluid: Boolean) {
    private val memRegex by lazy { """(mem\[)(\d+)(\]\s+\=\s+)(\d+)""".toRegex() }

    private data class Masks(val defaultMask: List<Pair<Char, Int>>, val fluidMask: List<List<Pair<Char, Int>>>)

    private fun createMask(line: String): Masks {
        val mask = mutableListOf<Pair<Char, Int>>()
        val fluidMask = mutableListOf<List<Pair<Char, Int>>>()
        val tmpFluid = mutableListOf<Int>()
        for (i in line.indices) {
            if (isFluid) {
                if (line[i] == '1') {
                    mask.add(Pair(line[i], i))
                } else if (line[i] == 'X') {
                    tmpFluid.add(i)
                }
            } else {
                if (line[i] != 'X') {
                    mask.add(Pair(line[i], i))
                }
            }
        }
        if (isFluid) {
            for (x in 0..(2.0.pow(tmpFluid.size.toDouble()).toInt())) {
                fluidMask.add("%0${tmpFluid.size}d".format(Integer.toBinaryString(x).toInt()).toCharArray() zip tmpFluid)
            }
        }
        return Masks(mask, fluidMask)
    }

    fun solve(instructions: List<String>): Long {
        var masks = Masks(mutableListOf(), mutableListOf())
        var memory = mutableMapOf<Long, Long>()
        for (line in instructions) {
            if (line.startsWith("mask")) {
                masks = createMask(line.substring(7))
            } else {
                val (_, mem, _, v) = memRegex.find(line)!!.destructured
                val value = if (isFluid) {
                    StringBuilder("0".repeat(36 - Integer.toBinaryString(mem.toInt()).length)
                            + Integer.toBinaryString(mem.toInt()))
                } else {
                    StringBuilder("0".repeat(36 - Integer.toBinaryString(v.toInt()).length)
                            + Integer.toBinaryString(v.toInt()))
                }
                for (mask in masks.defaultMask) {
                    value[mask.second] = mask.first
                }
                if (isFluid) {
                    for (fluid in masks.fluidMask) {
                        for ((i, j) in fluid) {
                            value[j] = i
                        }
                        memory[value.toString().toLong(2)] = v.toLong()
                    }
                } else {
                    memory[mem.toLong()] = value.toString().toLong(2)
                }
            }
        }
        return memory.map { it.value }.sum()
    }
}
