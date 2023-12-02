package day1

fun main() {
    println(Part2.calc(data))
    println(Part2Short.calc(data))
}

object Part2 {
    private val numMap = (1..9).associateBy{it.toString()} + listOf("one","two","three","four","five","six","seven","eight","nine").mapIndexed{i,n->n to i+1}

    fun calc(input: List<String>): Int {
        return input.sumOf { find(it) }
    }

    private fun find(string: String): Int {
        val first = numMap[string.findAnyOf(numMap.keys)!!.second]!!
        val second = numMap[string.findLastAnyOf(numMap.keys)!!.second]!!
        return first * 10 + second
    }
}

object Part2Short {
    private val numMap = ((1..9)+"one,two,three,four,five,six,seven,eight,nine".split(",")).mapIndexed{i,n->n.toString()to(i%9)+1}.toMap()

    fun calc(input: List<String>): Int = input.sumOf{numMap[it.findAnyOf(numMap.keys)!!.second]!! * 10 + numMap[it.findLastAnyOf(numMap.keys)!!.second]!!}
}