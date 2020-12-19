package com.scavi.brainsqueeze.adventofcode

class Day18OperationOrder {
    private val formulaPattern = """(\d+\s+)([*+])(\s+\d+)""".toRegex()
    private val parenthesesPattern = """\(\d+\s+[*+]\s+[\d+|\d+\s+\[*\]\s+\d+]+\)""".toRegex()
    private val arithmeticPatternA = """^(\d+\s+[*+]\s+\d+)""".toRegex()
    private val arithmeticPatternB = """\d+\s+\+\s+\d+""".toRegex()
    private val operatorsA = """[*+]""".toRegex()

    fun solve(input: List<String>, evalFunction: (String) -> String): Long {
        var result = 0L
        for (line in input) {   
            result += evaluateInput(line, evalFunction).toLong()
        }
        return result
    }

    private fun evaluateInput(line: String, evalFunction: (String) -> String): String {
        val equation = StringBuilder(line)
        while (equation.contains("(")) {
            val inParentheses = parenthesesPattern.findAll(equation)
            for (parenthesesLookup in inParentheses.iterator()) {
                for (group in parenthesesLookup.groups) {
                    val evaluated = evalFunction(group!!.value.substring(1, group.value.length - 1))
                    equation.replace(group.range.first, group.range.last + 1, evaluated)
                }
            }
        }
        return evalFunction(equation.toString())
    }

    fun evalA(input: String): String {
        var toEvaluate = input
        while (operatorsA.containsMatchIn(toEvaluate)) {
            val matches = arithmeticPatternA.findAll(toEvaluate)
            val match = matches.map { it.groupValues[0] }.joinToString()
            toEvaluate = "${calculate(match)} ${toEvaluate.substring(match.length)}".trim()
        }
        return toEvaluate
    }

    fun evalB(input: String): String {
        var toEvaluate = input
        while (toEvaluate.contains("+")) {
            val matches = arithmeticPatternB.findAll(toEvaluate)
            for (match in matches) {
                for (group in match.groups) {
                    val value = group!!.value.trim()
                    toEvaluate = toEvaluate.replace(value, calculate(value).toString())
                }
            }
        }
        return evalA(toEvaluate)
    }

    private fun calculate(match: String) : Long {
        val (a, o, b) = formulaPattern.find(match)!!.destructured
        return if (o == "*") a.trim().toLong() * b.trim().toLong() else a.trim().toLong() + b.trim().toLong()
    }
}
