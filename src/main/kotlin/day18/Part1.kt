package day18

fun main() {
    println(Part1.calc(testData))
    //println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        val edgesList = mutableListOf<Edge>()

        val instructions = load(input)
        var previous: Edge? = null
        var position = Point(0, 0)

        for (i in instructions) {
            for (t in 1..(i.length)) {
                position = position.add(i.direction)
                val edge = Edge(position, previous)
                edgesList.add(edge)
                previous?.next = edge
                previous = edge
            }
        }

        edgesList.first().previous = edgesList.last()
        edgesList.last().next = edgesList.first()

        val yGroups = edgesList.groupBy { it.position.y }
        var count = 0

        for (yGroup in yGroups) {
            var inside = false
            val xSorted = yGroup.value.sortedBy { it.position.x }
            var previousEdge: Edge? = null
            var previousShape: Shape = Shape.NONE
            for (x in xSorted) {
                val shape = x.shape()

                if (previousShape == Shape.NONE) {
                    if (shape == Shape.VERTICAL || shape == Shape.BOTTOM_LEFT || shape == Shape.TOP_LEFT) {
                        inside = true
                        count ++
                    }
                } else if (previousShape == Shape.VERTICAL) {
                    if (shape == Shape.VERTICAL || shape == Shape.BOTTOM_LEFT || shape == Shape.TOP_LEFT) {
                        inside = inside.not()
                        if (inside) {
                            count ++
                        } else {
                            count += x.position.x - previousEdge!!.position.x
                        }
                    }
                } else if (previousShape == Shape.BOTTOM_LEFT) {
                    if (shape == Shape.BOTTOM_RIGHT) {
                        inside = inside.not()
                        if (inside) {
                            count ++
                        } else {
                            count += x.position.x - previousEdge!!.position.x
                        }
                    }
                } else if (previousShape == Shape.TOP_LEFT) {
                    if (shape == Shape.TOP_RIGHT) {
                        inside = inside.not()
                        if (inside) {
                            count ++
                        } else {
                            count += x.position.x - previousEdge!!.position.x
                        }
                    }
                } else if (previousShape == Shape.TOP_RIGHT) {
                    if (shape == Shape.VERTICAL || shape == Shape.TOP_LEFT || shape == Shape.BOTTOM_LEFT) {
                        inside = inside.not()
                        if (inside) {
                            count ++
                        } else {
                            count += x.position.x - previousEdge!!.position.x
                        }
                    }
                } else if (previousShape == Shape.BOTTOM_RIGHT) {
                    if (shape == Shape.VERTICAL || shape == Shape.TOP_LEFT || shape == Shape.BOTTOM_LEFT) {
                        inside = inside.not()
                        if (inside) {
                            count ++
                        } else {
                            count += x.position.x - previousEdge!!.position.x
                        }
                    }
                }

                if (shape != Shape.HORIZONTAL) {
                    previousShape = shape
                    previousEdge = x
                }

                //if (inside) print("I") else print("O")
                print(shape.character)
            }
            println(" $count")
        }

        return count
    }

    fun load(input: List<String>): List<Instruction> {
        return input.map {
            val s = it.split(" ")
            Instruction(Direction.from(s[0]), s[1].toInt(), s[2])
        }
    }

    data class Instruction(val direction: Direction, val length: Int, val colour: String)

    data class Point(val x: Int, val y: Int) {
        fun add(direction: Direction): Point {
            return Point(x + direction.x, y + direction.y)
        }
    }

    data class Edge(val position: Point,  var previous: Edge?) {
        var next: Edge? = null

        fun isVertical(): Boolean {
            return ((previous!!.position.y < position.y && next!!.position.y > position.y) || (previous!!.position.y > position.y && next!!.position.y < position.y))
        }

        fun isTopLeft(): Boolean {
            return ((previous!!.position.x > position.x && previous!!.position.y == position.y && next!!.position.x == position.x && next!!.position.y > position.y) ||
                    (previous!!.position.x == position.x && previous!!.position.y > position.y && next!!.position.x > position.x && next!!.position.y == position.y))
        }

        fun isBottomLeft(): Boolean {
            return ((previous!!.position.x == position.x && previous!!.position.y < position.y && next!!.position.x > position.x && next!!.position.y == position.y) ||
                    (previous!!.position.x > position.x && previous!!.position.y == position.y && next!!.position.x == position.x && next!!.position.y < position.y))
        }

        fun isBottomRight(): Boolean {
            return  ((previous!!.position.x < position.x && previous!!.position.y == position.y && next!!.position.x == position.x && next!!.position.y < position.y) ||
                     (previous!!.position.x == position.x && previous!!.position.y < position.y && next!!.position.x < position.x && next!!.position.y == position.y))
        }

        fun isTopRight(): Boolean {
            return  ((previous!!.position.x < position.x && previous!!.position.y == position.y && next!!.position.x == position.x && next!!.position.y > position.y) ||
                     (previous!!.position.x == position.x && previous!!.position.y > position.y && next!!.position.x < position.x && next!!.position.y == position.y))
        }

        fun shape(): Shape {
            if (isVertical()) return Shape.VERTICAL
            if (isTopLeft()) return Shape.TOP_LEFT
            if (isTopRight()) return Shape.TOP_RIGHT
            if (isBottomRight()) return Shape.BOTTOM_RIGHT
            if (isBottomLeft()) return Shape.BOTTOM_LEFT
            return Shape.HORIZONTAL
        }

        override fun toString(): String {
            return shape().character.toString()
        }
    }

    enum class Direction(val x: Int, val y:Int) {
        UP(0,-1), RIGHT(1,0), DOWN(0,1), LEFT(-1,0);

        companion object {
            fun from(str: String): Direction {
                return when (str) {
                    "U" -> UP
                    "D" -> DOWN
                    "L" -> LEFT
                    "R" -> RIGHT
                    else -> throw IllegalStateException()
                }
            }
        }
    }

    enum class Shape(val character: Char) {
        NONE('O'), HORIZONTAL('-'), VERTICAL('|'), TOP_LEFT('F'), TOP_RIGHT('7'), BOTTOM_RIGHT('J'), BOTTOM_LEFT('L')
    }
}