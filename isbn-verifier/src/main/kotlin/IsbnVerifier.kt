class IsbnVerifier {
    private val ISBNLength = 10
    fun isValid(number: String): Boolean =
        when {
            !number.filter { it.isLetterOrDigit() }.containsValidISBNItems() -> false
            else -> verifyISBNItems(number.filter { it.isLetterOrDigit() })
        }

    private fun verifyISBNItems(normalizedNumber: String): Boolean =
        (0 until ISBNLength).fold(0) { acc, digit ->
            when {
                digit == ISBNLength - 1 && normalizedNumber[digit] == 'X' -> acc + 10 * (ISBNLength - digit)
                else -> acc + (normalizedNumber[digit].code - 48) * (ISBNLength - digit)
            }
        }.rem(11) == 0
}

// https://regex101.com/r/yeFrD0/1
private val ISBNDigits = """^\d{9}[\d|X]$""".toRegex();
private fun String.containsValidISBNItems(): Boolean = ISBNDigits.containsMatchIn( this )
