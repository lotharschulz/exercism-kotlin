object PigLatin {

    const val VOWELS = "aeiouy"
    const val CONSONANTS = "bcdfghjklmnpqrstvwxz"

    const val AY = "ay"
    const val PIG_QU = "qu"

    private val PIG_LATIN_VOWELS = listOf("yt", "xr")
    private val PIG_DOUBLE_CONSONANTS = listOf("ch", "th") + listOf(PIG_QU)
    private val PIG_TRIPLE_CONSONANTS = listOf("thr", "sch")

    fun translate(input: String): String {
        return when{
            input.startsWithChars(CONSONANTS) -> {
                println("input: $input")
                val regex = """([bcdfghjklmnpqrstvwxz]+)y+?.+""".toRegex()
                when{
                    // case : Y is treated like a vowel at the end of a consonant cluster
                    // regex matches """(bcdfghjklmnpqrstvwxz)"""
                    regex matches input -> {
                        println("5 input: $input")
                        input.substring(input.indexOf("y"), input.length) +
                                input.substring(0, input.indexOf("y")) + AY
                    }
                    input.substring(1,3).equals(PIG_QU) or input.startsWithPigLatin(PIG_TRIPLE_CONSONANTS) -> {
                        println("1 input: $input")
                        addAy(input.substring(3,input.length) + input.substring(0,3))
                    }
                    input.startsWithPigLatin(PIG_DOUBLE_CONSONANTS) -> {
                        println("2 input: $input")
                        addAy(input.substring(2,input.length) + input.substring(0,2))
                    }
                    !input.startsWithPigLatin(PIG_LATIN_VOWELS) -> {
                        /*println("input: $input")
                        println("input.substring(1,input.length): ${input.substring(1,input.length)}")
                        println("input.substring(0,1): ${input.substring(0,1)}")*/
                        println("3 input: $input")
                        sendFirstCharToEndAndAddAy(input)
                    }
                    input.startsWithPigLatin(PIG_LATIN_VOWELS) -> {
                        println("4 input: $input")
                        addAy(input)
                    }
                    else -> throw Exception("Not supported.")
                }
            }
            input.startsWithChars(VOWELS) -> {
                when{
                    input.startsWithPigLatin(PIG_LATIN_VOWELS) -> addAy(input)
                    input.startsWith("y") -> sendFirstCharToEndAndAddAy(input)
                    else -> addAy(input)
                }
            }
            else -> throw Exception("Not supported.")
        }
    }

    private fun addAy(i: String): String = i + AY
    private fun sendFirstCharToEndAndAddAy(i: String): String = addAy(i.substring(1,i.length) + i.substring(0,1))


    private fun String.startsWithPigLatin(i: List<String>):Boolean {
        /*println("this: $this")
        println("i: $i")
        println("this.startsWith(\"ch\"): ${this.startsWith("ch")}")
        println("i.filter { this.startsWith(it) }: ${i.filter { this.startsWith(it) }}")*/
        val r = !(i.filter { this.startsWith(it) }).isEmpty()
        //println("startsWithPigLatin: $r")
        return r
    }
    private fun String.startsWithChars(i: String):Boolean {
        val r = i.indexOf(Character.toLowerCase( this.get(0)) ) != -1
        //println("startsWithChars: $r")
        return r
    }
}