class Matrix (m: List<List<Int>>){
    val saddlePoints:Set<MatrixCoordinate> by lazy(mode = LazyThreadSafetyMode.NONE) {
        identifySaddlePoints(m)
    }

    private fun identifySaddlePoints(m: List<List<Int>>):Set<MatrixCoordinate> {
        if(m.isEmpty() or m[0].isEmpty()) return emptySet()
        val transposedMatrix2 = transposeQuadraticMatrix(m)
        // this.print2DMatrix2(m, "matrix")
        // this.print2DMatrix2(transposedMatrix2, "transposed matrix")

        val maxList = m.map { it.max() }.toList()
        val minTransposedList = transposedMatrix2.map { it.min() }.toList()
        val saddleNumbers = maxList.intersect(minTransposedList)
        return indentifySaddlePoints(saddleNumbers, m, maxList, minTransposedList)
    }

    fun indentifySaddlePoints(saddleNumbers: Set<Int?>, m: List<List<Int>>, maxList: List<Int?>, minTransposedList: List<Int?>):
            Set<MatrixCoordinate>{
        require(m.isNotEmpty() and m[0].isNotEmpty())

        val res:MutableSet<MatrixCoordinate> = hashSetOf()
        var row = 0
        var col:Int

        for (sn in saddleNumbers){
            for (l in 0 .. (m.size-1)){
                col = 0
                for (i in 0 .. (m[l].size-1)){
                    if(maxList.size >= l && minTransposedList.size >= i) {
                        if (sn == m[l][i] && maxList[l] == sn && minTransposedList[i] == sn) {
                            res.add(MatrixCoordinate(row, col))
                        }
                    }
                    col += 1
                }
                row += 1
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