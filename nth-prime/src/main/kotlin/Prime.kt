object Prime {
    fun nth(n: Int): Long {
        require(n > 0) {"There is no zeroth prime."}
        return primes().elementAt(n)
    }

    private fun primes(): Sequence<Long> {
        var i = 0L
        return sequence {
            generateSequence { i++ }
                    .filter { n -> n > 0 && ((2 until n).none { i -> n % i == 0L }) }
                    .forEach { yield(it) }
        }
    }
}