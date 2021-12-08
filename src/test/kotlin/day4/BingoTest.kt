package day4

import org.junit.jupiter.api.assertThrows
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class BingoTest {

    @Test
    fun `throws board incomplete error when accessing rows of incomplete board`() {
        val board = Board(emptyList())
        assertThrows<Board.Error.IncompleteBoard> { board.rows }
    }

    @Test
    fun `can draw numbers`() {
        val bingo = Bingo(emptyList())

        bingo.draw(5)
        bingo.draw(10)
        bingo.draw(15)

        assertEquals(listOf(5, 10, 15), bingo.drawnNumbers)
    }

    @Test
    fun `board can win a game`() {
        val boards = listOf(createCompleteBoard(), createCompleteBoard())
        val bingo = Bingo(boards)

        boards.last().rows.last().forEach(bingo::draw)

        assertNotNull(bingo.winner)
        assertEquals(boards.last(), bingo.winner)
    }

    @Test
    fun `can calculate winner score`() {
        val boards = listOf(
            Board(
                listOf(
                    listOf(1, 2, 3, 4, 5),
                    listOf(1, 2, 3, 4, 5),
                    listOf(1, 2, 3, 4, 5),
                    listOf(1, 2, 3, 4, 5),
                    listOf(1, 2, 3, 4, 10),
                )
            ),
            Board(
                listOf(
                    listOf(6, 7, 8, 9, 10),
                    listOf(6, 7, 8, 9, 10),
                    listOf(6, 7, 8, 9, 10),
                    listOf(6, 7, 8, 9, 10),
                    listOf(6, 7, 8, 9, 10),
                )
            ),
        )
        val bingo = Bingo(boards)

        val drawNumbers = listOf(1, 2, 3, 4, 5)
        drawNumbers.forEach(bingo::draw)

        assertNotNull(bingo.winner)
        assertNotNull(bingo.winnerScore)
        assertEquals(50, bingo.winnerScore)
    }

    private val random: Int
        get() = Random.nextInt(0, 100)

    private fun createCompleteBoard(): Board =
        Board(
            listOf(
                List(5) { random },
                List(5) { random },
                List(5) { random },
                List(5) { random },
                List(5) { random },
            ),
        )
}