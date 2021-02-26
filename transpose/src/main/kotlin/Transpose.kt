object Transpose {
    fun transpose(input: List<String>): List<String> {
        val maxLength = input.map{ it.length }.maxOrNull()?:0

        return (0 until maxLength).map { position ->
            input.map {
                line -> line.getOrNull(position)
            }.dropLastWhile { it == null }
                .map { it ?: ' ' }
                .joinToString("")
        }
    }
}