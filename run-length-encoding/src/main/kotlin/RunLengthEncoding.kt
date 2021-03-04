object RunLengthEncoding {

    fun encode(input: String): String = input.group().joinToString("") {
            when{
                it.isEmpty() -> ""
                it.length == 1 -> it
                else -> it.length.toString() + it.last()
            }
        }

    fun decode(input: String): String = input.replace("(\\d+)(\\D)".toRegex()) {
            it.groupValues[2].repeat(it.groupValues[1].toInt())
        }

    private fun String.group(): List<String> =
        if (isEmpty()) listOf()
        else listOf(takeWhile { it == first() }) + dropWhile { it == first() }.group()

}
