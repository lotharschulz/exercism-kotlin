class Anagram (private val word: String){
    fun match(anagrams: Collection<String>): Set<String> =
        anagrams.filter { it.length == word.length }
            .filterNot { it.equals(word, ignoreCase = true) }
            .filter { it.sortedChars() == word.sortedChars() }.toSet()
    private fun String.sortedChars(): List<Char> = this.toLowerCase().toCharArray().sorted()
}
