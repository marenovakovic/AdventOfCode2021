package day4

import java.io.File

fun main() {
    val lines = File("src/main/kotlin/day4/input.txt").readLines()
        .filter(String::isNotEmpty)
    val drawNumbers = lines.first().split(',').map(String::toInt)

    val boards = lines.drop(1)
        .filter(String::isNotBlank)
        .windowed(size = 5, step = 5)
        .map { board ->
            val rows = board
                .map { row ->
                    row
                        .split(' ')
                        .filter(String::isNotBlank)
                }
                .map { row -> row.map(String::toInt) }
            Board(rows)
        }

    val bingo = Bingo(boards)
    for (drawNumber in drawNumbers) {
        bingo.draw(drawNumber)
        if (bingo.winner != null) break
    }
}