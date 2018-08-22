class Matrix (m: List<List<Int>>){
    val saddlePoints:Set<MatrixCoordinate> by lazy(mode = LazyThreadSafetyMode.NONE) {
        identifySaddlePoints(m)
    }

    private fun identifySaddlePoints(matrix: List<List<Int>>):Set<MatrixCoordinate> {
        if(matrix.isEmpty() or matrix[0].isEmpty()) return emptySet()
        val transposedMatrix2 = transposeQuadraticMatrix(matrix)
        // this.print2DMatrix2(matrix, "matrix")
        // this.print2DMatrix2(transposedMatrix2, "transposed matrix")

        val maxList = matrix.map { it.max() }.toList()
        val minTransposedList = transposedMatrix2.map { it.min() }.toList()
        val saddleNumbers = maxList.intersect(minTransposedList)
        return indentifySaddlePoints(saddleNumbers, matrix, maxList, minTransposedList)
    }

    internal fun indentifySaddlePoints(saddleNumbers: Set<Int?>, matrix: List<List<Int>>, maxList: List<Int?>, minTransposedList: List<Int?>):
            Set<MatrixCoordinate>{
        require(matrix.isNotEmpty() and matrix[0].isNotEmpty())

        val res:MutableSet<MatrixCoordinate> = hashSetOf()

        for (sn in saddleNumbers){
            for (row in 0 until matrix.size){
                for (col in 0 until matrix[row].size){
                    if(maxList.size >= row) { // could be also minTransposedList.size >= col
                        if (sn == matrix[row][col] && maxList[row] == sn && minTransposedList[col] == sn) {
                            res.add(MatrixCoordinate(row, col))
                        }
                    }
                }
            }
        }
        return res
    }

    internal fun transposeQuadraticMatrix(m: List<List<Int>>):  List<List<Int>>{
        require(m.isNotEmpty() && m[0].isNotEmpty())
        for (l in m){
            require(m.size == l.size)
        }
        val rowColumn = m.size
        val transposedMatrix2: MutableList<MutableList<Int>> = mutableListOf()
        for (i in 0..(rowColumn - 1)) {
            transposedMatrix2.add(mutableListOf())
            for (j in 0..(rowColumn - 1)) {
                transposedMatrix2.get(i).add(m[j][i])
            }
        }
        return transposedMatrix2
    }

/*    private fun print2DMatrix2(m: List<List<Int>>, label: String){
        val output = StringBuilder()
        for (i in m){
            output.append("[")
            for (j in 0 .. (i.size-1)){
                output.append("${i.get(j)}")
                if (j != i.size-1) output.append(",")
            }
            output.append("]\n")
        }
        println("$label:")
        println(output)
    }*/

}