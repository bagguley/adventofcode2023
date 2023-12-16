package day14

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Long {
        var count = 0L
        val width = input[0].length
        val height = input.size
        for (x in 0 until width) {
            var score = height
            for (y in 0 until height) {
                val c = input[y][x]
                when (c) {
                    'O' -> {
                        count += score
                        score--
                    }
                    '#' -> {
                        score = height - y - 1
                    }
                }
            }
        }
        return count
    }
}