object Transpose {

    fun transpose(input: List<String>): List<String> {
        val longestInputString = input.map{ it.length }.maxOrNull()?:0
        if (longestInputString < 1) return emptyList()
        println(input)
        println(longestInputString)
        //val result: MutableList<String> = "".repeat(longestInputString).split("").toMutableList()
        val result = mutableListOf<String>()
        for (index in 0 until longestInputString) {
            result.add(index, "")
        }
        //println(result.size)
        //println(result)
        input.forEach {
            println("it: $it")
            for (index in 0 until longestInputString) {
                val stringToAdd = it.getOrNull(index) ?: ""
                println("stringToAdd: -$stringToAdd-")
                println("result[$index]: -${result[index]}-")
                //if (result[index].isEmpty() && stringToAdd.toString().isNotEmpty())
                //result[index] += stringToAdd.toString()
                println("it.length: ${it.length}")
                println("index: ${index}")
                when {
                    index >= it.length -> result[index] += " $stringToAdd"
                    else -> result[index] += stringToAdd.toString()
                }
            }
        }
        println(result)
        return result
    }
}