object PascalsTriangle {

    private fun rowFromPreviousRow(previousRow: List<Int>): List<Int> = listOf(1)
        .plus((1 until previousRow.size).map { previousRow[it - 1] + previousRow[it] })
        .plus(listOf(1))


    private tailrec fun calculate(currentRow: Int, numberOfRows: Int, acc: List<List<Int>>): List<List<Int>> =
        when {
            currentRow > numberOfRows -> acc
            currentRow == 1 -> calculate(currentRow + 1, numberOfRows, listOf(listOf(1)))
            else -> calculate(currentRow + 1, numberOfRows, acc.plus(listOf(rowFromPreviousRow(acc.last()))))
        }

    fun computeTriangle(rows: Int): List<List<Int>> = calculate(1, rows, listOf())

}
