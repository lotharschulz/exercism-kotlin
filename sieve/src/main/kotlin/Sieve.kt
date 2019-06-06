import kotlin.math.pow

object Sieve {
    fun primesUpTo(limit: Int): List<Int> {
        if (limit === 1) return listOf()
        val s = BooleanArray(limit+1) { true } // zero based
        for (i in 2 until limit){
            if (s.elementAt(i)){
                var j = i.toDouble().pow(2).toInt()
                while (j <= limit) {
                    s[j] = false
                    j += i
                }
            }
        }
        s[2] = true // 2 is prime
        val r = mutableListOf<Int>()
        s.forEachIndexed{i, e -> if (e){ r.add(i) } }
        return r.slice(2 until r.count()).toList() // slice removes 0 and 1 because no primes
    }
}
