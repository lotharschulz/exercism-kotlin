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

    fun convert(input: Int): String = "Pling"
}