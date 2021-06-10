class Forth {

    fun evaluate(vararg line: String): List<Int> {
        val tokenList = mutableListOf<String>()
        line.forEach {
            it.split(" ").forEach {
                tokenList.add(it);
            }
        }
        tokenList.forEach{
            println("it: $it")
        }
        val operator = tokenList.dropLast(1).toString()
        when(operator) {
            ForthToken.PLUS.value -> addition(tokenList)
            else -> println("operator not found")
        }
        return listOf(tokenList.size)
    }

    private fun addition(tokenList: List<String>){
        val summands = tokenList.dropLast(1).map { it.toInt() }
        summands.fold(0){sum, element -> sum + element}
    }
}
