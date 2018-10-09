object WordCount{
    private const val NORMALIZED_REG_EXP = "(\\W'|'\\W|\\.|:|,|[!%@&\$^])"

    fun phrase (s: String): Map<String, Int> = words(s).groupingBy { it }.eachCount()

    private fun words(s: String): List<String> = normalizeString(s).split("\\s+".toRegex())

    private fun normalizeString(s: String): String = s.toLowerCase()
            .replace(NORMALIZED_REG_EXP.toRegex(), " ").trim()

    // one line version
    // fun phrase(s: String): Map<String, Int> = s.toLowerCase().replace("(\\W'|'\\W|\\.|:|,|[!%@&\$^])".toRegex(), " ").trim().split("\\s+".toRegex()).groupingBy { it }.eachCount() // can't use \\p{Punct} unfortunately

}