class PhoneNumber(private val input: String) {
    private val SIMPLIFIED_NANP = """^([1-9]?)([\d]{2})([1-9]?)(\d{6})$""".toRegex()

    private val NO_NUMBERS = """[\D]""".toRegex()
    private val STARTING_WITH_ONE = """^1""".toRegex()
    private val ONE = "1"
    private val EMPTY_STRING = ""

    val number = calculateNumber(input)

    private fun calculateNumber(input: String):String? {
        val numbers = input.replace(NO_NUMBERS, EMPTY_STRING)
        if (numbers.length != 10 && !(numbers.length == 11 && numbers.startsWith(ONE))) return null
        SIMPLIFIED_NANP.find(numbers)?.let {
            if (it.groupValues[1].startsWith(ONE) || it.groupValues[3].startsWith(ONE)) return null
        }
        val x = numbers.replace(STARTING_WITH_ONE, EMPTY_STRING)
        return SIMPLIFIED_NANP.find(x)?.destructured?.toList()?.joinToString(EMPTY_STRING)
    }
}