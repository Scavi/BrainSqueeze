package com.scavi.brainsqueeze.adventofcode

import com.scavi.brainsqueeze.adventofcode.util.FileHelper
import org.junit.Test
import kotlin.test.assertEquals

class TestDay4PassportProcessing {

    @Test
    fun test1A() {
        val inputDummy = ("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\n" +
                "byr:1937 iyr:2017 cid:147 hgt:183cm\n" +
                "\n" +
                "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884\n" +
                "hcl:#cfa07d byr:1929\n" +
                "\n" +
                "hcl:#ae17e1 iyr:2013\n" +
                "eyr:2024\n" +
                "ecl:brn pid:760753108 byr:1931\n" +
                "hgt:179cm\n" +
                "\n" +
                "hcl:#cfa07d eyr:2025 pid:166559648\n" +
                "iyr:2011 ecl:brn hgt:59in")

        val day4 = Day4PassportProcessing()
        val validPassports = day4.solve(inputDummy, false)
        assertEquals(2, validPassports)
    }

    @Test
    fun test2A() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day4.txt")
        val input = filePath.reader().readText()
        val day4 = Day4PassportProcessing()
        val validPassports = day4.solve(input, false)
        assertEquals(250, validPassports)
    }

    @Test
    fun test1B() {
        val inputDummy = ("pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980\n" +
                "hcl:#623a2f\n" +
                "\n" +
                "eyr:2029 ecl:blu cid:129 byr:1989\n" +
                "iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm\n" +
                "\n" +
                "hcl:#888785\n" +
                "hgt:164cm byr:2001 iyr:2015 cid:88\n" +
                "pid:545766238 ecl:hzl\n" +
                "eyr:2022\n" +
                "\n" +
                "iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719")
        val day4 = Day4PassportProcessing()
        val validPassports = day4.solve(inputDummy, true)
        assertEquals(4, validPassports)
    }

    @Test
    fun test2B() {
        val filePath = FileHelper.fileForUnitTest("input/adventofcode/y2020/Day4.txt")
        val input = filePath.reader().readText()
        val day4 = Day4PassportProcessing()
        val validPassports = day4.solve(input, true)
        assertEquals(158, validPassports)
    }
}
