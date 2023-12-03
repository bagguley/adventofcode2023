package day3

fun main() {
    load(data)
}

fun load(input: List<String>) {
    val partData: MutableMap<Coordinates, DataPoint> = mutableMapOf()

    input.forEachIndexed { y, line ->
        line.forEachIndexed { x, character ->
            partData[Coordinates(x, y)] = DataPoint(Coordinates(x, y), character)
        }
    }

    partData.forEach { (coordinates, dataPoint) ->
        if (dataPoint.isSymbol()) {
            val surrounding = coordinates.surrounding()

            surrounding.forEach {
                val part = partData[it]!!
                if (part.isDigit()) {
                    part.isAdjacent = true
                }
            }
        }
    }

    var changed = true

    while (changed) {
        changed = false
        partData.forEach { (coordinates, dataPoint) ->
            if (dataPoint.isDigit() && dataPoint.isAdjacent) {
                val adjacentDigits = coordinates.adjacentLine()
                adjacentDigits.forEach {
                    if (!partData[it]!!.isAdjacent) {
                        partData[it]!!.isAdjacent = true
                        changed = true
                    }
                }
            }
        }
    }

    val stringBuilder = StringBuilder()

    for (y in 0..139) {
        for (x in 0..139) {
            val part = partData[Coordinates(x, y)]!!
            if (part.isDigit() && part.isAdjacent) {
                stringBuilder.append(part.character)
            } else {
                stringBuilder.append(' ')
            }
        }
        stringBuilder.append(' ')
    }

    val numbers = stringBuilder.trim().split(Regex("\\s+"))
    println(numbers.map { it.toInt() }.sum())
}


data class DataPoint(val coordinates: Coordinates, val character: Char, var isAdjacent: Boolean = false) {
    fun isSymbol(): Boolean {
        return !character.isDigit() && character != '.'
    }

    fun isDigit(): Boolean {
        return character.isDigit()
    }
}

data class Coordinates(val x: Int, val y: Int) {
    fun surrounding(): List<Coordinates> {
        return listOf(
            Coordinates(x-1, y-1),
            Coordinates(x, y-1),
            Coordinates(x+1, y-1),
            Coordinates(x-1, y),
            Coordinates(x+1, y),
            Coordinates(x-1, y+1),
            Coordinates(x, y+1),
            Coordinates(x+1, y+1)
        ).filter { it.isValid() }
    }

    fun adjacentLine(): List<Coordinates> {
        return listOf(
            Coordinates(x-1, y),
            Coordinates(x+1, y)
        ).filter { it.isValid() }
    }

    private fun isValid(): Boolean {
        return x in 0..139 && y in 0..139
    }
}