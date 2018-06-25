
enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    if (naturalNumber == 1) return Classification.DEFICIENT
    if (naturalNumber < 1) throw RuntimeException()
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