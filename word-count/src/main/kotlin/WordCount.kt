object WordCount{
    fun phrase(s: String): Map<String, Int> = s.toLowerCase().replace("(\\W'|\\.|:|,|[!%@&\$^])".toRegex(), " ").replace("(' )".toRegex(), " ").trim().split("\\s+".toRegex()).groupingBy { it }.eachCount() // can't use \\p{Punct} unfortunately
}