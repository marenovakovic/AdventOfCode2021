package day1

import java.io.File

fun main() {
    val input = File("src/main/kotlin/day1/input.txt").readLines().map(String::toInt)
    println(scan(input))
}