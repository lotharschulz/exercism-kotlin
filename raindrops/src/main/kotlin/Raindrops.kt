object Raindrops{
    fun getFactors(n: Int): List<Int> {
        if (n < 1) return emptyList()
        val fs = mutableListOf<Int>()
        (1..n / 2)
                .filter { n % it == 0 }
                .forEach { fs.add(it) }
        fs.add(n)
        return fs
    }

    fun convert(input: Int): String {
        val result = StringBuilder();
        getFactors(input).forEach(){
            when(it){
                3 -> result.append("Pling")
                5 -> result.append("Plang")
                7 -> result.append("Plong")
            }
        }
        if (result.toString().isEmpty()) result.append(input.toString())
        return result.toString()
    }

    /*
    https://www.programiz.com/kotlin-programming/examples/factors-number
    for (i in 1..number) {
        if (number % i == 0) {
            print("$i ")
        }
    }
     */
}