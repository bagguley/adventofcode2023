package day15

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
}
object Part2 {
    fun calc(input: List<String>): Int {
        return mapping(input)
    }

    private fun mapping(input: List<String>): Int {
        val map = mutableMapOf<Int, MutableList<Pair<String, Int>>>()

        input.forEach { seq ->
            val letters = seq.takeWhile { it.isLetter() }
            val hash = letters.fold(0) { a, c -> ((a + c.code) * 17) % 256 }

            if (seq.endsWith('-')) {
                map[hash]?.removeIf { it.first == letters }
            } else {
                val digits = seq.takeLastWhile { it.isDigit() }.toInt()
                val list = map.getOrPut(hash) { mutableListOf() }

                if (list.find { it.first == letters } != null) {
                    val i = list.indexOfFirst { it.first == letters }
                    list[i] = letters to digits
                } else {
                    list.add(letters to digits)
                }
            }
        }

        return map.entries.sumOf { entry ->
            entry.value.mapIndexed { slot, focal -> (entry.key + 1) * (slot + 1) * focal.second } .sum()
        }
    }
}