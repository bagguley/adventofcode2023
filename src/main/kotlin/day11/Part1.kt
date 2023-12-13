package day11

import kotlin.math.abs

typealias Galaxy = Pair<Int, Int>

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        val universe = load(input)
        universe.expand()
        return universe.allPairsDistance()
    }

    fun load(input: List<String>): Universe = Universe(input.flatMapIndexed { y, s -> s.mapIndexedNotNull { x, c -> if (c == '#') x to y else null } })

    class Universe(var map: List<Galaxy>) {
        fun expand() {
            expandRow()
            expandColumn()
        }

        fun allPairsDistance(): Int = map.mapIndexed { i, v -> map.drop(i + 1).sumOf { distance(it, v) }}.sum()

        private fun distance(from: Galaxy, to: Galaxy): Int = abs(from.first - to.first) + abs(from.second - to.second)

        private fun expandRow() {
            val allX = map.map { it.first }.distinct().sorted()
            val toExpand = (allX.first()..allX.last()).filter{it !in allX}.mapIndexed { i, v -> i + v }
            toExpand.forEach{ w -> map = map.map { if (it.first > w) it.first + 1 to it.second else it} }
        }

        private fun expandColumn() {
            val allY = map.map { it.second }.distinct().sorted()
            val toExpand = (allY.first()..allY.last()).filter { it !in allY }.mapIndexed { i, v -> i + v }
            toExpand.forEach{ w -> map = map.map { if (it.second > w) it.first to it.second + 1 else it} }
        }
    }
}