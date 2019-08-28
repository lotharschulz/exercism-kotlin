object PigLatin {

    const val VOWELS = "aeiouy"
    const val CONSONANTS = "bcdfghjklmnpqrstvwxz"

    const val AY = "ay"
    const val PIG_QU = "qu"

    private val PIG_LATIN_VOWELS = listOf("yt", "xr")
    private val PIG_DOUBLE_CONSONANTS = listOf("ch", "th") + listOf(PIG_QU)
    private val PIG_TRIPLE_CONSONANTS = listOf("thr", "sch")

    private val regex = """([bcdfghjklmnpqrstvwxz]+)y+?.+""".toRegex()

    fun translate(input: String): String = input.split(" ").joinToString(" ") { translateWord(it) }

    private fun translateWord(input: String): String {
        return when{
            input.startsWithChars(CONSONANTS) -> {
                when{
                    input.length == 2 && input.substring(1,2).equals("y") ->
                        addAy("y" + input.substring(0, 1))
                    regex matches input ->
                        input.substring(input.indexOf("y"), input.length) +
                                input.substring(0, input.indexOf("y")) + AY
                    input.substring(1,3).equals(PIG_QU) or input.startsWithPigLatin(PIG_TRIPLE_CONSONANTS) ->
                        addAy(input.substring(3,input.length) + input.substring(0,3))
                    input.startsWithPigLatin(PIG_DOUBLE_CONSONANTS) ->
                        addAy(input.substring(2,input.length) + input.substring(0,2))
                    !input.startsWithPigLatin(PIG_LATIN_VOWELS) ->
                        sendFirstCharToEndAndAddAy(input)
                    input.startsWithPigLatin(PIG_LATIN_VOWELS) ->
                        addAy(input)
                    else -> input
                }
            }
            input.startsWithChars(VOWELS) -> {
                when{
                    input.startsWithPigLatin(PIG_LATIN_VOWELS) -> addAy(input)
                    input.startsWith("y") -> sendFirstCharToEndAndAddAy(input)
                    else -> addAy(input)
                }
            }
            else -> input
        }
    }

    private fun addAy(i: String): String = i + AY

    private fun sendFirstCharToEndAndAddAy(i: String): String =
            addAy(i.substring(1,i.length) + i.substring(0,1))


    private fun String.startsWithPigLatin(i: List<String>):Boolean =
            !(i.filter { this.startsWith(it) }).isEmpty()
    private fun String.startsWithChars(i: String):Boolean =
            i.indexOf(Character.toLowerCase( this.get(0)) ) != -1
}