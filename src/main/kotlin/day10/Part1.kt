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

    class Grid(val map: MutableMap<Pair<Int, Int>, Char>) {
        private val scoreMap = mutableMapOf<Pair<Int, Int>, Int>()
        companion object {
            val SURROUNDS = listOf(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST)
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
            scoreMap[start] = 0

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
                val c = map[it.offset(coords)]
                val s = scoreMap[it.offset(coords)]
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
                    Direction.NORTH, Direction.SOUTH -> offset.pipes
                    else -> emptyList()
                }
                '-' -> when(offset) {
                    Direction.WEST, Direction.EAST -> offset.pipes
                    else -> emptyList()
                }
                'L' -> when(offset) {
                    Direction.NORTH, Direction.EAST -> offset.pipes
                    else -> emptyList()
                }
                'J' -> when (offset) {
                    Direction.NORTH, Direction.WEST -> offset.pipes
                    else -> emptyList()
                }
                '7' -> when (offset) {
                    Direction.SOUTH, Direction.WEST -> offset.pipes
                    else -> emptyList()
                }
                'F' -> when (offset) {
                    Direction.SOUTH, Direction.EAST -> offset.pipes
                    else -> emptyList()
                }
                else -> emptyList()
            }.contains(testChar)
        }
    }
}