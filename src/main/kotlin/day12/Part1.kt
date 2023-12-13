package day12

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
}

object Part1 {

    fun calc(input: List<String>) :Int {
        val loaded = load(input)
        return loaded.map { line -> validVariations(line.first, line.second) }.sumOf { it.size }
    }

    fun load(input: List<String>): List<Pair<String, String>> {
        return input.map { it.split(" ") }.map { it.first() to it.last() }
    }

    private fun validVariations(line: String, pattern: String): List<String> {
        return  variations(line).filter { isValid(it, pattern) }
    }

    private fun variations(line: String): List<String> {
        val places = line.mapIndexedNotNull { i,c -> if (c == '?') i else null }
        val result = mutableListOf<String>()
        for (i in 0 until (1 shl (places.size))) {
            val binary = i.toString(2).padStart(places.size,'0')
            val str = line.toCharArray()
            for (d in binary.indices) {
                if (binary[d] == '0') {
                    str[places[d]] = '.'
                } else {
                    str[places[d]] = '#'
                }
            }
            result.add(String(str))
        }

        return result
    }

    fun isValid(line: String, pattern: String): Boolean {
        val intPattern = pattern.split(",").map { it.toInt() }
        val dataIntPattern = line.trim('.').split(Regex("\\.+")).map { it.length }
        return intPattern == dataIntPattern
    }
}