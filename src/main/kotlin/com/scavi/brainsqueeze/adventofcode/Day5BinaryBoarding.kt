package com.scavi.brainsqueeze.adventofcode

class Day5BinaryBoarding {
    private fun next(value: Int) = if (value % 2 == 1) (value / 2) + 1 else (value / 2)

    fun solve(boardingPasses: List<String>, mySeat: Boolean = false): Int {
        val seatIds = mutableListOf<Int>()
        for (boardingPass in boardingPasses) {
            val row = calculate(boardingPass, 127, 0, boardingPass.length - 3)
            val column = calculate(boardingPass, 7, boardingPass.length - 3, boardingPass.length)
            seatIds.add((row * 8) + column)
        }
        seatIds.sort()
        if (mySeat) {
            for (i in seatIds[0] until seatIds[seatIds.size - 1]) {
                if (!seatIds.contains(i) && seatIds.contains(i - 1) && seatIds.contains(i + 1)) {
                    return i
                }
            }
        }
        return seatIds[seatIds.size - 1]
    }

    private fun calculate(boardingPass: String, hi: Int, from: Int, till: Int): Int {
        var low = 0
        var high = hi
        var reminder = high
        for (i in from until till) {
            reminder = next(reminder)
            when (boardingPass[i]) {
                'F', 'L' -> high -= reminder
                'B', 'R' -> low += reminder
            }
        }
        return high
    }
}
