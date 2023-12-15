package day12

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
}

object Part2 {
    private var cache = mutableMapOf<List<Any>, Long>()
    private var EXPAND = 5

    fun calc(input: List<String>): Long {
        val loaded = load(input)
        val expanded = expand(loaded)

        return expanded.sumOf { validVariations(it.first, it.second) }
    }

    fun load(input: List<String>): List<Pair<String, String>> {
        return input.map { it.split(" ") }.map { it.first() to it.last() }
    }

    fun expand(input: List<Pair<String, String>>): List<Pair<String, String>> {
        return input.map { p -> expand(p.first, p.second) }
    }

    fun expand(line: String, pattern: String): Pair<String, String> {
        return List(EXPAND){line}.joinToString("?") to List(EXPAND){pattern}.joinToString(",")
    }

    fun validVariations(originalLine: String, pattern: String): Long {
        val intPattern = pattern.split(",").map { it.toInt() }
        val lineTrimmed = originalLine.replace(Regex("\\.+"), ".").trim('.')
        cache = mutableMapOf()
        return patternCombinations(lineTrimmed, intPattern)
    }

    private fun patternCombinations(trimmedPattern: String, intPattern: List<Int>): Long {
        val gaps = List(intPattern.size){0}
        val totalGaps = trimmedPattern.length - intPattern.sum()
        return patternCombinations(0, totalGaps, trimmedPattern, gaps, intPattern)
    }

    private fun patternCombinations(headLength: Int, gapsLeft: Int, remainingPattern: String, gaps: List<Int>, intPattern: List<Int>): Long {

        if (cache.contains(listOf(headLength,gapsLeft,intPattern))) {
            return cache[listOf(headLength,gapsLeft,intPattern)]!!
        }

        var result = 0L

        val gapsHead = gaps[0]
        val numOfHashes = intPattern[0]

        val nextList = mutableListOf<Pair<Int, Int>>()

        for (gapSize in gapsHead..gapsLeft) {
            val gapPattern = createPattern(gapSize, numOfHashes)

            if (isValid(gapPattern, remainingPattern)) {
                if (gaps.size > 1) {
                    val nextGapsLeft = gapsLeft - gapSize - 1
                    nextList.add(headLength + gapSize + numOfHashes + 1 to nextGapsLeft)
                } else if (!remainingPattern.drop(gapSize + numOfHashes).contains("#")) {
                    result++
                }
            }
        }

        for (next in nextList) {
            val nextHeadLength = next.first
            val nextGapsLeft = next.second
            result += patternCombinations(nextHeadLength, nextGapsLeft, remainingPattern.drop(nextHeadLength - headLength), gaps.drop(1), intPattern.drop(1))
        }

        cache[listOf(headLength,gapsLeft,intPattern)] = result

        return result
    }

    private fun createPattern(leadingGap: Int, numPlaces: Int): String {
        val stringBuilder = StringBuilder()

        repeat(leadingGap) {stringBuilder.append('.') }
        repeat(numPlaces) {stringBuilder.append('#')}

        return stringBuilder.toString()
    }

    private fun isValid(gapPattern: String, pattern: String): Boolean {
        return gapPattern.isNotEmpty() && pattern.zip(gapPattern + ".").all { (p,g) -> p == '.' && g == '.' || p == '#' && g == '#' || p == '?' && g in "#." }
    }
}