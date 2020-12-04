package com.scavi.brainsqueeze.adventofcode

class Day4PassportProcessing {
    private val mandatoryFields = mapOf("byr" to ::vByr, "iyr" to ::vIyr, "eyr" to ::vEyr,
            "hgt" to ::vHgt, "hcl" to ::vHcl, "ecl" to ::vEcl, "pid" to ::vPid)
    private val pidRegex = """^\d{9}$""".toRegex()
    private val hclRegex = """#[a-f0-9]{6}""".toRegex()
    private val eyeColors = setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")

    fun solve(input: String, isStrict: Boolean): Int {
        var validPassports = 0
        val passports = input.split("\n\n")
        for (passport in passports) {
            val details = passport.trim().replace("\n", " ").split(" ").associate {
                Pair(it.split(":")[0], it.split(":")[1])
            }
            if (details.size >= 7) {
                var isValid = true
                for ((k, v) in mandatoryFields) {
                    isValid = isValid && details.contains(k)
                    isValid = if (isStrict) isValid && v(details.getOrDefault(k, "")) else isValid
                    if (!isValid) {
                        break
                    }
                }
                validPassports += if (isValid) 1 else 0
            }
        }
        return validPassports
    }

    private fun vByr(value: String): Boolean {
        return value.toInt() in 1920..2002
    }

    private fun vIyr(value: String): Boolean {
        return value.toInt() in 2010..2020
    }

    private fun vEyr(value: String): Boolean {
        return value.toInt() in 2020..2030
    }

    private fun vHgt(value: String): Boolean {
        if (value.length > 2) {
            val number = value.subSequence(0, value.length - 2).toString().toInt()
            if (value.endsWith("cm")) {
                return number in 150..193
            } else if (value.endsWith("in")) {
                return number in 59..76
            }
        }
        return false
    }

    private fun vHcl(value: String): Boolean {
        return hclRegex.containsMatchIn(value)
    }

    private fun vEcl(value: String): Boolean {
        return eyeColors.contains(value)
    }

    private fun vPid(value: String): Boolean {
        return pidRegex.containsMatchIn(value)
    }
}
