

object ETL {
    fun transform(source: Map<Int, Collection<Char>>): Map<Char, Int> = source.flatMap { pair ->
        pair.value.map { listChars -> listChars to pair.key }
    }.toMap().mapKeys { it.key.lowercaseChar() }
}
