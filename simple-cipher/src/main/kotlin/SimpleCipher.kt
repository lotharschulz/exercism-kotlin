data class Cipher(var key: String) {
    constructor() : this("key") {
        key= randomString()
    }

    init {
        require(key.isNotEmpty() && key.all { it.isLowerCase() }) { "input should be lowercase characters only" }
    }

    companion object {
        private val alphabet = generateSequence(97) { it + 1 }.take(26).toList().map{ it.toChar() }.joinToString(separator = "")
    }

    private fun randomString(stringLength: Int = 100) = List(stringLength) { alphabet.random() }.joinToString(separator = "")

    fun encode(s: String): String {
        var encodedString: String = ""

        var keyIndex = 0
        for (c in s) {
            if (alphabet.contains(c)) {
                val charIndex = alphabet.indexOf(c)
                val keyChar = key[keyIndex % key.length]
                val shift = alphabet.indexOf(keyChar)
                val encodedCharIndex = (charIndex + shift) % alphabet.length
                encodedString += alphabet[encodedCharIndex]
                keyIndex += 1
            } else {
                encodedString += c
            }
        }

        return encodedString
    }

    fun decode(s: String): String {
        var decodedString: String = ""

        var keyIndex = 0
        for (c in s) {
            if (alphabet.contains(c)) {
                val charIndex = alphabet.indexOf(c)
                val keyChar = key[keyIndex % key.length]
                val shift = alphabet.indexOf(keyChar)
                val decodedCharIndex = (alphabet.length + charIndex - shift) % alphabet.length
                decodedString += alphabet[decodedCharIndex]
                keyIndex += 1
            } else {
                decodedString += c
            }
        }

        return decodedString
    }
}