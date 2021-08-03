object ArmstrongNumber {

    fun check(input: Int): Boolean =
        when {
            input > -1 -> input == getDigitsRecursive(input).sumOf { digit ->
                Math.pow(digit.toDouble(), getNumberOfDigitsLog(input).toDouble())
            }.toInt()
            else -> false
        }

    fun getDigitsRecursive(input: Int): List<Int> {
        if (input == 0) return listOf(0)
        val result = mutableListOf<Int>()
        getDigitsRecursiveAcc(input, result)
        return result.toList()
    }

    fun getDigitsRecursiveAcc(input: Int, acc: MutableList<Int>): List<Int> =
        when {
            input > 0 -> {
                acc.add(input % 10)
                getDigitsRecursiveAcc(input / 10, acc)
            }
            else -> {
                acc.reverse()
                acc
            }
        }

    fun getNumberOfDigitsLog(input: Int): Int =
        if (input == 0) 1 else Math.log10(input.toDouble()).toInt() + 1
}
