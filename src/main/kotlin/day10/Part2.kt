package day10

import day10.Part2.Direction.*

fun main() {
    println(Part2.calc(testData3))
    println(Part2.calc(testData4))
    println(Part2.calc(testData5))
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>): Int {
        val grid = load(input)
        grid.trace()
        return grid.countNests()
    }

    fun load(input: List<String>): Grid {
        val map = mutableMapOf<Pair<Int,Int>, Char>()

        for (y in input.indices) {
            for (x in input[y].withIndex()) {
                map[x.index to y] = x.value
            }
        }

        return Grid(map, input.first().length, input.size)
    }

    enum class Direction(x: Int, y: Int, val pipes: List<Char>) {
        NORTH(0, -1, listOf('|','7','F')),
        EAST(1, 0, listOf('-','J','7')),
        SOUTH(0, 1, listOf('|','L','J')),
        WEST(-1, 0, listOf('-','L','F'));

        private val offset = Pair(x, y)

        fun offset(position: Pair<Int, Int>): Pair<Int, Int> {
            return offset.first + position.first to offset.second + position.second
        }
    }

    class Grid(val map: MutableMap<Pair<Int, Int>, Char>, val width: Int, val height: Int) {
        private val loopMap = mutableMapOf<Pair<Int, Int>, Boolean>()
        companion object {
            val SURROUNDS = listOf(NORTH, EAST, SOUTH, WEST)
        }

        fun trace() {
            trace(start())
        }

        fun countNests():Int {
            val nests = mutableSetOf<Pair<Int,Int>>()
            var previous = 'O'
            for (y in 0 until height) {
                var isInside = false
                for (x in 0 until width) {
                    val char = map[x to y]!!
                    if (loopMap.contains(x to y)) {
                        if (previous == 'O') {
                            if (char in "|LF") {
                                isInside = isInside.not()
                            }
                        } else if (previous == '|') {
                            if (char in "|LF") {
                                isInside = isInside.not()
                            }
                        } else if (previous == 'L') {
                            if (char in "J") {
                                isInside = isInside.not()
                            }
                        } else if (previous == 'F') {
                            if (char in "7") {
                                isInside = isInside.not()
                            }
                        } else if (previous == '7') {
                            if (char in "|FL") {
                                isInside = isInside.not()
                            }
                        } else if (previous == 'J') {
                            if (char in "|FL") {
                                isInside = isInside.not()
                            }
                        }
                        if (char in "|7FLJ") {
                            previous = char
                        }

                        print(char)
                    } else {
                        if (isInside) nests.add(x to y)
                    }
                }
            }

            return nests.size
        }

        private fun start(): Pair<Int, Int> {
            return map.entries.find { it.value == 'S' }!!.key
        }

        private fun trace(start: Pair<Int, Int>) {
            var nextNodes = mutableListOf(start)
            loopMap[start] = true

            while (nextNodes.isNotEmpty()) {
                val connectingNodes = mutableListOf<Pair<Int, Int>>()
                for (node in nextNodes) {
                    val connect = connects(node)
                    connect.forEach { loopMap[it] = true }
                    connectingNodes.addAll(connect)
                }
                nextNodes = connectingNodes
            }
        }

        private fun connects(coords: Pair<Int, Int>): List<Pair<Int, Int>> {
            val offsets = SURROUNDS.filter {
                val c = map[it.offset(coords)]
                val s = loopMap[it.offset(coords)]
                c != null && c in "|-7FLJ" && s == null
            }

            return offsets.filter{connects(it, coords)}.map { it.offset(coords) }
        }

        private fun connects(offset: Direction, coords: Pair<Int, Int>) : Boolean {
            val char = map[coords]!!
            val testChar = map[offset.offset(coords)]!!

            return when(char) {
                'S' -> offset.pipes
                '|' -> when(offset) {
                    NORTH, SOUTH -> offset.pipes
                    else -> emptyList()
                }
                '-' -> when(offset) {
                    WEST, EAST -> offset.pipes
                    else -> emptyList()
                }
                'L' -> when(offset) {
                    NORTH, EAST -> offset.pipes
                    else -> emptyList()
                }
                'J' -> when (offset) {
                    NORTH, WEST -> offset.pipes
                    else -> emptyList()
                }
                '7' -> when (offset) {
                    SOUTH, WEST -> offset.pipes
                    else -> emptyList()
                }
                'F' -> when (offset) {
                    SOUTH, EAST -> offset.pipes
                    else -> emptyList()
                }
                else -> emptyList()
            }.contains(testChar)
        }
    }
}