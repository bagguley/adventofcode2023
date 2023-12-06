package day6

fun main() {
    println(Part1.calc(data))
    println(Part1Short.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        val races = load(input)

        return races.map { it.waysToWin() }.reduce(Int::times)
    }

    private fun load(input: List<String>): List<Race> {
        val raceTime = input.first().drop(5).trim().split(Regex("\\s+")).map { it.toLong() }
        val distance = input.last().drop(9).trim().split(Regex("\\s+")).map { it.toLong() }

        return raceTime.zip(distance).map { Race(it.first, it.second) }
    }
}

class Race(private val raceTime: Long, private val raceRecord: Long) {
    fun waysToWin(): Int {
        return distances().count { it > raceRecord }
    }
    private fun distances(): List<Long> {
        val press = 1 until raceTime
        return press.map {(raceTime - it) * it }
    }
}

object Part1Short {
    fun calc(input: List<String>): Int {
        return input[0].drop(5).trim().split(Regex("\\s+")).map { it.toInt() }
            .zip(input[1].drop(9).trim().split(Regex("\\s+")).map { it.toInt() })
            .map{r -> (1 until r.first).map { (r.first - it)*it }.count{ it > r.second }}
            .reduce(Int::times)
    }
}

