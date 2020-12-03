package com.scavi.brainsqueeze.adventofcode

class Day2PasswordPhilosophy {
    private val split = """(\d+)-(\d+) (.): (.*)""".toRegex()

    fun solveA(input: List<String>, policy: (rule: Rule) -> Boolean): Int {
        var validPasswords = 0
        for (pwSetup in input) {
            val rule = parse(pwSetup)
            validPasswords = if (policy(rule)) validPasswords + 1 else validPasswords
        }
        return validPasswords
    }

    private fun parse(pwSetup: String): Rule {
        val (f, t, ch, pass) = split.find(pwSetup)!!.destructured
        return Rule(f.toInt(), t.toInt(), ch[0], pass)
    }

    fun oldPolicyRule(rule: Rule): Boolean {
        return rule.pass.filter { it == rule.ch }.count().let { it in rule.f..rule.t }
    }

    fun newPolicyRule(rule: Rule): Boolean {
        return (rule.pass.length >= rule.f && rule.pass[rule.f - 1] == rule.ch) xor
                (rule.pass.length >= rule.t && rule.pass[rule.t - 1] == rule.ch)
    }

    data class Rule(val f: Int, val t: Int, val ch: Char, val pass: String)
}
