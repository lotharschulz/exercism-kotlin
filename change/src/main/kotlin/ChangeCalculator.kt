class ChangeCalculator(private val l: List<Int>) {

    fun computeMostEfficientChange(grandTotal: Int): List<Int> {
        require(grandTotal >= 0) { "Negative totals are not allowed." }

        if (grandTotal == 0) return listOf()

        return computeChange(grandTotal)
            ?: throw IllegalArgumentException("The total $grandTotal cannot be represented in the given currency.")
    }

    private fun computeChange(change: Int): List<Int>? {
        val sortedCoins: List<Int> = l.sortedDescending()
        require(sortedCoins.all { it > 0 }) { "Coin values must be positive." }
        val sortedCoinsUsed = Array(change + 1) { Int.MAX_VALUE }
        sortedCoinsUsed[0] = 0

        val changeCombinations = Array(change + 1) { mutableListOf<Int>() }

        for (coin in sortedCoins) {
            for (changeAmount in coin..change) {
                if (sortedCoinsUsed[changeAmount - coin] != Int.MAX_VALUE &&
                    sortedCoinsUsed[changeAmount - coin] + 1 < sortedCoinsUsed[changeAmount]
                ) {
                    sortedCoinsUsed[changeAmount] = sortedCoinsUsed[changeAmount - coin] + 1
                    changeCombinations[changeAmount] = (changeCombinations[changeAmount - coin] + coin).toMutableList()
                }
            }
        }

        return changeCombinations.last().takeIf { it.sum() == change }
    }
}
