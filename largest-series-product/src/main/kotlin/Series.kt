class Series(private val input: String) {
    fun getLargestProduct(digits: Int):Int {
        require(input.matches("\\d+?".toRegex())) { "Input must be a number" }

        if (input.isBlank())  return 0
        var numbers = mutableListOf<Int>()
        for (s in input){
            numbers.add(s.toString().toInt())
        }
        println(numbers)
        val sum = numbers.foldRight(1,
                { mul, next -> mul * next }
        )
        println(sum)

        val sum1 = numbers.reduce { acc, i -> acc * i }
        println(sum1)

        val sum2 = numbers.take(digits).reduce { acc, i -> acc * i }
        println(sum2)

/*
        input.foldRight(1,
            mul, next -> mul * next
        )
        */
      return 9 * digits
    }
}

fun main(){
    val s = Series("123456")
    println(s.getLargestProduct(3))
}