package day4

interface Board {
    val rows: List<List<Int>>

    fun isWin(drawnNumbers: List<Int>): Boolean

    sealed class Error : Throwable() {
        object IncompleteBoard : Error()
    }

    companion object {
        operator fun invoke(rows: List<List<Int>>): Board =
            if (rows.size == 5 && rows.all { it.size == 5 }) CompleteBoard(rows)
            else IncompleteBoard
    }
}

private class CompleteBoard(override val rows: List<List<Int>>) : Board {

    override fun isWin(drawnNumbers: List<Int>): Boolean {
        if (isRowWin(drawnNumbers)) return true
        if (isColumnWin(drawnNumbers)) return true
        return false
    }

    private fun isRowWin(drawnNumbers: List<Int>): Boolean {
        for (row in rows)
            if (row.intersect(drawnNumbers.toSet()).size == 5)
                return true
        return false
    }

    private fun isColumnWin(drawnNumbers: List<Int>): Boolean {
        var drawnCount: Int
        for (i in rows.indices) {
            drawnCount = 0
            for (j in rows.first().indices)
                if (drawnNumbers.contains(rows[i][j])) drawnCount++
            if (drawnCount == 5) return true
        }
        return false
    }
}

private object IncompleteBoard : Board {
    override val rows: List<List<Int>>
        get() = throw Board.Error.IncompleteBoard

    override fun isWin(drawnNumbers: List<Int>): Boolean =
        throw Board.Error.IncompleteBoard
}
