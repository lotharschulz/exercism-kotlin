class Matrix(private val matrixAsString: String) {

    private val NL = "\n"
    private val SPACE = " "
    private val oneLiner = matrixAsString.indexOf(NL) == -1

    fun column(colNr: Int): List<Int> = when(oneLiner){
        true -> listOf(matrixAsString.toInt())
        false -> matrixAsString.split(NL).map { it.split(SPACE).filter { it.isNotEmpty() }.get(colNr-1).toInt() }
    }

    fun row(rowNr: Int): List<Int> = when(oneLiner){
        true -> listOf(matrixAsString.toInt())
        false -> matrixAsString.split(NL).get(rowNr-1).split(SPACE).filter { it.isNotEmpty() }.map { it.toInt() }
    }
}
