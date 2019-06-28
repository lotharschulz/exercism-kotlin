object Isogram{
    fun isIsogram(input: String): Boolean =
      !input.toLowerCase().filter { it.isLetterOrDigit() }.groupingBy { it }.eachCount().any { it.value > 1 }
}