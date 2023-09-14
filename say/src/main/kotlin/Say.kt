private val scales = listOf("", "thousand", "million", "billion")

private val oneToTwenty = listOf(

    "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",

    "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",

)

private val tens = listOf("", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")

class NumberSpeller {

    fun say(input: Long): String {
        require(input in 0..999999999998)
        return when (input) {
            0L -> "zero"
            else -> ""
        }
        TODO("Implement this function to complete the task")
    }
}
