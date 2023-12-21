package day17

import day17.Part1.Direction.*
import kotlin.math.abs

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        val width = input[0].length
        val height = input.size
        val exit = Point(width - 1, height - 1)

        val visited: MutableSet<Pair<Point, List<Direction>>> = mutableSetOf()
        val first = Path(listOf(Point(0, 0)), listOf(EAST), distanceToExit = Point(0,0).distanceTo(exit))

        val toVisitMap: MutableMap<Pair<Point,List<Direction>>, Path> = mutableMapOf((first.location() to first.lastDirections()) to first)
        var nextPath = toVisitMap.values.first()

        while (nextPath.location() != exit) {
            toVisitMap.remove(nextPath.location() to nextPath.lastDirections())

            visited.add(nextPath.location() to nextPath.lastDirections())

            val nextPaths = nextPoints(nextPath, width, height, input)

            nextPaths.forEach { next ->
                val inVisited = visited.contains(next.location() to next.lastDirections())

                if (!inVisited) {
                    val inToVisit = toVisitMap.get(next.location() to next.lastDirections())

                    if (inToVisit == null) {
                        toVisitMap[next.location() to next.lastDirections()] = next
                    } else {
                        if (inToVisit.score > next.score) {
                            toVisitMap[next.location() to next.lastDirections()] = next
                        }
                    }
                }
            }

            nextPath = toVisitMap.values.minByOrNull { it.distanceToExit }!!
        }

        return nextPath.score
    }

    private fun nextPoints(from: Path, width: Int, height: Int, input: List<String>): List<Path> {
        return validDirections(from).map { direction -> direction to from.location().add(direction) }
            .filter {
                it.second.x in 0 ..< width && it.second.y in 0 ..< height
            }.map {
                val newScore = from.score + input[it.second.y][it.second.x].digitToInt()
                Path(from.locations + it.second, from.directions + it.first,
                    newScore, it.second.distanceTo(Point(width - 1, height - 1)) + newScore)
            }
    }

    private fun validDirections(from: Path): List<Direction> {
        val lastDirections = from.directions.takeLast(3).groupBy { it }

        return when (from.direction()) {
            NORTH -> listOf(NORTH, EAST, WEST)
            EAST  -> listOf(EAST, NORTH, SOUTH)
            SOUTH -> listOf(SOUTH, EAST, WEST)
            WEST  -> listOf(WEST, NORTH, SOUTH)
        }.filter {
            (lastDirections[it]?.size ?: 0) < 3
        }
    }

    data class Path(val locations: List<Point>, val directions: List<Direction> = emptyList(), val score: Int = 0, val distanceToExit: Int) {
        fun location(): Point {
            return locations.last()
        }

        fun direction(): Direction {
            return directions.last()
        }

        fun lastDirections(): List<Direction> {
            return directions.takeLast(3)
        }
    }

    data class Point(val x: Int, val y: Int) {
        fun add(direction: Direction): Point {
            return Point(x + direction.x, y + direction.y)
        }

        fun distanceTo(other: Point): Int {
            return abs(x - other.x) + abs(y - other.y)
        }
    }

    enum class Direction(val x: Int, val y: Int) {
        NORTH(0, -1), EAST(1, 0), SOUTH(0, 1), WEST(-1, 0)
    }
}