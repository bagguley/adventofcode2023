package day2

fun main() {
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>):Int {
        return Part1.load(input).sumOf { it.power() }
    }

    private fun Part1.Game.power(): Int {
        return maxOf("red") * maxOf("green") * maxOf("blue")
    }

    private fun Part1.Game.maxOf(colour: String): Int {
        return turns.map { it.find(colour) }.maxBy { it }
    }
}

