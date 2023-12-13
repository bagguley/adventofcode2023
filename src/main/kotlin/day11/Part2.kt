package day11

import kotlin.math.abs

typealias GalaxyL = Pair<Long, Long>

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
}

object Part2 {

    fun calc(input: List<String>): Long {
        val universe = load(input)
        universe.expand()
        return universe.allPairsDistance()
    }

    fun load(input: List<String>): Universe = Universe(input.flatMapIndexed { y, s -> s.mapIndexedNotNull { x, c -> if (c == '#') x.toLong() to y.toLong() else null } })

    class Universe(var map: List<GalaxyL>) {
        private val expansion = 1_000_000

        fun expand() {
            expandRow()
            expandColumn()
        }

        fun allPairsDistance(): Long = map.mapIndexed { i, v ->  map.drop(i + 1).sumOf { distance(it, v) } }.sum()

        private fun distance(from: GalaxyL, to: GalaxyL): Long = abs(from.first - to.first) + abs(from.second - to.second)

        private fun expandRow() {
            val allX = map.map { it.first }.distinct().sorted()
            val toExpand = (allX.first()..allX.last()).filter{it !in allX}.mapIndexed { i, v -> (i * (expansion - 1)) + v }
            toExpand.forEach{ w -> map = map.map { if (it.first > w) it.first + expansion - 1 to it.second else it} }
        }

        private fun expandColumn() {
            val allY = map.map { it.second }.distinct().sorted()
            val toExpand = (allY.first()..allY.last()).filter { it !in allY }.mapIndexed { i, v -> (i * (expansion - 1)) + v }
            toExpand.forEach{ w -> map = map.map { if (it.second > w) it.first to it.second + expansion - 1 else it} }
        }
    }
}
