import java.util.SortedMap

class BinarySearchTree<T : Comparable<T>> {

    data class Node<T>(val data: T, val left: Node<T>? = null, val right: Node<T>? = null)

    var root: Node<T>? = null

    fun insert(value: T) {
        root = root?.insert(value) ?: Node(value)
    }

    private fun Node<T>.insert(value: T): Node<T> = when {
        value <= this.data -> this.copy(left = this.left?.insert(value) ?: Node(value))
        else -> this.copy(right = this.right?.insert(value) ?: Node(value))
    }

    fun asSortedList(): List<T> {
        return sortNode(root!!)
    }

    private fun sortNode(node: Node<T>?): List<T> = when {
        node == null -> emptyList()
        else -> sortNode(node.left) + listOf(node.data) + sortNode(node.right)
    }

    fun asLevelOrderList(): List<T> {
        val results = sortedMapOf<Int, List<T>>()
        layer(results, node = root, level = 0)
        return results.values.flatten()
    }

    private fun layer(results: SortedMap<Int, List<T>>, node: Node<T>?, level: Int) {
        if (node == null) { return }
        results[level] = results.getOrDefault(level, emptyList()) + listOf(node.data)
        node.left?.run { layer(results, node = this, level = level + 1) }
        node.right?.run { layer(results, node = this, level = level + 1) }
    }
}
