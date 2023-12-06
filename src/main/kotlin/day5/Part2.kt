package day5

fun main() {
    println(Part2.calc(data))
}

object Part2 {

    fun calc(input: List<List<String>>): Long {
        val seeds = input[0].first().drop(7).split(" ").map { it.toLong() }
        val soil = SeedMap(input[1].drop(1))
        val fertiliser = SeedMap(input[2].drop(1))
        val water = SeedMap(input[3].drop(1))
        val light = SeedMap(input[4].drop(1))
        val temp = SeedMap(input[5].drop(1))
        val humidity = SeedMap(input[6].drop(1))
        val location = SeedMap(input[7].drop(1))

        val ranges = seeds.windowed(2, 2).map {
            val range = (it.first() to it.first() + it.last() - 1)

            val mapped = soil.mapRange(range)
                .asSequence()
                .flatMap { fertiliser.mapRange(it) }
                .flatMap { water.mapRange(it) }
                .flatMap { light.mapRange(it) }
                .flatMap { temp.mapRange(it) }
                .flatMap { humidity.mapRange(it) }
                .flatMap { location.mapRange(it) }
                .toList()

            mapped.minOf { it.first }
        }

        return ranges.min()
    }

    private fun SeedMap.mapRange(range: Pair<Long, Long>): List<Pair<Long, Long>> {
        val ranges = seedMap.find{ it.contains(range) }?.mapRange(range) ?: listOf(range)
        return ranges.take(1) + ranges.drop(1).flatMap { mapRange(it) }
    }

    private fun SeedMapRow.contains(range: Pair<Long, Long>): Boolean {
        return (range.first in src..srcEnd ||
                range.second in src..srcEnd ||
                range.first < src && range.second > srcEnd)
    }

    private fun SeedMapRow.mapRange(range: Pair<Long, Long>): List<Pair<Long, Long>> {
        return when {
            range.first > srcEnd || range.second < src -> listOf(range)
            range.first < src -> {
                when {
                    range.second <= srcEnd -> listOf(src + offset to range.second + offset, range.first to src - 1)
                    else -> listOf(src + offset to srcEnd + offset, range.first to src - 1, srcEnd + 1 to range.second)
                }
            }
            else -> when {
                range.second <= srcEnd -> listOf(range.first + offset to range.second + offset)
                else -> listOf(range.first + offset to srcEnd + offset, srcEnd + 1 to range.second)
            }
        }
    }
}