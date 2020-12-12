package com.scavi.brainsqueeze.adventofcode

import kotlin.math.abs

class Day12RainRisk(private val wayPoint: WayPoint? = null) {
    private enum class CardDirection(val value: Int) {
        N(0), E(90), S(180), W(270);

        companion object {
            fun fromInt(value: Int) = values().first { it.value == value }
        }
    }
    private val split = """(\w)(\d+)""".toRegex()

    fun solve(instructions: List<String>): Int {
        val boat = Boat()
        for (current in instructions) {
            val (instruction, distance) = split.find(current)!!.destructured
            if (instruction == "F") {
                boat.control(instruction, distance.toInt(), wayPoint)
            } else {
                if (wayPoint != null) {
                    wayPoint.control(instruction, distance.toInt())
                } else {
                    boat.control(instruction, distance.toInt(), wayPoint)
                }

            }
        }
        return boat.manhattanDistance()
    }

    abstract class Control(var x: Int, var y: Int) {
        fun control(instruction: String, distance: Int) {
            turn(instruction, distance)
            move(instruction, distance)
        }

        protected open fun move(instruction: String, distance: Int) {
            when (instruction) {
                CardDirection.N.toString() -> this.y += distance
                CardDirection.E.toString() -> this.x += distance
                CardDirection.S.toString() -> this.y -= distance
                CardDirection.W.toString() -> this.x -= distance
            }
        }
        protected abstract fun turn(instruction: String, distance: Int)
    }

    open class WayPoint : Control(10, 1) {
        override fun turn(instruction: String, distance: Int) {
            val amount = distance / 90
            for (i in 1..amount) {
                if (instruction == "R") {
                    val prevX = this.x
                    this.x = this.y
                    this.y = prevX * -1
                } else {
                    val prevY = this.y
                    this.y = this.x
                    this.x = prevY * -1
                }
            }
        }
    }

    private class Boat(var direction: CardDirection = CardDirection.E) : Control(0, 0) {
        fun control(instruction: String, distance: Int, wayPoint: WayPoint? = null) {
            if (wayPoint != null) {
                this.x += wayPoint.x * distance
                this.y += wayPoint.y * distance
            } else {
                super.control(instruction, distance)
            }
        }

        fun manhattanDistance(): Int {
            return abs(this.x) + abs(this.y)
        }

        override fun move(instruction: String, distance: Int) {
            when (instruction) {
                "F" -> move(this.direction.toString(), distance)
                else -> super.move(instruction, distance)
            }
        }

        override fun turn(instruction: String, distance: Int) {
            if (instruction == "R") {
                this.direction = CardDirection.fromInt((this.direction.value + distance) % 360)
            } else if (instruction == "L") {
                val tmp = (this.direction.value - distance) % 360
                this.direction = CardDirection.fromInt(if (tmp >= 0) tmp else 360 - abs(tmp))
            }
        }
    }
}
