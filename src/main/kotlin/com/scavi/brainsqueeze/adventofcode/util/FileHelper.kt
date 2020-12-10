package com.scavi.brainsqueeze.adventofcode.util

import java.io.File

class FileHelper {
    companion object {
        fun fileForUnitTest(relativePath: String): File {
            val path = File(System.getProperty("user.dir"), relativePath)
            if (!path.exists()) {
                throw IllegalArgumentException(
                        "The input file '${path.absolutePath}' doesn't exist!")
            }
            return path.absoluteFile
        }

        fun readAsIntSet(filePath: File): Set<Int> {
            val result = mutableSetOf<Int>()
            filePath.reader().forEachLine {
                result.add(it.toInt())
            }
            return result
        }

        fun readAsLongList(filePath: File): List<Long> {
            val result = mutableListOf<Long>()
            filePath.reader().forEachLine {
                result.add(it.toLong())
            }
            return result
        }
    }
}

