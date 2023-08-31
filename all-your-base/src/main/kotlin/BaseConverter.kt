import kotlin.math.pow

class BaseConverter(private var base: Int, private var digits: IntArray) {
    init {
        require(base > 1) { "Bases must be at least 2." }
        require(digits.isNotEmpty()) { "You must supply at least one digit." }
        require(digits[0] != 0 || digits.size < 2) { "Digits may not contain leading zeros." }
        if (digits.any { it < 0 }) throw IllegalArgumentException("Digits may not be negative.")
        if (digits.any { it >= base }) throw IllegalArgumentException("All digits must be strictly less than the base.")
    }

    fun convertToBase(newBase: Int): IntArray {
        require(newBase > 1) { "Bases must be at least 2." }
        var p = digits.size - 1
        var toBase10 = digits.sumOf {
            it * base.toDouble().pow(p--)
        }.toInt()
        val result = ArrayList<Int>()
        do {
            result.add(0, toBase10 % newBase)
            toBase10 /= newBase
        } while (toBase10 >= 1)
        return result.toIntArray()
    }
}
