object SpiralMatrix {
    fun ofSize(size: Int): Array<IntArray>{
        val values = 1..(size * size)
        //println("values: $values")
        //println("columns: $size")

        val r:Array<IntArray> = Array(size) {
            IntArray(size) { it + 1  }
        }
        //r.forEach { it.forEach { i -> println(i) } }

        return r
    }
    
    fun edges(size: Int): List<Int>{
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
    }
}