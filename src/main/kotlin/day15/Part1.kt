package day15

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        return input.sumOf { hash(it) }
    }

    fun hash(input: String): Int {
        var result = 0

        input.forEach { c ->
            result += c.code
            result *= 17
            result %= 256
        }

        return result
    }
}