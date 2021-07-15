import java.lang.Character.MIN_VALUE as nullChar
import java.util.Stack
object MatchingBrackets {

    fun isValid(input: String): Boolean {
        val stack = Stack<Char>()

        input.forEach {
            val lastStackChar = if (stack.isNotEmpty()) stack.peek() else nullChar
            when{
                !it.isBracket() -> return@forEach
                stack.isNotEmpty() && it.matchesBracket(lastStackChar) -> stack.pop()
                else -> stack.push(it)
            }
        }
        return stack.isEmpty()
    }

    private fun Char.isBracket(): Boolean = this in listOf('[', ']', '{', '}', '(', ')')
    private fun Char.matchesBracket(c: Char): Boolean = when{
            this == ']' && c == '[' -> true
            this == '}' && c == '{' -> true
            this == ')' && c == '(' -> true
            else -> false
        }
}
