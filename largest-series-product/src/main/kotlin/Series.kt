class Series(private val input: String) {

    init {
        require(input.isEmpty() || input.matches("\\d+?".toRegex())) { "Input must be a number." }
    }

    private fun segments(digits: Int):List<List<Int>>{
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
        require(digits >= 0){ "Digits must be greater or equal zero." }
        if (digits == 0) return 1
        var product = 0
        var p:Int
        for (s in segments(digits)){
            p = s.reduce { acc, i -> acc * i }
            if ( p > product ) product = p
        }
        return product
    }
}