package day13

import kotlin.math.min

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>): Int {
        val maps = load(input)
        return maps.sumOf{find(it)}
    }

    fun load(input: List<String>): List<List<String>> {
        return input.map { it.split("\n") }
    }

    fun find(input: List<String>): Int {
        val horizontal = findHorizontal(input, 0)
        val vertical = findVertical(input, 0)

        return mutate(input).maxOf { findHorizontal(it, horizontal) * 100 + findVertical(it, vertical) }
    }

    fun mutate(input: List<String>): List<List<String>> {
        val result = mutableListOf<List<String>>()
        val width = input[0].length
        val height = input.size

        for (count in 0 until width * height) {
            val map = mutableListOf<String>()
            for (y in 0 until height) {
                val string = StringBuilder()
                for (x in 0 until width) {
                    if ((x + y * width) == count) {
                        val c = input[y][x]
                        if (c == '.') string.append('#') else string.append('.')
                    } else {
                        string.append(input[y][x])
                    }
                }
                map.add(string.toString())
            }
            result.add(map)
        }
        return result
    }

    fun findVertical(input: List<String>, skip: Int): Int {
        return findHorizontal(rotate(input), skip)
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

    fun findHorizontal(input: List<String>, skip: Int): Int {
        for (i in 1 until input.size) {
            val head = input.take(i).reversed()
            val tail = input.drop(i)

            val min = min(head.size, tail.size)
            val found = head.take(min) == tail.take(min)
            if (found && skip != i) return i
        }
        return 0
    }
}