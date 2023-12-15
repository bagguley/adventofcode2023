package day13

import kotlin.math.min

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        val maps = load(input)
        return maps.sumOf{findHorizontal(it) * 100} + maps.sumOf { findVertical(it) }
    }

    fun load(input: List<String>): List<List<String>> {
        return input.map { it.split("\n") }
    }

    fun findVertical(input: List<String>): Int {
        return findHorizontal(rotate(input))
    }

    fun rotate(input: List<String>): List<String> {
        val result = mutableListOf<String>()
        val width = input[0].length
        val height = input.size

        for (x in 0 until width) {
            val string = StringBuilder()
            for (y in 0 until height) {
                string.append(input[y][x])
            }
            result.add(string.toString())
        }
        return result
    }

    fun findHorizontal(input: List<String>): Int {
        for (i in 1 until input.size) {
            val head = input.take(i).reversed()
            val tail = input.drop(i)

            val min = min(head.size, tail.size)
            val found = head.take(min) == tail.take(min)
            if (found) return i
        }
        return 0
    }
}