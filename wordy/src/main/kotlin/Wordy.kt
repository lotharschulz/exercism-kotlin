object Wordy {
    private val ops = "(plus|minus|multiplied by|divided by)".toRegex()
    private val opx = "$ops (-?[0-9]+)|(raised to) the ([0-9]+)th power".toRegex()
    private val exp = "What is (-?[0-9]+)( $ops (-?[0-9]+)| raised to the ([0-9]+)th power)*[?]".toRegex()

    fun answer(input: String): Int {
        val init = exp.find(input)?.groupValues?.get(1)?.toInt() ?: throw Exception()
        val operations = opx.findAll(input).map(MatchResult::groupValues)
        return operations.fold(init) { acc, op ->
            when (op[1]) {
                "plus"          -> acc + op[2].toInt()
                "minus"         -> acc - op[2].toInt()
                "multiplied by" -> acc * op[2].toInt()
                "divided by"    -> acc / op[2].toInt()
                ""              -> List(op.last().toInt()) { acc }.reduce(Int::times)
                else            -> throw Exception()
            }
        }
    }
}