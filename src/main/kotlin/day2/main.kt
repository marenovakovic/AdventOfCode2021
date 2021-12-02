package day2

import java.io.File

fun main() {
    val coordinates =
        File("src/main/kotlin/day2/input.txt")
            .readLines()
            .map { line -> line.split(' ') }
            .map { (direction, step) -> Movement(direction, step.toInt()) }
            .fold(Coordinates.Zero) { coordinates, movement -> coordinates + movement }

    println(coordinates.horizontal * coordinates.depth)
}