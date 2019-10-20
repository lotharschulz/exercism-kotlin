object SpiralMatrix {
    fun ofSize(size: Int): Array<IntArray>{
        val values = 1..(size * size)
        println("values: $values")
        println("columns: $size")

        val r:Array<IntArray> = Array(size) {
            IntArray(size) { it }
        }
        r.forEach { it.forEach { println(it) } }
        return r
    }
}