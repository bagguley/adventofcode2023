package day4

import kotlin.math.min

fun main() {
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>): Int {
        val cards = input.map { readCard(it) }

        return cards.sumOf { calc(it.id, cards) }
    }
    fun calc(cardNumber: Int, cards: List<Card>, wins: MutableMap<Int, Int> = mutableMapOf()): Int {
        return wins.getOrPut(cardNumber) {
            if (cards[cardNumber - 1].matching > 0) {
                if (cardNumber == cards.size) 1 else
                    1 + IntRange(cardNumber + 1, min(cardNumber + cards[cardNumber - 1].matching, cards.size)).sumOf { calc(it, cards, wins) }
            } else 1
        }
    }

    private fun readCard(line: String): Card {
        val lineSplit = line.split(Regex("[|:]"))
        return Card(lineSplit[0].substring(4).trim().toInt(),
            lineSplit[1].trim().split(Regex("\\s+")).map { it.toInt() },
            lineSplit[2].trim().split(Regex("\\s+")).map { it.toInt() })
    }

    data class Card(val id: Int, val drawn: List<Int>, val chosen: List<Int>) {
        val matching = drawn.intersect(chosen).size
    }
}
