package day9

fun main() {
    println(Part1.calc(testData))
    println(Part1Short.calc(testData))
    println(Part1Shorter.calc(testData))
    println(Part1.calc(data))
    println(Part1Short.calc(data))
    println(Part1Shorter.calc(data))
}

object Part1 {
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

        return lists.sumOf { it.last() }
    }
}

object Part1Short {
    fun calc(input: List<String>): Long = input.map { it.split(" ").map { it.toLong() }}.sumOf { diff(it) }

    private fun diff(line: List<Long>): Long {
        val lists = mutableListOf(line)
        while(!lists[0].all { it == 0L }) lists[0].windowed(2).map { it.last() - it.first() }.also { lists.add(0, it) }
        return lists.sumOf { it.last() }
    }
}

object Part1Shorter {
    fun calc(input: List<String>): Long = input.map { it.split(" ").map { it.toLong() }}.sumOf { next(it) }

    private fun next(line: List<Long>): Long = generateSequence(line){it.zipWithNext().map{(a,b)->b-a}}.takeWhile{it.any{it != 0L}}.sumOf{it.last()}
}