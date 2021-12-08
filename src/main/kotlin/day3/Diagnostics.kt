package day3

private data class BitCount(
    val zeroes: Int,
    val ones: Int,
) {
    companion object {
        val Initial = BitCount(0, 0)
    }
}

private const val Zero = '0'
private const val One = '1'

class Diagnostics {
    private var _powerConsumption = -1
    val powerConsumption: Int
        get() = _powerConsumption

    private var _lifeSpan = -1
    val lifeSpan: Int
        get() = _lifeSpan

    fun process(binaries: List<String>) {
        _powerConsumption = calculatePowerConsumption(binaries)
        _lifeSpan = calculateLifeSpan(binaries)
    }

    private fun calculateLifeSpan(binaries: List<String>): Int {
        val oxygen = calculateRating(binaries, Rating.Oxygen)
        val co2 = calculateRating(binaries, Rating.CO2)
        return oxygen * co2
    }

    private fun calculatePowerConsumption(binaries: List<String>): Int {
        val gama = binaries.first().indices
            .map { position -> binaries.countBitsInColumn(position) }
            .map { (zeroes, ones) -> if (zeroes > ones) Zero else One }
            .joinToString(separator = "")

        val epsilon = !gama

        return gama.binaryToDecimal() * epsilon.binaryToDecimal()
    }

    private enum class Rating { Oxygen, CO2, }

    private fun calculateRating(binaries: List<String>, rating: Rating): Int {
        val ratings = binaries.toMutableList()

        for (position in binaries.first().indices) {
            val (zeroes, ones) = ratings.countBitsInColumn(position)
            val mostCommon = if (zeroes > ones) Zero else One
            ratings.removeIf { binary ->
                when (rating) {
                    Rating.Oxygen -> binary[position] != mostCommon
                    Rating.CO2 -> binary[position] == mostCommon
                }
            }
            if (ratings.size == 1) break
        }

        return ratings.single().binaryToDecimal()
    }

    private fun List<String>.countBitsInColumn(column: Int): BitCount =
        fold(BitCount.Initial) { acc, line ->
            if (line[column] == Zero) acc.copy(zeroes = acc.zeroes + 1)
            else acc.copy(ones = acc.ones + 1)
        }

    private operator fun String.not() =
        map { if (it == Zero) One else Zero }
            .joinToString(separator = "")

    private fun String.binaryToDecimal(): Int = toInt(radix = 2)
}