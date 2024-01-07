package day21

fun main() {
/*    println(Part2.calc(testData, 6))
    println(Part2.calc(testData, 10))
    println(Part2.calc(testData, 50))
    println(Part2.calc(testData, 100))
    println(Part2.calc(testData, 500))
    println(Part2.calc(testData, 1000))
    println(Part2.calc(testData, 5000))*/
    println(Part2.calc(data))
    //println(Part2.calc(data, 26501365))
}

object Part2 {
    fun calc(input: List<String>): Int {
        val steps = 26501365L
        val extraSteps = 65
        //val extraSteps = 1
        //val steps = 6L
        val size = input[0].length

        val odd = calc(input, size)
        val oddCount = odd.size.toLong()
        val even = calc(input, size + 1)
        val evenCount = even.size.toLong()

        println ("Odd: $oddCount, Even: $evenCount")

        val squaresWide = (((steps + 1L) / size) * 2L) - 1L

        val multiplier = (squaresWide - 1L) / 2L // (width - 1) / 2
        val sumToOne = multiplier * (multiplier + 1) / 2L
        val numOfSquares = (sumToOne * 4) + 1L
        println("Square Count: $numOfSquares")

        val oddCountSW = countSouthWest(odd, size, extraSteps)
        val oddCountSE = countSouthEast(odd, size, extraSteps)
        val oddCountNE = countNorthEast(odd, size, extraSteps)
        val oddCountNW = countNorthWest(odd, size, extraSteps)

        println("Odd SW: $oddCountSW")
        println("Odd SE: $oddCountSE")
        println("Odd NE: $oddCountNE")
        println("Odd NW: $oddCountNW")

        val numOfHalfSquaresOnEachSide = (squaresWide - 1L) / 2L
        val sumOfHalfSquares = numOfHalfSquaresOnEachSide * (oddCountSW + oddCountSE + oddCountNE + oddCountNW)
        val sumOfPoints = countSouthPoint(odd, size, extraSteps) + countNorthPoint(odd, size, extraSteps) +
                countEastPoint(odd, size, extraSteps) + countWestPoint(odd, size, extraSteps)

        val evenCountSW = countSouthWest(even, size, -extraSteps)
        val evenCountSE = countSouthEast(even, size, size + extraSteps)
        val evenCountNE = countNorthEast(even, size, size + extraSteps)
        val evenCountNW = countNorthWest(even, size, -extraSteps)

        println("Even SW: $evenCountSW")
        println("Even SE: $evenCountSE")
        println("Even NE: $evenCountNE")
        println("Even NW: $evenCountNW")

        val numOfRemainingEvenPartialSquares = numOfHalfSquaresOnEachSide + 1
        val sumOfRemainingEvenPartialSquares = numOfRemainingEvenPartialSquares * (evenCountSW + evenCountSE + evenCountNE + evenCountNW)

        val numOfOdd = ((squaresWide - 1L) / 2) * ((squaresWide - 1L) / 2)
        val numOfEven = ((squaresWide + 1L) / 2) * ((squaresWide + 1L) / 2)
        val numOfPositions = numOfOdd * oddCount + numOfEven * evenCount

        println("Squares Wide: $squaresWide")
        println("Num of odd: $numOfOdd")
        println("Num of even: $numOfEven")
        println("Num of halfSquares: $numOfHalfSquaresOnEachSide")
        println("Num of points: $sumOfPoints")

        println("Num of position: ${numOfPositions + sumOfHalfSquares + sumOfPoints + sumOfRemainingEvenPartialSquares}") // 608146800801836 too low



        return -1
    }

    fun calc(input: List<String>, steps: Int): Set<Point> {
        val garden = load(input)

        var walk = setOf(garden.start)

        for (step in 1..steps) {
            walk = walk.flatMap { garden.explore(it) }.toSet()
        }

        return walk
    }

    private fun print(done: Set<Point>) {
        val minY = done.minOf { it.y }
        val maxY = done.maxOf { it.y }
        val minX = done.minOf { it.x }
        val maxX = done.maxOf { it.x }

        for (y in minY..maxY) {
            for (x in minX..maxX) {
                if (done.contains(Point(x, y))) {
                    print('#')
                } else {
                    print('.')
                }
            }
            println()
        }
    }

    private fun countSouthWest(input: Set<Point>, size: Int, steps: Int): Long {
        var count = 0L

        for (row in 0..<size) {
            val maxCol = steps + row
            count += input.count{ it.y == row && it.x <= maxCol}
        }

        return count
    }

    private fun countSouthEast(input: Set<Point>, size: Int, steps: Int): Long {
        var count = 0L

        for (row in 0..<size) {
            val minCol = steps - row
            count += input.count{ it.y == row && it.x >= minCol}
        }

        return count
    }

    private fun countNorthEast(input: Set<Point>, size: Int, steps: Int): Long {
        var count = 0L

        for (row in 0..<size) {
            val minCol = steps - size + row + 1
            count += input.count{ it.y == row && it.x >= minCol}
        }

        return count
    }

    private fun countNorthWest(input: Set<Point>, size: Int, steps: Int): Long {
        var count = 0L

        for (row in 0..<size) {
            val maxCol = size + steps - row - 1
            count += input.count{ it.y == row && it.x <= maxCol}
        }

        return count
    }

    private fun countNorthPoint(input: Set<Point>, size: Int, steps: Int): Long {
        var count = 0L

        for (row in 0..<size) {
            val minCol = steps - row
            val maxCol = steps + row
            count += input.count{ it.y == row && it.x >= minCol && it.x <= maxCol}
        }

        return count
    }

    private fun countSouthPoint(input: Set<Point>, size: Int, steps: Int): Long {
        var count = 0L

        for (row in 0..<size) {
            val minCol = steps - size + row + 1
            val maxCol = size + steps - row - 1
            count += input.count{ it.y == row && it.x >= minCol && it.x <= maxCol}
        }

        return count
    }

    private fun countEastPoint(input: Set<Point>, size: Int, steps: Int): Long {
        var count = 0L

        for (row in 0..<size) {
            val maxCol1 = steps + row
            val maxCol2 = size + steps - row - 1
            count += input.count{ it.y == row && it.x <= maxCol1 && it.x <= maxCol2}
        }

        return count
    }

    private fun countWestPoint(input: Set<Point>, size: Int, steps: Int): Long {
        var count = 0L

        for (row in 0..<size) {
            val minCol1 = steps - row
            val minCol2 = steps - size + row + 1
            count += input.count{ it.y == row && it.x >= minCol1 && it.x >= minCol2}
        }

        return count
    }

    fun load(input: List<String>): Garden {
        var start = Point(0, 0)
        val plot = mutableMapOf<Point, Char>()
        input.forEachIndexed { yindex, ystring ->
            ystring.forEachIndexed{ xIndex, xChar ->
                when (xChar) {
                    'S' -> {
                        start = Point(xIndex, yindex)
                        plot[Point(xIndex, yindex)] = xChar
                    }
                    '.' -> plot[Point(xIndex, yindex)] = xChar
                }
            }
        }
        return Garden(start, plot, input[0].length, input.size)
    }

    data class Garden(val start: Point, val plot: Map<Point, Char>, val width: Int, val height: Int) {
        fun explore(point: Point): Set<Point> {
            return Direction.entries.map { point.add(it) }.filter { canWalk(it) }.toSet()
        }

        private fun canWalk(point: Point): Boolean {
            return plot.contains(point)
        }
    }

    data class Point(val x: Int, val y: Int) {
        fun add(direction: Direction): Point {
            return Point(x + direction.x, y + direction.y)
        }
    }

    enum class Direction(val x: Int, val y: Int) {
        NORTH(0, -1),
        EAST(1, 0),
        SOUTH(0, 1),
        WEST(-1, 0);
    }
}