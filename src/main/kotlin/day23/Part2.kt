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
        val result = mutableListOf<Int>()
        val queue = PriorityQueue<Path>()
        queue.add(Path(emptySet(), nodeMap[trail.start]!!, 0))

        while(queue.isNotEmpty()) {
            val nextPath = queue.remove()
            if (nextPath.current.position == trail.end) {
                result.add(nextPath.cost)
                continue
            }

            val node = nextPath.current

            val nextConnections = node.connections.filter { !nextPath.visited.contains(it.node) }

            for (nextConnection in nextConnections) {
                queue.add(Path(nextPath.visited + nextConnection.node, nextConnection.node, nextPath.cost + nextConnection.cost))
            }
        }

        return result.maxOf { it }
    }

    fun load(input: List<String>): Map<Point, Char> {
        return input.flatMapIndexed { row, string ->
            string.mapIndexed{ col, char -> Point(col, row) to char }
        }.associate { it }
    }

    private fun createNodeMap(trail: Trail): Map<Point, Node> {
        val nodeMap = mutableMapOf<Point, Node>()
        val visited = mutableSetOf<Point>()
        val queue = PriorityQueue<Step>()
        val firstNode = Node(trail.start)
        val endNode = Node(trail.end)
        visited.add(trail.end)

        nodeMap[trail.start] = firstNode
        nodeMap[trail.end] = endNode

        queue.add(Step(firstNode, trail.start, Direction.SOUTH, 0, 0))

        while (queue.isNotEmpty()) {
            val next = queue.remove()

            if (visited.contains(next.position) && nodeMap.contains(next.position)) {
                val node = nodeMap[next.position]!!
                node.addConnection(next.previous, next.recentCost)
                next.previous.addConnection(node, next.recentCost)
                continue
            }

            visited.add(next.position)

            val nextPositions = trail.next(next.position, next.lastDirection)
            if (nextPositions.isEmpty()) continue
            if (nextPositions.size == 1) {
                queue.add(Step(next.previous, nextPositions[0].first, nextPositions[0].second, next.totalCost + 1, next.recentCost + 1))
                continue
            }

            val newNode = Node(next.position)
            nodeMap[next.position] = newNode

            for (nextPosition in nextPositions) {
                newNode.addConnection(next.previous, next.recentCost)
                next.previous.addConnection(newNode, next.recentCost)
                queue.add(Step(newNode, nextPosition.first, nextPosition.second, next.totalCost + 1, 1))
            }
        }

        return nodeMap
    }

    class Trail(val trail: Map<Point, Char>, val width: Int, val height: Int) {
        val start = Point(1, 0)
        val end = Point(width - 2, height - 1)

        fun next(from: Point, direction: Direction): List<Pair<Point, Direction>> {
            return Direction.entries
                .filter { it.opposite() != direction}
                .map { from.add(it) to it }
                .filter { notWall(it.first) }
                .filter { inBounds(it.first) }
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

    data class Path(val visited: Set<Node>, val current: Node, val cost: Int): Comparable<Path> {
        override fun compareTo(other: Path): Int {
            return -1 * (cost.compareTo(other.cost))
        }
    }

    data class Connection(val node: Node, val cost: Int)

    data class Step(val previous: Node, val position: Point, val lastDirection: Direction, val totalCost: Int, val recentCost: Int): Comparable<Step> {
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
        NORTH(0, -1), SOUTH(0, 1), EAST(1, 0), WEST(-1, 0);

        fun opposite(): Direction {
            return when (this) {
                NORTH -> SOUTH
                EAST -> WEST
                SOUTH -> NORTH
                WEST -> EAST
            }
        }
    }
}