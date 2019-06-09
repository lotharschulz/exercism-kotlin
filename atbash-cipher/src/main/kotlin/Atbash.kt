object Atbash {
    fun encode(input: String): String {
        return input
                .toLowerCase()
                .filter { it.isLetterOrDigit() }
                .map { cipher[it] }
                .joinToString("")
                .chunked(5)
                .joinToString(" ")
    }

    fun decode (input: String): String {
        return input
                .toLowerCase()
                .filter { it.isLetterOrDigit() }
                .map { cipher[it] }
                .joinToString("")
    }

    private val cipher = buildCipherMap()

    private fun buildCipherMap(): Map<Char, Char> {
        val a = ('a'..'z').joinToString("")
        val n = (1..9).joinToString("")
        return (a.zip(a.reversed()) + n.zip(n)).toMap()
    }

}