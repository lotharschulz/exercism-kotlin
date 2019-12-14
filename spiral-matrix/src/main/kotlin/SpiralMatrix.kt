object SpiralMatrix {
    fun ofSize(size: Int): Array<IntArray>{

        val res = Array<IntArray>(size){IntArray(size) {0} }

        var lastRow = size
        var lastCol = size
        var r = 1 // zeilen index
        var c = 1 // spalten index
        var value:Int = 1
        var whileCntr = 0
        while (r <= lastRow && c <= lastCol){
            for(i in 1+whileCntr..lastCol){
                // [zeilen] [spalten]
                res[r-1][i-1] = value
                value++
            }
            r++
            for (i in r+whileCntr..lastRow){
                res[i-1][lastCol-1] = value
                value++
            }
            lastCol--
            if (r<=lastRow){
                for (i in lastCol downTo c){
                    res[lastRow-1][i-1] = value
                    value++
                }
                lastRow--
            }
            if (c<=lastCol){
                for (i in lastRow downTo r){
                    res[i-1][c-1] = value
                    value++
                }
                c++
            }
            whileCntr++
        }
        return res
    }
    
/*    fun edges(size: Int): List<Int>{
        if(size == 0) return emptyList()
        if(size == 1) return listOf(1)
        val allItems = (1..(size*size)).toList()
        val chunks = allItems.subList(1, allItems.size).chunked(size-1)
        val edges = mutableListOf<Int>()
        // 1 is always the value of the first edge
        edges.add(0,1)
        // add last element of every chunk
        chunks.forEach { edges.add(it.elementAt( it.size-1)) }
        // there are only for edges in a 2D matrix
        return edges.subList(0, 4)
    }*/
}