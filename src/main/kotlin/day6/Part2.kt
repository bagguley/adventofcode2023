package day6

fun main() {
    println(Part2.calc(data))
    println(Part2Short.calc(data))
}

object Part2 {
    fun calc(input: List<String>): Int {
        val races = load(input)

        return races.waysToWin()
    }

    private fun load(input: List<String>): Race {
        val raceTime = input[0].drop(5).trim().replace(Regex("\\s+"), "").toLong()
        val distance = input[1].drop(9).trim().replace(Regex("\\s+"), "").toLong()

        return Race(raceTime, distance)
    }
}

object Part2Short {
    fun calc(input: List<String>): Int {
        return (input[0].drop(5).trim().replace(Regex("\\s+"), "").toLong() to
                input[1].drop(9).trim().replace(Regex("\\s+"), "").toLong())
            .let{r -> (1 until r.first).map { (r.first - it)*it }.count{ it > r.second }}
    }
}