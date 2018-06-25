
enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    require(naturalNumber > 0) { "naturalNumber be greater than 0." }
    if (naturalNumber == 1) return Classification.DEFICIENT
    val dsum = naturalNumber.divisors().sum()
    return when{
        dsum == naturalNumber -> Classification.PERFECT
        dsum < naturalNumber -> Classification.DEFICIENT
        else -> Classification.ABUNDANT // dsum > naturalNumber
    }
}

fun Int.divisors(): List<Int> {
    return listOf(1) + (2 .. this/2).filter { this.rem(it) == 0 }
}