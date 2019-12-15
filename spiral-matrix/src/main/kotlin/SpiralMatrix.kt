object SpiralMatrix {

    private var value=1
    fun ofSize(size: Int): Array<IntArray> {
        value = 1
        if(size == 0) return emptyArray()
        if(size == 1) return Array<IntArray>(1){IntArray(1){1} }

        // matrix[rows][columns]
        val matrix = Array<IntArray>(size){IntArray(size) }
        var indices = (0 until size)

        while (!indices.isEmpty()) {
            fillOuterMatrix(matrix, indices)
            indices = indices.dropFirstAndLast()
        }
        return matrix
    }

    private fun fillOuterMatrix(mat: Array<IntArray>, i:IntRange) {
        val first = i.first
        val last = i.last
        // top row
        (first..last).forEach {mat[first][it] = value++}
        // right column
        (first+1..last).forEach {mat[it][last] = value++}
        // bottom row
        (last-1 downTo first).forEach { mat[last][it] = value++}
        // left column
        (last-1 downTo first+1).forEach { mat[it][first] = value++}
    }

    private fun IntRange.dropFirstAndLast(): IntRange {
        val xs = this.filter { it != this.first() && it != this.last() }
        return when {
            xs.isEmpty() -> IntRange.EMPTY
            else -> IntRange(xs.first(), xs.last())
        }
    }
}