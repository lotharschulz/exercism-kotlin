object PigLatin {

    const val VOWELS = "aeiouy"
    private val PIG_LATIN_VOWELS = listOf<String>("yt", "xr")

    fun translate(input: String): String {
        return when{
            input.startsWith(VOWELS) or input.startsWithPigLatinVowels(PIG_LATIN_VOWELS) -> input + "ay"
            else -> "foo"
        }
    }

    private fun String.startsWithPigLatinVowels(i: List<String>) = (i.filter { it.startsWith(this) }).isEmpty()
}