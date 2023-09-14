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
