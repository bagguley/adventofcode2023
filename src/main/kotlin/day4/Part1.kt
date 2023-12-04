package day4

fun main() {
    println(Part1.calc(data))
    println(Part1Short.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        val split = input.map { it.split(Regex("[:|]")) }
        val pairs = split.map { Pair(it[1].trim().split(Regex("\\s+")), it[2].trim().split(Regex("\\s+")))}
        return pairs.sumOf { it.first.intersect(it.second).size.let { 1 shl(it-1) } }
    }
}

object Part1Short {
    fun calc(input: List<String>): Int {
        return input.map{it.split(Regex("[|:]")).let{Pair(it[1].trim().split(Regex("\\s+")),it[2].trim().split(Regex("\\s+")))}.let{it.first.intersect(it.second).size}}.sumOf{1 shl(it-1)}
    }
}
