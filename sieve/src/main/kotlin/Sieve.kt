import kotlin.math.pow

object Sieve {
    fun primesUpTo(limit: Int): List<Int> {
        var numbers = (2..limit).toList()
        val primes = mutableListOf<Int>()
        while (numbers.isNotEmpty()) {
            val prime = numbers.first()
            primes.add(prime)
            numbers = numbers.filter { it % prime != 0 }
        }
        return primes
    }

    fun primesUpToAlt(limit: Int): List<Int> = primes.take(limit).toList().filter { it <= limit }

    private val primes: Sequence<Int> = sequence {
        var numbers = generateSequence(2) { it + 1 }
        while (true) {
            val prime = numbers.first()
            yield(prime)
            numbers = numbers.drop(1).filter { it % prime != 0 }
        }
    }

    fun primesUpToAlt2(limit: Int): List<Int> {
        if (limit == 1) return listOf()
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
        return r.slice(2 until r.count()) // slice removes 0 and 1 because no primes
    }
}
