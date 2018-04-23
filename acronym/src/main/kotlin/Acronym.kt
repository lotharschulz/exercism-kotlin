class Acronym{
    companion object {
        fun generate (phrase: String): String {
            return phrase.split(" ", ":", "-", ",").
                    filter { it.isNotBlank() }.map { it.first().toUpperCase() }.joinToString("")
        }
    }
}