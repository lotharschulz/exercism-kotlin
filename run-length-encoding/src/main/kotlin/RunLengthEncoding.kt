object RunLengthEncoding {

    fun encode(input: String): String =
        input.group().joinToString("") { if (it.isEmpty()) "" else it.length.toString() + it.last() }

    fun decode(input: String): String {
        TODO("Implement this to complete the task")
    }

    private fun String.group(): List<String> =
        if (isEmpty()) listOf()
        else listOf(takeWhile { it == first() }) + dropWhile { it == first() }.group()


}
