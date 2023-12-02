package day1

fun main() {
    println(Part1.calc(data))
    println(Part1Short.calc(data))
}

object Part1 {
    fun calc(input: List<String> ): Int {
        return input.sumOf { findNum(it) }
    }
    private fun findNum(string: String): Int {
        val d = (string.find { it.isDigit() })!!
        val e = (string.findLast{ it.isDigit() })!!
        return ("${d}${e}".toInt())
    }
}

object Part1Short {
    fun calc(input: List<String>): Int = input.sumOf{it.find { it.isDigit() }!!.digitToInt() * 10 + it.findLast { it.isDigit() }!!.digitToInt()}
}