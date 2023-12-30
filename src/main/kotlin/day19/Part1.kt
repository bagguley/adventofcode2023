package day19

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        val rules = loadRules(input[0].split("\n"))
        val data = loadData(input[1].split("\n"))

        return data.filter { isAccepted(it, rules) }.sumOf { it.sum() }
    }

    fun loadRules(input: List<String>): Map<String, Workflow> {
        return input.associate {
            val key = it.substringBefore('{')
            val rest = it.substringAfter('{').dropLast(1).split(',')

            val rules = rest.dropLast(1).map {
                val s = it.split(Regex("[:]"))
                Rule(s[0][0], s[0][1], s[0].drop(2).toInt(), s[1])
            }

            val otherwise = rest.last()

            key to Workflow(key, rules, otherwise)
        }
    }

    fun loadData(input: List<String>): List<Data> {
        return input.map {
            Data(it.substring(1, it.length - 1).split(",").associate { it.split("=").let { it[0][0] to it[1].toInt() } })
        }
    }

    fun isAccepted(data: Data, rules: Map<String, Workflow>): Boolean {
        return isAccepted("in", data, rules)
    }

    private fun isAccepted(key: String, data: Data, workflows: Map<String, Workflow>): Boolean {
        val workflow = workflows[key]!!

        val testResult = workflow.test(data)

        return when (testResult) {
            "A" -> true
            "R" -> false
            else -> isAccepted(testResult, data, workflows)
        }
    }

    data class Data(private val dataMap: Map<Char, Int>) {
        fun get(key: Char) : Int = dataMap[key]!!

        fun sum(): Int {
            return dataMap.map { it.value }.sum()
        }
    }

    data class Workflow(val id: String, val rules: List<Rule>, val otherwise: String) {
        fun test(data: Data): String {
            return rules.find{ it.test(data) }?.ifTrue ?: otherwise
        }
    }

    data class Rule(val testChar: Char, val test: Char, val testValue: Int, val ifTrue: String) {
        fun test(data: Data): Boolean {
            val dataValue = data.get(testChar)
            return when (test) {
                '<' -> dataValue < testValue
                '>' -> dataValue > testValue
                else -> false
            }
        }
    }
}