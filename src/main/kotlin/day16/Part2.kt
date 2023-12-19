package day16

import day16.Part2.Direction.*

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>): Int {
        val width = input[0].length
        val height = input.size

        val results = mutableListOf<Int>()
        for (x in 0 until width) {
            results.add(calcBeam(input, SOUTH, x to 0))
            results.add(calcBeam(input, NORTH, x to height-1))
        }
        for (y in 0 until height) {
            results.add(calcBeam(input, EAST, 0 to y))
            results.add(calcBeam(input, WEST, width-1 to y))
        }

        return results.max()
    }

    fun calcBeam(input: List<String>, direction: Direction, position: Pair<Int, Int>): Int {
        val energisedMap = mutableSetOf<Pair<Int,Int>>()
        val seenSet = mutableSetOf<Beam>()
        val width = input[0].length
        val height = input.size

        val beams = mutableListOf(Beam(direction, position))

        while(beams.isNotEmpty()) {
            val toAdd: MutableList<Beam> = mutableListOf()
            beams.forEach{
                seenSet.add(Beam(it))
                energisedMap.add(it.position)
                toAdd.addAll(move(it, input))
            }
            beams.addAll(toAdd)
            beams.removeIf { it.position.first < 0 || it.position.first >= width
                    || it.position.second < 0 || it.position.second >= height}
            beams.removeIf { seenSet.contains(it) }
        }

        return energisedMap.size
    }

    fun move(beam: Beam, input: List<String>): List<Beam> {
        val point = input[beam.position.second][beam.position.first]
        return when (point) {
            '.' -> beam.move()
            '|' -> beam.hitVertical()
            '-' -> beam.hitHorizontal()
            '/' -> beam.hit45Right()
            '\\' -> beam.hit45Left()
            else -> emptyList()
        }
    }

    data class Beam(var direction: Direction, var position: Pair<Int, Int>) {
        constructor(beam: Beam) : this(beam.direction, beam.position)

        fun move(): List<Beam> {
            position = position.first + direction.x to position.second + direction.y
            return emptyList()
        }

        fun splitVertical(): List<Beam> {
            position = position.first to position.second - 1
            direction = NORTH
            return listOf(Beam(SOUTH, position.first to position.second + 2))
        }

        fun splitHorizontal(): List<Beam> {
            position = position.first - 1 to position.second
            direction = WEST
            return listOf(Beam(EAST, position.first + 2 to position.second))
        }

        fun moveRight(): List<Beam> {
            direction = EAST
            return move()
        }

        fun moveLeft(): List<Beam> {
            direction = WEST
            return move()
        }

        fun moveUp(): List<Beam> {
            direction = NORTH
            return move()
        }

        fun moveDown(): List<Beam> {
            direction = SOUTH
            return move()
        }

        fun hitVertical(): List<Beam> {
            return when (direction) {
                SOUTH -> move()
                EAST -> splitVertical()
                NORTH -> move()
                WEST -> splitVertical()
            }
        }

        fun hitHorizontal(): List<Beam> {
            return when (direction) {
                SOUTH -> splitHorizontal()
                EAST -> move()
                NORTH -> splitHorizontal()
                WEST -> move()
            }
        }

        fun hit45Right(): List<Beam> {
            return when (direction) {
                SOUTH -> moveLeft()
                EAST -> moveUp()
                NORTH -> moveRight()
                WEST -> moveDown()
            }
        }

        fun hit45Left(): List<Beam> {
            return when (direction) {
                SOUTH -> moveRight()
                EAST -> moveDown()
                NORTH -> moveLeft()
                WEST -> moveUp()
            }
        }
    }

    enum class Direction(val x: Int, val y: Int) {
        NORTH(0, -1),
        EAST(1, 0),
        SOUTH(0, 1),
        WEST(-1, 0);
    }
}