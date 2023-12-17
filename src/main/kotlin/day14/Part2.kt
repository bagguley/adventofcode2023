package day14

fun main() {
    for (i in 160 .. 224) {
        if (1_000_000_000 % i == 0) {
            println("Z " + i)
        }
    }
    //println(Part2.calc(testData))

    println()

    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>): Long {
        val chars = input.map { it.toMutableList() }

        val history = mutableListOf<List<List<Char>>>()
        var duplicate = 0
        var duplicateIndex = 0

        for(i in 1..1_000_000_000) {
            calcNorth(chars)
            calcWest(chars)
            calcSouth(chars)
            calcEast(chars)

            if (history.contains(chars)) {
                duplicate = i
                duplicateIndex = history.indexOf(chars)
                break
            }
            history.add(chars.map { it.toList() })
        }

        val diff = (1_000_000_000 - duplicateIndex) % (duplicate - duplicateIndex - 1) + duplicateIndex - 1

        return calcLoad(history[diff])
    }

    fun calcNorth(input: List<MutableList<Char>>) {
        val width = input[0].size
        val height = input.size
        for (x in 0 until width) {
            var position = 0
            for (y in 0 until height) {
                val c = input[y][x]
                when (c) {
                    'O' -> {
                        input[y][x] = '.'
                        input[position][x] = 'O'
                        position++
                    }

                    '#' -> {
                        position = y + 1
                    }
                }
            }
        }
    }

    fun calcWest(input: List<MutableList<Char>>) {
        val width = input[0].size
        val height = input.size
        for (y in 0 until height) {
            var position = 0
            for (x in 0 until width) {
                val c = input[y][x]
                when (c) {
                    'O' -> {
                        input[y][x] = '.'
                        input[y][position] = 'O'
                        position++
                    }

                    '#' -> {
                        position = x + 1
                    }
                }
            }
        }
    }

    fun calcSouth(input: List<MutableList<Char>>) {
        val width = input[0].size
        val height = input.size
        for (x in 0 until width) {
            var position = height - 1
            for (y in height - 1 downTo 0) {
                val c = input[y][x]
                when (c) {
                    'O' -> {
                        input[y][x] = '.'
                        input[position][x] = 'O'
                        position--
                    }

                    '#' -> {
                        position = y - 1
                    }
                }
            }
        }
    }

    fun calcEast(input: List<MutableList<Char>>) {
        val width = input[0].size
        val height = input.size
        for (y in 0 until height) {
            var position = width - 1
            for (x in width - 1 downTo  0) {
                val c = input[y][x]
                when (c) {
                    'O' -> {
                        input[y][x] = '.'
                        input[y][position] = 'O'
                        position--
                    }

                    '#' -> {
                        position = x - 1
                    }
                }
            }
        }
    }

    fun calcLoad(input: List<List<Char>>):Long {
        var count = 0L
        val width = input[0].size
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