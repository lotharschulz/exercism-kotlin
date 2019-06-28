object Isogram{
    fun isIsogram(input: String): Boolean =
      0 == input.toLowerCase().filter { it.isLetterOrDigit() }.groupingBy { it }.eachCount().filter { it.value > 1 }.size
}