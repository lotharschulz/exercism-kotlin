data class Cipher(val input: String = "") {

    // TODO: Implement proper constructor

    private val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
    var key: String
    init {
        require(input.isNotEmpty() && input.all { it.isLowerCase() }) { "input should be lowercase characters only" }
        key = randomStringByKotlinCollectionRandom()
    }

    fun encode(s: String): String {
        return ""
    }

    fun decode(s: String): String {
        return ""
    }


    private fun randomStringByKotlinCollectionRandom(stringLength: Int = 100) = List(stringLength) { charPool.random() }.joinToString(separator = "")
}

