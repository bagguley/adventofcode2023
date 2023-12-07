package day7

fun main() {
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>):Long {
        return load(input).sorted().foldIndexed(0L) { index, acc, hand ->  acc + (index + 1) * hand.bid }
    }

    private fun load(input: List<String>): List<Hand> {
        return input.map { it.split(" ").let { Hand(it[0], it[1].toLong()) }}
    }

    class Hand(sequence: String, val bid: Long): Comparable<Hand> {
        private val rankString = sequence.map { 'A' + "23456789TJQKA".indexOf(it) }.joinToString()

        private val handType: HandType

        init {
            val groups = sequence.groupBy { it }.map { it.key to it.value.size }

            handType = when (groups.size) {
                1 -> HandType.FIVE_OF_A_KIND
                2 -> if (groups.any { it.second == 4 }) HandType.FOUR_OF_A_KIND else HandType.FULL_HOUSE
                3 -> if (groups.any { it.second == 3 }) HandType.THREE_OF_A_KIND else HandType.TWO_PAIR
                4 -> HandType.ONE_PAIR
                else -> HandType.HIGH_CARD
            }
        }

        override fun compareTo(other: Hand): Int {
            return when (val cmp = handType.score.compareTo(other.handType.score)) {
                0 -> rankString.compareTo(other.rankString)
                else -> cmp
            }
        }
    }
}

enum class HandType(val score:Long) {
    HIGH_CARD(0), ONE_PAIR(1), TWO_PAIR(2), THREE_OF_A_KIND(3), FULL_HOUSE(4), FOUR_OF_A_KIND(5), FIVE_OF_A_KIND(6)
}