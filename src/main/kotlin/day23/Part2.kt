package day23

import java.util.PriorityQueue

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>): Int {
        val map = load(input)

        val trail = Trail(map, input[0].length, input.size)

        val nodeMap = createNodeMap(trail)

        println("Graph built")



        return -1
    }

    fun load(input: List<String>): Map<Point, Char> {
        return input.flatMapIndexed { row, string ->
            string.mapIndexed{ col, char -> Point(col, row) to char }
        }.associate { it }
    }

    private fun createNodeMap(trail: Trail) {
        val nodeMap = mutableMapOf<Point, Node>()
        val visited = mutableSetOf<Point>()
        val queue = PriorityQueue<Step>()
        val firstNode = Node(trail.start)

        nodeMap[trail.start] = firstNode

        queue.add(Step(firstNode, trail.start, 0, 0))

        while (queue.isNotEmpty()) {
            val next = queue.remove()

            if (visited.contains(next.position) && nodeMap.contains(next.position)) {
                val node = nodeMap[next.position]!!
                node.addConnection(next.previous, next.recentCost)
                next.previous.addConnection(node, next.recentCost)
                continue
            }

            visited.add(next.position)

            val nextPositions = trail.next(next.position).filter{!visited.contains(it)}
            if (nextPositions.isEmpty()) continue
            if (nextPositions.size == 1) {
                queue.add(Step(next.previous, nextPositions[0], next.totalCost + 1, next.recentCost + 1))
                continue
            }

            for (nextPosition in nextPositions) {
                val newNode = Node(nextPosition)
                nodeMap[nextPosition] = newNode
                newNode.addConnection(next.previous, next.recentCost)
                next.previous.addConnection(newNode, next.recentCost)
                queue.add(Step(newNode, nextPosition, next.totalCost + 1, 0))
            }
        }
    }

    class Trail(private val trail: Map<Point, Char>, val width: Int, val height: Int) {
        val start = Point(1, 0)
        val end = Point(width - 2, height - 1)

        fun next(from: Point): List<Point> {
            return Direction.entries.map { from.add(it) }
                .filter { notWall(it) }
                .filter { inBounds(it) }
        }

        private fun notWall(point: Point): Boolean {
            return trail[point] != '#'
        }

        private fun inBounds(point: Point):Boolean {
            return point.column in 0..<width && point.row in 0..<height
        }
    }

    data class Node(val position: Point, val connections: MutableSet<Connection> = mutableSetOf()) {
        fun addConnection(node: Node, cost: Int) {
            connections.add(Connection(node,  cost))
        }

        override fun hashCode(): Int {
            return position.hashCode()
        }

        override fun equals(other: Any?): Boolean {
            return if (other is Node) {
                position == other.position
            } else false
        }

        override fun toString(): String {
            return "$position, ${connections.size}"
        }
    }

    data class Connection(val node: Node, val cost: Int)

    data class Step(val previous: Node, val position: Point, val totalCost: Int, val recentCost: Int): Comparable<Step> {
        override fun compareTo(other: Step): Int {
            return totalCost.compareTo(other.totalCost)
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