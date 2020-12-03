package com.scavi.brainsqueeze.adventofcode

class Day2PasswordPhilosophy {
    fun solveA(input: List<String>, policy: (tokens: Array<String>) -> Boolean): Int {
        var validPasswords = 0
        for (pwSetup in input) {
            val tokens = pwSetup.split(regex = "\\s|:".toRegex()).toTypedArray()
            validPasswords = if (policy(tokens)) validPasswords + 1 else validPasswords
        }
        return validPasswords
    }

    fun oldPolicyRule(tokens: Array<String>): Boolean {
        val analyse = tokens[3].filter { it == tokens[1][0] }
        return "${tokens[1]}{${tokens[0].replace("-", ",")}}".toRegex().matches(analyse) // x{1,2}
    }

    fun newPolicyRule(tokens: Array<String>): Boolean {
        val pos1 = tokens[0].split("-")[0].toInt() - 1
        val pos2 = tokens[0].split("-")[1].toInt() - 1
        if (tokens[3].length <= pos2) {
            return false
        }
        return (tokens[3][pos1] == tokens[1][0] && tokens[3][pos2] != tokens[1][0]) ||
                (tokens[3][pos1] != tokens[1][0] && tokens[3][pos2] == tokens[1][0])
    }
}
