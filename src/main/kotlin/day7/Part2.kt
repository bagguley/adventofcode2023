package day7

fun main() {
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>):Long {
        return load(input).sorted().foldIndexed(0L) { index, acc, hand ->  acc + (index + 1) * hand.bid }
    }

    private fun load(input: List<String>): List<Hand> {
        return input.map { Hand(it.substringBefore(" "), it.substringAfter(" ").toLong()) }
    }

    class Hand(sequence: String, val bid: Long): Comparable<Hand> {
        private val rankString = sequence.map { 'A' + "J23456789TQKA".indexOf(it) }.joinToString()

        private val handType: HandType

        init {
            val groups = sequence.groupBy { it }.map { it.key to it.value.size }

            val preHandType = when (groups.size) {
                1 -> HandType.FIVE_OF_A_KIND
                2 -> if (groups.any { it.second == 4 }) HandType.FOUR_OF_A_KIND else HandType.FULL_HOUSE
                3 -> if (groups.any { it.second == 3 }) HandType.THREE_OF_A_KIND else HandType.TWO_PAIR
                4 -> HandType.ONE_PAIR
                else -> HandType.HIGH_CARD
            }

            val numOfJokers = sequence.count { it == 'J' }

            handType = when (preHandType) {
                HandType.FIVE_OF_A_KIND -> HandType.FIVE_OF_A_KIND
                HandType.FOUR_OF_A_KIND -> if (numOfJokers > 0) HandType.FIVE_OF_A_KIND else HandType.FOUR_OF_A_KIND
                HandType.FULL_HOUSE -> if (numOfJokers > 0) HandType.FIVE_OF_A_KIND else HandType.FULL_HOUSE
                HandType.THREE_OF_A_KIND -> if (numOfJokers > 0) HandType.FOUR_OF_A_KIND else HandType.THREE_OF_A_KIND
                HandType.TWO_PAIR -> when (numOfJokers) {1 -> HandType.FULL_HOUSE 2 -> HandType.FOUR_OF_A_KIND else -> HandType.TWO_PAIR}
                HandType.ONE_PAIR -> if (numOfJokers > 0) HandType.THREE_OF_A_KIND else HandType.ONE_PAIR
                HandType.HIGH_CARD -> if (numOfJokers > 0) HandType.ONE_PAIR else HandType.HIGH_CARD
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

