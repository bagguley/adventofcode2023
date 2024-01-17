package day24

fun main() {
    println(Part1.calc(testData, 7.0, 27.0))
    println(Part1.calc(data, 200000000000000.0, 400000000000000.0))
}

object Part1 {
    fun calc(input: List<String>, min: Double, max:Double): Int {
        val hail = load(input)

        var tail = hail.drop(1)
        var head = hail.first()
        var count = 0

        while (tail.isNotEmpty()) {
            count += tail.mapNotNull {
                head.crosses(it)
            }.count {
                it.x in min..max && it.y in min..max
            }

            head = tail.first()
            tail = tail.drop(1)
        }

        return count
    }

    fun load(input: List<String>): List<Hail> {
        return input.map {
            val split = it.split(" @ ")
            val position = split[0].split(", ").map { it.trim().toDouble() }
            val velocity = split[1].split(", ").map { it.trim().toInt() }
            Hail( Point(position[0], position[1]), Velocity(velocity[0], velocity[1]) )
        }
    }

    class Hail(val position: Point, val velocity: Velocity) {
        fun crosses(other: Hail): Point? {
            val thisGradient = velocity.y.toDouble() / velocity.x
            val otherGradient = other.velocity.y.toDouble() / other.velocity.x

            if (thisGradient == otherGradient) {
                return null
            }

            val thisC = position.y - thisGradient * position.x

            val otherC = other.position.y - otherGradient * other.position.x

            val crossX = (thisC - otherC) / (otherGradient - thisGradient)

            val crossY = thisGradient * crossX + thisC

            if (notBefore(crossX, crossY) && other.notBefore(crossX, crossY)) {
                return Point(crossX, crossY)
            }

            return null
        }

        fun notBefore(x: Double, y: Double): Boolean {
            val xAfter = if (velocity.x > 0.0) x >= position.x else x <= position.x
            val yAfter = if (velocity.y > 0.0) y >= position.y else y <= position.y
            return xAfter && yAfter
        }
    }

    data class Point(val x: Double, val y: Double)

    data class Velocity(val x: Int, val y: Int)
}