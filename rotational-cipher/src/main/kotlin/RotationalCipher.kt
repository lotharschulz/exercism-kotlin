class RotationalCipher(private val input: Int) {
    fun encode(text: String): String = text.map { char ->
            when (char) {
                in 'a'..'z' -> (((char.minus('a').plus(input))%26)+'a'.toInt()).toChar()
                in 'A'..'Z' -> (((char.minus('A').plus(input))%26)+'A'.toInt()).toChar()
                else -> char
            }
        }.joinToString("")
}