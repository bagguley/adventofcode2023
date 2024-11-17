package day25

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        val nodes = load(input)

        while (true) {
            val graph = buildGraph(nodes)

            val counts = graph.keys.associateWith { 1 }.toMutableMap()

            while (graph.size > 2) {
                val a = graph.keys.random()
                val b = graph[a]!!.random()
                val newNode = "$a-$b"

                counts[newNode] = (counts.remove(a) ?: 0) + (counts.remove(b) ?: 0)
                graph.combineValues(a, b, newNode)
                graph.mergeNodes(a, newNode)
                graph.mergeNodes(b, newNode)
            }

            val (nodeA, nodeB) = graph.keys.toList()
            if (graph[nodeA]!!.size == 3) {
                return counts[nodeA]!! * counts[nodeB]!!
            }
        }
    }

    private fun load(input:List<String>): List<Node> {
        return input.map { line ->
            val name = line.take(3)
            val connections = line.drop(5).split(" ")
            Node(name, connections)
        }
    }

    private fun buildGraph(nodes: List<Node>): MutableMap<String, List<String>> {
        val nodeMap = nodes.associateBy( { it.name }, { it.connections }).toMutableMap()

        nodes.forEach { node ->
            node.connections.forEach { connection ->
                nodeMap[connection] = nodeMap.getOrElse(connection) { emptyList() } + node.name
            }
        }

        return nodeMap
    }

    private fun MutableMap<String, List<String>>.mergeNodes(oldNode: String, newNode: String) {
        remove(oldNode)!!.forEach { target ->
            this[target] = this[target]!!.map { if (it == oldNode) newNode else it }
        }
    }

    private fun MutableMap<String, List<String>>.combineValues(a: String, b: String, newNode: String) {
        this[newNode] = (this[a]!!.filter { it != b } + this[b]!!.filter { it != a })
    }

    private data class Node(val name: String, val connections: List<String>)
}

