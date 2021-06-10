import ForthToken.PLUS
import ForthToken.MINUS
import ForthToken.MULTIPLY
import ForthToken.DIVISION
import ForthToken.DUP
import ForthToken.DROP
import ForthToken.OVER
import ForthToken.SWAP

class Forth {
    private val s = Stack<Int>()
    private val m = mutableMapOf<String, List<String>>()

    fun evaluate(vararg line: String): List<Int> {
        line.forEach {
            evaluateInstruction(it.lowercase())
        }
        return s.toList()
    }

    private fun evaluateInstruction(line: String) {
        val tokens = line.split(' ').toMutableList()
        while (tokens.isNotEmpty()) {
            when(val item = tokens.removeAt(0)) {
                ":" -> {
                    defineMacro(tokens)
                    tokens.removeAll {true}
                }
                in m -> tokens.addAll(0, m[item] as List<String>)
                in listOf(PLUS.value,
                    MINUS.value,
                    MULTIPLY.value,
                    DIVISION.value) -> binaryArithmeticOperation(item)
                in listOf(DUP.value, DROP.value, OVER.value, SWAP.value) -> stackOperation(item)
                else -> {
                    require(item.all(Char::isDigit)) {"undefined operation"}
                    s.push(item.toInt())
                }
            }
        }
    }

    private fun need(n: Int) {
        if (n > 0) require(s.isNotEmpty()) {"empty stack"}
        if (n > 1) require(s.size > 1) {"only one value on the stack"}
    }

    private fun binaryArithmeticOperation(operation: String) {
        need(2)
        val b = s.pop()
        val a = s.pop()
        s.push(when(operation) {
            PLUS.value -> a + b
            MINUS.value -> a - b
            MULTIPLY.value -> a * b
            else -> {
                require(b != 0) {"divide by zero"}
                a / b
            }
        })
    }

    private fun stackOperation(operation: String) {
        when (operation) {
            DUP.value -> {
                need(1)
                s.push(s.peek())
            }
            DROP.value -> {
                need(1)
                s.pop()
            }
            OVER.value -> {
                need(2)
                val b = s.pop()
                val a = s.peek()
                s.push(b)
                s.push(a)
            }
            SWAP.value -> {
                need(2)
                val b = s.pop()
                val a = s.pop()
                s.push(b)
                s.push(a)
            }
        }
    }

    private fun defineMacro(tokens: List<String>) {
        require(tokens.last() == ";") {"malformed macro definition"}
        val name = tokens.first()
        require(!name.all(Char::isDigit)) {"illegal operation"}
        val words = tokens.drop(1).dropLast(1)

        val definition = mutableListOf<String>()
        for (word in words) {
            if (word in m)
                m[word]?.let{ definition.addAll(it) }
            else
                definition.add(word)
        }
        m[name] = definition
    }
}
