package day21

fun main() {
    println(Part1.calc(testData, 6))
    println(Part1.calc(data, 64))
}

object Part1 {
    fun calc(input: List<String>, steps: Int): Int {
        val garden = load(input)

        var walk = setOf(garden.start)

        for (step in 1..steps) {
            walk = walk.flatMap { garden.explore(it) }.toSet()
        }

        return walk.size
    }

    fun load(input: List<String>): Garden {
        var start = Point(0, 0)
        val plot = mutableMapOf<Point, Char>()
        input.forEachIndexed { yindex, ystring ->
            ystring.forEachIndexed{ xIndex, xChar ->
                when (xChar) {
                    'S' -> {
                        start = Point(xIndex, yindex)
                        plot[Point(xIndex, yindex)] = xChar
                    }
                    '.' -> plot[Point(xIndex, yindex)] = xChar
                }
            }
        }
        return Garden(start, plot)
    }

    data class Garden(val start: Point, val plot: Map<Point, Char>) {
        fun explore(point: Point): Set<Point> {
            return Direction.entries.map { point.add(it) }.filter { canWalk(it) }.toSet()
        }

        private fun canWalk(point: Point): Boolean {
            return plot.contains(point)
        }
    }

    data class Point(val x: Int, val y: Int) {
        fun add(direction: Direction): Point {
            return Point(x + direction.x, y + direction.y)
        }
    }

    enum class Direction(val x: Int, val y: Int) {
        NORTH(0, -1),
        EAST(1, 0),
        SOUTH(0, 1),
        WEST(-1, 0);
    }
}