class Series(private val input: String) {

    init {
        require(input.all { it.isDigit() }) { "Input must contain numbers only." }
    }

    fun getLargestProduct(digits: Int):Number {
        require(digits >= 0){ "Digits must be greater or equal zero." }
        require(digits <= input.length) {"Input string length must be bigger than digit number."}

        if (digits == input.length)
            return input.fold(1){ acc, next -> acc * (next.toInt() - 48)}
        return (0..(input.length - digits))
                .map { input.slice(it..(it + digits-1)) }
                .map { it.fold(1){ acc, next -> acc * (next.toInt() - 48)} }
                .max()!!
    }
}