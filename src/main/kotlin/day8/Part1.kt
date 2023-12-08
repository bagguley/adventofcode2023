package day8

fun main() {
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        val directions = input[0]

        val map = input[1].split("\n").map { loadNode(it) }.associateBy { it.id }

        var count = 0
        var node = map["AAA"]!!

        while(true) {
            val idx = count % directions.length
            val direction = directions[idx]
            node = when (direction) {
                'L' -> map[node.left]!!
                else -> map[node.right]!!
            }
            count++
            if (node.id == "ZZZ") break
        }

        return count
    }

    private fun loadNode(input: String): Node {
        return Node(input.substring(0, 3), input.substring(7, 10), input.substring(12, 15))
    }
}

class Node(val id: String, val left:String, val right: String)