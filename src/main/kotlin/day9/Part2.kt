package day9

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
    println(Part2Short.calc(testData))
    println(Part2Short.calc(data))
    println(Part2Shorter.calc(testData))
    println(Part2Shorter.calc(data))
}

object Part2 {
    fun calc(input: List<String>): Long {
        return load(input).sumOf { diff(it) }
    }

    private fun load(input: List<String>): List<List<Long>> {
        return input.map { it.split(" ").map { it.toLong() }}
    }

    private fun diff(input: List<Long>): Long {
        val lists = mutableListOf(input)
        var next = input
        while(!next.all { it == 0L }) {
            next = next.windowed(2).map { it.last() - it.first() }
            lists.add(0, next)
        }

        return lists.windowed(2).fold(0L){ acc, lines -> lines.last().first() - acc}
    }
}

object Part2Short {
    fun calc(input: List<String>): Long = input.map { it.split(" ").map { it.toLong() }}.sumOf { diff(it) }

    private fun diff(line: List<Long>): Long {
        val lists = mutableListOf(line)
        while(!lists[0].all { it == 0L }) lists[0].windowed(2).map { it.last() - it.first() }.also { lists.add(0, it) }
        return lists.windowed(2).fold(0L){ acc, lines -> lines.last().first() - acc}
    }
}

object Part2Shorter {
    fun calc(input: List<String>): Long = input.map { it.split(" ").map { it.toLong() }}.sumOf { next(it) }

    private fun next(line: List<Long>): Long = generateSequence(line){it.zipWithNext().map{(a,b)->b-a}}.takeWhile{it.any{it != 0L}}.fold(0L){ acc, lines -> lines.first() - acc}
}