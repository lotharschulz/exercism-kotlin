object SpiralMatrix {
    fun ofSize(size: Int): Array<IntArray>{
        val values = 1..(size * size)
        println("values: $values")
        println("columns: $size")

        val matrix:Array<IntArray> = Array(size) {
            IntArray(size)
        }
        //matrix.forEach { it.forEach { println(it) } }
/*
        for (i in 1 until size+1) {
            for (j in 0 until size){
                matrix[i-1][j] = i+j
            }
        }
*/
        matrix.forEach { it.forEach { it2 -> println(it2) } }
        return matrix
    }
}