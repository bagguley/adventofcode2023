package day17

import day17.Part2.Direction.*
import kotlin.math.abs

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(testData2))
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>): Int {
        val width = input[0].length
        val height = input.size
        val exit = Point(width - 1, height - 1)

        val visited: MutableSet<Pair<Point, List<Direction>>> = mutableSetOf()
        val toVisitMap: MutableMap<Pair<Point,List<Direction>>, Path> = mutableMapOf()

        val first = Path(listOf(Point(0, 0)), listOf(), distanceHeuristic = Point(0,0).distanceTo(exit))

        toVisitMap.put((first.location() to first.lastDirections()),  first)

        var nextPath = toVisitMap.values.first()

        while (nextPath.location() != exit) {
            toVisitMap.remove(nextPath.location() to nextPath.lastDirections())

            visited.add(nextPath.location() to nextPath.lastDirections())

            val nextPaths = nextPoints(nextPath, width, height, input)

            nextPaths.forEach { next ->
                val inVisited = visited.contains(next.location() to next.lastDirections())

                if (!inVisited) {
                    val inToVisit = toVisitMap.get(next.location() to next.lastDirections())

                    if (inToVisit == null || inToVisit.score > next.score) {
                        toVisitMap.put(next.location() to next.lastDirections(), next)
                    }
                }
            }

            nextPath = toVisitMap.values.sortedBy { it.distanceHeuristic }.first()
        }

        return nextPath.score
    }

    private fun nextPoints(from: Path, width: Int, height: Int, input: List<String>): List<Path> {
        val result = mutableListOf<Path>()

        if (from.directions.isEmpty()) {
            moveFour(from, EAST, width, height, input)?.let{ result.add(it) }
            moveFour(from, SOUTH, width, height, input)?.let{ result.add(it) }
            return result
        }

        when (from.direction()) {
            NORTH -> {
                moveOne(from, NORTH, width, height, input)?.let { result.add(it) }
                moveFour(from, EAST, width, height, input)?.let { result.add(it) }
                moveFour(from, WEST, width, height, input)?.let { result.add(it) }
            }
            EAST  -> {
                moveOne(from, EAST, width, height, input)?.let { result.add(it) }
                moveFour(from, NORTH, width, height, input)?.let { result.add(it) }
                moveFour(from, SOUTH, width, height, input)?.let { result.add(it) }
            }
            SOUTH -> {
                moveOne(from, SOUTH, width, height, input)?.let { result.add(it) }
                moveFour(from, EAST, width, height, input)?.let { result.add(it) }
                moveFour(from, WEST, width, height, input)?.let { result.add(it) }
            }
            WEST  -> {
                moveOne(from, WEST, width, height, input)?.let { result.add(it) }
                moveFour(from, NORTH, width, height, input)?.let { result.add(it) }
                moveFour(from, SOUTH, width, height, input)?.let { result.add(it) }
            }
        }

        return result
    }

    fun moveFour(from: Path, direction: Direction, width: Int, height: Int, input: List<String>): Path? {
        var endPoint: Point = from.location()
        var score: Int = from.score
        for (i in 1 .. 4) {
            endPoint = endPoint.add(direction)
            if (endPoint.x in 0 ..< width && endPoint.y in 0 ..< height) {
                score += input[endPoint.y][endPoint.x].digitToInt()
            } else return null
        }

        return Path(from.locations + endPoint, from.directions + direction + direction + direction + direction,
            score, endPoint.distanceTo(Point(width - 1, height - 1)) + score)
    }

    fun moveOne(from: Path, direction: Direction, width: Int, height: Int, input: List<String>): Path? {
        val lastDirections = from.directions.takeLast(10).groupBy { it }
        if ((lastDirections[direction]?.size ?: 0) == 10) return null

        var endPoint: Point = from.location()
        var score: Int = from.score
        endPoint = endPoint.add(direction)

        if (endPoint.x in 0 ..< width && endPoint.y in 0 ..< height) {
            score += input[endPoint.y][endPoint.x].digitToInt()
        } else return null

        return Path(from.locations + endPoint, from.directions + direction,
            score, endPoint.distanceTo(Point(width - 1, height - 1)) + score)
    }

    data class Path(val locations: List<Point>, val directions: List<Direction> = emptyList(), val score: Int = 0, val distanceHeuristic: Int) {
        fun location(): Point {
            return locations.last()
        }

        fun direction(): Direction {
            return directions.last()
        }

        fun lastDirections(): List<Direction> {
            return directions.takeLast(10)
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