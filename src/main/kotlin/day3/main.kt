package day3

import java.io.File

fun main() {
    val diagnostics = Diagnostics()
    val binaries =
        File("src/main/kotlin/day3/input.txt").readLines()

    diagnostics.process(binaries)

    println(diagnostics.powerConsumption)
    println(diagnostics.lifeSpan)
}