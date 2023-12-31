package day17

import day17.Part1.Direction.*
import java.util.PriorityQueue
import kotlin.math.abs

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        val inputInts = input.map { it.toCharArray().map { it.digitToInt() } }
        val width = inputInts[0].size
        val height = inputInts.size
        val exit = Point(width - 1, height - 1)

        val visited: MutableSet<Pair<Point, Pair<Direction, Int>>> = mutableSetOf()
        val first = Node(Point(0, 0), EAST, 0, 0, Point(0,0).distanceTo(exit))

        val pq = PriorityQueue<Node>()
        pq.add(first)

        while (pq.first().location != exit) {
            val nextPath = pq.remove()

            if (visited.contains(nextPath.location to (nextPath.direction to nextPath.consecutive))) continue

            visited.add(nextPath.location to (nextPath.direction to nextPath.consecutive))

            val nextPaths = nextPoints(nextPath, width, height, inputInts)

            nextPaths.forEach { next ->
                val inVisited = visited.contains(next.location to (next.direction to next.consecutive))

                if (!inVisited) {
                    pq.add(next)
                }
            }
        }

        return pq.first().score
    }

    private fun nextPoints(from: Node, width: Int, height: Int, input: List<List<Int>>): List<Node> {
        return validDirections(from)
            .filter {
                val newLoc = from.location.add(it.first)
                (newLoc.x in 0 ..< width && newLoc.y in 0 ..< height)
            }.map {
                val newLoc = from.location.add(it.first)
                val newScore = from.score + input[newLoc.y][newLoc.x]
                Node(newLoc, it.first, it.second,
                    newScore, newLoc.distanceTo(Point(width - 1, height - 1)) + newScore)
            }
    }

    private fun validDirections(from: Node): List<Pair<Direction, Int>> {
        return when (from.direction) {
            NORTH -> listOf(NORTH to from.consecutive + 1, EAST to 1, WEST to 1)
            EAST  -> listOf(EAST to from.consecutive + 1, NORTH to 1, SOUTH to 1)
            SOUTH -> listOf(SOUTH to from.consecutive + 1, EAST to 1, WEST to 1)
            WEST  -> listOf(WEST to from.consecutive + 1, NORTH to 1, SOUTH to 1)
        }.filter {
            it.second <= 3
        }
    }

    data class Node(val location: Point, val direction: Direction, val consecutive: Int, val score: Int, val distanceToExit: Int): Comparable<Node> {
        override fun compareTo(other: Node): Int {
            return (score + distanceToExit).compareTo(other.score + other.distanceToExit)
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