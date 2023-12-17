package day14

fun main() {
    println(Part2a.calc(data))

    println()

    //println(Part2a.calc(data))
}

object Part2a {

    val eastMap = mutableMapOf<String, String>()
    fun calc(input: List<String>): Long {
        var chars = input

        for(i in 1..1_000_000_000) {
            chars = calcEast(rotateRight(chars)) // North
            chars = calcEast(rotateRight(chars)) // West
            chars = calcEast(rotateRight(chars)) // South
            chars = rotateRight(calcEast(rotateRight(chars))) // East

            if (i % 1_000_000 == 0) {
                println(i)
            }
        }

        return calcLoad(chars)
    }

    fun calcEast(input: List<String>): List<String> {
        return input.map { line ->
            line.split("#").joinToString("#") {
                eastMap.getOrPut(it) {
                    val oCount = it.count { c -> c == 'O' }
                    ".".repeat(it.length - oCount) + "O".repeat(oCount)
                }
            }
        }
    }

    fun rotateRight(input: List<String>): List<String> {
        val width = input[0].length
        val height = input.size
        return (0 until width).map { x ->
            (height - 1 downTo 0).map { y -> input[y][x] }.joinToString("")
        }
    }

    fun calcLoad(input: List<String>):Long {
        var count = 0L
        val width = input[0].length
        val height = input.size
        for (x in 0 until width) {
            for (y in 0 until height) {
                val c = input[y][x]
                when (c) {
                    'O' -> {
                        count += height - y
                    }
                }
            }
        }
        return count
    }

}