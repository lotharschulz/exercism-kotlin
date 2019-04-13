const val CAESAR_CIPHER_DIFFERENCE = 26

class RotationalCipher(private val input: Int) {
    fun encode(text: String): String = text.map { char ->
            when (char) {
                in 'a'..'z' -> encodeChar(char, 'a')
                in 'A'..'Z' -> encodeChar(char, 'A')
                else -> char
            }
        }.joinToString("")

    private fun encodeChar(char: Char, base: Char): Char =
            (((char.minus(base).plus(input))%CAESAR_CIPHER_DIFFERENCE)+base.toInt()).toChar()
}