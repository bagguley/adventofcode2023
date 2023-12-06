package day5

fun main() {
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<List<String>>): Long {
        val seeds = input[0].first().drop(7).split(" ").map { it.toLong() }
        val soil = SeedMap(input[1].drop(1))
        val fertiliser = SeedMap(input[2].drop(1))
        val water = SeedMap(input[3].drop(1))
        val light = SeedMap(input[4].drop(1))
        val temp = SeedMap(input[5].drop(1))
        val humidity = SeedMap(input[6].drop(1))
        val location = SeedMap(input[7].drop(1))

        return seeds.minOf {
            soil.mapSeed(it)
            .let { fertiliser.mapSeed(it)}
            .let { water.mapSeed(it)}
            .let { light.mapSeed(it)}
            .let { temp.mapSeed(it)}
            .let { humidity.mapSeed(it)}
            .let { location.mapSeed(it)}
        }
    }

    fun createSeedMap(input: String) : SeedMapRow {
        val (dest, src, len) = input.split(" ").map { it.toLong() }
        return SeedMapRow(dest, src, len)
    }
}

class SeedMap(input: List<String>) {
    val seedMap = input.map { Part1.createSeedMap(it) }

    fun mapSeed(seed: Long): Long {
        return seedMap.find { it.contains(seed) }?.mapSeed(seed) ?: seed
    }
}

data class SeedMapRow(val dest: Long, val src: Long, val len: Long) {
    val offset = dest - src
    val srcEnd = src + len - 1
    fun mapSeed(seed: Long): Long {
        return if (contains(seed)) seed + offset else seed
    }

    fun contains(seed: Long): Boolean {
        return seed in src..srcEnd
    }
}