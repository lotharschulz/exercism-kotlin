class ChainNotFoundException(msg: String) : RuntimeException(msg)

data class Domino(val left: Int, val right: Int)

object Dominoes {

    fun formChain(vararg xs: Domino) = formChain(xs.toList())

    fun formChain(xs: List<Domino>): List<Domino> = when {
        xs.isEmpty() -> emptyList()
        else -> {
            val ys = mutableListOf(listOf(xs.first()))
            order(ys, xs.drop(1))
            ys.removeIf { it.size != xs.size || it.first().left != it.last().right }
            if (ys.isEmpty()) throw ChainNotFoundException("empty list") else ys.first()
        }
    }

    private fun order(acc: MutableList<List<Domino>>, pool: List<Domino>) {
        if (pool.isEmpty()) return
        val xs = acc.last()
        val last = xs.last()
        pool.filter { last.right == it.left || last.right == it.right }
            .forEach {
                acc.add(xs.plus(if (last.right == it.left) it else Domino(it.right, it.left)))
                order(acc, pool.minus(it))
            }
    }
}
