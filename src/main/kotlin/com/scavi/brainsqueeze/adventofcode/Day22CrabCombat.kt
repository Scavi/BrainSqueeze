package com.scavi.brainsqueeze.adventofcode

import java.util.*

class Day22CrabCombat {
    private enum class Player { Unknown, Player1, Player2 }

    fun solveA(input: List<String>): Int {
        val playersCards = getCards(input)
        val res = play(playersCards.first, playersCards.second, false)
        return res.second.withIndex().map { res.second[it.index] * (res.second.size-it.index)}.sum()
    }

    fun solveB(input: List<String>): Int {
        val playersCards = getCards(input)
        val res = play(playersCards.first, playersCards.second, true)
        return res.second.withIndex().map { res.second[it.index] * (res.second.size-it.index)}.sum()
    }

    private fun play(
            playersCards1: LinkedList<Int>,
            playersCards2: LinkedList<Int>,
            recursion: Boolean): Pair<Boolean, LinkedList<Int>> {
        val seen = mutableSetOf<String>()
        while (playersCards1.isNotEmpty() and playersCards2.isNotEmpty()) {
            val cardsHash = "$playersCards1$playersCards2"
            if (cardsHash in seen) {
                return Pair(true, playersCards1)
            }
            seen.add(cardsHash)
            val card1 = playersCards1.pop()
            val card2 = playersCards2.pop()
            var player1Won = card1 > card2
            if (recursion && playersCards1.size >= card1 && playersCards2.size >= card2) {
                player1Won = play(copy(playersCards1, card1), copy(playersCards2, card2), recursion).first
            }
            if (player1Won) {
                playersCards1.add(card1)
                playersCards1.add(card2)
            } else {
                playersCards2.add(card2)
                playersCards2.add(card1)
            }
        }
        return Pair(playersCards1.isNotEmpty(), if (playersCards1.isEmpty()) playersCards2 else playersCards1)
    }

    private fun copy(list: LinkedList<Int>, size: Int): LinkedList<Int> {
        val newList = LinkedList<Int>()
        var pos = 0
        while (pos < size && pos < list.size) {
            newList.add(list[pos++])
        }
        return newList
    }

    private fun getCards(input: List<String>): Pair<LinkedList<Int>, LinkedList<Int>> {
        val cardsPlayer1 = LinkedList<Int>()
        val cardsPlayer2 = LinkedList<Int>()
        var player = Player.Unknown
        for (line in input) {
            if (line.isNotEmpty()) {
                when {
                    "Player 1" in line -> player = Player.Player1
                    "Player 2" in line -> player = Player.Player2
                    else -> {
                        when (player) {
                            Player.Player1 -> cardsPlayer1.add(line.toInt())
                            Player.Player2 -> cardsPlayer2.add(line.toInt())
                            else -> error("wooops!")
                        }
                    }
                }
            }
        }
        return Pair(cardsPlayer1, cardsPlayer2)
    }
}
