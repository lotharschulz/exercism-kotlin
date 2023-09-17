private val digits = listOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

private val teens = listOf("eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")

private val tens = listOf("ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")

val scales = mapOf(
    1_000_000_000L to "billion",
    1_000_000L to "million",
    1_000L to "thousand",
    100L to "hundred",
)

class NumberSpeller {
//    companion object {
//        val digits = listOf(
//            "zero", "one", "two", "three", "four",
//            "five", "six", "seven", "eight", "nine",
//        )
//        val teens = listOf(
//            "eleven", "twelve", "thirteen",
//            "fourteen", "fifteen", "sixteen",
//            "seventeen", "eighteen", "nineteen",
//        )
//        val tens = listOf(
//            "ten", "twenty", "thirty",
//            "forty", "fifty", "sixty",
//            "seventy", "eighty", "ninety",
//        )
//        val bigNumbers = mapOf(
//            1_000_000_000L to "billion",
//            1_000_000L to "million",
//            1_000L to "thousand",
//            100L to "hundred",
//        )
//    }

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
        input < 10 -> digits[input]
        input in 11..19 -> teens[(input - 11)]
        input in 10..90 && input % 10 == 0 -> tens[(input - 1) / 10]
        else -> encodeSmall(input - (input % 10)) + "-" + encodeSmall(input % 10)
    }
}

/*
private val scales = listOf("", "thousand", "million", "billion")

private val oneToTwenty = listOf(

    "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",

    "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",

)

private val tens = listOf("twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")

class NumberSpeller {

    fun say(input: Long): String {
        require(input in 0..999999999998)
        return when {
            input < 20 -> oneToTwenty[input.toInt()]
            input < 100 -> {
                var ten = tens[(input / 10).toInt() - 2]
                if (input % 10 > 0) ten += "-" + oneToTwenty[(input % 10).toInt()]
                ten
            }
            input < 1000 -> {
                var hun = oneToTwenty[(input / 100).toInt()] + " hundred"
                if (input % 100 > 0) hun += " " + say(input % 100)
                hun
            }
            else -> {
                // https://exercism.org/tracks/kotlin/exercises/say/solutions/Ric0chet
                println("else")
                var result = ""
                println("input: $input")
                var i = input
                if (i % 1000 > 0) result = say(i % 1000)
                for (index in 0..5) {
                    i /= 1000
                    println("i: $i")
                    println("i % 1000: ${i % 1000}")
                    if (i % 1000 > 0) {
                        var sca = say(i % 1000) + " " + scales[index + 1]
                        println("sca: $sca")
                        if (result > "") sca += " $result"
                        result = sca
                    } else {
                        break
                    }
                }
                result
            }
        }
    }
}
*/
