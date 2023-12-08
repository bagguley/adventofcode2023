package day8

fun main() {
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>): Long {
        val directions = input[0]
        val directionsLength = directions.length

        val nodeMap = input[1].split("\n").map { loadNode(it) }.associateBy { it.id }

        for (idx in directions.indices) {
            for (node in nodeMap.values) {
                node.distanceToZ[idx] = node.distanceToZ(directions, nodeMap, idx)
            }
        }

        val steps = nodeMap.filterKeys { it.endsWith("A") }.values.map { Step(it, 0L) }

        steps.forEach { it.step(directionsLength) }
        val result: Long

        while (true) {
            val max = steps.maxOf { it.steps }

            steps.filter { it.steps < max }
                .forEach { it.stepTo(max, directionsLength) }

            if (steps.map{it.steps}.toSet().size == 1) {
                result = steps.map{it.steps}.toSet().first()
                break
            }
        }

        return result
    }

    private fun loadNode(input: String): Node2 {
        return Node2(input.substring(0, 3), input.substring(7, 10), input.substring(12, 15))
    }

    private class Node2(val id: String, val left:String, val right: String) {
        val isTerminal = id.endsWith('Z')

        val distanceToZ = mutableMapOf<Int, Pair<Long, Node2>>()

        fun distanceToZ(directions: String, nodeMap: Map<String, Node2>, indexOffset: Int): Pair<Long, Node2> {
            var count = 0L
            var node = this
            while(true) {
                val idx = (count + indexOffset) % directions.length
                val direction = directions[idx.toInt()]
                node = when (direction) {
                    'L' -> nodeMap[node.left]!!
                    else -> nodeMap[node.right]!!
                }
                count++
                if (node.isTerminal) {
                    break
                }
            }
            return count to node
        }
    }

    private class Step(var node: Node2, var steps: Long) {
        fun step(directionsLength: Int) {
            val pair = node.distanceToZ[(steps % directionsLength).toInt()]!!
            steps += pair.first
            node = pair.second
        }

        fun stepTo(max: Long, directionsLength: Int) {
            while (steps < max) {
                step(directionsLength)
            }
        }
    }
}