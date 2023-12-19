package day16

import day16.Part1.Direction.*

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        val energisedSet = mutableSetOf<Position>()
        val seenSet = mutableSetOf<Beam>()
        val width = input[0].length
        val height = input.size

        var beams = listOf(Beam(Position(0, 0), EAST))

        while(beams.isNotEmpty()) {
            beams.forEach {
                seenSet.add(Beam(it))
                energisedSet.add(it.position)
            }

            beams = beams.flatMap{ beam -> move(beam, input) }
                .filter { it.position.x in 0..< width && it.position.y in 0 ..< height }
                .filter { !seenSet.contains(it)}
        }

        return energisedSet.size
    }

    private fun move(beam: Beam, input: List<String>): List<Beam> {
        val point = input[beam.position.y][beam.position.x]
        return when (point) {
            '.' -> beam.move()
            '/' -> beam.hit45Right()
            '\\' -> beam.hit45Left()
            '|' -> beam.hitVertical()
            '-' -> beam.hitHorizontal()
            else -> throw IllegalStateException()
        }
    }

    data class Beam(val position: Position, val direction: Direction) {
        constructor(beam: Beam) : this(beam.position, beam.direction)

        fun move(): List<Beam> = listOf(Beam(position.add(direction), direction))

        private fun splitVertical(): List<Beam> = listOf(Beam(position.add(NORTH), NORTH), Beam(position.add(SOUTH), SOUTH))

        private fun splitHorizontal(): List<Beam> = listOf(Beam(position.add(EAST), EAST), Beam(position.add(WEST), WEST))

        private fun move(direction: Direction): List<Beam> = listOf(Beam(position.add(direction), direction))

        fun hitVertical(): List<Beam> {
            return when(direction) {
                NORTH, SOUTH -> move()
                EAST, WEST -> splitVertical()
            }
        }

        fun hitHorizontal(): List<Beam> {
            return when (direction) {
                EAST, WEST -> move()
                SOUTH, NORTH -> splitHorizontal()
            }
        }

        fun hit45Right(): List<Beam> {
           return when (direction) {
                SOUTH -> move(WEST)
                EAST -> move(NORTH)
                NORTH -> move(EAST)
                WEST -> move(SOUTH)
            }
        }

        fun hit45Left(): List<Beam> {
            return when (direction) {
                SOUTH -> move(EAST)
                EAST -> move(SOUTH)
                NORTH -> move(WEST)
                WEST -> move(NORTH)
            }
        }
    }

    data class Position(val x: Int, val y:Int) {
        fun add(direction: Direction) = Position(x + direction.x, y + direction.y)
    }

    enum class Direction(val x: Int, val y: Int) {
        NORTH(0, -1), EAST(1, 0), SOUTH(0, 1), WEST(-1, 0);
    }
}