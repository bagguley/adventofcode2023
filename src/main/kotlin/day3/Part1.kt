package day3

fun main() {
    load(data)
}

fun load(input: List<String>) {
    val partData: MutableMap<Coordinates, DataPoint> = mutableMapOf()
    var id = 0
    input.forEachIndexed { y, line ->
        line.forEachIndexed { x, character ->
            partData[Coordinates(x, y)] = DataPoint(id++, Coordinates(x, y), character)
        }
    }

    val gearData: MutableMap<Coordinates, DataPoint> = mutableMapOf()

    partData.forEach { (coordinates, dataPoint) ->
        if (dataPoint.isSymbol()) {
            val surrounding = coordinates.surrounding()
            surrounding.forEach {
                val surroundingPart = partData[it]!!
                if (surroundingPart.isDigit()) {
                    surroundingPart.isAdjacent = true
                }
            }
        }
    }

    for (y in 0..139) {
        for (x in 0..139) {
            val part = partData[Coordinates(x, y)]!!
            if (part.isDigit()) {
                val adjacentDigits = part.coordinates.adjacentLine()
                adjacentDigits.forEach {
                    val adjacentPart = partData[it]!!
                    if (adjacentPart.isDigit()) {
                        adjacentPart.id = part.id
                    }
                }
            }
        }
    }

    partData.forEach { (coordinates, dataPoint) ->
        if (dataPoint.isGearSymbol()) {
            gearData[coordinates] = dataPoint
            val surrounding = coordinates.surrounding()
            surrounding.forEach {
                val surroundingPart = partData[it]!!
                if (surroundingPart.isDigit()) {
                    dataPoint.touchesGears.add(surroundingPart.id)
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
    println(numbers.sumOf { it.toInt() })

    val gears = gearData.filter { (_, value) ->
        value.touchesGears.size == 2
    }

    val ratios = gears.map { (_, value) ->
        value.touchesGears.map { idToNumber(it, partData) }.reduceRight{ a, b ->  a * b }
    }.sum()

    println(ratios)
}

fun idToNumber(id: Int, partData: Map<Coordinates, DataPoint>): Int {
    val stringBuilder = StringBuilder()
    for (y in 0..139) {
        for (x in 0..139) {
            val part = partData[Coordinates(x,y)]!!
            if (part.id == id) {
                stringBuilder.append(part.character)
            }
        }
    }
    return stringBuilder.toString().toInt()
}


data class DataPoint(var id: Int, val coordinates: Coordinates, val character: Char, var isAdjacent: Boolean = false,
                     val touchesGears: MutableSet<Int> = mutableSetOf()) {
    fun isSymbol(): Boolean {
        return !character.isDigit() && character != '.'
    }

    fun isDigit(): Boolean {
        return character.isDigit()
    }

    fun isGearSymbol(): Boolean {
        return character == '*'
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