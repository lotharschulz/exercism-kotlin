object SumOfMultiples {

    private fun sum(n: Int) = n*(n+1)/2

    fun sum(ns: Set<Int>, i: Int): Int {
        var multiples: MutableList<Int> = mutableListOf<Int>()
        for (n in ns){
            for(elem in 1 .. i){
                if (elem * n < i) {
                    multiples.add(elem * n)
                }
            }
        }

        return multiples.distinct().sum()
    }
}
