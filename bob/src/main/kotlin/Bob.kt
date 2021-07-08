object Bob {
    fun hey(input: String): String = when{
            input.noContent() -> "Fine. Be that way!"
            input.isQuestion() && input.isYell() -> "Calm down, I know what I'm doing!"
            input.isQuestion() -> "Sure."
            input.isYell() -> "Whoa, chill out!"
            else -> "Whatever."
        }

    private val PUNCTUATION_REGEX = "[!\"#\$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]".toRegex();
    private fun String.stripLastChar(): String = this.slice(0..this.length - 2)
    private fun String.isPunctuations(): Boolean = PUNCTUATION_REGEX.containsMatchIn( this.stripLastChar().filter { !it.isWhitespace() } )

    private fun String.isQuestion(): Boolean = !this.noContent() && this.isNotEmpty() && this.trim().last() == '?'
    private fun String.isYell(): Boolean = this.stripLastChar().any { it.isLetter() } && this.stripLastChar().filter { it.isLetter() }.all { it.isUpperCase() }
    private fun String.noContent(): Boolean = this.none { it.isLetterOrDigit() } && !this.isPunctuations()
}
