class Matrix(private val matrixAsString: String) {

    fun column(colNr: Int): List<Int> {
        TODO("Implement this to complete the task")
    }

    fun row(rowNr: Int): List<Int> {
/*
        print(matrixAsString.split("\n").forEachIndexed{
            index, element -> println("index = $index, element = $element")

        })
*/
        //val r:Int = rowNr-1
        if (matrixAsString.indexOf("\n") == -1) return listOf(matrixAsString.toInt())
        return matrixAsString.split("\n").get(rowNr-1).split(" ").map { it.toInt() }
        //return listOf(2, 3)
    }
}
