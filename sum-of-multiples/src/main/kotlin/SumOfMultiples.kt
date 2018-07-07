object SumOfMultiples {

    fun sum(ns: Set<Int>, i: Int): Int {
        var multiples: MutableList<Int> = mutableListOf<Int>()
        ns.forEach { n -> (1 .. i).filter { e -> e * n < i }.forEach { e -> multiples.add(e*n) } }
        return multiples.distinct().sum()
    }
}
