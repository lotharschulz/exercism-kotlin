object PrimeFactorCalculator {
    fun primeFactors(int: Int): List<Int> = primes(int.toLong()).map { it.toInt() }
    fun primeFactors(long: Long): List<Long> = primes(long)

    private tailrec fun primes(long: Long, acc: List<Long> = emptyList()): List<Long> =
        when(val nextPrime = (2..long).firstOrNull { long % it == 0L }){
            null -> acc
            else -> primes(long / nextPrime, acc + nextPrime)
        }

}
