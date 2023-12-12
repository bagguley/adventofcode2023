package day10

fun main() {
    println(Part1.calc(testData1))
    println(Part1.calc(testData2))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        val grid = load(input)
        grid.trace()
        return grid.max()
    }

    fun load(input: List<String>): Grid {
        val map = mutableMapOf<Pair<Int,Int>, Char>()

        for (y in input.indices) {
            for (x in input[y].withIndex()) {
                map[x.index to y] = x.value
            }
        }

        return Grid(map)
    }

    class Grid(val map: MutableMap<Pair<Int, Int>, Char>) {
        private val scoreMap = mutableMapOf<Pair<Int, Int>, Int>()
        companion object {
            val NORTH = Pair(0, -1)
            val EAST = Pair(1, 0)
            val SOUTH = Pair(0, 1)
            val WEST = Pair(-1, 0)
            val SURROUNDS = listOf(NORTH, EAST, SOUTH, WEST)
        }

        fun trace() {
            trace(start())
        }

        fun max(): Int {
            return scoreMap.entries.maxOf { it.value }
        }

        private fun start(): Pair<Int, Int> {
            return map.entries.find { it.value == 'S' }!!.key
        }

        private fun trace(start: Pair<Int, Int>) {
            var count = 1
            var nextNodes = mutableListOf(start)

            while (nextNodes.isNotEmpty()) {
                val connectingNodes = mutableListOf<Pair<Int, Int>>()
                for (node in nextNodes) {
                    val connect = connects(node)
                    connect.forEach { scoreMap[it] = count }
                    connectingNodes.addAll(connect)
                }
                nextNodes = connectingNodes
                count++
            }
        }

        private fun connects(coords: Pair<Int, Int>): List<Pair<Int, Int>> {
            val offsets = SURROUNDS.filter {
                val c = map[coords.first + it.first to coords.second + it.second]
                val s = scoreMap[coords.first + it.first to coords.second + it.second]
                c != null && c in "|-7FLJ" && s == null
            }

            return offsets.filter{connects(it, coords)}
                .map { coords.first + it.first to coords.second + it.second }
        }

        private fun connects(offset: Pair<Int, Int>, coords: Pair<Int, Int>) : Boolean {
            val char = map[coords]!!
            val testChar = map[coords.first + offset.first to coords.second + offset.second]!!
            return when(char) {
                'S' -> when(offset) {
                    NORTH -> listOf('|','7','F')
                    EAST -> listOf('-','J','7')
                    SOUTH -> listOf('|','L','J')
                    WEST -> listOf('-','L','F')
                    else -> emptyList()
                }
                '|' -> when(offset) {
                    NORTH -> listOf('|','7','F')
                    SOUTH -> listOf('|','L','J')
                    else -> emptyList()
                }
                '-' -> when(offset) {
                    WEST -> listOf('-','L','F')
                    EAST -> listOf('-','J','7')
                    else -> emptyList()
                }
                'L' -> when(offset) {
                    NORTH -> listOf('|','7','F')
                    EAST -> listOf('-','J','7')
                    else -> emptyList()
                }
                'J' -> when (offset) {
                    NORTH -> listOf('|','7','F')
                    WEST -> listOf('-','L','F')
                    else -> emptyList()
                }
                '7' -> when (offset) {
                    SOUTH -> listOf('|','L','J')
                    WEST -> listOf('-','L','F')
                    else -> emptyList()
                }
                'F' -> when (offset) {
                    SOUTH -> listOf('|','L','J')
                    EAST -> listOf('-','J','7')
                    else -> emptyList()
                }
                else -> emptyList()
            }.contains(testChar)
        }
    }
}