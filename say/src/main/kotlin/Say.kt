private val tilTwenty = listOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
    "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")

private val tens = listOf("ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")

val scales = mapOf(
    1_000_000_000L to "billion",
    1_000_000L to "million",
    1_000L to "thousand",
    100L to "hundred",
)

class NumberSpeller {

    fun say(input: Long): String {
        require(input in 0..999999999998)
        val parts = mutableListOf<String>()
        var current = input

        scales.forEach { (num, unit) ->
            if (current >= num) {
                parts.add(say(current / num) + " " + unit)
                current = current.mod(num)
            }
        }

        if (current.mod(100) > 0 || input == 0L) {
            parts.add(encodeSmall(current.toInt()))
        }

        return parts.joinToString(" ")
    }

    private fun encodeSmall(input: Int): String = when {
        input < 20 -> tilTwenty[input]
        input in 10..90 && input % 10 == 0 -> tens[(input - 1) / 10]
        else -> encodeSmall(input - (input % 10)) + "-" + encodeSmall(input % 10)
    }
}
