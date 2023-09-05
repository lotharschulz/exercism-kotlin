import kotlin.math.cos
import kotlin.math.exp
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0) {
    operator fun times(other: ComplexNumber) = ComplexNumber(
        real = real * other.real - imag * other.imag,
        imag = real * other.imag + imag * other.real,
    )

    operator fun plus(other: ComplexNumber) = ComplexNumber(
        real = real + other.real,
        imag = imag + other.imag,
    )

    operator fun minus(other: ComplexNumber) = ComplexNumber(
        real = real - other.real,
        imag = imag - other.imag,
    )

    operator fun div(other: ComplexNumber) = ComplexNumber(
        real = (real * other.real + imag * other.imag) / (other.real.pow(2) + other.imag.pow(2)),
        imag = (imag * other.real - real * other.imag) / (other.real.pow(2) + other.imag.pow(2)),
    )

    val abs = sqrt(real.pow(2) + imag.pow(2))

    fun conjugate() = ComplexNumber(real, -imag)
}

fun exponential(other: ComplexNumber) = ComplexNumber(exp(other.real) * cos(other.imag), sin(other.imag))
