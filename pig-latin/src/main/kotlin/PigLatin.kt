object PigLatin {

    const val VOWELS = "aeiouy"
    const val CONSONANTS = "bcdfghjklmnpqrstvwxz"
    const val AY = "ay"

    private val PIG_LATIN_VOWELS = listOf<String>("yt", "xr")

    fun translate(input: String): String {
        return when{
            input.startsWithChars(CONSONANTS) -> input.substring(1,input.length) + input.substring(0,1) + AY
            input.startsWithChars(VOWELS) or input.startsWithPigLatinVowels(PIG_LATIN_VOWELS) -> input + AY
            else -> "foo"
        }
    }

    private fun String.startsWithPigLatinVowels(i: List<String>) = (i.filter { it.startsWith(this) }).isEmpty()
    private fun String.startsWithChars(i: String) = i.indexOf(Character.toLowerCase( this.get(0)) ) != -1
}