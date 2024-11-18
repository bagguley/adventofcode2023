package day24

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>): Long {
        val hailstones = load(input)

        val range = -300L..300L
        while (true) {
            val hail = hailstones.shuffled().take(4)
            range.forEach { deltaX ->
                range.forEach { deltaY ->
                    val hail0 = hail[0].withVelocityDelta(deltaX, deltaY)
                    val intercepts = hail.drop(1).mapNotNull {
                        it.withVelocityDelta(deltaX, deltaY).crosses(hail0)
                    }
                    if (intercepts.size == 3 &&
                        intercepts.all { it.x == intercepts.first().x } &&
                        intercepts.all { it.y == intercepts.first().y }
                    ) {
                        range.forEach { deltaZ ->
                            val z1 = hail[1].predictZ(intercepts[0].time, deltaZ)
                            val z2 = hail[2].predictZ(intercepts[1].time, deltaZ)
                            val z3 = hail[3].predictZ(intercepts[2].time, deltaZ)
                            if (z1 == z2 && z2 == z3) {
                                return (intercepts.first().x + intercepts.first().y + z1).toLong()
                            }
                        }
                    }
                }
            }
        }
    }

    private fun load(input: List<String>): List<Hail> {
        return input.map {
            val split = it.split(" @ ")
            val position = split[0].split(", ").map { it.trim().toDouble() }
            val velocity = split[1].split(", ").map { it.trim().toDouble() }
            Hail( Point(position[0], position[1], position[2]), Velocity(velocity[0], velocity[1], velocity[2]) )
        }
    }

    private data class Hail(val position: Point, val velocity: Velocity) {
        val gradient = velocity.y / velocity.x

        fun crosses(other: Hail): Intersection? {
            if (gradient.isNaN() || other.gradient.isNaN() || gradient == other.gradient) return null

            val thisC = position.y - gradient * position.x

            val otherC = other.position.y - other.gradient * other.position.x

            val crossX = (otherC - thisC) / (gradient - other.gradient)

            val crossY = gradient * (crossX - position.x) + position.y

            val t1 = (crossX - position.x) / velocity.x
            val t2 = (crossX - other.position.x) / other.velocity.x

            if (t1 < 0 || t2 < 0) return null

            return Intersection(crossX, crossY, t1)
        }

        fun withVelocityDelta(vx: Long, vy: Long): Hail = copy(velocity = Velocity(velocity.x + vx, velocity.y + vy, velocity.z))

        fun predictZ(time: Double, deltaVZ: Long): Double = (position.z + time * (velocity.z + deltaVZ))
    }

    private data class Point(val x: Double, val y: Double, val z: Double)

    private data class Velocity(val x: Double, val y: Double, val z: Double)

    private data class Intersection(val x: Double, val y: Double, val time: Double)
}

