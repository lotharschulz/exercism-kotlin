import java.lang.Character.MIN_VALUE as nullChar
object MatchingBrackets {

    fun isValid(input: String): Boolean {
        val stack = Deque<Char>()
        input.forEach {
            val lastStackChar = stack.peek() ?: nullChar
            when{
                !it.isBracket() -> return@forEach
                stack.isNotEmpty() && it.matchesBracket(lastStackChar) -> stack.pop()
                else -> stack.push(it)
            }
        }
        return stack.isEmpty()
    }

    private fun Char.isBracket(): Boolean = this in listOf('[', ']', '{', '}', '(', ')')
    private fun Char.matchesBracket(c: Char): Boolean = this == c
}
