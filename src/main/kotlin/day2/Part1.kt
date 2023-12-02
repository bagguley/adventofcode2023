package day2

fun main() {
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        return load(input).filter { it.isValid(12, 13, 14) }.sumOf { it.num }
    }

    fun load(input: List<String>) : List<Game> {
        return input.map { it.split(": ").let { Game(it[0].drop(5).toInt(), loadGameTurns(it[1])) } }
    }

    private fun loadGameTurns(turnsLine: String): List<Turn> {
        return turnsLine.split(";").map { loadTurn(it) }
    }

    private fun loadTurn(turn: String): Turn {
        val cubes = turn.split(",").map { it.trim() }
        return Turn(cubes.map { loadCube(it) })
    }

    private fun loadCube(cube: String): Cube {
        val split = cube.split(" ")
        return Cube(split[0].toInt(), split[1])
    }

    data class Game(val num: Int, val turns: List<Turn>) {
        fun isValid(red: Int, green: Int, blue: Int) : Boolean {
            return turns.all { it.isValid(red, green, blue) }
        }
    }

    data class Turn(val cubes: List<Cube>) {
        fun isValid(red: Int, green: Int, blue: Int) : Boolean {
            return find("red") < red && find("green") <= green && find("blue") <= blue
        }

        fun find(colour: String) : Int {
            return cubes.find { it.colour == colour }?.count ?: 0
        }
    }

    data class Cube(val count: Int, val colour: String)
}
