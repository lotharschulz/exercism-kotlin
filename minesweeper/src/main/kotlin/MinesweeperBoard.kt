data class MinesweeperBoard(val board: List<String>) {
    fun withNumbers(): List<String> = board.mapIndexed { rowIndex, row ->
        row.mapIndexed { columnIndex, column ->
            if (column == '*') {
                '*'
            } else {
                val s = Pair(rowIndex, columnIndex).adjacent()
                when (s) {
                    0 -> ' '
                    else -> '0' + s
                }
            }
        }.joinToString("")
    }

    private fun Pair<Int, Int>.adjacent(): Int = (first - 1..first + 1)
        .filter { it >= 0 && it < board.size }
        .sumOf { x ->
            (second - 1..second + 1).count { y ->
                y >= 0 && y < board[x].length && board[x][y] == '*'
            }
        }
}
