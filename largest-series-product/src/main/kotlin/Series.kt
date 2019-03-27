class Series(private val input: String) {

    fun segments(digits: Int):List<List<Int>>{
        require(digits <= input.length) {"Input string length must be bigger than digit number."}
        if(digits == 0) return listOf(listOf(1))

        val inputIntList:List<Int> = transformInputToIntList(input)

        var j = 0
        val l = mutableListOf<List<Int>>()

        while (j + digits <= inputIntList.size){
            l.add(inputIntList.subList(j, j + digits))
            j += 1
        }
        return l
    }

    private fun transformInputToIntList(input: String):List<Int>{
        return input.toList().map { it.toInt() - 48 }
    }

    fun getLargestProduct(digits: Int):Number {
        println("digits: $digits")
        require(input.matches("\\d+?".toRegex())) { "digits must be a number." }
        var product:Int = 0
        var p:Int
        for (s in segments(digits)){
            p = s.reduce { acc, i -> acc * i }
            if ( p > product ) product = p
        }
        return product
            

/*
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
*/

/*
        input.foldRight(1,
            mul, next -> mul * next
        )
        */
//      return 9 * digits
    }
}

fun main(){
    val s = Series("1027839564")

    println(s.segments(3))

    println(s.getLargestProduct(3))
}