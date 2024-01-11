package day22

import java.util.PriorityQueue
import kotlin.math.max
import kotlin.math.min

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
}

object Part2 {
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

        for (brick in settled) {
            val brickUp = brick.up()
            val collidesAbove = brickUp.collidesWith(settled - brick)
            brick.addSupports(collidesAbove)

            collidesAbove.forEach{it.addSupportedBy(brick)}
        }

        val sortedSettled = settled.sortedBy { it.maxZ() }

        var count = 0

        for (brick in sortedSettled) {
            count += findFallers(brick).size - 1
        }

        return count
    }

    private fun findFallers(firstBrick: Brick): MutableSet<Brick> {
        val fallen = mutableSetOf<Brick>()
        val next = PriorityQueue<Brick>()
        next.add(firstBrick)

        while (!next.isEmpty()) {
            val nextBrick = next.remove()
            fallen.add(nextBrick)
            val onlySupports = nextBrick.supports.filter { (it.supportedBy - fallen).isEmpty() }
            next.addAll(onlySupports)
            fallen.addAll(onlySupports)
        }

        return fallen
    }

    fun load(input: List<String>): List<Brick> {
        return input.map {
            val split = it.split("~")
            val start = split[0].split(",").let { Point(it[0].toInt(), it[1].toInt(), it[2].toInt()) }
            val end = split[1].split(",").let { Point(it[0].toInt(), it[1].toInt(), it[2].toInt()) }
            Brick(start, end)
        }.sortedBy { min(it.start.z, it.end.z) }
    }

    data class Brick(val start: Point, val end: Point): Comparable<Brick> {
        val supportedBy = mutableSetOf<Brick>()
        val supports = mutableSetOf<Brick>()

        fun canFall(): Boolean {
            return start.z > 1 && end.z > 1
        }

        fun fall(): Brick {
            return Brick(start.zMinus(), end.zMinus())
        }

        fun up(): Brick {
            return Brick(start.zPlus(), end.zPlus())
        }

        fun collides(others: List<Brick>): Boolean {
            return others.filter{zCollides(it)}.filter { xCollides(it) }.any{yCollides(it)}
        }

        fun collidesWith(others: List<Brick>): Set<Brick> {
            return others.filter{zCollides(it)}.filter { xCollides(it) }.filter{yCollides(it)}.toSet()
        }

        private fun zCollides(other:Brick): Boolean {
            return start.z <= other.end.z && end.z >= other.start.z
        }

        private fun xCollides(other: Brick): Boolean {
            return start.x <= other.end.x && end.x >= other.start.x
        }

        private fun yCollides(other: Brick): Boolean {
            return start.y <= other.end.y && end.y >= other.start.y
        }

        fun addSupportedBy(brick: Brick) {
            supportedBy.add(brick)
        }

        fun addSupports(brick: Set<Brick>) {
            supports.addAll(brick)
        }

        fun maxZ(): Int {
            return max(start.z, end.z)
        }

        override fun compareTo(other: Brick): Int {
            return maxZ().compareTo(other.maxZ())
        }
    }

    data class Point(val x: Int, val y: Int, val z: Int) {
        fun zMinus(): Point {
            return Point(x, y, z-1)
        }

        fun zPlus(): Point {
            return Point(x, y, z+1)
        }
    }
}