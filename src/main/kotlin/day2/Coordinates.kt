package day2

data class Movement(
    val direction: String,
    val step: Int,
)

@Suppress("DataClassPrivateConstructor")
data class Coordinates private constructor(
    private val aim: Int,
    val horizontal: Int,
    val depth: Int,
) {
    operator fun plus(movement: Movement): Coordinates =
        when (movement.direction) {
            "up" -> copy(aim = aim - movement.step)
            "down" -> copy(aim = aim + movement.step)
            "forward" -> copy(
                horizontal = horizontal + movement.step,
                depth = depth + aim * movement.step,
            )
            else -> throw IllegalStateException()
        }

    companion object {
        val Zero: Coordinates = Coordinates(aim = 0, horizontal = 0, depth = 0)
    }
}