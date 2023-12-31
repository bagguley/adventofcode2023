package day20

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(testData2))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Long {
        var actions = mutableListOf<Action>()
        var highPulseCount = 0L
        var lowPulseCount = 0L

        val modules = load(input)
        val start = modules["broadcaster"]!!

        repeat(1000) {
            actions.addAll(start.pulse("button", false))
            lowPulseCount++

            while (actions.isNotEmpty()) {
                val nextActions = mutableListOf<Action>()

                for (action in actions) {
                    if (action.pulse) {
                        highPulseCount++
                    } else {
                        lowPulseCount++
                    }
                    if (modules.contains(action.to)) {
                        nextActions.addAll(modules[action.to]!!.pulse (action.from, action.pulse))
                    }
                }

                actions = nextActions
            }
        }

        return lowPulseCount * highPulseCount
    }

    fun load(input: List<String>): Map<String, Module> {
        val modules = input.map {
            when {
                it.startsWith("%") -> createFlipFlop(it)
                it.startsWith("&") -> createConjunction(it)
                it.startsWith("broadcaster") -> createBroadcaster(it)
                else -> throw IllegalStateException("Bad input $it")
            }
        }.associateBy { it.name }

        for (module in modules) {
            for (connection in module.value.connections) {
                val next = modules[connection]
                if (next is Conjunction) next.addInputConnection(module.key)
            }
        }

        return modules
    }

    fun createFlipFlop(line: String): FlipFlop {
        val split = line.split(" -> ")
        val name = split[0].drop(1)
        val connections = split[1].split(", ")
        return FlipFlop(name, connections)
    }

    fun createConjunction(line: String): Conjunction {
        val split = line.split(" -> ")
        val name = split[0].drop(1)
        val connections = split[1].split(", ")
        return Conjunction(name, connections)
    }

    fun createBroadcaster(line: String): Broadcaster {
        val split = line.split(" -> ")
        val name = split[0]
        val connections = split[1].split(", ")
        return Broadcaster(name, connections)
    }

    data class Action(val from: String, val to: String, val pulse: Boolean)

    abstract class Module(val name: String, val connections: List<String>) {
        abstract fun pulse(from: String, pulse: Boolean): List<Action>
    }

    class FlipFlop(name: String, connections: List<String>): Module(name, connections) {
        private var state = false

        override fun pulse(from: String, pulse: Boolean): List<Action> {
            if (!pulse) {
                state = state.not()
                return connections.map { Action(name, it, state) }
            }
            return emptyList()
        }
    }

    class Conjunction(name: String, connections: List<String>): Module(name, connections) {
        private val memory = mutableMapOf<String, Boolean>()

        fun addInputConnection(from: String) {
            memory[from] = false
        }

        override fun pulse(from: String, pulse: Boolean): List<Action> {
            memory[from] = pulse

            return if (memory.all{ it.value }){
                connections.map { Action(name, it, false) }
            } else {
                connections.map { Action(name, it, true) }
            }
        }
    }

    class Broadcaster(name: String, connections: List<String>): Module(name, connections) {
        override fun pulse(from: String, pulse: Boolean): List<Action> {
            return connections.map { Action(name, it, pulse) }
        }
    }
}