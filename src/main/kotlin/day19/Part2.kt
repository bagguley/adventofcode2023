package day19

import kotlin.math.max
import kotlin.math.min

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>): Long {
        val workflows = loadRules(input[0].split("\n"))

        val startWorkflow = workflows["in"]!!
        return combinations(startWorkflow, Limits(1..4000, 1..4000, 1..4000, 1..4000), workflows)
            .sumOf { it.x.count().toLong() * it.m.count().toLong() * it.a.count().toLong() * it.s.count().toLong() }
    }

    fun combinations(workflow: Workflow, limits: Limits, workflows: Map<String, Workflow>): List<Limits> {
        val result = mutableListOf<Limits>()

        var newLimits = limits

        for (rule in workflow.rules) {
            val limitPair = newLimits.applyLimit(rule)

            if (rule.ifTrue == "A") {
                result.add(limitPair.first)
            } else if (rule.ifTrue == "R") {
                // Do nothing
            } else {
                result.addAll(combinations(workflows[rule.ifTrue]!!, limitPair.first, workflows))
            }

            newLimits = limitPair.second
        }

        // Apply final limit to 'otherwise'
        if (workflow.otherwise == "A" ) {
            result.add(newLimits)
        } else if (workflow.otherwise == "R") {
            // Do nothing
        } else {
            result.addAll(combinations(workflows[workflow.otherwise]!!, newLimits, workflows))
        }


        return result
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

    data class Workflow(val id: String, val rules: List<Rule>, val otherwise: String)

    data class Rule(val testChar: Char, val test: Char, val testValue: Int, val ifTrue: String)

    data class Limits(val x: IntRange, val m: IntRange, val a: IntRange, val s: IntRange) {
        fun applyLimit(rule: Rule): Pair<Limits, Limits> {
            val fn = when (rule.test) {
                '<' -> ({r: IntRange -> newMax(r, rule.testValue)}) to ({r: IntRange -> newMin(r, rule.testValue - 1)})
                '>' -> ({r: IntRange -> newMin(r, rule.testValue)}) to ({r: IntRange -> newMax(r, rule.testValue + 1)})
                else -> throw IllegalStateException("Unknown comparison ${rule.test}")
            }

            return when (rule.testChar) {
                'x' -> Limits(fn.first(x), m, a, s) to Limits(fn.second(x), m, a, s)
                'm' -> Limits(x, fn.first(m), a, s) to Limits(x, fn.second(m), a, s)
                'a' -> Limits(x, m, fn.first(a), s) to Limits(x, m, fn.second(a), s)
                's' -> Limits(x, m, a, fn.first(s)) to Limits(x, m, a, fn.second(s))
                else -> throw IllegalStateException("Unknown rating ${rule.testChar}")
            }
        }

        fun newMax(range: IntRange, testValue: Int): IntRange {
            return IntRange(range.first, min(testValue - 1, range.last))
        }

        fun newMin(range: IntRange, testValue: Int): IntRange {
            return IntRange(max(testValue + 1, range.first), range.last)
        }
    }
}