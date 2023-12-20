package day14

fun main() {
    println(Part2a.calc(testData))
    println(Part2a.calc(data))
}

object Part2a {

    fun calc(input: List<String>): Long {
        var chars = input
        var duplicate = 0
        var duplicateIndex = 0
        val history = mutableListOf<List<String>>()

        for(i in 1..1_000_000_000) {
            chars = calcEast(rotateRight(chars)) // North
            chars = calcEast(rotateRight(chars)) // West
            chars = calcEast(rotateRight(chars)) // South
            chars = calcEast(rotateRight(chars)) // East

            if (history.contains(chars)) {
                duplicate = i
                duplicateIndex = history.indexOf(chars)
                break
            }

            history.add(chars)
        }

        val diff = (1_000_000_000 - duplicateIndex) % (duplicate - duplicateIndex - 1) + duplicateIndex - 1

        return calcLoad(history[diff])
    }

    private fun calcEast(input: List<String>): List<String> {
        return input.map { line ->
            line.split("#").joinToString("#") {
                val oCount = it.count { c -> c == 'O' }
                ".".repeat(it.length - oCount) + "O".repeat(oCount)
            }
        }
    }

    private fun rotateRight(input: List<String>): List<String> {
        return (0 until input[0].length).map { x ->
            (input.size - 1 downTo 0).map { y -> input[y][x] }.joinToString("")
        }
    }

    private fun calcLoad(input: List<String>): Long {
        var count = 0L
        val height = input.size
        for (x in 0 until input[0].length) {
            for (y in 0 until height) {
                if (input[y][x] == 'O') count += height - y
            }
        }
        return count
    }
}