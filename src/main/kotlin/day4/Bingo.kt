package day4

class Bingo(private val boards: List<Board>) {
    private var _drawnNumbers = emptyList<Int>()
    val drawnNumbers: List<Int>
        get() = _drawnNumbers

    private var _winner: Board? = null
    val winner: Board?
        get() = _winner

    private var _winnerScore: Int = -1
    val winnerScore: Int
        get() = _winnerScore

    fun draw(number: Int) {
        _drawnNumbers = drawnNumbers + number
        _winner = boards.firstOrNull { it.isWin(drawnNumbers) }

        if (winner != null) {
            _winnerScore = calculateWinnerScore(winner!!) * number
        }
    }

    private fun calculateWinnerScore(board: Board): Int =
        board.rows.map { row -> row.filterNot { drawnNumbers.contains(it) } }
            .sumOf(List<Int>::sum)
            .also { println(it) }
}