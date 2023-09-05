data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0) {
    operator fun times(other: ComplexNumber) = ComplexNumber(
        real = real * other.real - imag * other.imag,
        imag = real * other.imag + imag * other.real,
    )

    operator fun plus(other: ComplexNumber) = ComplexNumber(
        real = real + other.real,
        imag = imag + other.imag,
    )
}
