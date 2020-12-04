package com.scavi.brainsqueeze.adventofcode

class Day4PassportProcessing {
    private val mandatoryFields = setOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
    private val pidRegex = """^\d{9}$""".toRegex()
    private val hgtRegex = """^(\d+)(cm|in)$""".toRegex()
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
                for (field in mandatoryFields) {
                    isValid = isValid && details.contains(field)
                    if (isStrict) {
                        val value = details.getOrDefault(field, "")
                        isValid = isValid && value.isNotEmpty() && validate(field, value)
                    }
                }
                validPassports += if (isValid) 1 else 0
            }
        }
        return validPassports
    }

    // the when function reduces the original solution where mapped validation functions were used
    // by 12 lines
    // Reference:
    // https://github.com/shaeberling/euler/blob/master/kotlin/src/com/s13g/aoc/aoc2020/Day4.kt#42
    private fun validate(field: String, value: String) : Boolean {
        return when (field) {
            "byr" -> value.toInt() in 1920..2002
            "iyr" -> value.toInt() in 2010..2020
            "eyr" -> value.toInt() in 2020..2030
            "hgt" -> {
                val groups = hgtRegex.find(value)
                if (groups == null) false
                else {
                    val number = groups.groupValues[1].toInt()
                    when(groups.groupValues[2]) {
                        "cm" -> number in 150..193
                        "in" -> number in 59..76
                        else -> false
                    }
                }
            }
            "hcl" -> hclRegex.containsMatchIn(value)
            "ecl" -> eyeColors.contains(value)
            "pid" -> pidRegex.containsMatchIn(value)
            else -> false
        }
    }
}
