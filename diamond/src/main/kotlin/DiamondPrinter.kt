class DiamondPrinter {
    fun printToList(c: Char): List<String> {
        return ('A' .. c).plus(('A' until c).reversed()).map {
            when {
                charPos(c) - charPos(it) == charPos(c) ->
                    " ".repeat(charPos(c)) + it + " ".repeat(charPos(c))
                else ->
                    " ".repeat(charPos(c) - charPos(it)) + it +
                    " ".repeat(2 * charPos(it) - 1) + it +
                    " ".repeat(charPos(c) - charPos(it))
            }
        }
    }

    fun charPos(c:Char): Int {
        return ('A'..'Z').indexOf(c.toUpperCase())
    }

}
