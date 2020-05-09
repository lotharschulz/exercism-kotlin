class Matrix(private val matrixAsString: String) {

    private val NL = "\n"
    private val SPACE = " "

    fun column(colNr: Int): List<Int> =
        if (matrixAsString.indexOf(NL) == -1)
            listOf(matrixAsString.toInt())
        else
            matrixAsString.split(NL).map { it.split(SPACE).filter { it.isNotEmpty() }.get(colNr-1).toInt() }

    fun row(rowNr: Int): List<Int> =
        if (matrixAsString.indexOf(NL) == -1)
            listOf(matrixAsString.toInt())
        else
            matrixAsString.split(NL).get(rowNr-1).split(SPACE).filter { it.isNotEmpty() }.map { it.toInt() }
}
