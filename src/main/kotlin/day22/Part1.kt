package day22

import kotlin.math.min

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        val bricks = load(input)

        val settled = mutableListOf<Brick>()
        val remaining = bricks.toMutableList()

        while (remaining.isNotEmpty()) {
            var brick = remaining.first()

            while (brick.canFall()) {
                val brickFallen = brick.fall()
                if (!brickFallen.collides(settled)) {
                    brick = brickFallen
                } else {
                    break
                }
            }
            settled.add(brick)
            remaining.removeAt(0)
        }

        var count = 0
        for (brick in settled) {
            if (!anyFall(settled - brick)) {
                count++
            }
        }

        return count
    }

    fun load(input: List<String>): List<Brick> {
        return input.map {
            val split = it.split("~")
            val start = split[0].split(",").let { Point(it[0].toInt(), it[1].toInt(), it[2].toInt()) }
            val end = split[1].split(",").let { Point(it[0].toInt(), it[1].toInt(), it[2].toInt()) }
            Brick(start, end)
        }.sortedBy { min(it.start.z, it.end.z) }
    }

    private fun anyFall(bricks: List<Brick>): Boolean {
        for (brick in bricks) {
            if (brick.canFall()) {
                val brickFallen = brick.fall()
                if (!brickFallen.collides(bricks - brick)) {
                    return true
                }
            }
        }
        return false
    }

    data class Brick(val start: Point, val end: Point) {
        fun canFall(): Boolean {
            return start.z > 1 && end.z > 1
        }

        fun fall(): Brick {
            return Brick(start.zMinus(), end.zMinus())
        }

        fun collides(others: List<Brick>): Boolean {
            return others.any { collides(it) }
        }

        private fun collides(other: Brick): Boolean {
            if (start.z == end.z && other.start.z == other.end.z && start.z == other.start.z) {
                return (start.x <= other.end.x && end.x >= other.start.x) && (start.y <= other.end.y && end.y >= other.start.y)
            } else if (start.y == end.y && other.start.y == other.end.y && start.y == other.start.y) {
                return (start.x <= other.end.x && end.x >= other.start.x) && (start.z <= other.end.z && end.z >= other.start.z)
            } else if (start.x == end.x && other.start.x == other.end.x && start.x == other.start.x) {
                return (start.z <= other.end.z && end.z >= other.start.z) && (start.y <= other.end.y && end.y >= other.start.y)
            }
            return false
        }
    }

    data class Point(val x: Int, val y: Int, val z: Int) {
        fun zMinus(): Point {
            return Point(x, y, z-1)
        }
    }
}