class Stack<T> {
    private val stack = mutableListOf<Int>()
    fun push(elem: Int) {
        stack.add(elem)
    }
    fun peek(): Int = if (isNotEmpty()) stack.last() else 0
    fun pop(): Int = if (isNotEmpty()) stack.removeAt(stack.lastIndex) else 0
    private fun isEmpty(): Boolean = stack.isEmpty()
    fun isNotEmpty(): Boolean = !isEmpty()
    val size: Int get() = stack.size
    fun toList(): List<Int> = stack.toList()
}
