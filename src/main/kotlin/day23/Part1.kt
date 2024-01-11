package day23

import java.util.PriorityQueue

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        val result = mutableListOf<Path>()
        val width = input[0].length
        val height = input.size
        val trail = Trail(load(input), width, height)

        val queue = PriorityQueue<Path>()
        queue.add(Path(emptySet(), trail.start, 0))

        while (queue.isNotEmpty()) {
            val next = queue.remove()
            if (next.position == trail.end) {
                result.add(next)
            }
            if (next.visited.contains(next.position)) continue
            queue.addAll(trail.next(next.position).map { Path(next.visited + next.position, it, next.length + 1) })
        }

        return result.maxOf { it.length }
    }

    fun load(input: List<String>): Map<Point, Char> {
        return input.flatMapIndexed { row, string ->
            string.mapIndexed{ col, char -> Point(col, row) to char }
        }.associate { it }
    }

    class Trail(private val trail: Map<Point, Char>, val width: Int, val height: Int) {
        val start = Point(1, 0)
        val end = Point(width - 2, height - 1)

        fun next(from: Point): List<Point> {
            return allowed(from).map { from.add(it) }
                .filter { notWall(it) }
                .filter { inBounds(it)}
        }

        private fun allowed(point: Point): List<Direction> {
            return when (val char = trail[point]) {
                '.' -> Direction.entries
                '>' -> listOf(Direction.EAST)
                'v' -> listOf(Direction.SOUTH)
                '<' -> listOf(Direction.WEST)
                '^' -> listOf(Direction.NORTH)
                else -> throw IllegalArgumentException("$char")
            }
        }

        private fun notWall(point: Point): Boolean {
            return trail[point] != '#'
        }

        private fun inBounds(point: Point):Boolean {
            return point.column in 0..<width && point.row in 0..<height
        }
    }

    data class Path(val visited: Set<Point>, val position: Point, val length: Int): Comparable<Path> {
        override fun compareTo(other: Path): Int {
            return length.compareTo(other.length)
        }

    }

    data class Point(val column: Int, val row: Int) {
        fun add(direction: Direction): Point {
            return Point(column + direction.x, row + direction.y)
        }
    }

    enum class Direction(val x: Int, val y:Int) {
        NORTH(0, -1), SOUTH(0, 1), EAST(1, 0), WEST(-1, 0)
    }
}

