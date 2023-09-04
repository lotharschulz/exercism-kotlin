data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0)

operator fun ComplexNumber.times(other: ComplexNumber) = ComplexNumber(
    real = real * other.real - imag * other.imag,
    imag = real * other.imag + imag * other.real
)