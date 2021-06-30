import java.util.Locale

object AffineCipher {

    fun encode(input: String, a: Int, b: Int): String {
        require(a.coprime(26)){"a and m must be coprime."}
        val text = input.lowercase(Locale.getDefault()).filter { it.isLetterOrDigit() }
        val encoded = text.map {
            when {
                it.isDigit() -> it
                else -> it.affineCipherEncode(a, b)
            }
        }.joinToString(separator = "")
        return encoded.chunked(size = 5).joinToString(separator = " ")
    }

    fun decode(input: String, a: Int, b: Int): String {
        require(a.coprime(26)){"a and m must be coprime."}
        val text = input.filter { !it.isWhitespace() }

        return text.map {
            if (it.isDigit()) {
                it
            } else {
                decodeChar(it, b, a.modularMultiplicativeInverse())
            }
        }.joinToString(separator = "")    }

    // https://en.wikipedia.org/wiki/Greatest_common_divisor
    tailrec fun Int.findGreatestCommonDivisor(a: Int): Int = when (a) {
            0 -> this
            else -> a.findGreatestCommonDivisor(this % a)
        }

    // https://en.wikipedia.org/wiki/Coprime_integers
    fun Int.coprime(a: Int): Boolean = 1 == this.findGreatestCommonDivisor(a)

    // https://en.wikipedia.org/wiki/Modular_multiplicative_inverse
    fun Int.modularMultiplicativeInverse(alphabetLength: Int = 26): Int = generateSequence(1) { it + 1 }
        .take(alphabetLength - 1)
        .first { ((this % alphabetLength) * it) % alphabetLength == 1 }

    private fun decodeChar(c: Char, b: Int, inverse: Int): Char {
        return c.toAffineCipherIndexAndCipherChar {
            var product = (inverse * (it - b))
            while (product < 0) { product += 26 } // result has to be positive for modulo to work
            product % 26
        }
    }

    private fun Char.affineCipherEncode(a: Int, b: Int, alphabetLength: Int = 26): Char =
        this.toAffineCipherIndexAndCipherChar {
            ((a * it) + b) % alphabetLength
        }

    private fun Char.toAffineCipherIndexAndCipherChar(op: (Int) -> Int): Char =
        op.invoke(this.affineCipherIndex()).toAffineCipherChar()

    private fun Int.toAffineCipherChar(differenceChar: Char = 'a'): Char = (this + differenceChar.code).toChar()

    private fun Char.affineCipherIndex(differenceChar: Char = 'a'): Int = this.code - differenceChar.code


}
